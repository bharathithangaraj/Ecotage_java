package com.ecotage.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;

import com.ecotage.exception.UserManagementException;
import com.ecotage.response.dto.ResponseMessage;
import com.ecotage.vo.OauthDetail;

public class CommonUtil {

	public static Date CURRENT_TIME = getCurrentTime();

	private static final String EMPTY_STRING = "";
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
	
	public static final Pattern VALID_PHONE_NO =  Pattern.compile("^[0-9]{10}");

	static final Properties properties = new Properties();
	private static String ALGORITHM = null;
	private static byte[] KEY = null;

	static {
		properties.put("encryption.algorithm", "AES/ECB/PKCS5Padding");
		properties.put("encryption.key", "MySuperSecretKey");
		ALGORITHM = (String) properties.get("encryption.algorithm");
		KEY = ((String) properties.get("encryption.key")).getBytes();
	}

	public static String encrypt(String value) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			final Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			final String encrypted = new String(java.util.Base64.getEncoder().encode(c.doFinal(value.getBytes())),
					"UTF-8");
			return encrypted;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decrypt(String value) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			final Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			final String decrypted = new String(
					c.doFinal(java.util.Base64.getDecoder().decode(value.getBytes("UTF-8"))));
			return decrypted;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Date getCurrentTime() {
		return new Date();
	}

	/**
	 * This decryption will decrypt the encrypt bean id to entity primary Long Id
	 * 
	 * @param encryptId - response bean encrypt id into primary Key Id of an entity.
	 */
	public static Long decryptToId(String encryptId) {
		Long id = 0L;
		if (null != encryptId) {
			try {
				id = Long.valueOf(decrypt(encryptId));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	/**
	 * This encryption will encrypt the Long entity id to String
	 * 
	 * @param entity/Dao bean primary Key Id
	 */
	public static String encryptFromId(Long id) {
		String encryptId = EMPTY_STRING;
		if (null != id) {
			try {
				encryptId = encrypt(id.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return encryptId;
	}
	
	public static OauthDetail getAuth(String loginId, String password) throws IOException {
		
		 OauthDetail auth = null;
		URL url = new URL("http://localhost:8180/oauth/token");
        Map<String,Object> params = new LinkedHashMap<String, Object>();
        params.put("username", loginId);
        params.put("password", password);
        params.put("grant_type", "password");

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        
        String encoded = Base64.getEncoder().encodeToString(("ecotage-client"+":"+"ecotage-secret").getBytes(StandardCharsets.UTF_8));  //Java 8
       

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Authorization", "Basic "+encoded);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        
        Reader in = null;

       if(conn.getResponseCode() == 200) {
    	    in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
       } else {
    	   in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
       }
        

        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        System.out.println("response :::::"+response);
        JSONObject responseJson = new JSONObject();
        try {

            responseJson = new JSONObject(response);
            
            	 auth = new OauthDetail();
                 auth.setAccess_token(responseJson.getString("access_token"));
                 auth.setToken_type(responseJson.getString("token_type"));
                 auth.setRefresh_token(responseJson.getString("refresh_token"));
                 auth.setExpires_in(responseJson.getInt("expires_in"));
                 auth.setScope(responseJson.getString("scope"));
                 System.out.println(auth);
           
           
        } catch(Exception ex) {
        	throw new UserManagementException(ex.getMessage());
        }
       
        return auth;
	}

}
