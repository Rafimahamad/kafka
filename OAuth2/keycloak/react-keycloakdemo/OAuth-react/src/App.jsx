
import './App.css'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { AuthProvider } from './config/authContext';
import Home from './components/home';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Product from './components/product';
import Base from './components/base';


function App() {


  return (
    <>

     <ToastContainer/>
<AuthProvider >

<Router>
 <Base>
  <Routes>
   
     <Route path="/" element={<Home />} />
    <Route path="/product" element={<Product />} />
 
  </Routes>
 </Base>
</Router>
</AuthProvider>

    </>
  )
}

export default App
