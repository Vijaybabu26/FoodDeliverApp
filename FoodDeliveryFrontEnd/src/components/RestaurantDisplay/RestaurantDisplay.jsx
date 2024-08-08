import React, { useEffect, useState } from 'react';
import ResCard from '../ResCard/ResCard';
import RestaurantCard from '../RestaurantCard/RestaurantCard';
import './RestaurantDisplay.css';


const RestaurantDisplay = () => {

  const [listofrestaurant,setlistofrestaurant] = useState([]);

  useEffect(()=>{
    fetchdata();
  },[]);

  const fetchdata = async () =>{
    const data = await fetch("http://localhost:8080/api/restaurant/restaurantlist");
    const jsonobj = await data.json();
    console.log(jsonobj);
    setlistofrestaurant(jsonobj);
    console.log(listofrestaurant);
  }

  return listofrestaurant.length === 0 ? ( 
    <>
    <h1>Restaurants Are Closed</h1>
    <h2>EXPLORE OUR PAGE</h2>
    </>
  ) :(
    <div className='food-display' id='food-display'>
        <h2>Top Restaurants Near You</h2><br></br>
        <div className="food-display-list">
           {/* <RestaurantCard/> */}
           <div className="res-container">
            {listofrestaurant.map((restaurant) => (
              <ResCard key={restaurant.resId} resinfo={restaurant}/>
            ))}
           </div>
           
        </div>
    </div>
  )
}

export default RestaurantDisplay
