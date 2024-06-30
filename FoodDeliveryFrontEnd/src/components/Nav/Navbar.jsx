import React, { useContext, useState } from 'react';
import { Link } from 'react-router-dom';
import { StoreContext } from '../../Context/StoreContext';
import { assets } from '../../assets/assets';
import './Navbar.css';

const Navbar = () => {
  // {setshowlogin}
const [menu,setmenu] = useState("home");

const{getTotalCartAmount} = useContext(StoreContext)

  return (
    <>
    <div className='navbar'>
          {/* <img src={assets.logo} alt="" className="logo" /> */}
          <Link to='/'><img src="https://png.pngtree.com/template/20191014/ourmid/pngtree-pin-food-delivery-map-location-delivery-logo-concept-image_318151.jpg" alt="" className="logo" /></Link>
          <ul className="navbar-menu">
          <Link to='/' onClick={() => setmenu("home")} className={menu === "home" ? "active" : ""}><li>HOME</li></Link>
              <Link to="/food" onClick={() => setmenu("menu")} className={menu === "menu" ? "active" : ""} ><li>MENU</li></Link>
                <li onClick={() => setmenu("Mobile")} className={menu === "Mobile" ? "active" : ""}>MOBILE</li>
                {/* <li onClick={() => setmenu("Register")} className={menu === "Register" ? "active" : ""}>REGISTER</li> */}
                {/* <li onClick={() => setmenu("SignIn")} className={menu === "SignIn" ? "active" : ""}>SIGN IN</li> */}
                <li onClick={() => setmenu("ContactUs")} className={menu === "ContactUs" ? "active" : ""} > CONTACT US</li>
          </ul><div className="navbar-right">
          <img src={assets.search_icon} alt='' />
              
              <div className="navbar-search-icon">
              <Link to='/cart'><img src={assets.basket_icon} alt="" /></Link>
                  <div className={getTotalCartAmount()===0?"":"dot"}></div>
              </div>
              <button ><Link to='/login'>SIGN IN</Link></button>
              {/* onClick={()=>setshowlogin(true)} */}
              <li></li>
          </div>
    </div>
    </>
  )
}

export default Navbar
