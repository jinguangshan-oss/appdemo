package com.example.appdemo.util;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加解密工具
 */
public class EncUtil {

    public static final String SIGN_KEY = "cd300e8e009f24194142927360c6cffd";

	public static void main(String[] args) {
        SignConfigBean signBean = new SignConfigBean();
        signBean.setClientCode("jgs002");
        signBean.setUsername("ff10jgs002");
        signBean.setBalance(new BigDecimal("2000"));
        signBean.setVersion(670);
        String sign = toMD5(signBean.getClientCode()
                + signBean.getUsername()
                + signBean.getBalance().setScale(3, RoundingMode.DOWN)
                + signBean.getVersion() + SIGN_KEY);
        System.out.println(sign);
	}
	
    public static String hexSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byteO = md[i];
                buf[k++] = hexDigits[byteO >>> 4 & 0xf];
                buf[k++] = hexDigits[byteO & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String toMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            byte[] byteDigest = md.digest();

            StringBuilder buf = new StringBuilder("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                int i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encodeStrBase64(String plainText) {
        byte[] b = plainText.getBytes();
        Base64 base64 = new Base64();
        b = base64.encode(b);
        String s = new String(b);
        return s;
    }

    public static String decodeStrBase64(String encodeStr) {
        byte[] b = encodeStr.getBytes();
        Base64 base64 = new Base64();
        b = base64.decode(b);
        String s = new String(b);
        return s;
    }

    public static String SHA256(String str) {

        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

	/**
	 * AES/CBC/PKCS7Padding加密处理
	 * @param plainText
	 * @param key
	 * @return
	 * @throws Exception
	 */
    public static String aesPkcs7Encrypt(String plainText, String key){
    	try {
    	    Base64 base64 = new Base64();
            Security.addProvider(new BouncyCastleProvider());
            // Hashing key.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key.getBytes("UTF-8"));
            byte[] keyBytes = new byte[32];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            // Generating IV.
            byte[] iv = new byte[16];
            System.arraycopy(keyBytes, 0, iv, 0, iv.length);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Encrypt.
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
            return URLEncoder.encode(base64.encodeToString(encrypted), "UTF-8");
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return "加密异常";
    }
}
