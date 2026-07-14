import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 1, topic: "State vs Props", reads: "15k reads", excerpt: "Understanding data flow models in standard React components..." },
    { id: 2, topic: "Hooks Revolution", reads: "22k reads", excerpt: "Deep dive into functional components using useState and useEffect hooks..." }
  ];

  return (
    <div style={{ padding: '15px', backgroundColor: '#efe', borderRadius: '6px' }}>
      <h3>✍️ Trending Blog Details</h3>
      {blogs.map(blog => (
        <div key={blog.id} style={{ marginBottom: '10px', borderBottom: '1px dashed #999' }}>
          <h4>{blog.topic} ({blog.reads})</h4>
          <p>{blog.excerpt}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;