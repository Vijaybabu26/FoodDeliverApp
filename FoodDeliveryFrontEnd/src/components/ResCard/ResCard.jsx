import React from 'react';
import './ResCard.css';
const ResCard = (props) => {
  
  const restaurantId = props.resinfo.resId;
  
  const menu = async (event) =>{
    event.preventDefault();
    window.location.href ='/restaurantmenu';
    localStorage.setItem('resId',restaurantId);
  }

  
  // const fetchdata = async () => {
  
  //   try {
  //     const response = await fetch(`http://localhost:8080/api/menu/restaurantmenu/${restaurantId}`);
  //     const jsonobj = await response.json();
  //     setlistofproducts(jsonobj); // Update the state with fetched data
  //     console.log(jsonobj);
  //   } catch (error) {
  //     console.error('Error fetching data:', error);
  //   }
  // };

  return (
    <div>
      <div className="rescard">
        <img src={props.resinfo.resImage} alt="" className="resimage"/>
        <div className="res-info">
        <h3>{props.resinfo.resName}</h3>
        <h3>Average Rating : {props.resinfo.resAvgRating}</h3>
        <h3>Delivery Fee :  &#8377; {props.resinfo.resDelievryFee}</h3>
        </div>
        
      </div>
    </div>
  )
}

export default ResCard
