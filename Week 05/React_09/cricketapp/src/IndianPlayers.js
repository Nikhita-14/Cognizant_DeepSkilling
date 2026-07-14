import React from 'react';

function ListofPlayers() {
  // Array of 11 players with names and scores
  const players = [
    { name: "Sachin", score: 120 },
    { name: "Dhoni", score: 95 },
    { name: "Virat", score: 85 },
    { name: "Rohit", score: 110 },
    { name: "Rahul", score: 45 },
    { name: "Shikhar", score: 65 },
    { name: "Rishabh", score: 55 },
    { name: "Hardik", score: 75 },
    { name: "Ravindra", score: 60 },
    { name: "Bumrah", score: 15 },
    { name: "Shami", score: 10 }
  ];

  // Filter players with scores below 70 using an ES6 Arrow Function
  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>List of All Players (Using map)</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} : <b>{player.score}</b>
          </li>
        ))}
      </ul>

      <h2 style={{ marginTop: '30px', color: '#d9534f' }}>
        Players with Scores Below 70 (Using Arrow Function Filter)
      </h2>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            {player.name} : <b>{player.score}</b>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;