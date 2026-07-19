import React, { Component } from 'react';

// Form validation helper utility
const validateForm = (errors) => {
  let valid = true;
  Object.values(errors).forEach((val) => val.length > 0 && (valid = false));
  return valid;
};

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  // Handle changes dynamically as per the case logic guidelines
  handleChange = (event) => {
    event.preventDefault();
    const { name, value } = event.target;
    let errors = { ...this.state.errors };

    switch (name) {
      case 'fullName':
        errors.fullName =
          value.length < 5
            ? 'Full Name must be 5 characters long!'
            : '';
        break;
      case 'email':
        const validEmailRegex = RegExp(
          /^[a-zA-Z0-BA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/i
        );
        errors.email = validEmailRegex.test(value)
          ? ''
          : 'Email is not valid!';
        break;
      case 'password':
        errors.password =
          value.length < 8
            ? 'Password must be 8 characters long!'
            : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  };

  // Process form tracking submission criteria via browser alert boxes
  handleSubmit = (event) => {
    event.preventDefault();
    
    // Check if form fields are completely empty initially before validating structural blocks
    if (!this.state.fullName && !this.state.email && !this.state.password) {
      alert('Please fill out the registration form fields.');
      return;
    }

    if (validateForm(this.state.errors)) {
      alert('Valid Form');
    } else {
      if (this.state.errors.fullName !== '') {
        alert(this.state.errors.fullName);
      }
      if (this.state.errors.email !== '') {
        alert(this.state.errors.email);
      }
      if (this.state.errors.password !== '') {
        alert(this.state.errors.password);
      }
    }
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px', fontFamily: 'Arial, sans-serif' }}>
        <h1 style={{ color: 'red', fontSize: '36px', fontWeight: 'bold' }}>Register Here!!!</h1>
        
        <form onSubmit={this.handleSubmit} style={{ display: 'inline-block', textAlign: 'left', marginTop: '20px' }}>
          {/* Name Field */}
          <div style={{ marginBottom: '15px' }}>
            <label style={{ display: 'inline-block', width: '90px', fontSize: '18px' }}>Name:</label>
            <input 
              type="text" 
              name="fullName" 
              value={this.state.fullName} 
              onChange={this.handleChange} 
              style={{ padding: '4px', fontSize: '16px', border: '1px solid #767676', borderRadius: '2px' }}
            />
          </div>

          {/* Email Field */}
          <div style={{ marginBottom: '15px' }}>
            <label style={{ display: 'inline-block', width: '90px', fontSize: '18px' }}>Email:</label>
            <input 
              type="text" 
              name="email" 
              value={this.state.email} 
              onChange={this.handleChange} 
              style={{ padding: '4px', fontSize: '16px', border: '1px solid #767676', borderRadius: '2px' }}
            />
          </div>

          {/* Password Field */}
          <div style={{ marginBottom: '15px' }}>
            <label style={{ display: 'inline-block', width: '90px', fontSize: '18px' }}>Password:</label>
            <input 
              type="password" 
              name="password" 
              value={this.state.password} 
              onChange={this.handleChange} 
              style={{ padding: '4px', fontSize: '16px', border: '1px solid #767676', borderRadius: '2px' }}
            />
          </div>

          {/* Submit Action Control */}
          <div style={{ paddingLeft: '90px' }}>
            <button 
              type="submit" 
              style={{ padding: '3px 12px', cursor: 'pointer', fontSize: '14px', border: '1px solid #a0a0a0', backgroundColor: '#f0f0f0', borderRadius: '3px' }}
            >
              Submit
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default Register;