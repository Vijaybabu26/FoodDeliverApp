import {RES_IMG}from "./Constants";
const RestarantCard = (props) => {
    <div className="restaurantcard">
        <img
      className="res-logo"
      src={RES_IMG + props.resInfo.info.cloudinaryImageId}
    />
    <h3>{props.resInfo.info.name}</h3>
    <h3>{props.resInfo.info.cuisines.join(", ")}</h3>
    <h3>{props.resInfo.info.avgRating}</h3>
    <h3>{props.resInfo.info.costForTwo}</h3>
    </div>
}
export default RestarantCard;