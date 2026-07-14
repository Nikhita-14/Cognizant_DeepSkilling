import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
    constructor(props) {
        super(props);
        // Initialize the component state with an empty array of posts and an error flag [cite: 85]
        this.state = {
            posts: [],
            error: null
        };
    }

    // Method responsible for fetching data from the API and storing it in state [cite: 86]
    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                // Map the raw JSON objects into instances of our Post class
                const postInstances = data.map(p => new Post(p.id, p.title, p.body));
                this.setState({ posts: postInstances });
            })
            .catch(err => {
                // Trigger lifecycle error mechanism if fetch fails completely
                this.componentDidCatch(err, { componentStack: 'loadPosts fetch routine' });
            });
    }

    // Lifecycle hook that runs automatically after the component is inserted into the DOM [cite: 70, 89]
    componentDidMount() {
        this.loadPosts();
    }

    // Lifecycle hook responsible for catching errors in child components or routines [cite: 71]
    componentDidCatch(error, errorInfo) {
        alert(`An error occurred in the component: ${error.message}`);
        this.setState({ error: error.message });
    }

    render() {
        const { posts, error } = this.state;

        if (error) {
            return <div style={{ color: 'red', padding: '20px' }}><h3>Failed to load blog posts.</h3></div>;
        }

        return (
            <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
                <h2>Latest Blog Posts</h2>
                <hr />
                {posts.length === 0 ? (
                    <p>Loading posts...</p>
                ) : (
                    posts.map(post => (
                        <div key={post.id} style={{ margin: '20px 0', padding: '15px', border: '1px solid #ddd', borderRadius: '5px' }}>
                            {/* Rendering the title using a heading and the content using a paragraph [cite: 62] */}
                            <h3 style={{ color: '#2c3e50', textTransform: 'capitalize' }}>{post.id}. {post.title}</h3>
                            <p style={{ color: '#7f8c8d' }}>{post.body}</p>
                        </div>
                    ))
                )}
            </div>
        );
    }
}

export default Posts;