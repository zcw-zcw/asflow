package com.swpu.asflow.utils;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 返回 json 给客户端的数据封装类
 *
 * @author dyq
 * @date 2019/12/12 16:03
 */
public class Msg {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    /**
     * 状态码：100 --> 成功  ， 200 --> 失败
     */
    private int code;
    /**
     * 状态消息 SUCCESS 或 FAIL
     */
    private String message;
    /**
     * 待封装的数据
     */
    private Map<String, Object> data = new ConcurrentHashMap<>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMessage(SUCCESS);
        return result;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMessage(FAIL);
        return result;
    }

    public Msg add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    private void setData(Map<String, Object> data) {
        this.data = data;
    }
}

