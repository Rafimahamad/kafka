import { createContext, useState, useEffect } from "react";
import { toast } from "react-toastify";
import keycloakInstance from "./keycloak-config";


const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [keyCloakObject, setKeycloakObject] = useState(null);

  useEffect(() => {
   if(keycloakInstance){
    keycloakInstance.init({
        // onLoad: 'login-required', # auto login page
        onLoad:'check-sso',
        checkLoginIframe: false,
        
      })
      .then((authenticated) => {
        console.log(authenticated);
        setIsAuthenticated(authenticated); 
        setKeycloakObject(keycloakInstance);     
        if(authenticated){
        toast.success("login Success!");
        }
      })
      .catch((error) => {
        console.log(error);
        toast.error("error Occured !");
      });
    
    }
  },[]);

  return (
    <AuthContext.Provider
      value={{
        isAuthenticated: isAuthenticated,
        keyCloakObject: keyCloakObject
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export { AuthContext };

