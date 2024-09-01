import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './EditItem.css';
const EditItem = () => {
    const[itemId,setitemId] = useState(0);
    const [itemName, setItemName] = useState("");
    const [itemImage, setItemImage] = useState("");
    const [itemDescription, setItemDescription] = useState("");
    const [price, setPrice] = useState("");
    const [availabilty, setAvailabilty] = useState(true); 
    const [category, setCategory] = useState("");
    const [resId, setResId] = useState(0);
    const [product, setProduct] = useState(null);
    
    useEffect(() => {
        fetchitem();
      }, []);

    
    const fetchitem = async () => {
        const itemName = localStorage.getItem('itemName');
        setItemName(itemName);
        try {
            const response = await fetch(`http://localhost:8080/api/menu/edititemview/${itemName}`);
            if (response.ok) {
                const productData = await response.json();
                setProduct(productData);
                setItemName(productData.itemName);
                setItemImage(productData.itemImage);
                setItemDescription(productData.itemDescription);
                setPrice(productData.price);
                setAvailabilty(productData.availabilty);
                setCategory(productData.category);
                setResId(productData.resId.resId);
                setitemId(productData.itemId);
                console.log(productData);
            } else {
                console.error('Failed to fetch product data');
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };
    
    const EditProduct = async (event) => {
        event.preventDefault();
        const restaurantId = resId;
        const data = {
            itemId,
            itemName,
            itemImage,
            itemDescription,
            price,
            resId:  { resId: restaurantId }, // Corrected this line
            availabilty,
            category
        };

        const userConfirmed = window.confirm("Are you sure you want to edit this product?");

        if (!userConfirmed) {
            alert("Product edit canceled.");
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/api/menu/edititem', data, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            console.log(response.data);

            if (response.data) {
                alert("Product Edit Success");
                window.location.href = '/list';
            }
        } catch (error) {
            console.error('Error adding product:', error);
            alert('Failed to Edit product. Please try again.');
        }
    };
  

  return (
    <div>
        <h2>Edit Your Product Details</h2>
              <div className='add'>
            <form className="flex-col" onSubmit={EditProduct}>
                <div className="add-product-name flex-col">
                    <p>Product Image URL</p>
                    <input type='text' name='image' placeholder='Type here' required value={itemImage} onChange={(e) => setItemImage(e.target.value)} />
                </div>
                <div className="add-product-name flex-col">
                    <p>Product Name</p>
                    <input type='text' name='name' placeholder='Type here' required value={itemName} onChange={(e) => setItemName(e.target.value)}/>
                </div>
                <div className="add-product-description flex-col">
                    <p>Description</p>
                    <textarea name='description' rows="6" placeholder='Write Content Here' required value={itemDescription} onChange={(e) => setItemDescription(e.target.value)} ></textarea>
                </div>
                <div className="add-category-price">
                <div className="add-category flex-col">
                    <p>Product Availability</p>
                    <select required value={availabilty} onChange={(e) => setAvailabilty(e.target.value === 'true' ? true : false)}>
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
                        <input type="number" name='price' placeholder='$20' required value={price} onChange={(e) => setPrice(e.target.value)}  />
                    </div>
                </div>
                <button type='submit' className='add-btn'>Edit Product</button>
            </form>
        </div>
    </div>
  )
}

export default EditItem
