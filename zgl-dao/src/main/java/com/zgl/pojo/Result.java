package com.zgl.pojo;

import java.io.Serializable;

/**
 * 返回前端请求的结果状态实体
 */
public class Result implements Serializable {
    private boolean success;//true   false
    private String message;//返回结果消息给前端    添加成功、修改成功、删除成功
    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}