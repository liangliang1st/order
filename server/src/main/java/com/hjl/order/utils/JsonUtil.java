package com.hjl.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName JsonUtil
 * @AUthor hanjialiang
 * @Date 2019-04-14 10:44
 * @Version 1.0
 * @Description
 */
public class JsonUtil {
    private static ObjectMapper objectMapper=new ObjectMapper();

    public static String toJson(Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object fromJson(String string,Class classType){
        try {
            return objectMapper.readValue(string,classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object fromJson(String string, TypeReference typeReference){
        try {
            return objectMapper.readValue(string,typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
