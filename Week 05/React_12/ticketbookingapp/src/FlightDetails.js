import React from 'react';

function FlightDetails({ isLoggedIn }) {
  const flights = [
    { id: "AI-101", from: "Mumbai", to: "Delhi", departure: "10:00 AM" },
    { id: "6E-502", from: "Bengaluru", to: "Hyderabad", departure: "02:30 PM" },
    { id: "SG-303", from: "Chennai", to: "Kolkata", departure: "06:15 PM" }
  ];

  const handleBook = (flightId) => {
    alert(`Success! Ticket for flight ${flightId} has been booked.`);
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h3>Available Domestic Flights</h3>
      <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', width: '100%', textAlign: 'left' }}>
        <thead>
          <tr style={{ backgroundColor: '#f2f2f2' }}>
            <th>Flight ID</th>
            <th>From</th>
            <th>To</th>
            <th>Departure</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {flights.map((flight) => (
            <tr key={flight.id}>
              <td>{flight.id}</td>
              <td>{flight.from}</td>
              <td>{flight.to}</td>
              <td>{flight.departure}</td>
              <td>
                {/* Conditional Rendering: Show booking option only to logged-in users */}
                {isLoggedIn ? (
                  <button 
                    onClick={() => handleBook(flight.id)} 
                    style={{ backgroundColor: '#28a745', color: 'white', border: 'none', padding: '5px 10px', borderRadius: '4px', cursor: 'pointer' }}
                  >
                    Book Ticket
                  </button>
                ) : (
                  <span style={{ color: '#666', fontSize: '13px', fontStyle: 'italic' }}>Login to book</span>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default FlightDetails;