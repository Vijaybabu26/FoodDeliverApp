import React from 'react'
import './RestaurantCard.css'
import { assets } from '../../assets/assets'

const RestaurantCard = () => {
  return (
    <div className='restaurantcard'>
        <div className='restaurantcard-details'>
            <h1>Available Restaurants...</h1>
            <div className='restaurant-details'>
                <div className='restaurant-image'>
                <img src="https://images.pexels.com/photos/941861/pexels-photo-941861.jpeg?cs=srgb&dl=pexels-chanwalrus-941861.jpg&fm=jpg" alt="" />
                </div>
                
                <h3>Tomato Restaurant</h3>
                <div className="food-item-info">
                <div className='food-item-name-rating'>
                    <img src={assets.rating_starts} alt=''/>
                </div>
                <p className="food-item-desc">
                    Food Items Available In Our Restaurants
                </p>
                <p className="food-item-price">
                    For Each Person : &#8377; 200
                </p>
            </div>
            </div>
        </div>
    </div>
  )
}

export default RestaurantCard
