package com.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // ��ͨbeanת��Json
        System.out.println("��ͨbeanת��Json:");
        ChildBean p = new ChildBean("wwwww", "boy", 23);
        String str = JsonUtil.object2JsonString(p);
        System.out.println(str);

        // ��ͨJsonת��bean,�� {"childAge":23,"childName":"wwwww","childSex":"boy"}
        System.out.println("��ͨJsonת��bean:");
        ChildBean c = (ChildBean) JsonUtil.jsonString2Object(str, ChildBean.class);
        System.out.println(c);

        // Java Listת��ΪJson
        System.out.println("Java Listת��ΪJson:");
        List<ChildBean> list = new ArrayList<ChildBean>();
        for (int i = 0; i < 5; i++) {
            ChildBean childBean = new ChildBean("wwwww" + i, "boy", i);
            list.add(childBean);
        }
        String jsonList = JsonUtil.javaList2JsonList(list);
        System.out.println(jsonList);

        // json �б�ת��ΪJava List
        System.out.println("json �б�ת��ΪJava List:");
        List<ChildBean> l = (List<ChildBean>) JsonUtil.jsonList2JavaList(jsonList, ChildBean.class);
        System.out.println(l);

        // ����beanת��ΪJson
        System.out.println("����beanת��ΪJson:");
        List<ChildBean> list2 = new ArrayList<ChildBean>();
        for (int i = 0; i < 10; i++) {
            ChildBean childBean = new ChildBean("aaaaaa" + i, "boy", i);
            list2.add(childBean);
        }
        Person me = new Person("zhang", 1, "man", 1);
        me.setList(list2);

        String str2 = JsonUtil.object2JsonString(me);
        System.out.println("str2=" + str2);

        // ����Jsonת��bean
        System.out.println("����Jsonת��bean:");
        Map<String, Class> classMap = new HashMap<String, Class>();
        classMap.put("list", ChildBean.class); // ָ�������������Ե�ӳ���ϵ������ʹ����ŵ�map��
        Person person = (Person) JsonUtil.jsonString2Object(str2, Person.class, classMap);
        System.out.println(person);
        System.out.println(person.getList().get(0).getChildName());

        // Java����ת��ΪJSON
        System.out.println("java����ת��ΪJSON:");
        // String[] array = {"asd","dfgd","asd","234"};
        ChildBean[] array = new ChildBean[10];
        for (int i = 0; i < 10; i++) {
            ChildBean childBean = new ChildBean("aaaaaa" + i, "boy", i);
            array[i] = childBean;
        }
        String jsonArray = JsonUtil.javaArray2Json(array);
        System.out.println(jsonArray);

        // Json����ת��ΪJava����
        System.out.println("Json����ת��ΪJava����:");
        ChildBean[] cb = (ChildBean[]) JsonUtil.jsonArray2JavaArrray(jsonArray, ChildBean.class);
        System.out.println(Arrays.toString(cb));

        //Mapת����json
        System.out.println("Mapת����json:");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 1000);
        map.put("userName", "����");
        map.put("userSex", "��");
        String jsonStr = JsonUtil.javaMap2Json(map);
        System.out.println(jsonStr);
        
        //jsonת��Ϊmap
        System.out.println("jsonת��Ϊmap:");
        Map<String, Object> jmap = (Map<String, Object>)JsonUtil.javaMap2Json(jsonStr, Map.class);
        System.out.println(jmap);
    }
}