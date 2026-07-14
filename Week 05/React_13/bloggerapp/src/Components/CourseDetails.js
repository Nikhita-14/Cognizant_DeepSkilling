import React from 'react';

function CourseDetails() {
  const courses = [
    { id: "C101", name: "Full Stack Java Developer", duration: "12 Weeks" },
    { id: "C102", name: "MERN Stack Specialist", duration: "8 Weeks" }
  ];

  return (
    <div style={{ padding: '15px', backgroundColor: '#fff3cd', borderRadius: '6px' }}>
      <h3>🎓 Academy Course Details</h3>
      <ul>
        {courses.map(course => (
          <li key={course.id} style={{ margin: '8px 0' }}>
            <b>{course.id} - {course.name}</b> ({course.duration})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;