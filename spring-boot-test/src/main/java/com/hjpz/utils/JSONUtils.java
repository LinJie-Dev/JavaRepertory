package com.hjpz.utils;

import com.alibaba.fastjson.*;
import com.hjpz.exception.FastJsonUtilException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>功能描述：序列化工具类</p>
 * @author Architecture
 * @version 1.0
 * @date  2017年11月20日 
 */
@SuppressWarnings("all")  
public class JSONUtils {  
    
    private static final Logger logger = LoggerFactory.getLogger(JSONUtils.class);
    
    /**   
    * @Description:json字符串转换为javaBean对象
    * @param jsontext
    * @param clazz
    * @return T
    * @throws FastJsonUtilException
    */  
    public static final <T> T getObject(String jsontext, Class<T> clazz) {
        try {  
        	return JSON.parseObject(jsontext, clazz);  
        } catch (Exception e) {  
            logger.error("json字符串转换失败" + jsontext, e);  
        }
        return null;
    }
    
    /**   
    * @Description:将对象转换为格式化后的JSON字符串
    * @param Object
    * @param prettyFormat
    * @return String
    */  
    public static final String toJSONString(Object object, boolean prettyFormat) {  
        return JSON.toJSONString(object, prettyFormat);  
    }  
    
    /**   
    * @Description:将对象中为null的字段进行处理，避免序列化
    * @param Object
    * @return Object
    */  
    public static final Object HandlerNull(Object object) {  
        return JSON.parse(JSON.toJSONString(object));  
    }  
    
    /**   
    * @Description:将对象转换为JSON字符串
    * @param Object
    * @return String
    */ 
    public static final String toJSONString(Object object) {  
        return JSON.toJSONString(object);  
    }  
    
    /**   
    * @Description:json字符串转换为javaBean集合
    * @param jsonStr
    * @param clazz
    * @return List<T>
    * @author FastJsonUtilException
    */ 
    public static <T> List<T> getList(String jsonStr, Class<T> clazz) throws FastJsonUtilException {
        List<T> list = new ArrayList<T>();  
        try {  
            list = JSON.parseArray(jsonStr, clazz); 
            return list;
        } catch (Exception e) {  
            logger.error("json字符串转List失败！" + jsonStr, e);  
        }  
        throw new FastJsonUtilException(jsonStr);
    }  
  
    /**   
    * @Description:json字符串转换为List<Map<String, Object>>
    * @param jsonStr
    * @return List<Map<String, Object>>
    * @throws FastJsonUtilException
    */   
    public static List<Map<String, Object>> listKeyMaps(String jsonString) throws FastJsonUtilException{  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        try {  
            list = JSON.parseObject(jsonString,  new TypeReference<List<Map<String, Object>>>() {  
            });  
            return list;
        } catch (Exception e) {  
            logger.error("json字符串转map失败", e);  
        }  
        throw new FastJsonUtilException();
    }  
  
    /**   
    * @Description:json字符串转换为Map<String, Object>
    * @param jsonStr
    * @return Map<String, Object>
    * @throws FastJsonUtilException
    */ 
    public static Map<String, Object> json2Map(String jsonStr) throws FastJsonUtilException {  
        try {  
            return JSON.parseObject(jsonStr, Map.class);  
        } catch (Exception e) {  
            logger.error("json字符串转换失败！" + jsonStr, e);  
        }  
        throw new FastJsonUtilException();  
    }  
    
    /**   
    * @Description:json字符串中的某个Key取值进行转换得出List<T>
    * @param jsonStr
    * @param list_str
    * @param clazz
    * @return List<T>
    * @throws FastJsonUtilException
    */ 
    public static final <T> List<T> getList(String jsontext, String list_str, Class<T> clazz) {  
        JSONObject jsonobj = JSON.parseObject(jsontext);  
        if (jsonobj == null) {  
            return null;  
        }  
        Object obj = jsonobj.get(list_str);  
        if (obj == null) {  
            return null;  
        }  
        if (obj instanceof JSONArray) {  
            JSONArray jsonarr = (JSONArray) obj;  
            List<T> list = new ArrayList<T>();  
            for (int i = 0; i < jsonarr.size(); i++) {  
                list.add(jsonarr.getObject(i, clazz));  
            }  
            return list;  
        }  
        return null;  
    }  
  
    /**   
    * @Description:json字符串中的某个Key取值进行转换得出 T
    * @param jsonStr
    * @param list_str
    * @param clazz
    * @return T
    * @throws FastJsonUtilException
    */  
    public static final <T> T getObject(String jsontext, String obj_str,  Class<T> clazz) {  
        JSONObject jsonobj = JSON.parseObject(jsontext);  
        if (jsonobj == null) {  
            return null;  
        }  
        Object obj = jsonobj.get(obj_str);  
        if (obj == null) {  
            return null;  
        }  
        if (obj instanceof JSONObject) {  
            return jsonobj.getObject(obj_str, clazz);  
        } else {  
            logger.info(obj.getClass()+"");  
        }  
        return null;  
    }  
    //把List<Map<String, Object>>的字符串转换成JsonArray  
    public static String parseListForMapsToJsonArrayStr(List<Map<String, Object>> list) {  
        String jsonArrayStr = null;  
        if(list != null && list.size() != 0) {  
            JSONArray jsonArray = new JSONArray();  
            JSONObject jsonObject = null;  
            Object value = null;  
            for(Map<String, Object> map : list) {  
                jsonObject = new JSONObject();  
                Set<String> set = map.keySet();  
                for(String key : set) {  
                    value = map.get(key);  
                    if(value != null) {  
                        try {  
                            jsonObject.put(key, value.toString());  
                        } catch (JSONException e) {  
                            e.printStackTrace();  
                        }  
                    }  
                }  
                if(jsonObject.size() != 0) {  
                    jsonArray.add(jsonObject);  
                }  
            }  
            jsonArrayStr = jsonArray.toString();  
        }  
          
        return jsonArrayStr;  
    }  
}