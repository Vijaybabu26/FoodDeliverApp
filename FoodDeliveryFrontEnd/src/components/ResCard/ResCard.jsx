import React from 'react'
import './ResCard.css'
const ResCard = (props) => {
  return (
    <div>
      <div className="rescard">
        <img src={props.resinfo.resImage} alt="" className="resimage"/>
        <h3>{props.resinfo.resName}</h3>
        <h3>Average Rating : {props.resinfo.resAvgRating}</h3>
        <h3>Delivery Fee :  &#8377; {props.resinfo.resDelievryFee}</h3>
      </div>
    </div>
  )
}

export default ResCard
