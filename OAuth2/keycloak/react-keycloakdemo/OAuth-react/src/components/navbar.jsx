import { useEffect} from 'react';
import {Link} from 'react-router-dom';

const Navbar=()=>{

// const {isAuthenticated}  =useContext(AuthContext);


useEffect(()=>{
    // console.log(isAuthenticated);
    console.log("navbar")
})
    return (
        <>
   
        <nav className="navbar">
      <div className="logo">
        <h2>MyLogo</h2>
      </div>
      <ul className={""}>
        <li><Link to={"/"}>Home</Link></li>
        <li><Link to={"/product"}>Products</Link></li>
        <li><a href="/services">Services</a></li>
        <li><a href="/contact">Contact</a></li>
      </ul>
      <div className="hamburger">
        <span className="bar"></span>
        <span className="bar"></span>
        <span className="bar"></span>
      </div>
    </nav>
        </>
    )
}

export default Navbar;