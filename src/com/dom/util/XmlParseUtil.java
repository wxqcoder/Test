package com.dom.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlParseUtil {
	
	
	/**
	 * 加载xml文档
	 * @param filename
	 * @return
	 */
	public static Document load(String filename) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(filename)); // 读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;

	}
	
	/** 
     * 递归遍历所有父节点、子节点 
     * @param ele 
     */  
    public static void parserNode(Element element){  
          
        StringBuffer sqlBuffer = new StringBuffer("insert into uf_templatefield_dt1(mainid,fieldname" +
        		",parentnode,path) values(");
        String elementName = element.getName();
        System.out.println(elementName);
        String path = element.getPath();
        System.out.println(path);
        String parentNode = element.getParent()==null?"root":element.getParent().getName();
        System.out.println(parentNode);
        sqlBuffer.append(elementName+","+parentNode+","+path+")");
        //从根节点开始遍历，像【属性=值】的形式存为一个Attribute对象存储在List集合中  
        List<Attribute> attrList = element.attributes();
        
        for(Attribute attr : attrList){  
            //每循环一次，解析此节点的一个【属性=值】，没有则输出空  
            String name = attr.getName();  
            String value = attr.getValue();  
            System.out.println(name+"="+value);  
            
            
        }  
          
        List<Element> elementList = element.elements();  
        //递归遍历父节点下的所有子节点  
        for(Element e : elementList){  
            parserNode(e);  
        }  
    }  
	
	/**
	 * 解析xml文档
	 */
	public void parseXml(){
		Document doc = load("D:/6115.xml");
		 Element root = doc.getRootElement();//获取根节点
		 String name = root.getName();
		 parserNode(root);
	}
	
	
	
	
	
    public void createXMLDemo() throws Exception {  

        // 创建saxReader对象  
        SAXReader reader = new SAXReader();  
        // 通过read方法读取一个文件 转换成Document对象  
        Document document = reader.read(new File("src/car.xml"));  
        //获取根节点元素对象  
        Element node = document.getRootElement();  
        //遍历所有的元素节点  
        // listNodes(node); 

        elementMethod(node);

    } 

    public void readXMLDemo() throws Exception {  
         Document document = DocumentHelper.createDocument();
         Element root = document.addElement( "cars" );
         Element supercarElement= root.addElement("supercars")
            .addAttribute("company", "Ferrai");

         supercarElement.addElement("carname")
            .addAttribute("type", "Ferrari 101")
            .addText("Ferrari 101");

         supercarElement.addElement("carname")
            .addAttribute("type", "sports")
            .addText("Ferrari 202");
         // 写入到一个新的文件中 
         //writer(document);
    }

   
    /** 
     * 遍历当前节点元素下面的所有(元素的)子节点 
     *  
     * @param node 
     */  
    public void listNodes(Element node) {  
        System.out.println("当前节点的名称：：" + node.getName());  
        // 获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        // 遍历属性节点  
        for (Attribute attr : list) {  
            System.out.println(attr.getText() + "-----" + attr.getName()  
                    + "---" + attr.getValue());  
        }  

        if (!(node.getTextTrim().equals(""))) {  
            System.out.println("文本内容：：：：" + node.getText());  
        }  

        // 当前节点下面子节点迭代器  
        Iterator<Element> it = node.elementIterator();  
        // 遍历  
        while (it.hasNext()) {  
            // 获取某个子节点对象  
            Element e = it.next();  
            // 对子节点进行遍历  
            listNodes(e);  
        }  
    }  

    /** 
     * 介绍Element中的element方法和elements方法的使用 
     *  
     * @param node 
     */  
    public void elementMethod(Element node) {  
        // 获取node节点中，子节点的元素名称为supercars的元素节点。  
        Element e = node.element("supercars");  
        // 获取supercars元素节点中，子节点为carname的元素节点(可以看到只能获取第一个carname元素节点)  
        Element carname = e.element("carname");  

        System.out.println(e.getName() + "----" + carname.getText());  

        // 获取supercars这个元素节点 中，所有子节点名称为carname元素的节点 。  

        List<Element> carnames = e.elements("carname");  
        for (Element cname : carnames) {  
            System.out.println(cname.getText());  
        }  

        // 获取supercars这个元素节点 所有元素的子节点。  
        List<Element> elements = e.elements();  

        for (Element el : elements) {  
            System.out.println(el.getText());  
        }  

    }  
    
    public static void main(String[] args) {
		XmlParseUtil xu = new XmlParseUtil();
		xu.parseXml();
	}
	
}
