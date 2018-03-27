package com.eivencrm.common.util;


import com.eivencrm.common.config.JsonConsts;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.scene.control.Pagination;
import org.aspectj.bridge.MessageUtil;
import org.codehaus.groovy.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Json返回结果
 * */
public class JsonResult {


    private boolean rel;//是否成功
    private String msg="";//返回信息
    private Object list="";//返回数据
    private int count =0;

    public JsonResult(){

    }
    public JsonResult(boolean rel, String msg,Object list,int count) {
        this.rel = rel;
        this.msg = msg;
        this.list = list;
        this.count = count;
    }
    public JsonResult setError(final JsonResult error, String info){
        this.rel = error.isRel();
        this.msg = error.getMsg()+info;
        return this;
    }
    public static JsonResult putFail(String msg){
        JsonResult result = new JsonResult();
        result.setMsg(msg);
        return result;
    }
    public static JsonResult putSuccess(Object list,int count){
        JsonResult result = new JsonResult();
        result.setRel(JsonConsts.RESULT_SUCCESS);
        result.setMsg(JsonConsts.RESULT_SUCCESS_MSG);
        result.setList(list);
        result.setCount(count);
        return result;
    }
    public static JsonResult putSuccess(){
        JsonResult result = new JsonResult();
        result.setRel(JsonConsts.RESULT_SUCCESS);
        result.setMsg(JsonConsts.RESULT_SUCCESS_MSG);
        return result;
    }
    public static JsonResult putSuccess(String msg){
        JsonResult result = new JsonResult();
        result.setRel(JsonConsts.RESULT_SUCCESS);
        result.setMsg(msg);
        return result;
    }


    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return rel == JsonConsts.RESULT_SUCCESS;
    }

    public static String toJson(JsonResult result) {
        return JsonContext.toJson(result);
    }







}
