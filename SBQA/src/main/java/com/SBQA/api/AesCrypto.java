package com.SBQA.api;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AesCrypto {
	
	String key = "sBcertNonStd";
	
	// AES Code
	public String Decrypt(String text) throws Exception
	{
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes= new byte[16];
		byte[] b= key.getBytes("UTF-8");
		int len= b.length;
		if (len > keyBytes.length) len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
		byte [] results = cipher.doFinal(base64Decode(text));
        return new String(results,"UTF-8");
    }

    public String Encrypt(String text) throws Exception
    {    
    	Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    	byte[] keyBytes= new byte[16];
    	byte[] b= key.getBytes("UTF-8");
    	int len= b.length;
    	if (len > keyBytes.length) len = keyBytes.length;
    	System.arraycopy(b, 0, keyBytes, 0, len);
    	SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
    	IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
    	cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);
    	byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
    	return base64Encode(results);
    }
    
    
    // Base64 Code
    private static byte[] mBase64EncMap, mBase64DecMap; 
    static
    {
    	byte[] base64Map = 
    	{
    		(byte)'A', (byte)'B', (byte)'C', (byte)'D', (byte)'E', (byte)'F',
  	        (byte)'G', (byte)'H', (byte)'I', (byte)'J', (byte)'K', (byte)'L', 
  	        (byte)'M', (byte)'N', (byte)'O', (byte)'P', (byte)'Q', (byte)'R', 
  	        (byte)'S', (byte)'T', (byte)'U', (byte)'V', (byte)'W', (byte)'X', 
  	        (byte)'Y', (byte)'Z', 
  	        (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f', 
  	        (byte)'g', (byte)'h', (byte)'i', (byte)'j', (byte)'k', (byte)'l', 
  	        (byte)'m', (byte)'n', (byte)'o', (byte)'p', (byte)'q', (byte)'r', 
  	        (byte)'s', (byte)'t', (byte)'u', (byte)'v', (byte)'w', (byte)'x', 
  	        (byte)'y', (byte)'z', 
  	        (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', 
  	        (byte)'6', (byte)'7', (byte)'8', (byte)'9', (byte)'+', (byte)'/'
    	}; 
    	mBase64EncMap = base64Map;
    	mBase64DecMap = new byte[128];
    	for (int i=0; i<mBase64EncMap.length; i++)
    		mBase64DecMap[mBase64EncMap[i]] = (byte) i;
    	
    } 

    public static String base64Encode(byte[] aData) 
    {
    	if ((aData == null) || (aData.length == 0)) 
  	            throw new IllegalArgumentException("Can not encode NULL or empty byte array."); 

  	        byte encodedBuf[] = new byte[((aData.length+2)/3)*4]; 

  	        int srcIndex, destIndex; 
  	        for (srcIndex=0, destIndex=0; srcIndex < aData.length-2; srcIndex += 3) { 
  	            encodedBuf[destIndex++] = mBase64EncMap[(aData[srcIndex] >>> 2) & 077]; 
  	            encodedBuf[destIndex++] = mBase64EncMap[(aData[srcIndex+1] >>> 4) & 017 | 
  	                        (aData[srcIndex] << 4) & 077]; 
  	            encodedBuf[destIndex++] = mBase64EncMap[(aData[srcIndex+2] >>> 6) & 003 | 
  	                        (aData[srcIndex+1] << 2) & 077]; 
  	            encodedBuf[destIndex++] = mBase64EncMap[aData[srcIndex+2] & 077]; 
  	        } 

  	        if (srcIndex < aData.length) { 
  	            encodedBuf[destIndex++] = mBase64EncMap[(aData[srcIndex] >>> 2) & 077]; 
  	            if (srcIndex < aData.length-1) { 
  	                encodedBuf[destIndex++] = mBase64EncMap[(aData[srcIndex+1] >>> 4) & 017 | 
  	                    (aData[srcIndex] << 4) & 077]; 
  	                encodedBuf[destIndex++] = mBase64EncMap[(aData[srcIndex+1] << 2) & 077]; 
  	            } 
  	            else { 
  	                encodedBuf[destIndex++] = mBase64EncMap[(aData[srcIndex] << 4) & 077]; 
  	            } 
  	        } 

  	        while (destIndex < encodedBuf.length) { 
  	            encodedBuf[destIndex] = (byte) '='; 
  	            destIndex++; 
  	        } 

  	        String result = new String(encodedBuf); 
  	        return result; 
  	    } 

  	    public static byte[] base64Decode(String aData) { 
  	        if ((aData == null) || (aData.length() == 0)) 
  	            throw new IllegalArgumentException("Can not decode NULL or empty string."); 

  	        byte[] data = aData.getBytes(); 

  	        int tail = data.length; 
  	        while (data[tail-1] == '=') 
  	            tail--; 

  	        byte decodedBuf[] = new byte[tail - data.length/4]; 

  	        for (int i = 0; i < data.length; i++) 
  	            data[i] = mBase64DecMap[data[i]]; 

  	        int srcIndex, destIndex; 
  	        for (srcIndex = 0, destIndex=0; destIndex < decodedBuf.length-2; 
  	                srcIndex += 4, destIndex += 3) { 
  	            decodedBuf[destIndex] = (byte) ( ((data[srcIndex] << 2) & 255) | 
  	                ((data[srcIndex+1] >>> 4) & 003) ); 
  	            decodedBuf[destIndex+1] = (byte) ( ((data[srcIndex+1] << 4) & 255) | 
  	                ((data[srcIndex+2] >>> 2) & 017) ); 
  	            decodedBuf[destIndex+2] = (byte) ( ((data[srcIndex+2] << 6) & 255) | 
  	                (data[srcIndex+3] & 077) ); 
  	        } 

  	        if (destIndex < decodedBuf.length) 
  	            decodedBuf[destIndex] = (byte) ( ((data[srcIndex] << 2) & 255) | 
  	                ((data[srcIndex+1] >>> 4) & 003) ); 
  	        if (++destIndex < decodedBuf.length) 
  	            decodedBuf[destIndex] = (byte) ( ((data[srcIndex+1] << 4) & 255) | 
  	                ((data[srcIndex+2] >>> 2) & 017) ); 

  	        return decodedBuf; 
  	    } 

}

