package com.little.config;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 手动编写的 json 解析处理器
 * */
public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
    *  将对象格式的数据转换成纯字符串
    * */
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     *  将纯字符串的数据转换成指定的对象
     * */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

