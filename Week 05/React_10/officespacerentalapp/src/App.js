import React from 'react';

function App() {
  // 1. Create an element/variable to display the heading of the page
  const pageHeading = <h1 style={{ textAlign: 'center', color: '#2c3e50' }}>Office Space Rental Marketplace</h1>;

  // 2. Create an object of a featured office to display standalone details
  const featuredOffice = {
    Name: "Premium Innovation Hub",
    Rent: 75000,
    Address: "Tech Park Phase 1, Sector 62"
  };

  // 3. Create a list of Objects to loop through for more data
  const officeSpaces = [
    { Name: "Co-Working Smart Space", Rent: 45000, Address: "Downtown Avenue, Block C" },
    { Name: "Executive Corporate Suite", Rent: 90000, Address: "Financial District, Tower B" },
    { Name: "Startup Incubator Desk", Rent: 25000, Address: "Old Railway Road, Lane 4" },
    { Name: "Skyline Business Center", Rent: 60000, Address: "Harbor View Towers, Floor 14" }
  ];

  return (
    <div style={{ padding: '30px', fontFamily: 'Arial, sans-serif', maxWidth: '800px', margin: '0 auto' }}>
      
      {/* Rendering the heading element */}
      {pageHeading}
      <hr />

      {/* Attribute usage to display the image of the office space */}
      <div style={{ textAlign: 'center', margin: '20px 0' }}>
        <img 
          src={`${process.env.PUBLIC_URL}/office.jpg`} 
          alt="Office Space Showcase" 
          style={{ width: '100%', maxHeight: '350px', objectFit: 'cover', borderRadius: '8px', border: '1px solid #ddd' }}
        />
      </div>

      {/* Displaying Featured Office Object Details */}
      <div style={{ background: '#f8f9fa', padding: '20px', borderRadius: '8px', marginBottom: '30px', borderLeft: '5px solid #007bff' }}>
        <h2>Featured Listing</h2>
        <p><b>Name:</b> {featuredOffice.Name}</p>
        <p><b>Address:</b> {featuredOffice.Address}</p>
        {/* Conditional Styling: Red if below 60000, Green if 60000 or above */}
        <p>
          <b>Rent:</b>{' '}
          <span style={{ color: featuredOffice.Rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
            Rs. {featuredOffice.Rent} / month
          </span>
        </p>
      </div>

      {/* Looping through the list of Office Objects */}
      <h2>Available Rental Spaces</h2>
      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '20px' }}>
        {officeSpaces.map((office, index) => {
          // Determine the inline style color dynamically for each specific iteration
          const rentColor = office.Rent < 60000 ? 'red' : 'green';

          return (
            <div key={index} style={{ border: '1px solid #eee', padding: '15px', borderRadius: '6px', boxShadow: '0 2px 4px rgba(0,0,0,0.05)' }}>
              <h3>{office.Name}</h3>
              <p style={{ color: '#666', fontSize: '14px' }}>{office.Address}</p>
              <p>
                Rent:{' '}
                <span style={{ color: rentColor, fontWeight: 'bold' }}>
                  Rs. {office.Rent}
                </span>
              </p>
            </div>
          );
        })}
      </div>

    </div>
  );
}

export default App;