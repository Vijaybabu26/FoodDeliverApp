import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { assets } from '../../assets/assets';
import './LoginPopup.css';

const LoginPopup = ({setshowlogin}) => {

  const Navigate = useNavigate();

    const[currstate,setcurrstate] = useState("Login")


    const[userName,setuserName] = useState("")
    const[phoneNo,setphoneNo] = useState("")
    const[password,setpassword] = useState("")
    const[emailId,setemailId] = useState("")
    const [address, setaddress] = useState("")
    

    function getTextareaValue(event) {
      setaddress(event.target.value);
    }

  const RegisterSubmit = async (event) => {
    event.preventDefault();
  
    const data = { userName, phoneNo, password, emailId, address };
  
    try {
      const response = await axios.post('http://localhost:8080/api/user/registeruser', data, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
  
      console.log(response.data); // Assuming response.data is the JSON object returned by the server
  
      if (response.data.userExists) {
        setRegistrationMessage("User already exists. Please choose a different username or log in.");
      } else {
        alert("User Registration Success");
        Navigate('/'); 
      }
    } catch (error) {
      console.error('Error registering user:', error);
      // Handle error as needed
    }
  };
  


  const LoginSubmit = async (event) => {
    event.preventDefault();
    const data = {phoneNo, password};
    const response = await fetch('http://localhost:8080/api/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
        
    });
    const result = await response.json();
    alert("User Login Success");
        Navigate('/'); 
    console.log(result);
}
// function redirect() {
//   window.location.href = "/"; // Replace "/" with the desired URL
//         }

  return (
    <div className='login-popup'>
      <form action="" className="login-popup-container" onSubmit={currstate === "Login" ? LoginSubmit : RegisterSubmit}>
        <div className="login-popup-title">
            <h2>{currstate}</h2>
            <img onClick={()=>setshowlogin(false)} src={assets.cross_icon} alt="" />
        </div>
        <div className="login-popup-input">
            {currstate==="Login"?<></>
            :<input type='text' placeholder='Your Name' required value={userName}
            onChange={(e) => setuserName(e.target.value) }/>}
            
            {currstate==="Login"?<></>
            :<input type='text' placeholder='Your Email' required value={emailId}
            onChange={(e) => setemailId(e.target.value) }/>}

            <input type='text' placeholder='Your Phno' required value={phoneNo}
          onChange={(e) => setphoneNo(e.target.value) }/>
            {currstate==="Login"?<></>
            :<textarea placeholder='Your Address' id='myTextarea' required onChange={getTextareaValue}></textarea>}

            <input type='password' placeholder='Password' required value={password}
          onChange={(e) => setpassword(e.target.value) }/>
        </div>
        <button><span onClick={()=>setshowlogin(false)}></span>{currstate==="Sign Up"?"Create Account":"Login"}</button>
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
