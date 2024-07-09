import axios from 'axios';
import React, { useState } from 'react';
import './Login.css';

const Login = () => {

  // const[image,setimage]  = useState(false)

  const[currstate,setcurrstate] = useState("Login");

  const[resName,setresName] = useState("");
  const[resPhoneNo,setresPhoneNo] = useState("");
  const[resPassword,setresPassword] = useState("");
  const[resDescription,setresDescription] = useState("");
  const[resAddress,setAddress] = useState("");
  const[resOperationHours,setresOperationHours] = useState();
  const[resAvgRating,setresAvgRating] = useState();
  const[resDelievryFee,setresDelievryFee] = useState();
  const[resImage,setresImage] = useState("");

  // const RegisterSubmit = async (event) =>{
  //   event.preventDefault();

  //   const data = { resName , resPhno, resPassword, resDesc,resAddress,reshours,resAvgrating,resdeliveryfee, resimage }
  
  //   try {
  //     const response = await axios.post('http://localhost:8080/api/restaurant/registerrestaurant', data, {
  //       headers: {
  //           'Content-Type': 'application/json'
  //       }
  //   });

  //     console.log(response.data);

  //     if (response.data) {
  //         alert("Restaurant Registration Success");
  //         // Corrected the function name: It should be `navigate` instead of `Navigate`
  //         Navigate('/login');
  //     }
  // } catch (error) {
  //     console.error('Error registering user:', error);
  //     // Handle error as needed (e.g., display an error message)
  // }
  
  // }

  const RegisterSubmit = async (event) => {
    event.preventDefault();

    const data = {
        resName,
        resPhoneNo,
        resPassword,
        resDescription,
        resAddress,
        resOperationHours,
        resAvgRating,
        resDelievryFee,
        resImage
    };

    try {
        const response = await axios.post('http://localhost:8080/api/restaurant/registerrestaurant', data, {
            headers: {
                'Content-Type': 'application/json'
            }
        });

        console.log(response.data);

        if (response.data) {
            alert("Restaurant Registration Success");
            // Corrected the function name: It should be `navigate` instead of `Navigate`
            Navigate('/login');
        }
    } catch (error) {
        console.error('Error registering user:', error);
        // Handle error as needed (e.g., display an error message)
    }
};


  // const LoginSubmit = async (event) =>{
  //   event.preventDefault();
  //   const data = {resPhno, resPassword};
  //   try {
  //     const response = await axios.post('http://localhost:8080/api/restaurant/login', data, {
  //       headers: {
  //           'Content-Type': 'application/json'
  //       }
  //   });
  //     const result = response.data;
  //     if(result){
  //       alert("Restaurant Login Success")
  //       localStorage.setItem('resphno',response.data.resPhoneNo);
  //       localStorage.setItem('respassword', response.data.resPassword);
  //       localStorage.setItem('resName', response.data.resName);
  //       localStorage.setItem('resDescription',response.data.resDescription);
  //       localStorage.setItem('resAddress',response.data.resAddress);
  //       localStorage.setItem('reshours',response.data.resOperationHours);
  //       localStorage.setItem('resavgrating',response.data.resAvgRating);
  //       localStorage.setItem('resDeliveryFee',response.data.resDelievryFee);
  //       localStorage.setItem('resImage',response.data.resImage);
  //       console.log(localStorage.getItem('resName'));
  //       window.location.href='/add';
  //       console.log(result);
  //     }else {
  //       alert("Login failed. Please check your credentials.");
  //       // Correct the typo: It should be 'navigate' instead of 'Navigate'
  //       Navigate('/login');
  //   }
  //   } catch (error) {
  //     alert("User Login Failed");
  //     console.error('Error logging in:', error);
  //     // Handle error as needed (e.g., display an error message)
  //   }
    
  // }

  const LoginSubmit = async (event) => {
    event.preventDefault();
    const data = { resPhoneNo, resPassword };
    try {
        const response = await axios.post('http://localhost:8080/api/restaurant/login', data, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const result = response.data;
        if (result) {
            alert("Restaurant Login Success");
            localStorage.setItem('resphno', response.data.resPhoneNo);
            localStorage.setItem('respassword', response.data.resPassword);
            localStorage.setItem('resName', response.data.resName);
            localStorage.setItem('resDescription', response.data.resDescription);
            localStorage.setItem('resAddress', response.data.resAddress);
            localStorage.setItem('reshours', response.data.resOperationHours);
            localStorage.setItem('resavgrating', response.data.resAvgRating);
            localStorage.setItem('resDeliveryFee', response.data.resDelievryFee);
            localStorage.setItem('resImage', response.data.resImage);
            console.log(localStorage.getItem('resName'));
            window.location.href = '/add';
            console.log(result);
        } else {
            alert("Login failed. Please check your credentials.");
            // Correct the typo: It should be 'navigate' instead of 'Navigate'
            Navigate('/login');
        }
    } catch (error) {
        alert("User Login Failed");
        console.error('Error logging in:', error);
        // Handle error as needed (e.g., display an error message)
    }
};
console.log(resPhoneNo);

  return (
    <div className='Login'>
        <form action="" onSubmit={currstate === "Login" ? LoginSubmit : RegisterSubmit}>
          <div className="login-tittle">
          <h2>{currstate}</h2>
          </div>
          <div className="login-input">
          <p>Restaurant Phone No</p>
          <input type='text' placeholder='Restaurant Phno' required value={resPhoneNo} onChange={(e)=> setresPhoneNo(e.target.value)}/>
          <p>Restaurant Password</p>
          <input type='text' placeholder='Restaurant Password' required value={resPassword} onChange={(e)=> setresPassword(e.target.value)}/>
          
          {currstate==="Login"?<></>
            :<><p>Restaurant Name</p><input type='text' placeholder='Restaurant Name' required value={resName} onChange={(e)=> setresName(e.target.value)}/></>}
          
          {currstate==="Login"?<></>
            :<><p>Restaurant Description</p><textarea placeholder='Restaurant Description' id='myTextarea' required value={resDescription} onChange={(e)=> setresDescription(e.target.value)}></textarea></>}
          
          {currstate==="Login"?<></>
            :<><p>Restaurant Address</p><textarea placeholder='Restaurant Address' id='myTextarea' required value={resAddress} onChange={(e)=> setAddress(e.target.value)}></textarea></>}
            
          {currstate==="Login"?<></>
            :<><p>Restaurant Operational In Hours</p><input type='number' placeholder='Operational Hours' required value={resOperationHours} onChange={(e)=>setresOperationHours(e.target.value)}/></>}
          
          {currstate==="Login"?<></>
            :<><p>Delivery Fee</p><input type='number' placeholder='Delivery Fee' required value={resDelievryFee} onChange={(e)=>setresDelievryFee(e.target.value)}/></>}
          
          {currstate==="Login"?<></>
            :<><p>Average Rating</p><input type='number' placeholder='Restaurant Rating' required value={resAvgRating} onChange={(e)=> setresAvgRating(e.target.value)}/></>}

          {currstate==="Login"?<></>
          :<><p>Restaurant Image Url</p><input type='text' placeholder='Restaurant Image Url' required value={resImage} onChange={(e)=> setresImage(e.target.value)}/></>}

          <button type='submit' className='add-btn'>{currstate}</button>
          
                {currstate==="Login"
                ?<p>Create a New Account? <span onClick={()=>setcurrstate("Sign Up")}>Click Here</span></p>
                :<p>Already have An Account? <span onClick={()=> setcurrstate("Login")}>Login Here</span></p>
                }
                {/* onChange={(e) => setphoneNo(e.target.value) } */}
          </div>
        </form>
        
    </div>
  )
}

export default Login
