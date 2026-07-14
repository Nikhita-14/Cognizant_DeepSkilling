import React from 'react';
import EmployeeCard from './EmployeeCard';

// Cleaned out props entirely since this container doesn't need to forward data anymore
function EmployeesList() {
  const employees = [
    { id: 1, name: "Amit Sharma", role: "Software Engineer" },
    { id: 2, name: "Priya Nair", role: "UX Designer" },
    { id: 3, name: "Rohan Verma", role: "Product Manager" }
  ];

  return (
    <div style={{ display: 'flex', gap: '20px', justifyContent: 'center', flexWrap: 'wrap' }}>
      {employees.map(emp => (
        // No longer forwarding theme props down manually here!
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;