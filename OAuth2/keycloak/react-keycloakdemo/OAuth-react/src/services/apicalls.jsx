import axios from "axios"
import keycloakInstance from "../config/keycloak-config";


const axiosUrl=axios.create({
    baseURL:'http://localhost:8092/api/v1',

})

export const getAllProductDetails= async ()=>{
 const result= await axiosUrl.get('/products',{
    headers:{
        Authorization: `Bearer ${keycloakInstance.token}`
    }
 });
 return result.data;
}