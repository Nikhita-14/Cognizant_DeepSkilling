import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: 0
    };

    // Binding methods
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  // Generate a random ID whenever the component mounts or resets
  componentDidMount() {
    this.generateRandomNumber();
  }

  generateRandomNumber = () => {
    // Generates a random transaction reference number between 1 and 100
    const randomNum = Math.floor(Math.random() * 100) + 1;
    this.setState({ NumberHolder: randomNum });
  };

  // Dynamically handles state update for both input fields (text and textarea)
  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  // Form submission handler
  handleSubmit(event) {
    const msg = 'Thanks ' + this.state.ename + '\nYour Complaint was Submitted.\nTransaction ID is: ' + this.state.NumberHolder;
    alert(msg);
    event.preventDefault();
    
    // Optional: Reset form fields and generate a new reference number for the next submission
    this.setState({
      ename: '',
      complaint: ''
    });
    this.generateRandomNumber();
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '40px', fontFamily: 'sans-serif' }}>
        <h1 style={{ color: 'red', fontSize: '36px', fontWeight: 'bold' }}>
          Register your complaints here!!!
        </h1>

        <form onSubmit={this.handleSubmit} style={{ display: 'inline-block', marginTop: '20px', textAlign: 'left' }}>
          {/* Employee Name Input Field */}
          <div style={{ marginBottom: '15px' }}>
            <label style={{ display: 'inline-block', width: '100px', fontSize: '18px' }}>Name:</label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
              required
              style={{ width: '250px', padding: '5px', fontSize: '16px' }}
            />
          </div>

          {/* Complaint Textarea Field */}
          <div style={{ marginBottom: '15px', display: 'flex', alignItems: 'flex-start' }}>
            <label style={{ display: 'inline-block', width: '100px', fontSize: '18px', marginTop: '5px' }}>Complaint:</label>
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
              required
              rows="4"
              style={{ width: '250px', padding: '5px', fontSize: '16px', resize: 'none' }}
            />
          </div>

          {/* Submit Button */}
          <div style={{ textAlign: 'center' }}>
            <button
              type="submit"
              style={{
                padding: '5px 15px',
                fontSize: '16px',
                cursor: 'pointer',
                backgroundColor: '#e1e1e1',
                border: '1px solid #adadad',
                borderRadius: '3px'
              }}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;