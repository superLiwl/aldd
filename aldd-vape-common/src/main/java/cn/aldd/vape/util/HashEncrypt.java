package cn.aldd.vape.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * All rights Reserved, Designed By 翼虎能源
 * Copyright:    Copyright(C) 2015-2017
 * Company   北京翼虎能源科技有限公司
 *
 * @author 刘广路
 * @version 1.0.0
 * @date 2017/9/13 21:34
 * @Description Hahs加密算法
 */
public class HashEncrypt {

    private final static Logger logger = LoggerFactory.getLogger(HashEncrypt.class);

    /**
     * SHA 加密通用算法
     *
     * @param source         加密
     * @param hashIterations 迭代次数
     * @param strType        SHA-256,SHA-512
     * @return 加密后的Hex串
     */
    public static String encryptSHA(final String source, int hashIterations, final String strType) {
        // 返回值
        String strResult = null;
        // 是否是有效字符串
        if (source != null && source.length() > 0) {
            try {
                // 创建加密对象
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                byte byteBuffer[] = source.getBytes();
                for (int i = 0; i < hashIterations; i++) {
                    // 传入要加密的字符串
                    messageDigest.update(byteBuffer);
                    // 得到 byte 结果
                    byteBuffer = messageDigest.digest();
                }
                // 將 byte 转为 16进制 string
                StringBuffer strHexString = new StringBuffer();
                //  byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                logger.error("---NoSuchAlgorithmException--",e);
            }
        }
        return strResult;
    }
}
