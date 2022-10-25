package util;

import java.nio.charset.StandardCharsets;

import java.security.MessageDigest;

public class MD5Util {
	
	public static String hashPassword(String pass) {
		
		 try {
		    MessageDigest msg = MessageDigest.getInstance("MD5");
	        byte[] hash = msg.digest(pass.getBytes(StandardCharsets.UTF_8));
	        StringBuilder s = new StringBuilder();
	        for (byte b : hash) {
	            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
	            pass = s.toString();
	        }
		 } catch (Exception exception) {

	        }
	       
	        return pass;
	}

}
