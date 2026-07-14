import React, { useContext } from 'react';
import ThemeContext from './ThemeContext'; // Import context

function EmployeeCard({ employee }) {
  // Retrieve the global context value directly using useContext hook
  const theme = useContext(ThemeContext);

  // Apply button styling matching context theme value string flags
  const buttonStyle = {
    padding: '6px 12px',
    cursor: 'pointer',
    border: 'none',
    borderRadius: '4px',
    backgroundColor: theme === 'light' ? '#007bff' : '#343a40',
    color: 'white'
  };

  return (
    <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', minWidth: '200px', textAlign: 'center', background: theme === 'light' ? '#fff' : '#f0f0f0' }}>
      <h4>{employee.name}</h4>
      <p style={{ color: '#666', fontSize: '14px' }}>{employee.role}</p>
      
      {/* Dynamic button class styling mapped to theme state configurations */}
      <button style={buttonStyle} className={`btn btn-${theme}`}>
        View Details ({theme.toUpperCase()})
      </button>
    </div>
  );
}

export default EmployeeCard;