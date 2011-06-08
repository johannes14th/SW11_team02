package genDocx;

import fileHandler.FileHandler;
import handleXML.HandleXML;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ErrorHandler.ErrorHandler;

import com.javadocx.CreateDocx;

public class GenDocX {

	File xml_;
	HandleXML handler_;

	public GenDocX(File xml) {
		xml_ = xml;
		handler_ = new HandleXML(xml_);
	}

	public File getXml() {
		return xml_;
	}

	public NodeList getXmlAll() {
		try{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(xml_);
		 return doc.getChildNodes();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<String> getXmlMetaData() {
		try{
			return handler_.getMetaData();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private NodeList getXmlVars() {
		try{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(xml_);
		  return doc.getElementsByTagName("var");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean generateDocX(HashMap<String, String> values, HashMap<String, String> metadata) {
		try {
			CreateDocx objDocx = new CreateDocx(".docx");


			//List<String> list = getXmlVars();
//			String text = "";
//			for(int i = 0; i < values.size(); i++) {
//				String node = values.get(i);
//				text += node;
//			}
//			objDocx.addText(text);
//			HashMap<String, String> test = new HashMap<String, String>();
//			test.put("i", "single");
//			test.put("color", "blue");
//			objDocx.addText("HALLO", test);
//
//			HashMap<String, String> test2 = new HashMap<String, String>();
//			test2.put("u", "single");
//			test2.put("jc", "left");
//			objDocx.addText("TEST", test2);
			NodeList nodes = getXmlAll();
			Node node = null;
			if(nodes.getLength() > 0) {
				nodes = nodes.item(0).getChildNodes();
				if(nodes.getLength() == 2) {
					node = nodes.item(1);
				} else {
					ErrorHandler.addErrorMessage("no metadata or root node");
				}
			} else {
				ErrorHandler.addErrorMessage("no correct template");
			}
			System.out.println("HIIIIIIIIIIIIER" + nodes.getLength());

			if(node != null) 
			{
//				while(node.hasChildNodes()) {
//					HashMap<String, String> style = new HashMap<String, String>();
//					NodeList vars = ((Document) node).getElementsByTagName("var");
//					for(int i = 0; i < vars.getLength(); i++) {
//						Element tagElmnt = (Element) nodes.item(i);
//						String key = tagElmnt.getAttribute("id");
//						objDocx.addText(key, style);
//					}
//					nodes = node.getChildNodes();
//
//				}
				//visit(node, 0);
				NodeList vars = getXmlVars();
				for(int i = 0; i < vars.getLength(); i++) {
					Node tmp = vars.item(i);
					HashMap<String, String> style = new HashMap<String, String>();
					while(tmp.getParentNode() != null && tmp.getParentNode().getNodeName() != "root") {
						tmp = tmp.getParentNode();
						Element tagElmnt = (Element) tmp;
						if(style.get(tmp.getNodeName()) == null) {
							String attr = tagElmnt.getAttribute("type");
							System.out.println(tmp.getNodeName());
							style.put(tmp.getNodeName(), attr);
						}
					}
					Element tagElmnt = (Element) vars.item(i);
					String key = tagElmnt.getAttribute("id");
					System.out.println(values.get(key));
					objDocx.addText(values.get(key), style);
				}
			}

			String filename = "NOFILENAME";
			if(metadata.get("filename") != null) {
				filename = metadata.get("filename");
			}

			// Files saved to systempath, not to userpath
			objDocx.createDocx(FileHandler.getSystemPath() + FileHandler.getSeparator() + filename);

			return true;
		} catch (Exception e) {
			System.out.println("error " + e.toString());
			return false;
		}

	}

//	public void visit(Node node, int level)
//	{
//		NodeList nl = node.getChildNodes();
//
//		for(int i=0, cnt=nl.getLength(); i<cnt; i++)
//		{
//			System.out.println("["+nl.item(i)+"]  " + level);
//
//			visit(nl.item(i), level+1);
//		}
//	}

}
