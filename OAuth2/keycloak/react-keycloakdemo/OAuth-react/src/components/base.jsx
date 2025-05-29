import Navbar from "./navbar";

const Base = ({ children }) => {
    return (
      
      <div>
     
  <div>
  <Navbar />
  </div>
        {children}
  
      </div>
     
    )
  }
  
  export default Base;