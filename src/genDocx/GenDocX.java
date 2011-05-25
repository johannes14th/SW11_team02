package genDocx;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.javadocx.*;

import fileHandler.FileHandler;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GenDocX {
	
	File xml_;
	
	public GenDocX(File xml) {
		xml_ = xml;
	}
	
	public File getXml() {
		return xml_;
	}

	public NodeList getXmlVars() {
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
	
	public boolean generateDocX() {
		try {
			CreateDocx objDocx = new CreateDocx(".docx");
			NodeList list = getXmlVars();
			String text = "";
			for(int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				text += node.getTextContent();
			}
			objDocx.addText(text);	
			
			// Files saved to systempath, not to userpath
			objDocx.createDocx(FileHandler.getSystemPath() + FileHandler.getSeparator() + "test2");
			return true;
		} catch (Exception e) {
			System.out.println("error " + e.toString());
			return false;
		}
		
}

}
