import React from 'react'
import './Login.css'
import { assets } from '../../AdminAssets/assets'
import { useState } from 'react'

const Login = () => {

  const[image,setimage]  = useState(false)

  const[currstate,setcurrstate] = useState("Login")

  return (
    <div className='Login'>
        <form>
          <div className="login-tittle">
          <h2>{currstate}</h2>
          </div>
          <div className="login-input">
          <p>Restaurant Phone No</p>
          <input type='text' placeholder='Restaurant Phno' required />
          <p>Restaurant Password</p>
          <input type='text' placeholder='Restaurant Password' required />
          
          {currstate==="Login"?<></>
            :<><p>Restaurant Name</p><input type='text' placeholder='Restaurant Name' required /></>}
          
          {currstate==="Login"?<></>
            :<><p>Restaurant Description</p><textarea placeholder='Restaurant Description' id='myTextarea' required ></textarea></>}
          
          {currstate==="Login"?<></>
            :<><p>Restaurant Address</p><textarea placeholder='Restaurant Address' id='myTextarea' required ></textarea></>}
            
          {currstate==="Login"?<></>
            :<><p>Restaurant Operational In Hours</p><input type='number' placeholder='Operational Hours' required/></>}
          
          {currstate==="Login"?<></>
            :<><p>Delivery Fee</p><input type='number' placeholder='Delivery Fee' required/></>}
          
          {currstate==="Login"?<></>
            :<><p>Average Rating</p><input type='number' placeholder='Restaurant Rating' required/></>}

          {currstate==="Login"?<></>
          :<div className="add-img-upload flex-col">
          <p>Upload Restaurant Image</p>
          <label htmlFor='image'>
          <img src={image ? URL.createObjectURL(image) : assets.upload_area} alt=''/>
          </label>
          <input onChange={(event) => setimage(event.target.files[0])} type='file' id='image' hidden required/>
          </div>}

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
