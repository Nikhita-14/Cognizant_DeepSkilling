import React, { Component } from 'react';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

class App extends Component {
  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>Student Management Portal</h1>
        <hr />
        <Home />
        <About />
        <Contact />
      </div>
    );
  }
}

export default App;