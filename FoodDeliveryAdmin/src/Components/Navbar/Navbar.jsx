import React, { useEffect, useState } from 'react';
import { assets } from '../../../AdminAssets/assets';
import './Navbar.css';
const Navbar = () => {
  const [resimage,setresimage] = useState("");
  useEffect(()=>{
    const restimage = localStorage.getItem('resImage');
    setresimage(restimage);
    
  },[])
  return (
    <>
    <div className='navbar'>
      <img className='logo' src={assets.logo} alt="" />
      
      <img className='profile' src={resimage} alt="" />
    </div>
    </>
  )
}

export default Navbar
