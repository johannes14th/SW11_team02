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
	List<HashMap<String,String>> list_;
	CreateDocx objDocx_;

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

	public boolean generateDocX(HashMap<String, String> values, HashMap<String, String> metadata, String username) {
		try {
			objDocx_ = new CreateDocx(".docx");
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

			//metadata
			if(node != null)
			{
				visit(node, 0, values);
				NodeList vars = getXmlVars();
				for(int i = 0; i < vars.getLength(); i++) {
				}
			}

			String filename = "NOFILENAME";
			if(metadata.get("filename") != null) {
				filename = metadata.get("filename");
			}

			// Files saved to systempath, not to userpath
			objDocx_.createDocx(FileHandler.getUserPath(username) + FileHandler.getSeparator() + filename);

			return true;
		} catch (Exception e) {
			System.out.println("error " + e.toString());
			return false;
		}

	}

	private void visit(Node node, int level, HashMap<String, String> values) {
		NodeList nl = node.getChildNodes();

		for(int i=0, cnt=nl.getLength(); i<cnt; i++)
		{
			Node tmp = nl.item(i);
			if(nl.item(i).getNodeName().equals("text") || nl.item(i).getNodeName().equals("var")) {
				HashMap<String, String> style = new HashMap<String, String>();
				while(tmp.getParentNode() != null && tmp.getParentNode().getNodeName() != "root") {
					tmp = tmp.getParentNode();
					Element tagElmnt = (Element) tmp;
					if(style.get(tmp.getNodeName()) == null) {
						String attr = tagElmnt.getAttribute("type");
						style.put(tmp.getNodeName(), attr);
					}
				}

				if(nl.item(i).getNodeName().equals("var")) {
					Element tagElmnt = (Element) nl.item(i);
					String key = tagElmnt.getAttribute("id");

					if(values.get(key) != null) {
						objDocx_.addText(values.get(key), style);
					} else {
						objDocx_.addText("", style);
					}
				} else {
					objDocx_.addText(nl.item(i).getTextContent(), style);
				}
			}
			visit(nl.item(i), level+1, values);
		}
	}

}
