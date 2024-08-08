import React from 'react'
import './LogOut.css'
import { assets } from '../../../AdminAssets/assets'

const LogOut = () => {
    const LogOut = async (event) =>{
        localStorage.removeItem('resId');
        localStorage.removeItem('resphno');
        localStorage.removeItem('respassword');
        localStorage.removeItem('resName');
        localStorage.removeItem('resDescription');
        localStorage.removeItem('resAddress');
        localStorage.removeItem('reshours');
        localStorage.removeItem('resavgrating');
        localStorage.removeItem('resDeliveryFee');
        localStorage.removeItem('resImage');
        localStorage.setItem('resImage', assets.profile_image);
        window.location.href = '/login';
    };
    
  return (
        <>
        <center>
        <button className='button-logout' onClick={LogOut} >LOG OUT</button><br></br>
        </center>
        </>
  )
}

export default LogOut
