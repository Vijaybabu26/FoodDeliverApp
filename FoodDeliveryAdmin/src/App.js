import React, { useEffect, useState } from 'react';
import ReactDOM from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Navbar from "./Components/Navbar/navbar";
import Sidebar from "./Components/Sidebar/sidebar";
import Login from "./Login/Login";
import Add from "./Pages/Add/Add";
import List from "./Pages/List/List";
import Order from "./Pages/Order/Order";

import LogOut from './Components/LogOut/LogOut';
import EditItem from './Pages/EditItem/EditItem';

var htmlRoot = document.getElementById("root");
var rootReact = ReactDOM.createRoot(htmlRoot);



const App = () => {
  const [resname,setresname] = useState("")
  useEffect(()=>{
    const ResName = localStorage.getItem('resName');
    setresname(ResName);
    
  },[])
  return (
    <div className='Admin'>
      <ToastContainer/>
      <Navbar/>
      <h2 style={{ textAlign: 'center' }}>Welcome, {resname}</h2><br></br>
      <h3 style={{ textAlign: 'center' }}>Add More Products To Increase Your Sales</h3><br></br>
      <LogOut/><br></br>
      <hr/>
      <div className="app-content">
      <Sidebar/>
      <Routes>
        <Route path="/add" element={<Add/>} />
        <Route path="/list" element={<List/>} />
        <Route path="/order" element={<Order/>} />
        <Route path="/login" element={<Login/>}/>
        <Route path="/edititem" element={<EditItem/>}/>
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