import React from 'react';
import './FoodDisplayR.css';
const FoodDisplayR = () => {
    const [listofproduct, setlistofproducts] = useState([]);
    const restaurantId = parseInt(localStorage.getItem('resId'));
  const listofproduct1 = Array.isArray(listofproduct) ? listofproduct : [];
  useEffect(() => {
    fetchdata();
  }, []);

  const fetchdata = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/menu/restaurantmenu/${restaurantId}`);
      const jsonobj = await response.json();
      setlistofproducts(jsonobj); // Update the state with fetched data
      console.log(jsonobj);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };
  return (
    <div className='food-display' id='food-display'>
    <h2>Top Dishes Near You</h2> 
    <div className="food-display-list">
        {listofproduct.map((item)=>{
          if(category==="All" || category === item.category){
            return <FoodDisplayR key={item}/>
          }                
        })}
    </div>
</div>
  )
}

export default FoodDisplayR
