import React, { useState } from 'react'
import './FoodDisplayR.css';
const FoodDisplayR = () => {

    const [menu ,setmenu] = useState([]);

  return (
    <div>
      <div className='food-display' id='food-display'>
      <h2>Top Dishes In Our Restaurant</h2> 
        <div className="food-display-list">
            {/* {food_list.map((item,index)=>{
              if(category==="All" || category === item.category){
                return <FoodItem key={index} id={item._id} name={item.name} description={item.description} price={item.price} image={item.image}/>
              }                
            })} */}
        </div>
      </div>
    </div>
  )
}

export default FoodDisplayR
