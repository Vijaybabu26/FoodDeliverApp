import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import StoreContextProvider from "./Context/StoreContext";
import Cart from "./Pages/Cart/Cart";
import Home from "./Pages/Home/Home";
import PlaceOrder from "./Pages/PlaceOrder/PlaceOrder";
import ExploreMenu from "./components/ExploreMenu/ExploreMenu";
import FoodDisplay from "./components/FoodDisplay/FoodDisplay";
import Footer from "./components/Footer/Footer";
import LoginPopup from "./components/Login/LoginPopup";
import Navbar from "./components/Nav/Navbar";
import FoodDisplay from "./components/FoodDisplay/FoodDisplay";

var htmlRoot = document.getElementById("root");
var rootReact = ReactDOM.createRoot(htmlRoot);

const App = () =>{  

  const[showlogin,setshowlogin] = useState(false)
  const[category,setcategory] = useState("All")

  return (
    <>
    {showlogin?<LoginPopup setshowlogin={setshowlogin}/>:<></>}
   
    <div className="App">
       <Navbar setshowlogin={setshowlogin} />  
       <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/cart" element={<Cart/>}/>
        <Route path="/order" element={<PlaceOrder/>}/>
        <Route path="/food" element={<><ExploreMenu category={category} setcategory={setcategory} /><FoodDisplay category={category} /></>}/>
       </Routes>
    </div>
    <Footer/>
    </>
  );
}

export default App;
rootReact.render(
<BrowserRouter>
<StoreContextProvider>
<App/>
</StoreContextProvider>
</BrowserRouter>
);