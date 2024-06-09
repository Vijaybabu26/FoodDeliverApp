import React, { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { StoreContext } from '../../Context/StoreContext';
import './Cart.css';
const Cart = () => {

    const {cartItem,food_list,removeFromCart,getTotalCartAmount} = useContext(StoreContext);
    
    const navigate = useNavigate();

    
    return(
      <div className='cart'>
       <div className="cart-items">
        <div className="cart-items-title">
          <p>Items</p>
          <p>Title</p>
          <p>Price</p>
          <p>Quantity</p>
          <p>Total</p>
          <p>Remove</p>

       </div>
       <br/>
       <hr/>
       {food_list.map((item,index)=>{
        if(cartItem[item._id]>0){
          return(
            <div>
            <div className="cart-items-title cart-items-item">
              <img src={item.image} alt="" />
              <p>{item.name}</p>
              <p> &#8377; {item.price}</p>
              <p>{cartItem[item._id]}</p>
              <p> &#8377; {item.price*cartItem[item._id]}</p>
              <p onClick={()=>removeFromCart(item._id)} className='cross'>x</p>
            </div>
            <hr/>
            </div>
          )
        }
       })}
    </div>
    <div className="cart-bottom">
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
        <button onClick={()=>navigate('/order')}>PROCEED TO CHECKOUT</button>
      </div>
      <div className="cart-promocode">
          <div>
            <p>If You Have A Promo Code, Enter It Here</p>
            <div className="cart-promocode-input">
              <input type='text' placeholder='PROMO CODE'/>
              <button>Submit</button>
            </div>
          </div>
      </div>
    </div>
    </div>
    );
}

export default Cart
