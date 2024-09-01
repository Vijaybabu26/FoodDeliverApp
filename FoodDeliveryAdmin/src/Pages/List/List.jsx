import React, { useEffect, useState } from 'react';
import ItemEdit from "./../../Components/ItemEdit/ItemEdit";
import './List.css';
const List = () => {
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

  return listofproduct1.length === 0 || restaurantId === 0 ? (
    <>
      <h1>ADD PRODUCTS TO INCREASE YOUR</h1><br></br>
      <h2>REVENUE</h2>
    </>
  ) : (
    <>
      <div className='food-display' id='food-display'>
        <div className="res-container">
          {listofproduct.map((product) => (
            <ItemEdit key={product.id} product={product}/>
            

          ))}
        </div>
      </div>
      <hr />
    </>
  );
};

export default List;

