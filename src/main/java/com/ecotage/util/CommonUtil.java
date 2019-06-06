package com.ecotage.util;

import java.security.Key;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

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

}
