import React, { useState } from 'react';

function CurrencyConverter() {
  const [inr, setInr] = useState('');
  const [euro, setEuro] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent page refresh on form submission
    const converted = parseFloat(inr) * 0.011; // Example conversion rate
    setEuro(isNaN(converted) ? 0 : converted.toFixed(2));
  };

  return (
    <div style={{ marginTop: '30px', padding: '20px', border: '1px solid #ccc', borderRadius: '8px' }}>
      <h3>Currency Converter (INR to EUR)</h3>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Amount in INR: </label>
          <input 
            type="number" 
            value={inr} 
            onChange={(e) => setInr(e.target.value)} 
            placeholder="Enter rupees..."
            style={{ padding: '5px', marginLeft: '10px' }}
            required
          />
        </div>
        <button type="submit" style={{ padding: '6px 12px', cursor: 'pointer', backgroundColor: '#007bff', color: 'white', border: 'none', borderRadius: '4px' }}>
          Convert
        </button>
      </form>

      {euro !== null && (
        <p style={{ marginTop: '15px', fontWeight: 'bold', color: '#28a745' }}>
          Equivalent Amount in Euro: € {euro}
        </p>
      )}
    </div>
  );
}

export default CurrencyConverter;