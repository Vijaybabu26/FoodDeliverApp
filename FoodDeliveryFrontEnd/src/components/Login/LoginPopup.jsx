import React, { useState } from 'react'
import { assets } from '../../assets/assets'
import './LoginPopup.css'
const LoginPopup = ({setshowlogin}) => {

    const[currstate,setcurrstate] = useState("Login")

  return (
    <div className='login-popup'>
      <form action="" className="login-popup-container">
        <div className="login-popup-title">
            <h2>{currstate}</h2>
            <img onClick={()=>setshowlogin(false)} src={assets.cross_icon} alt="" />
        </div>
        <div className="login-popup-input">
            {currstate==="Login"?<></>
            :<input type='text' placeholder='Your Name' required/>}
            
            {currstate==="Login"?<></>
            :<input type='text' placeholder='Your Email' required/>}

            <input type='text' placeholder='Your Phno' required/>

            {currstate==="Login"?<></>
            :<textarea placeholder='Your Address' required></textarea>}

            <input type='password' placeholder='Password' required/>
        </div>
        <button>{currstate==="Sign Up"?"Create Account":"Login"}</button>
        <div className="login-popup-condition">
            <input type='checkbox' required/>
            <p>By Continuing, I Agree To The Terms Of use & Privacy Policy.</p>
        </div>
        {currstate==="Login"
        ?<p>Create a New Account? <span onClick={()=>setcurrstate("Sign Up")}>Click Here</span></p>
        :<p>Already have An Account? <span onClick={()=> setcurrstate("Login")}>Login Here</span></p>
        }
      </form>
    </div>
  )
}

export default LoginPopup
