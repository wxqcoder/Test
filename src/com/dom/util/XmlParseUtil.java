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
	 * ����xml�ĵ�
	 * @param filename
	 * @return
	 */
	public static Document load(String filename) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(filename)); // ��ȡXML�ļ�,���document����
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;

	}
	
	/** 
     * �ݹ�������и��ڵ㡢�ӽڵ� 
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
        //�Ӹ��ڵ㿪ʼ������������=ֵ������ʽ��Ϊһ��Attribute����洢��List������  
        List<Attribute> attrList = element.attributes();
        
        for(Attribute attr : attrList){  
            //ÿѭ��һ�Σ������˽ڵ��һ��������=ֵ����û���������  
            String name = attr.getName();  
            String value = attr.getValue();  
            System.out.println(name+"="+value);  
            
            
        }  
          
        List<Element> elementList = element.elements();  
        //�ݹ�������ڵ��µ������ӽڵ�  
        for(Element e : elementList){  
            parserNode(e);  
        }  
    }  
	
	/**
	 * ����xml�ĵ�
	 */
	public void parseXml(){
		Document doc = load("D:/6115.xml");
		 Element root = doc.getRootElement();//��ȡ���ڵ�
		 String name = root.getName();
		 parserNode(root);
	}
	
	
	
	
	
    public void createXMLDemo() throws Exception {  

        // ����saxReader����  
        SAXReader reader = new SAXReader();  
        // ͨ��read������ȡһ���ļ� ת����Document����  
        Document document = reader.read(new File("src/car.xml"));  
        //��ȡ���ڵ�Ԫ�ض���  
        Element node = document.getRootElement();  
        //�������е�Ԫ�ؽڵ�  
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
         // д�뵽һ���µ��ļ��� 
         //writer(document);
    }

   
    /** 
     * ������ǰ�ڵ�Ԫ�����������(Ԫ�ص�)�ӽڵ� 
     *  
     * @param node 
     */  
    public void listNodes(Element node) {  
        System.out.println("��ǰ�ڵ�����ƣ���" + node.getName());  
        // ��ȡ��ǰ�ڵ���������Խڵ�  
        List<Attribute> list = node.attributes();  
        // �������Խڵ�  
        for (Attribute attr : list) {  
            System.out.println(attr.getText() + "-----" + attr.getName()  
                    + "---" + attr.getValue());  
        }  

        if (!(node.getTextTrim().equals(""))) {  
            System.out.println("�ı����ݣ�������" + node.getText());  
        }  

        // ��ǰ�ڵ������ӽڵ������  
        Iterator<Element> it = node.elementIterator();  
        // ����  
        while (it.hasNext()) {  
            // ��ȡĳ���ӽڵ����  
            Element e = it.next();  
            // ���ӽڵ���б���  
            listNodes(e);  
        }  
    }  

    /** 
     * ����Element�е�element������elements������ʹ�� 
     *  
     * @param node 
     */  
    public void elementMethod(Element node) {  
        // ��ȡnode�ڵ��У��ӽڵ��Ԫ������Ϊsupercars��Ԫ�ؽڵ㡣  
        Element e = node.element("supercars");  
        // ��ȡsupercarsԪ�ؽڵ��У��ӽڵ�Ϊcarname��Ԫ�ؽڵ�(���Կ���ֻ�ܻ�ȡ��һ��carnameԪ�ؽڵ�)  
        Element carname = e.element("carname");  

        System.out.println(e.getName() + "----" + carname.getText());  

        // ��ȡsupercars���Ԫ�ؽڵ� �У������ӽڵ�����ΪcarnameԪ�صĽڵ� ��  

        List<Element> carnames = e.elements("carname");  
        for (Element cname : carnames) {  
            System.out.println(cname.getText());  
        }  

        // ��ȡsupercars���Ԫ�ؽڵ� ����Ԫ�ص��ӽڵ㡣  
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
