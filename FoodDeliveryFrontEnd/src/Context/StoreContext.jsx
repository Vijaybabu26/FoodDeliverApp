import { createContext, useState } from "react";
import { food_list } from "../assets/assets";

export const StoreContext = createContext(null)

const StoreContextProvider =(props) =>{

const[cartItem, setcartItem] = useState({})

    const addtocart =(itemid) =>{
        if(!cartItem[itemid]){
            setcartItem((prev)=>({...prev,[itemid]:1}))
        }else{
            setcartItem((prev)=>({...prev,[itemid]:prev[itemid]+1}))
        }
    }

    const removeFromCart = (itemid) =>{
        setcartItem((prev)=>({...prev,[itemid]:prev[itemid]-1}))
    }

    const getTotalCartAmount = () =>{
        let totalAmount = 0;
        for (const item in cartItem){
            if(cartItem[item]>0){
                let itemInfo = food_list.find((product)=> product._id === item);
                totalAmount +=itemInfo.price * cartItem[item];
            }
            
        }
        return totalAmount;
    }
    // useEffect(
    //     ()=>{
    //         console.log(cartItem);
    //     },[cartItem]
    // )

    const contextvalue = {
        food_list,
        cartItem,
        setcartItem,
        addtocart,
        removeFromCart,
        getTotalCartAmount
    }

    return(
        <StoreContext.Provider value={contextvalue}>
            {props.children}
        </StoreContext.Provider>
    );
}
export default StoreContextProvider;
