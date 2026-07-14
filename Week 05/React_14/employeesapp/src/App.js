import React, { useState } from 'react';
import EmployeesList from './EmployeesList';
import ThemeContext from './ThemeContext'; // Import context

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    // Wrap everything in the Context Provider
    <ThemeContext.Provider value={theme}>
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h2 style={{ textAlign: 'center' }}>Employee Management Dashboard</h2>
        <div style={{ textAlign: 'center', marginBottom: '20px' }}>
          <button onClick={toggleTheme} style={{ padding: '8px 16px', cursor: 'pointer' }}>
            Switch to {theme === 'light' ? 'Dark' : 'Light'} Mode
          </button>
        </div>
        
        {/* REMOVED theme property passing from the component prop definition */}
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;