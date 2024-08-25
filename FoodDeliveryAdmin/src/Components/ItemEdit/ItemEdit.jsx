import React from 'react'
import "./ItemEdit.css"

export const ItemEdit = (props) => {
  return (
    <div className="product-list">
        <div className='product-item'>
    <div><img src={props.product.itemImage} alt="" />
    </div>
    <div><h3>Product Name : {props.product.itemName}</h3></div>
    <div><h3> Price : &#8377; {props.product.price}</h3></div>
    <div><h3>Category : {props.product.category}</h3></div>
    <div><button>EDIT</button></div>
    <div><button>DELETE</button></div>
    </div>
    </div>
  )
}
