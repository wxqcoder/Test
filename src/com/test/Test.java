package com.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // 普通bean转化Json
        System.out.println("普通bean转化Json:");
        ChildBean p = new ChildBean("wwwww", "boy", 23);
        String str = JsonUtil.object2JsonString(p);
        System.out.println(str);

        // 普通Json转化bean,如 {"childAge":23,"childName":"wwwww","childSex":"boy"}
        System.out.println("普通Json转化bean:");
        ChildBean c = (ChildBean) JsonUtil.jsonString2Object(str, ChildBean.class);
        System.out.println(c);

        // Java List转化为Json
        System.out.println("Java List转化为Json:");
        List<ChildBean> list = new ArrayList<ChildBean>();
        for (int i = 0; i < 5; i++) {
            ChildBean childBean = new ChildBean("wwwww" + i, "boy", i);
            list.add(childBean);
        }
        String jsonList = JsonUtil.javaList2JsonList(list);
        System.out.println(jsonList);

        // json 列表转化为Java List
        System.out.println("json 列表转化为Java List:");
        List<ChildBean> l = (List<ChildBean>) JsonUtil.jsonList2JavaList(jsonList, ChildBean.class);
        System.out.println(l);

        // 复杂bean转化为Json
        System.out.println("复杂bean转化为Json:");
        List<ChildBean> list2 = new ArrayList<ChildBean>();
        for (int i = 0; i < 10; i++) {
            ChildBean childBean = new ChildBean("aaaaaa" + i, "boy", i);
            list2.add(childBean);
        }
        Person me = new Person("zhang", 1, "man", 1);
        me.setList(list2);

        String str2 = JsonUtil.object2JsonString(me);
        System.out.println("str2=" + str2);

        // 复杂Json转化bean
        System.out.println("复杂Json转化bean:");
        Map<String, Class> classMap = new HashMap<String, Class>();
        classMap.put("list", ChildBean.class); // 指定复杂类型属性的映射关系，可以使多个放到map中
        Person person = (Person) JsonUtil.jsonString2Object(str2, Person.class, classMap);
        System.out.println(person);
        System.out.println(person.getList().get(0).getChildName());

        // Java数组转换为JSON
        System.out.println("java数组转换为JSON:");
        // String[] array = {"asd","dfgd","asd","234"};
        ChildBean[] array = new ChildBean[10];
        for (int i = 0; i < 10; i++) {
            ChildBean childBean = new ChildBean("aaaaaa" + i, "boy", i);
            array[i] = childBean;
        }
        String jsonArray = JsonUtil.javaArray2Json(array);
        System.out.println(jsonArray);

        // Json数组转化为Java数组
        System.out.println("Json数组转化为Java数组:");
        ChildBean[] cb = (ChildBean[]) JsonUtil.jsonArray2JavaArrray(jsonArray, ChildBean.class);
        System.out.println(Arrays.toString(cb));

        //Map转换成json
        System.out.println("Map转换成json:");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 1000);
        map.put("userName", "张三");
        map.put("userSex", "男");
        String jsonStr = JsonUtil.javaMap2Json(map);
        System.out.println(jsonStr);
        
        //json转化为map
        System.out.println("json转化为map:");
        Map<String, Object> jmap = (Map<String, Object>)JsonUtil.javaMap2Json(jsonStr, Map.class);
        System.out.println(jmap);
    }
}