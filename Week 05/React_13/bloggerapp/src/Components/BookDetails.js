import React from 'react';

function BookDetails() {
  const books = [
    { id: 1, title: "React Up & Running", author: "Stoyan Stefanov", price: "Rs. 450" },
    { id: 2, title: "Learning React", author: "Alex Banks", price: "Rs. 600" }
  ];

  return (
    <div style={{ padding: '15px', backgroundColor: '#eef', borderRadius: '6px' }}>
      <h3>📚 Book Details Collection</h3>
      {books.map(book => (
        <div key={book.id} style={{ marginBottom: '10px', borderBottom: '1px dashed #999' }}>
          <p><b>Title:</b> {book.title}</p>
          <p><b>Author:</b> {book.author} | <b>Price:</b> {book.price}</p>
        </div>
      ))}
    </div>
  );
}

export default BookDetails;