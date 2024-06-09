import React, { useContext } from 'react';
import { StoreContext } from '../../Context/StoreContext';
import './PlaceOrder.css';
const PlaceOrder = () => {

const {getTotalCartAmount} = useContext(StoreContext);

  return (
    <div className='place-order'>
      <div className="place-order-left">
        <p className='title'>Delivery Information</p>
        <div className="multi-feilds">
        <input type="text" placeholder='First Name'/>
        <input type="text" placeholder='Last Name'/>
        </div>
        <input type="text" placeholder='Email Address'/>
        <input type="text" placeholder='Street'/>
        <div className="multi-feilds">
        <input type="text" placeholder='City'/>
        <input type="text" placeholder='State'/>
        </div>
        <div className="multi-feilds">
        <input type="text" placeholder='Zip Code'/>
        <input type="text" placeholder='Country'/>
        </div>
        <input type='text' placeholder='Phono'/>
      </div>
      <div className="place-order-right">
      <div className="cart-total">
        <div>
          <div className="cart-total-details">
            <p>Subtotal</p>
            <p>&#8377; {getTotalCartAmount()}</p>
          </div>
          <hr/>
          <div className="cart-total-details">
          <p>Delivery Fee</p>
          <p>&#8377; {getTotalCartAmount()===0?0:40}</p>
          </div>
          <hr/>
          <div className="cart-total-details">
          <p>Total</p>
          <p>&#8377; {getTotalCartAmount()===0?0:getTotalCartAmount()+40}</p>
          </div>
        </div>
        <button>PROCEED TO PAYMENT</button>
      </div>
      </div>
    </div>
  )
}

export default PlaceOrder
