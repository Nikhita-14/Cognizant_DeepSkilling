import React from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
  // Set this flag to true or false to switch between views
  const Flag = true; 

  return (
    <div style={{ maxWidth: '600px', margin: '20px auto', border: '1px solid #ddd', borderRadius: '8px', padding: '10px' }}>
      <h1 style={{ textAlign: 'center', color: '#2c3e50' }}>Cricket App Dashboard</h1>
      <hr />
      
      {/* Simple conditional rendering block */}
      {Flag ? (
        <div>
          <span style={{ background: '#eef', padding: '5px 10px', borderRadius: '4px', fontSize: '12px' }}>Flag is set to TRUE</span>
          <ListofPlayers />
        </div>
      ) : (
        <div>
          <span style={{ background: '#efe', padding: '5px 10px', borderRadius: '4px', fontSize: '12px' }}>Flag is set to FALSE</span>
          <IndianPlayers />
        </div>
      )}
    </div>
  );
}

export default App;