import axios from 'axios';
import React from 'react';
import "./ItemEdit.css";
const ItemEdit = (props) => {
  
  const productName = props.product.itemName;
  const availability = props.product.availabilty;
  console.log(availability);

const availabilityStatus = availability ? 'Available' : 'Not Available';
console.log(availabilityStatus);

  console.log(productName);



const DeleteProduct = async (event) => {
  event.preventDefault();
  const confirmDelete = window.confirm("Are you sure you want to delete this product?");
  if (!confirmDelete) {
    return; // If the user cancels, do nothing
  }

  try {
    const response = await axios.post(`http://localhost:8080/api/menu/deleteitem/${props.product.itemName}`);
    if (response.status === 200) {
      alert("Product Deleted Successfully");
      localStorage.setItem('itemName',null);
      window.location.href = '/list';
    } else {
      throw new Error('Failed to delete product');
    }
  } catch (error) {
    console.error('Error deleting product:', error);
    alert('Failed to delete product. Please try again.');
  }
};

const EditItem = async (event) =>{
  event.preventDefault();
  window.location.href = '/edititem';
  localStorage.setItem('itemName',productName);
}

  return (
        <div className="product-list">
            <div className='product-item'>
        <div><img src={props.product.itemImage} alt="" /></div>
        <div><h3>Product Name : {props.product.itemName}</h3></div>
        <div><h3> Price : &#8377; {props.product.price}</h3></div>
        <div><h3>Category : {props.product.category}</h3></div>
        <div><h3>Status : {availabilityStatus}</h3></div>
        <div>
          <form onSubmit={EditItem}><button>EDIT</button></form></div>
          <div>
          <form onSubmit={DeleteProduct}><button>DELETE</button></form>
          </div>
        </div>
        </div>
  )
}

export default ItemEdit

