import React, { Component } from 'react';

class Cart extends Component {
    render() {
        return (
            <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', marginTop: '15px' }}>
                <thead>
                    <tr style={{ backgroundColor: '#f2f2f2' }}>
                        <th>Item Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {/* Loop through the passed item array prop using map */}
                    {this.props.item.map((item, index) => {
                        return (
                            <tr key={index}>
                                <td>{item.itemname}</td>
                                <td>Rs. {item.price}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        );
    }
}

export default Cart;