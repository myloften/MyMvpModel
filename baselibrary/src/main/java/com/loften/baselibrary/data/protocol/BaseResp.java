package com.loften.baselibrary.data.protocol;

import java.io.Serializable;

public class BaseResp<T> implements Serializable {
    private String Status; //状态信息  success,fail,error
    private T results; //返回结果  返回结果
    private String Message;//异常信息  有异常时保存在此字段
    private String strResult;
    private boolean error;
    private T data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStrResult() {
        return strResult;
    }

    public void setStrResult(String strResult) {
        this.strResult = strResult;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
