import { useEffect, useState } from "react";
import RestarantCard from "./RestaurantCard";

const Body = () => {
    const [ListOfRestaurants,setListOfRestaurants] = useState([]);
    const [FilteredRestaurants,setFilteredRestaurants] = useState([]);
    const [SearchText,setSearchText] = useState("");

    const FetchResData = async () => {
        const data = await fetch("https://www.swiggy.com/dapi/restaurants/list/v5?lat=17.67740&lng=83.20360&is-seo-homepage-enabled=true&page_type=DESKTOP_WEB_LISTING");

        const ResDataJson = data.json();

        setListOfRestaurants(
            ResDataJson?.data?.cards[2]?.card?.card?.id?.gridElements?.infoWithStyle?.restaurants
        );
        setFilteredRestaurants(
            ResDataJson?.data?.cards[2]?.card?.card?.gridElements?.infoWithStyle?.restaurants
        );
    }
    useEffect(
        () => {
            FetchResData();
        }
    );
    

    return ListOfRestaurants.length === 0 ? (
        <>
        <h1>No Data</h1>
        </>
    ):(
        <>
        <div className="body">
            <div className="filter">
                <div className="search">
                    <input type="text" className="searchbox" value={SearchText} onChange={
                        (e) =>{
                            SearchText =e.target.value;
                            console.log(SearchText);
                        }
                    }/>
                    <button onClick={
                        () =>{
                            console.log(SearchText);
                            const filteredRestaurants = ListOfRestaurants.filter(
                                (restaurants) => {
                                    restaurants.info.name.toLowerCase().include(SearchText.toLowerCase());
                                }
                            );
                            setFilteredRestaurants(filteredRestaurants);
                        }
                    }>SEARCH</button>
                </div>

                <button onClick={
                    () =>{
                        const filterres = ListOfRestaurants.filter(
                            (restaurants) => restaurants.info.avgRating > 4
                        );
                        setListOfRestaurants(filterres);
                    }
                }>TOP RATED RESTAURANTS</button>
            </div>
            <div className="RestaurantContainer">
                {
                    FilteredRestaurants.map(
                        (res) => {
                            <RestarantCard key={res.info.id} resInfo={res}/>
                        }
                    )
                }
            </div>
        </div>
        </>
    );

}
export default Body;