@RestController
public class SecureController {
    @GetMapping("/secure")
    public String secure() {
        return "This is a secure endpoint";
    }
}