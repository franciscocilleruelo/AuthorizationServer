package es.techedge.isban.authorization.enhancer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import es.techedge.isban.authorization.beans.UserDTO;

public class CustomTokenEnhancer implements TokenEnhancer {
	 
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    	UserDTO user = (UserDTO) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();
        
        // Incluir cualquier informacion adicional al usuario
 
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
 
        return accessToken;
    }
 
}
