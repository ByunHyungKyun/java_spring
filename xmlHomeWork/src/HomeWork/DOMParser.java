package HomeWork;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("D:\\A_TeachingMaterial\\6.JspSpring\\workspace\\xmlHomeWork\\src\\HomeWork\\application-context.xml");
		
		// root 구하기
		Element root = document.getDocumentElement();
		
		// root의 속성
		System.out.println("JSP XML Parser HomeWork");
		System.out.println("");
		
		NodeList childeren = root.getChildNodes(); 
		for(int i = 0; i < childeren.getLength(); i++){
			Node node = childeren.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){ 
				Element ele = (Element)node;
				String nodeName = ele.getNodeName();
				System.out.print("bean key: " + ele.getAttribute("id"));
				NodeList childeren2 = ele.getChildNodes();
				if(nodeName.equals("bean")){
					System.out.println("  value: " + ele.getAttribute("class"));
				}
				 if(childeren2.getLength()>0){
					for(int a = 0; a < childeren2.getLength(); a++){
						Node node2 = childeren2.item(a);
						if(node2.getNodeType() == Node.ELEMENT_NODE){
							Element ele2 = (Element)node2;
							String nodeName2 = ele2.getNodeName();
							System.out.print("property key: " + ele2.getAttribute("name"));
							System.out.println("  value: " + ele2.getAttribute("ref-value"));
						}
					}
				}
			}
		}
	}
}