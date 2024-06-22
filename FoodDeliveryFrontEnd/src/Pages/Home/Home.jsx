import React, { useState } from 'react'
import ExploreMenu from '../../components/ExploreMenu/ExploreMenu'
import FoodDisplay from '../../components/FoodDisplay/FoodDisplay'
import Header from '../../components/Header/Header'
import RestaurantDisplay from '../../components/RestaurantDisplay/RestaurantDisplay'
import './Home.css'

const Home = () => {

    const[category,setcategory] = useState("All")

  return (
    <div>
      <Header/>
      <RestaurantDisplay/>
      <ExploreMenu category={category} setcategory={setcategory}/>
        <FoodDisplay category={category}/>
    </div>
  )
}

export default Home
