package com.study.jaewonstudy.webservice.config;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class AES128Config {

    private static final Charset ENCODING_TYPE = StandardCharsets.UTF_8;
    private static final String INSTANCE_TYPE = "AES/CBC/PKCS5Padding";

    private SecretKeySpec secretKeySpec;
    private Cipher cipher;
    private IvParameterSpec ivParameterSpec;

    //  생성자
    public AES128Config(final String key){
        try{
            byte[] keyBytes = key.getBytes(ENCODING_TYPE);
            secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            cipher = Cipher.getInstance(INSTANCE_TYPE);
            ivParameterSpec = new IvParameterSpec(keyBytes);

        } catch (NoSuchPaddingException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    //  암호화
    public String encrypt(final String text) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrpytText = cipher.doFinal(text.getBytes(ENCODING_TYPE));
        return new String(Base64.encodeBase64(encrpytText));
    }

    //  복호화
    public String decrypt(final String text) throws Exception{
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decodeText = Base64.decodeBase64(text.getBytes());
        return new String(cipher.doFinal(decodeText), ENCODING_TYPE);
    }
}
