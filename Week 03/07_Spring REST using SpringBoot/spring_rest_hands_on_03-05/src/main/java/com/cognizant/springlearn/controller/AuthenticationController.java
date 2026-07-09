package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET_KEY = "secretkeysecretkeysecretkeysecretkey"; // Matches filter requirements

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - Handshaking request initialization signature received");
        LOGGER.debug("Received Authorization Value: {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END - Handshake trace verified successfully");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Processing decoding strategy context targeting parameter value: {}", authHeader);
        String encodedCredentials = authHeader.replace("Basic ", "").trim();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        String user = credentials.split(":")[0];
        LOGGER.debug("Resolved Identity Output Name Match: {}", user);
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.debug("Constructing cryptographic builder for subject entity name: {}", user);
        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20-minute lifespan
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
    }
}