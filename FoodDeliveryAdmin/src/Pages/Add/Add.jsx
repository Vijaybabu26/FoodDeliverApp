import React, { useEffect, useState } from 'react'
import './Add.css'
import { assets } from '../../../AdminAssets/assets'
const Add = () => {

    const[image,setimage]  = useState(false)

    const[data,setdata] = useState({
        name:"",
        description:"",
        price:"",
        category:"Salad"
    })

    const onchangehandler = (event) =>{
        const name = event.target.name;
        const value = event.target.value;
        setdata(data=>({...data,[name]:value}))
    }

    const onSubmitHandler = async (event) =>{
        event.preventDefault();
        const formData = new FormData();
        formData.append("name",data.name)
        formData.append("description",data.description)
        formData.append("price",Number(data.price))
        formData.append("category",data.category)
        formData.append("image",image)
        // const response = 
        if(response.data.success){
            setdata({
                name:"",
                description:"",
                price:"",
                category:"Salad"
            })
        }else{
            setimage(false)
        }
    }

    useEffect(()=>{
        console.log(data);
    },[data])

  return (
    <div className='add'>
        <form action="" className="flex-col">
            <div className="add-img-upload flex-col">
                <p>Upload Image</p>
                <label htmlFor='image'>
                    <img src={image ? URL.createObjectURL(image) : assets.upload_area} alt=''/>
                </label>
                <input onChange={(event) => setimage(event.target.files[0])} type='file' id='image' hidden required/>
            </div>
            <div className="add-product-name flex-col">
                <p>Product Name</p>
                <input onChange={onchangehandler} value={data.name} type='text' name='name' placeholder='type here'/>
            </div>
            <div className="add-product-description flex-col">
                <p>Description</p>
                <textarea onChange={onchangehandler} value={data.description} name='description' rows="6" placeholder='Write Content Here'></textarea>
            </div>
            <div className="add-category-price">
                <div className="add-category flex-col">
                    <p>Product Category</p>
                    <select onChange={onchangehandler} value={data.price}name='category'>
                        <option value="Salad">Salad</option>
                        <option value="Rolls">Rolls</option>
                        <option value="Deserts">Deserts</option>
                        <option value="Sandwich">Sandwich</option>
                        <option value="Cake">Cake</option>
                        <option value="Pure Veg">Pure Veg</option>
                        <option value="Pasta">Pasta</option>
                        <option value="Noodles">Noodles</option>
                    </select>
                </div>
                <div className="add-price">
                    <p>Product Price</p>
                    <input type="Number" name='price' placeholder='$20'/>
                </div>
            </div>
            <button type='submit' className='add-btn'>ADD</button>
            
        </form>
    </div>
  )
}

export default Add
