import React from 'react';
import { Link } from 'react-router-dom';

function TrainersList({ trainers }) {
    return (
        <div style={{ padding: '20px' }}>
            <h2>Our Trainers</h2>
            <ul>
                {trainers.map((trainer) => (
                    <li key={trainer.TrainerId} style={{ margin: '10px 0', fontSize: '18px' }}>
                        {/* Dynamic route passing the individual trainer ID */}
                        <Link to={`/trainers/${trainer.TrainerId}`}>
                            {trainer.Name}
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TrainersList;