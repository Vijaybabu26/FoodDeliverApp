import React from 'react'
import "./ItemEdit.css"

export const ItemEdit = () => {
  return (
    <div className="product-list">
        <div className='product-item'>
    <div><img src="https://www.licious.in/blog/wp-content/uploads/2023/01/Shutterstock_2047827035-1024x683.jpg" alt="" />
    </div>
    <div><h3>Product Name</h3></div>
    <div><h3>Product Price</h3></div>
    <div><button>EDIT</button></div>
    <div><button>DELETE</button></div>
    </div>
    </div>
  )
}
