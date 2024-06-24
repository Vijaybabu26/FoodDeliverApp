import React from 'react'
import './RestaurantCard.css'
import { Link } from 'react-router-dom'
const RestaurantCard = () => {
  return (
    <div className='restaurantcard'>
        <div className='restaurantcard-details'>
            <h3>Available Restaurants...</h3>
            <Link to="/food">
            <div className='restaurant-details'>
            <img src='https://www.nrn.com/sites/nrn.com/files/styles/article_featured_retina/public/Mcd%20Drive%20Thru.jpg?itok=DeF7fayX'></img>
            <h1>MC DONALD'S Restaurant</h1>     
            <p>Review : 4.5 Stars</p> 
            <p>Vizag</p>
            <h1> &#8377; 200 For Each Person</h1>
            </div>
            </Link>
        </div>
        
    </div>
  )
}

export default RestaurantCard
