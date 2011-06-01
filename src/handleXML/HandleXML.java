package handleXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class HandleXML {

	File xml_;
	Document doc_;
	DocumentBuilder db_;
	List<String> nodes_;
	List<String> values_;

	public HandleXML(File xml)
	{
		xml_ = xml;
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			db_ = dbf.newDocumentBuilder();
			doc_ = db_.parse(xml_);

			nodes_ = new ArrayList<String>();
			//final_nodes_ = new ArrayList<String>();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean checkXML()
	{
		try
		{
			db_.parse(xml_);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

//	private void scanNodes(NodeList nodes)
//	{
//		for (int i=0; i<nodes.getLength(); i++)
//		{
//			//nodes_.add(marker_+the_nodes.item(i).getNodeName());
//			if (nodes.item(i).hasChildNodes() && !(nodes.item(i).getNodeName().equals("metadata")))
//			{
//
//				scanNodes(nodes.item(i).getChildNodes());
//			}
//
//			else {
//				if(!(nodes.item(i).getNodeName().equals("#text")) && !(nodes.item(i).getNodeName().equals("metadata"))) {
//					values_.add(nodes.item(i).getNodeName());
//				}
//			}
//		}
//
//		return;
//
//	}

	private void scanNodes() {
		NodeList nodes = doc_.getElementsByTagName("var");
		for (int i = 0; i<nodes.getLength(); i++){
			Element tagElmnt = (Element) nodes.item(i);
			values_.add(tagElmnt.getAttribute("id"));
		}

	}

	public List<String> getVarList()
	{
		values_ = new ArrayList<String>();
		scanNodes();

//		for (int i=0; i<final_nodes_.size(); i++)
//		{
//			System.out.println(final_nodes_.get(i));
//		}
		return values_;
	}

	public List<String> getMetaData() {
		NodeList nodes = doc_.getElementsByTagName("metadata");
		List<String> list = new ArrayList<String>();

		if(nodes.getLength() > 0) {
			NodeList tmp = nodes.item(0).getChildNodes();
			for(int i = 0; i < tmp.getLength(); i++) {
				if(!(tmp.item(i).getNodeName().equals("#text"))) {
					list.add(tmp.item(i).getNodeName());
				}
			}
		}
		return list;
	}
}


