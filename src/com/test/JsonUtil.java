package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

public class JsonUtil {

    /**
     * �����ͣ�Jsonת��Ϊbean
     * 
     * @param jsonString
     * @param pojoCalss
     * @return
     */
    public static Object jsonString2Object(String jsonString, Class pojoCalss) {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);

        Object pojo = JSONObject.toBean(jsonObject, pojoCalss);

        return pojo;

    }

    /**
     * �������ͣ�Jsonת��Ϊbean<br>
     * �÷�ʾ����<br>
     * Map<String, Class> classMap = new HashMap<String, Class>();
     * classMap.put("list", ChildBean.class); //ָ�������������Ե�ӳ���ϵ������ʹ����ŵ�map��<br>
     * Person person=(Person)JsonUtil.jsonString2Object(str2, Person.class,
     * classMap);<br>
     * 
     * @param jsonString
     * @param pojoCalss
     * @return
     */
    public static Object jsonString2Object(String jsonString, Class pojoCalss, Map<String, Class> classMap) {
        JSONObject jobj = JSONObject.fromObject(jsonString);
        return JSONObject.toBean(jobj, pojoCalss, classMap);
    }

    /**
     * ��|�������ͣ���java����ת����json�ַ���<br>
     * ֧�ָ������ͣ�Java bean �м�����������list
     * 
     * @param javaObj
     * @return
     */
    public static String object2JsonString(Object javaObj) {

        JSONObject json = JSONObject.fromObject(javaObj);

        return json.toString();

    }

    /**
     * ��json���󼯺ϱ��ʽ�еõ�һ��java�����б�
     * 
     * @param jsonString
     * @param pojoClass
     * @return
     */
    public static List jsonList2JavaList(String jsonString, Class pojoClass) {

        JSONArray jsonArray = JSONArray.fromObject(jsonString);

        JSONObject jsonObject;

        Object pojoValue;

        List list = new ArrayList();

        for (int i = 0; i < jsonArray.size(); i++) {

            jsonObject = jsonArray.getJSONObject(i);

            pojoValue = JSONObject.toBean(jsonObject, pojoClass);

            list.add(pojoValue);

        }

        return list;

    }

    /**
     * ��java���󼯺ϱ��ʽ�еõ�һ��json�б�
     * 
     * @param list
     * @return
     */
    public static String javaList2JsonList(List list) {

        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    /**
     * ����ת��ΪJSON
     * 
     * @param array
     * @return
     */
    public static String javaArray2Json(Object[] array) {
        JSONArray jsonarray = JSONArray.fromObject(array);
        return jsonarray.toString();
    }

    /**
     * Json����ת��ΪJava����
     * 
     * @param jsonArray
     * @param clas
     * @return
     */
    public static Object jsonArray2JavaArrray(String jsonArray, Class clas) {
        JsonConfig jconfig = new JsonConfig();
        jconfig.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
        jconfig.setRootClass(clas);
        JSONArray jarr = JSONArray.fromObject(jsonArray);
        return JSONSerializer.toJava(jarr, jconfig);
    }

    /**
     * Mapת����json
     * @param map
     * @return
     */
    public static String javaMap2Json(Map<String, Object> map) {
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * jsonת��Ϊmap
     * @param jsonString
     * @param pojoCalss
     * @return
     */
    public static Object javaMap2Json(String jsonString, Class pojoCalss) {
        return jsonString2Object(jsonString, pojoCalss);//���÷���jsonString2Object
    }

}