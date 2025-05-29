import Keycloak from 'keycloak-js';

const keycloakInstance = new Keycloak({
    url:'http://localhost:8080',
    realm:'project-k',
    clientId:"auth-client",
    redirectUri: 'http://localhost:5173',
    pkceMethod: 'S256', 

});

export default keycloakInstance;