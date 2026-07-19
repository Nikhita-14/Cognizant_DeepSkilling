import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      person: null,
      loading: true
    };
  }

  // Asynchronous lifecycle execution to fetch user data on component load
  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }

  render() {
    const { person, loading } = this.state;

    // Display a loader while fetching information from the endpoint
    if (loading) {
      return (
        <div style={{ textAlign: 'center', marginTop: '50px', fontSize: '20px', fontFamily: 'sans-serif' }}>
          Loading user details...
        </div>
      );
    }

    // Ensure safe access to deep object paths
    if (!person) {
      return (
        <div style={{ textAlign: 'center', marginTop: '50px', fontSize: '20px', fontFamily: 'sans-serif' }}>
          Failed to load user data.
        </div>
      );
    }

    // Extract title, firstname, and large profile picture
    const { title, first, last } = person.name;
    const { large: imageUrl } = person.picture;

    return (
      <div style={{ margin: '50px auto', maxWidth: '600px', paddingLeft: '40px', fontFamily: 'sans-serif' }}>
        {/* Render Title and First Name */}
        <h1 style={{ fontSize: '32px', fontWeight: 'bold', marginBottom: '15px' }}>
          {title} {first} {last}
        </h1>
        
        {/* Render User Image Profile View */}
        <img 
          src={imageUrl} 
          alt={`${first}'s profile`} 
          style={{ width: '150px', height: '150px', objectFit: 'cover' }}
        />
      </div>
    );
  }
}

export default Getuser;