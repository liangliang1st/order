package com.hjl.order.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @AUthor hanjialiang
 * @Date 2019-04-10 20:48
 * @Version 1.0
 * @Description 生成 时间+随机 的主键
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Integer number=new Random().nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
