import React from 'react'
import './Sidebar.css'
import { assets } from '../../../AdminAssets/assets'
import { NavLink } from 'react-router-dom'
const Sidebar = () => {
  return (
    <div className='sidebar'>
        <div className="sidebar-options">
            {/* <NavLink to='' className="sidebaroption">
                <img src={assets.Restaurant} alt="" />
                <p>Register Restaurant</p>
            </NavLink> */}
            <NavLink to='/login' className="sidebaroption">
                <img src={assets.RestaurantLogin} alt="" />
                <p>Restaurant Login</p>
            </NavLink>
            <NavLink to='/add' className="sidebaroption">
                <img src={assets.add_icon} alt="" />
                <p>Add Items</p>
            </NavLink>
            <NavLink to='/list' className="sidebaroption">
                <img src={assets.order_icon} alt="" />
                <p>List Items</p>
            </NavLink>
            <NavLink to='/order' className="sidebaroption">
                <img src={assets.parcel_icon} alt="" />
                <p>Orders</p>
            </NavLink>
            
        </div>
    </div>
  )
}

export default Sidebar
