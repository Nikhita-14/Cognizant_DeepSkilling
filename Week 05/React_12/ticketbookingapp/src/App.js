import React, { Component } from 'react';
import FlightDetails from './FlightDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    
    // Declaring an Element Variable to store the conditional button element
    let authButton;

    if (isLoggedIn) {
      authButton = (
        <button 
          onClick={this.handleLogout} 
          style={{ padding: '8px 16px', backgroundColor: '#dc3545', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Logout
        </button>
      );
    } else {
      authButton = (
        <button 
          onClick={this.handleLogin} 
          style={{ padding: '8px 16px', backgroundColor: '#007bff', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Login
        </button>
      );
    }

    return (
      <div style={{ maxWidth: '700px', margin: '30px auto', fontFamily: 'Arial, sans-serif', padding: '0 15px' }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderBottom: '2px solid #eee', paddingBottom: '10px' }}>
          <h1 style={{ margin: 0, color: '#2c3e50', fontSize: '24px' }}>Virgin Airways Portal</h1>
          {/* Rendering the Element Variable containing our dynamic button */}
          {authButton}
        </div>

        {/* Dynamic header welcome message container */}
        <div style={{ margin: '20px 0', padding: '15px', borderRadius: '6px', backgroundColor: isLoggedIn ? '#e2f0d9' : '#fff3cd', color: isLoggedIn ? '#385723' : '#856404' }}>
          {isLoggedIn ? (
            <h2>Welcome Back, Registered User! You now have full booking access privileges.</h2>
          ) : (
            <h2>Browsing Mode (Guest View). Please sign in to finalize ticket purchases.</h2>
          )}
        </div>

        {/* Injecting flight schedule, passing active state through props */}
        <FlightDetails isLoggedIn={isLoggedIn} />
      </div>
    );
  }
}

export default App;