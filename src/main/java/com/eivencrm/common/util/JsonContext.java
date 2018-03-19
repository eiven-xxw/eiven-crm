package com.eivencrm.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.eivencrm.common.helper.JsonbjectParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 用org.json实现的轻量级的json解析
 * Author Fred
 * @date 2018年3月19日
 * Updates
 * .....
 * 
 */

public class JsonContext {
	private static final Logger logger = LoggerFactory.getLogger(JsonContext.class);
	
	private static JsonContext _instance = null;
	private static JsonbjectParser _parser = null;
	
	private JsonContext() {
		;
	}
	
	public static JsonContext instance() {
		if(_instance == null) {
			_instance = new JsonContext();
			_parser = new JsonbjectParser();
		}
		return _instance;
	}
	
	public String toJsonString(Map<String, Object> map)  {
		return JSONObject.toJSONString(map);  
	}
	
	public  String toJsonString(Collection<Object> collection) {
		return JSONObject.toJSONString(collection); 
	}
	
	public String toJsonString(Object obj)  {
		return JSONObject.toJSONString(obj);  
	}
	
	public <T> T parseItem(String jsonStr, Class<T> cls) {
		return parseItem(JSONObject.parseObject(jsonStr), cls);
	}
	
	public <T> T parseItem(JSONObject jobject, Class<T> cls) {
		try {
			return _parser.parseItem(jobject, cls);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex.getMessage());
		}
		return null;
	}
	
	public <T> List<T> parseList(String jsonStr, Class<T> cls)  {
		return parseList(JSONArray.parseArray(jsonStr), cls);
	}
	
	public <T> List<T> parseList(JSONArray array, Class<T> cls)  {
		try {
			return _parser.parseList(array, cls);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex.getMessage());
		}
		return null;
	}
	
	
	public static String toJson(Map<String, Object> map)  {
		return instance().toJsonString(map);  
	}
	
	public static String toJson(Collection<Object> collection) {
		return instance().toJsonString(collection); 
	}
	
	public static String toJson(Object obj)  {
		return instance().toJsonString(obj);  
	}
	
	public static <T> T jsonToObject(String jsonStr, Class<T> cls) {
		return instance().parseItem(jsonStr, cls);
	}
	
	public static <T> T jsonToObject(JSONObject jobject, Class<T> cls) {
		return instance().parseItem(jobject, cls);
	}
	
	public static <T> List<T> jsonToList(String jsonStr, Class<T> cls)  {
		return instance().parseList(jsonStr, cls);
	}
	
	public static <T> List<T> jsonToList(JSONArray array, Class<T> cls)  {
		return instance().parseList(array, cls);
	}
	
	
	public static void main(String[] args) {
		String ss = "{\"name\":[{\"id\":1,\"id\":2,\"id\":3,\"id\":4}]}";
//		String json = "{\"id\":1,\"orgId\":1,\"appName\":\"社商会\",\"appId\":\"1\",\"appKey\":\"1\",\"appType\":1,\"comment\":null,\"status\":1}";
//		ThirdAppVo vo = JsonContext.jsonToObject(json, ThirdAppVo.class);
//		System.out.println(vo.getAppName());
//		ThirdAppVo vo1 = new ThirdAppVo();
//		vo1.setAppName("人才会");
//		vo1.setAppId("11111");
//		System.out.println(JsonContext.toJson(vo));

		
		/*Map<String,String> map = new HashMap<String,String>();
		map.put("couponType", "1");		//优惠券的类型,打折还是现金
		map.put("maximum", "2");			//优惠券的数量
		map.put("expireTime", "2");				//优惠券的开始时间
		map.put("expireTime2", "2");
		String s=toJson(map);
		System.out.println(s);*/
		List list = jsonToList(ss, ArrayList.class);
		System.out.println(list);
	}
}
