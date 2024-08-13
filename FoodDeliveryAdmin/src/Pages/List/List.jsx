import React,{ useEffect, useState } from 'react'
import './List.css'
import { ItemEdit } from '../../Components/ItemEdit/ItemEdit'
const List = () => {
  const [listofproduct,setlistofproducts] = useState([]);

  const [resId, setResId] = useState(0);
  const restaurantId = parseInt(localStorage.getItem('resId'), 10);

  useEffect(()=>{
    fetchdata();
  },[]);

  const fetchdata = async () =>{
    const data = await fetch("http://localhost:8080/api/menu/restaurantmenu/restaurantId",restaurantId);
    const jsonobj = await data.json();
    console.log(jsonobj);
  }

  return listofproduct.length === 0 ? ( 
    <>
    <h1>ADD PRODUCTS TO INCREASE YOUR</h1>
    <h2>REVENUE</h2>
    </>
  ) :(
    <>
    <div className='food-display' id='food-display'>
      <div className="res-container">
        {listofproduct.map((products) => (
          <ItemEdit key={products.itemId}/>
        ))}
      
      </div>
        
      </div><hr></hr>
    </>
    
  )
}

export default List
