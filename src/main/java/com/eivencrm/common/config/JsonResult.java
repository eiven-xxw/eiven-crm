package com.eivencrm.common.config;

import java.util.HashMap;
import java.util.Map;

import com.eivencrm.common.util.JsonContext;
import com.eivencrm.common.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description: TODO()
 * Author Fred
 * @date 2016年7月20日 上午10:12:49 
 * Updates
 * 这里补充更新记录
 */
public class JsonResult {
	
	
	/**
	 * 接口返回信息是否展示 0:否
	 */
	public static final int UNSHOW = 0;

	/**
	 * 接口返回信息是否展示 1:是
	 */
	public static final int SHOW = 1;
	
	private int status; 
	private String info="";
	private int show;
	private Object data="";

	public JsonResult(){
		
	}
	public JsonResult(int status, String info, int show) {
		this.status = status;
		this.info = info;
		this.show = show;
	}
	public JsonResult setError(final JsonResult error, String info){
		this.status = error.getStatus();
		this.info = error.getInfo()+info;
		this.show = error.getShow();
		return this;
	}
	
	public static JsonResult putFail(){
		return putFail(JsonConsts.RESULT_FAIL_MSG, UNSHOW);
	}
	
	public static JsonResult putFail(String msg){
		return putFail(msg, UNSHOW);
	}
	
	public static JsonResult putFail(String msg, int showFlag){
		JsonResult result = new JsonResult();
		result.setStatus(JsonConsts.RESULT_FAIL);
		result.setInfo(msg);
		result.setShow(showFlag);
		return result;
	}
	
	public static JsonResult putFail(Exception ex){
		return putFail(ex, UNSHOW);
	}
	
	public static JsonResult putFail(Exception ex, int showFlag){
		JsonResult result = new JsonResult();
		result.setStatus(JsonConsts.RESULT_FAIL);
		if(ex != null)
			result.setInfo(JsonConsts.RESULT_FAIL_MSG + ":" + ex.getMessage());
		else
			result.setInfo(JsonConsts.RESULT_FAIL_MSG);
		result.setShow(showFlag);
		return result;
	}
	
	public static JsonResult putCustomFail(int code, String msg) {
		return putCustomFail(code, msg, UNSHOW);
	}
	
	public static JsonResult putCustomFail(int code, String msg, int showFlag) {
		JsonResult result =  putFail(msg, showFlag);
		result.setStatus(code);
		return result;
	}
	
	public static JsonResult putCustomFail(int code, Exception ex) {
		return putCustomFail(code, ex, UNSHOW);
	}
	
	public static JsonResult putCustomFail(int code, Exception ex, int showFlag) {
		JsonResult result =  putFail(ex, showFlag);
		result.setStatus(code);
		return result;
	}
	
	public static JsonResult putSuccess(){
		JsonResult result = new JsonResult();
		result.setStatus(JsonConsts.RESULT_SUCCESS);
		result.setInfo(JsonConsts.RESULT_SUCCESS_MSG);
		result.setShow(UNSHOW);
		return result;
	}
	
	public static JsonResult putSuccess(Object data){
		JsonResult rslt = putSuccess();
		rslt.setData(data);
		return rslt;
	}







	public static JsonResult putSuccess(String info, Object data){
		JsonResult result = putSuccess();
		result.setInfo(info);
		result.setData(data);
		return result;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getShow() {
		return show;
	}
	public void setShow(int show) {
		this.show = show;
	}
	public Object getData() {
		return data;
	}
	

	public void setData(Object data) {
		if(data != null) {
			this.data = data;
		} else { 
			this.data = data;
		}
	}
	
	@JsonIgnore
	public boolean isSuccess() {
		return status == JsonConsts.RESULT_SUCCESS;
	}
	
	public static String toJson(JsonResult result) {
		return JsonContext.toJson(result);
	}
	
	public static String putValidate(boolean success) {
		return putValidate(success, null);
	}
	public static String putValidate(boolean success, String info) {
		Map result = new HashMap();
		result.put("success", success);
		if(StringUtils.isNotEmpty(info)) {
			result.put("message", info);
		}
		return JsonContext.toJson(result);
	}
	

	
}
