import React, { useState } from 'react'
import Header from '../../components/Header/Header'
import RestaurantDisplay from '../../components/RestaurantDisplay/RestaurantDisplay'
import './Home.css'

const Home = () => {

    const[category,setcategory] = useState("All")

  return (
    <div>
      <Header/>
      <RestaurantDisplay/>
      {/* <ExploreMenu category={category} setcategory={setcategory}/>
        <FoodDisplay category={category}/> */}
    </div>
  )
}

export default Home
