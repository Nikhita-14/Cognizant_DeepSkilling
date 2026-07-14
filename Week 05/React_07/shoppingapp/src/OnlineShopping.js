import React, { Component } from 'react';
import Cart from './Cart';

export class OnlineShopping extends Component {
    render() {
        // Initialize an array with 5 shopping items
        const CartInfo = [
            { itemname: "Laptop", price: 80000 },
            { itemname: "TV", price: 120000 },
            { itemname: "Washing Machine", price: 50000 },
            { itemname: "Mobile", price: 30000 },
            { itemname: "Fridge", price: 70000 }
        ];

        return (
            <div className="mydiv" style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
                <h1>Items Ordered:</h1>
                {/* Invoke the Cart component and pass the array through props */}
                <Cart item={CartInfo} />
            </div>
        );
    }
}