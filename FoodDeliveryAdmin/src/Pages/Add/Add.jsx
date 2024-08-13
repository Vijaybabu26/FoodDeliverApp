import React, { useState } from 'react';
import axios from 'axios';
import './Add.css';

const Add = () => {
    const [itemName, setItemName] = useState("");
    const [itemImage, setItemImage] = useState("");
    const [itemDescription, setItemDescription] = useState("");
    const [price, setPrice] = useState("");
    const [availability, setAvailability] = useState(true); 
    const [category, setCategory] = useState("");
    const [resId, setResId] = useState(0);

    const restaurantId = parseInt(localStorage.getItem('resId'), 10);
    console.log(restaurantId);

    const AddProduct = async (event) => {
        event.preventDefault();
        setResId(restaurantId);
        const data = {
            itemName,
            itemImage,
            itemDescription,
            price,
            resId:  { resId: restaurantId }, // Corrected this line
            availability,
            category
        };

        try {
            const response = await axios.post('http://localhost:8080/api/menu/additem', data, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            console.log(response.data);

            if (response.data) {
                alert("Product Adding Success");
                window.location.href = '/list';
            }
        } catch (error) {
            console.error('Error adding product:', error);
            alert('Failed to add product. Please try again.');
        }
    };

    return (
        <div className='add'>
            <form className="flex-col" onSubmit={AddProduct}>
                <div className="add-product-name flex-col">
                    <p>Product Image URL</p>
                    <input type='text' name='image' placeholder='Type here' required value={itemImage} onChange={(e) => setItemImage(e.target.value)} />
                </div>
                <div className="add-product-name flex-col">
                    <p>Product Name</p>
                    <input type='text' name='name' placeholder='Type here' required value={itemName} onChange={(e) => setItemName(e.target.value)} />
                </div>
                <div className="add-product-description flex-col">
                    <p>Description</p>
                    <textarea name='description' rows="6" placeholder='Write Content Here' required value={itemDescription} onChange={(e) => setItemDescription(e.target.value)}></textarea>
                </div>
                <div className="add-category-price">
                    <div className="add-category flex-col">
                        <p>Product Availability</p>
                        <select required value={availability} onChange={(e) => setAvailability(e.target.value === 'true')}>
                            <option value="true">AVAILABLE</option>
                            <option value="false">NOT AVAILABLE</option>
                        </select>
                    </div>
                    <div className="add-product-name flex-col">
                        <p>Product Category</p>
                        <input type='text' name='category' placeholder='Type here' required value={category} onChange={(e) => setCategory(e.target.value)} />
                    </div>
                    <div className="add-price">
                        <p>Product Price</p>
                        <input type="number" name='price' placeholder='$20' required value={price} onChange={(e) => setPrice(e.target.value)} />
                    </div>
                </div>
                <button type='submit' className='add-btn'>Add Product</button>
            </form>
        </div>
    );
};

export default Add;
