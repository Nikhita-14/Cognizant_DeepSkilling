import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import { trainersMockData } from './TrainersMock';
import Home from './Home';
import TrainersList from './Trainerlist';
import TrainerDetail from './TrainerDetails';

function App() {
  return (
    <BrowserRouter>
      <div style={{ fontFamily: 'Arial, sans-serif' }}>
        {/* Simple Navigation Menu bar header layout */}
        <nav style={{ padding: '15px', backgroundColor: '#2c3e50', color: '#fff' }}>
          <Link to="/" style={{ color: '#fff', marginRight: '20px', textDecoration: 'none', fontWeight: 'bold' }}>Home</Link>
          <Link to="/trainers" style={{ color: '#fff', textDecoration: 'none', fontWeight: 'bold' }}>Trainers List</Link>
        </nav>

        {/* Dynamic Area mapping routes to components */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={trainersMockData} />} />
          {/* Parameterized routing segment targeting id */}
          <Route path="/trainers/:id" element={<TrainerDetail trainers={trainersMockData} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;