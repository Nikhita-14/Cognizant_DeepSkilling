import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    // Initializing the state to store entry and exit counts
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  // Method to increment the entry count
  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  // Method to increment the exit count
  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif', maxWidth: '400px', margin: '20px auto', border: '1px solid #ccc', borderRadius: '8px', textAlign: 'center' }}>
        <h2>Mall Footflow Monitor</h2>
        <hr />
        
        <div style={{ display: 'flex', justifyContent: 'space-around', margin: '20px 0' }}>
          <div>
            <h3>Entry Count</h3>
            <p style={{ fontSize: '24px', fontWeight: 'bold', color: 'green' }}>{this.state.entrycount}</p>
            {/* Button text explicitly matching requirements */}
            <button onClick={this.updateEntry} style={{ padding: '8px 16px', cursor: 'pointer', backgroundColor: '#4CAF50', color: 'white', border: 'none', borderRadius: '4px' }}>
              Login
            </button>
          </div>

          <div>
            <h3>Exit Count</h3>
            <p style={{ fontSize: '24px', fontWeight: 'bold', color: 'red' }}>{this.state.exitcount}</p>
            {/* Button text explicitly matching requirements */}
            <button onClick={this.updateExit} style={{ padding: '8px 16px', cursor: 'pointer', backgroundColor: '#f44336', color: 'white', border: 'none', borderRadius: '4px' }}>
              Exit
            </button>
          </div>
        </div>
      </div>
    );
  }
}

export default CountPeople;