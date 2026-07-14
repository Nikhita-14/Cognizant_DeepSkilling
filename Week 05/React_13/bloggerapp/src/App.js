import React, { useState } from 'react';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  // State tracking which section should be rendered
  const [activeTab, setActiveTab] = useState('none');

  // Multi-way Conditional Rendering Logic using standard expressions
  let renderedContent;
  if (activeTab === 'books') {
    renderedContent = <BookDetails />;
  } else if (activeTab === 'blogs') {
    renderedContent = <BlogDetails />;
  } else if (activeTab === 'courses') {
    renderedContent = <CourseDetails />;
  } else {
    renderedContent = <p style={{ color: '#666', fontStyle: 'italic' }}>Please select a tab above to view relevant technical resource streams.</p>;
  }

  return (
    <div style={{ maxWidth: '650px', margin: '30px auto', fontFamily: 'Arial, sans-serif', border: '1px solid #ddd', borderRadius: '8px', padding: '20px' }}>
      <h2 style={{ textAlign: 'center', color: '#2c3e50' }}>Cognizant Blogger Dashboard</h2>
      <hr />

      {/* Navigation Buttons Area */}
      <div style={{ display: 'flex', justifyContent: 'space-around', marginBottom: '25px' }}>
        <button 
          onClick={() => setActiveTab('books')}
          style={{ padding: '10px 15px', cursor: 'pointer', fontWeight: activeTab === 'books' ? 'bold' : 'normal' }}
        >
          Book Details
        </button>
        <button 
          onClick={() => setActiveTab('blogs')}
          style={{ padding: '10px 15px', cursor: 'pointer', fontWeight: activeTab === 'blogs' ? 'bold' : 'normal' }}
        >
          Blog Details
        </button>
        <button 
          onClick={() => setActiveTab('courses')}
          style={{ padding: '10px 15px', cursor: 'pointer', fontWeight: activeTab === 'courses' ? 'bold' : 'normal' }}
        >
          Course Details
        </button>
      </div>

      {/* Output Content display workspace section container */}
      <div style={{ border: '1px solid #eee', padding: '15px', borderRadius: '4px', minHeight: '150px' }}>
        {renderedContent}
      </div>
    </div>
  );
}

export default App;