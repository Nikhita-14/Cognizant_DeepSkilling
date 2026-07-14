import React from 'react';
import '../Stylesheets/mystyle.css'; // Importing the style sheet

// Function component passing props using destructuring
export const CalculateScore = ({ Name, School, Total, goal }) => {
    // Calculating the average score based on Total out of 5 goals (as per common grading metrics)
    const calculateAverage = (total, goalCount) => {
        return (total / goalCount).toFixed(2);
    };

    return (
        <div className="formatstyle">
            <h1><font color="blue">Student Details</font></h1>
            <div className="student-info">
                <p><b>Name:</b> <span>{Name}</span></p>
                <p><b>School:</b> <span>{School}</span></p>
                <p><b>Total:</b> <span>{Total}</span></p>
                <p><b>Goal:</b> <span>{goal}</span></p>
                <p><b>Average:</b> <span>{calculateAverage(Total, goal)}</span></p>
            </div>
        </div>
    );
};