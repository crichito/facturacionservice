package app.erp.util;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoLibrary {
	
	static String initVector = "RandomInitVector"; // 16 bytes IV
	
	public static String KeyGenerate(){
		SecureRandom random = new SecureRandom();
		
		byte bytes[] = new byte[16]; // 128 bits are converted to 16 bytes;
		random.nextBytes(bytes);
		
		// 128 bit key
		return Base64.getEncoder().encodeToString(bytes).substring(0, 15);
		//return new BigInteger(128, random).toString().substring(0, 16); 
		//return KeyGenerator.getInstance("AES").generateKey().toString();
	}
	
	public static String encrypt(String value, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            
            return Base64.getEncoder().encodeToString(encrypted)
            		.replace('+', '-').replace('/', '_').replace('=', '*');
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encrypted, String key) {
        try {
        	encrypted = encrypted.replace('-', '+').replace('_', '/').replace('*', '=');
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}