package manywho.flow.sdk.utils;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import manywho.flow.sdk.security.*;
import manywho.flow.sdk.*;

/**
 * @author sangeetha_b
 *
 */
public class AuthenticationUtils {
	
	private final static Logger LOGGER = Logger.getLogger(AuthenticationUtils.class.getName());

	public static AuthenticatedWho deserialize(String token)
    {
		AuthenticatedWho authenticatedWho = new AuthenticatedWho();				
		String[] parameters = null;

        // Start by splitting the string so we have a complete key/value pairing
        parameters = token.split("&");

        List<String> paramList=Arrays.asList(parameters);
        
        for (String paramValue : paramList) {        	
			if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_MANYWHO_TENANT_ID)){
				authenticatedWho.setManyWhoTenantId(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_MANYWHO_USER_ID)){
				authenticatedWho.setManyWhoUserId(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_MANYWHO_TOKEN)){				
				authenticatedWho.setManyWhoToken(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_DIRECTORY_ID)){				
				authenticatedWho.setDirectoryId(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_DIRECTORY_NAME)){
				authenticatedWho.setDirectoryName(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_EMAIL)){
				authenticatedWho.setEmail(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_IDENTITY_PROVIDER)){
				authenticatedWho.setIdentityProvider(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_TENANT_NAME)){
				//authenticatedWho.setManyWhoToken(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_TOKEN)){
				authenticatedWho.setToken(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_USER_ID)){
				authenticatedWho.setUserId(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_USERNAME)){
				authenticatedWho.setUsername(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_FIRST_NAME)){
				authenticatedWho.setFirstName(parsedParamValue(paramValue));
			} else if (paramValue.trim().startsWith(ManyWhoConstants.AUTHENTICATED_WHO_TOKEN_LAST_NAME)){
				authenticatedWho.setLastName(parsedParamValue(paramValue));
			}
		}    

        return authenticatedWho;
    }
	
	private static String parsedParamValue(String paramValue) {
		String str = "";
		try {
			if (paramValue != null && paramValue.trim().length() > 0) {
				str = paramValue.split("=")[1];				
			}
		} catch (Exception e) {
			LOGGER.severe("parsedParamValue :"+e.getMessage());
		}
		return str;
	}
	
	public static String Serialize(AuthenticatedWho authenticatedWho)
    {
        String token = "";     
        
        return token;
    }

    public static void validateAuthenticatedWho(AuthenticatedWho authenticatedWho)
    {
        
    }
}