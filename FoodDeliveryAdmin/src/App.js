import ReactDOM from "react-dom/client";
import React from 'react'
import Navbar from "./Components/Navbar/navbar";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Sidebar from "./Components/Sidebar/sidebar";
import Add from "./Pages/Add/Add";
import List from "./Pages/List/List";
import Order from "./Pages/Order/Order";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Login from "./Login/Login";

var htmlRoot = document.getElementById("root");
var rootReact = ReactDOM.createRoot(htmlRoot);

const App = () => {
  return (
    <div className='Admin'>
      <ToastContainer/>
      <Navbar/>
      <hr/>
      <div className="app-content">
      <Sidebar/>
      <Routes>
        <Route path="/add" element={<Add/>} />
        <Route path="/list" element={<List/>} />
        <Route path="/order" element={<Order/>} />
        <Route path="/login" element={<Login/>}/>
      </Routes>
      </div>
    </div>
  )
}

export default App;
rootReact.render(
<BrowserRouter>
<App/>
</BrowserRouter>
);