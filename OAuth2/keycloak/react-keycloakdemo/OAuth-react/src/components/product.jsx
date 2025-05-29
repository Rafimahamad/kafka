import {useEffect,useContext,useState} from 'react';
import { getAllProductDetails } from '../services/apicalls';
import { AuthContext } from '../config/authContext';

const Product =()=>{

const {isAuthenticated}=useContext(AuthContext);

    useEffect(()=>{
    if(isAuthenticated){
loadProductData();
    }
},[isAuthenticated])

const [data,setData]=useState(null);


const loadProductData= async ()=>{
const db=await getAllProductDetails();
console.log(db);
setData(db);
}


    return(
        <>
        <div>
        <div className='tagName'>
          <h1>  your Data ! </h1>
         </div>
         
      {
      data ? (
        <div className="make-center">
    <div className="card-container"> 
      {data.map((product, index) => (
        <div key={index} className="card">
          <div className="title">{product.name}</div>
          <div className="content">
            <p>id : {product.id}</p>
             <p>price: {product.price}</p>
          </div>

        </div>
        
      ))}
    </div> </div>
  ) : (
    <p>Loading...</p>
  )}

  
    </div>
    </>
    )
}
export default Product;