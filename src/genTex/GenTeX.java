package genTex;

import fileHandler.FileHandler;
import handleXML.HandleXML;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import CreateTemplate.Template;
import ErrorHandler.ErrorHandler;

public class GenTeX {

	File xml_;
	HandleXML handler_;
	Template texTemplate_;
	HashMap<Integer, HashMap<String,String>> styleMap_;

	public GenTeX(File xml) {
		xml_ = xml;
		handler_ = new HandleXML(xml_);
		styleMap_ = new HashMap<Integer, HashMap<String,String>>();
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

	public boolean generateTeX(HashMap<String, String> values,HashMap<String, String> metadata, String username) {

		try {
			texTemplate_ = new Template("C:\\Users\\johannes\\SW11\\vorlage.tex");

			NodeList nodes = getXmlAll();
			Node node = null;
			if(nodes.getLength() > 0) {
				nodes = nodes.item(0).getChildNodes();
				if(nodes.getLength() == 2) {
					node = nodes.item(1);
					//visit(node, 0, values);
				} else {
					ErrorHandler.addErrorMessage("no metadata or root node");
				}
			} else {
				ErrorHandler.addErrorMessage("no correct template");
			}

			if(node != null) {
				visit(node, 0, values);
			}

			String filename = "NOFILENAME";
			if(metadata.get("filename") != null) {
				filename = metadata.get("filename");

				filename = filename.toLowerCase();

				if(!filename.contains(".tex")) {
					filename += ".tex";
				}
			}

			// Files saved to systempath, not to userpath
			createTeX(FileHandler.getUserPath(username) + FileHandler.getSeparator() + filename);
			//createTeX("C:\\Users\\johannes\\workspace\\SW11_team02\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebTEXter\\b.tex");

			return true;
		} catch (Exception e) {
			System.out.println("error " + e.toString());
			return false;
		}

	}

	private void createTeX(String file) {
		texTemplate_.createTexTemplate(file);
	}

	private void visit(Node node, int level, HashMap<String, String> values)
	{
		NodeList nl = node.getChildNodes();

		for(int i=0, cnt=nl.getLength(); i<cnt; i++)
		{

			if(nl.item(i).getNodeName().equals("text") || nl.item(i).getNodeName().equals("var")) {
				String content="";

				if(nl.item(i).getNodeName().equals("text")) {
					content = nl.item(i).getTextContent();
				} else {
					Element tagElmnt = (Element) nl.item(i);
					String key = tagElmnt.getAttribute("id");

					if(values.get(key) != null) {
						content = values.get(key);
					} else {
						content = "";
					}

				}

				if(level == 0) {
					styleMap_.clear();
				}
				else {
					for(int key = styleMap_.size(); key >= level; key--) {
						styleMap_.remove(key);
					}
				}
				texTemplate_.addContent(content, styleMap_);


			}
			else if(!(nl.item(i).getNodeName().equals("#text"))){
				HashMap<String, String> style = new HashMap<String, String>();
				Element tagElmnt = (Element) nl.item(i);
				String attr = tagElmnt.getAttribute("type");
				style.put(nl.item(i).getNodeName(), attr);
				styleMap_.put(level, style);
			}
			visit(nl.item(i), level+1, values);
		}
	}
}
