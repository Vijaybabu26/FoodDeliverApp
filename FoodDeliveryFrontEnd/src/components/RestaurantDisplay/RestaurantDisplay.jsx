import React from 'react'
import './RestaurantDisplay.css'
import RestaurantCard from '../RestaurantCard/RestaurantCard'
const RestaurantDisplay = () => {
  return (
    <div className='food-display' id='food-display'>
        <h2>Top Dishes Near You</h2><br></br>
        <div className="food-display-list">
            <RestaurantCard/>
        </div>
    </div>
  )
}

export default RestaurantDisplay
