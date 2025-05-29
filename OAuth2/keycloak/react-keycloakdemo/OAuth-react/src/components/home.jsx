import {useContext} from "react"
import { AuthContext } from "../config/authContext";
import {toast} from "react-toastify";
import keycloakInstance from "../config/keycloak-config";
import { Link } from 'react-router-dom';

const Home=()=>{
const {isAuthenticated}=useContext(AuthContext);
const {keyCloakObject}=useContext(AuthContext);


    return(
        <>
{ isAuthenticated ?
<div className="container">
    <h1>Welcome you are Loggedin </h1>
    <h2>{keyCloakObject.tokenParsed.given_name}</h2>
    <button onClick={()=>{
        keycloakInstance.logout();
        toast.info("successfully loggedout! ")
           }}  className="button">logout</button>

           <Link to={"/product"}>seeData</Link>
</div>
:
<div>
    <h2> Please Login ! </h2>
    <button onClick={()=>{
        keycloakInstance.login();
    }}>login</button>
</div>
}
        
        </>
    )
}

export default Home;