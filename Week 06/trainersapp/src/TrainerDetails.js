import React from 'react';
import { useParams, Link } from 'react-router-dom';

function TrainerDetail({ trainers }) {
    // Extract the id string parameter out of the active URL string path
    const { id } = useParams();
    
    // Find the specific object matching that ID
    const trainer = trainers.find(t => t.TrainerId === parseInt(id));

    if (!trainer) {
        return <div style={{ padding: '20px', color: 'red' }}><h3>Trainer profile not found!</h3></div>;
    }

    return (
        <div style={{ padding: '20px', border: '1px solid #ccc', margin: '20px', borderRadius: '8px', maxWidth: '400px' }}>
            <h2>Trainer Profile Card</h2>
            <hr />
            <p><b>ID:</b> {trainer.TrainerId}</p>
            <p><b>Name:</b> {trainer.Name}</p>
            <p><b>Email:</b> {trainer.Email}</p>
            <p><b>Phone:</b> {trainer.Phone}</p>
            <p><b>Stream:</b> {trainer.Technology}</p>
            <p><b>Skills:</b> {trainer.Skills}</p>
            <br />
            <Link to="/trainers" style={{ display: 'inline-block', marginTop: '10px' }}>← Back to List</Link>
        </div>
    );
}

export default TrainerDetail;