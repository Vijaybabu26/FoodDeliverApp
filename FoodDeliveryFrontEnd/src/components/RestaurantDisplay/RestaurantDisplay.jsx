import React from 'react'
import RestaurantCard from '../RestaurantCard/RestaurantCard'
import './RestaurantDisplay.css'


const RestaurantDisplay = () => {
  return (
    <div className='food-display' id='food-display'>
        <h2>Top Restaurants Near You</h2><br></br>
        <div className="food-display-list">
            <RestaurantCard/>
        </div>
    </div>
  )
}

export default RestaurantDisplay
