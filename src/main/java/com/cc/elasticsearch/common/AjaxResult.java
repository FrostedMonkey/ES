package com.cc.elasticsearch.common;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.HashMap;

/**
 * @author : chenchen
 * @ClassName AjaxResult
 * @date : 2020-07-06 16:04
 * @Description TODO
 **/
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";
    private int code;
    private String msg;
    private Object data;

    public AjaxResult() {
    }

    public AjaxResult(Integer code, String msg, Object data) {
        super.put("code", code);
        super.put("msg", msg);
    }

    public AjaxResult(Integer code, String msg) {
        super.put("code", code);
        super.put("msg", msg);
    }

    public static AjaxResult error(Integer code, String msg, Object data) {
        return new AjaxResult(code, msg, data);
    }

    public static AjaxResult error(Integer code, String msg) {
        return error(code, msg, (Object)null);
    }

    public static AjaxResult error(String msg) {
        return error(AjaxResult.Type.ERROR.value, msg, (Object)null);
    }

    public static AjaxResult error() {
        return error(AjaxResult.Type.ERROR.value, "操作失败");
    }

    public static AjaxResult success() {
        return success("操作成功");
    }

    public static AjaxResult success(Object data) {
        return success("操作成功", data);
    }

    public static AjaxResult success(String msg) {
        return success(msg, (Object)null);
    }

    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(AjaxResult.Type.SUCCESS.value, msg, data);
    }

    public static AjaxResult warn(String msg) {
        return warn(msg, (Object)null);
    }

    public static AjaxResult warn(String msg, Object data) {
        return new AjaxResult(AjaxResult.Type.WARN.value, msg, data);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return (new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)).append("code", this.getCode()).append("msg", this.getMsg()).append("data", this.getData()).toString();
    }

    public static enum Type {
        SUCCESS(0),
        NORECORD(-1),
        WARN(301),
        ERROR(500);

        private final int value;

        private Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
