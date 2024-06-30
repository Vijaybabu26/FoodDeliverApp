import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { assets } from '../../assets/assets';
import './LoginPopup.css';

const LoginPopup = () => {
  
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

  // const RegisterSubmit = async (event) => {
  //   event.preventDefault();
  
  //   const data = { userName, phoneNo, password, emailId, address };
  
  //   try {
  //     const response = await axios.post('http://localhost:8080/api/user/registeruser', data, {
  //       headers: {
  //         'Content-Type': 'application/json'
  //       }
  //     });
  
  //     console.log(response.data); 
  
  //     if (response.data.userExists) {
  //       setRegistrationMessage("User already exists. Please choose a different username or log in.");
  //     } else {
  //       alert("User Registration Success");
  //       Navigate('/'); 
  //     }
  //   } catch (error) {
  //     console.error('Error registering user:', error);
  //     // Handle error as needed
  //   }
  // };

  const RegisterSubmit = async (event) => {
    event.preventDefault();
  
    const data = { userName, phoneNo, password, emailId, address };
  
    try {
      const response = await axios.post('http://localhost:8080/api/user/registeruser', data, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
  
      console.log(response.data);
  
      if (response.data) {
        setRegistrationMessage("User already exists. Please choose a different username or log in.");
      } else {
        alert("User Registration Success");
        Navigate('/'); // Corrected function name
      }
    } catch (error) {
      console.error('Error registering user:', error);
      // Handle error as needed (e.g., display an error message)
    }
  };
  
  const LoginSubmit = async (event) => {
    event.preventDefault();
    const data = { phoneNo, password };
  
    try {
      const response = await axios.post('http://localhost:8080/api/user/login', data, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
  
      const result = response.data;
  
      if (result) {
        alert("User Login Success");
        Navigate('/');
        console.log(result);
        console.log(result?.match(/userName=([^,]+)/)?.[1]);

      } else {
        alert("Login failed. Please check your credentials.");
        Navigate('/login');
      }
    } catch (error) {
      alert("User Login Failed");
      console.error('Error logging in:', error);
      // Handle error as needed (e.g., display an error message)
    }
  };

  
// function redirect() {
//   window.location.href = "/"; // Replace "/" with the desired URL
//         }

  return (
    <div className='login-popup'>
      <form action="" className="login-popup-container" onSubmit={currstate === "Login" ? LoginSubmit : RegisterSubmit}>
        <div className="login-popup-title">
            <h2>{currstate}</h2>
            <Link to="/"><img src={assets.cross_icon} alt=""/></Link>
         
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
