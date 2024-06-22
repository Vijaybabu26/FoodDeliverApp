import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import StoreContextProvider from "./Context/StoreContext";
import Cart from "./Pages/Cart/Cart";
import Home from "./Pages/Home/Home";
import PlaceOrder from "./Pages/PlaceOrder/PlaceOrder";
import FoodItem from "./components/FoodItem/FoodItem";
import Footer from "./components/Footer/Footer";
import LoginPopup from "./components/Login/LoginPopup";
import Navbar from "./components/Nav/Navbar";

var htmlRoot = document.getElementById("root");
var rootReact = ReactDOM.createRoot(htmlRoot);

const App = () =>{  

  const[showlogin,setshowlogin] = useState(false)

  return (
    <>
    {showlogin?<LoginPopup setshowlogin={setshowlogin}/>:<></>}
   
    <div className="App">
       <Navbar setshowlogin={setshowlogin} />  
       <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/cart" element={<Cart/>}/>
        <Route path="/order" element={<PlaceOrder/>}/>
        {/* <Route path="/food" element={<FoodItem/>}/> */}
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