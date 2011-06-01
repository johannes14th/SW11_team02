package genDocx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import junit.framework.TestCase;

import org.w3c.dom.NodeList;


public class TestgenDocx extends TestCase {
	File xmlTester;

	@Override
	public void setUp() {
		try {
			super.setUp();
			xmlTester = new File ("test.xml");
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(xmlTester));
				writer.write("<?xml version=\"1.0\"?><template><metadata><author></author><date></date><filename></filename></metadata><root><font type=\"Arial\"><color type=\"green\"><var id=\"to\"></var><b type=\"single\"><var id=\"bold\"></var></b><color type=\"yellow\"><var id=\"bla\"></var></color></color><var id=\"gregor\"></var></font><i type=\"single\"><u type=\"single\"><var id=\"from\"></var></u><var id=\"irgendwas\"></var></i><jc type=\"center\"><var id=\"title\"></var><var id=\"text\"></var></jc></root></template>");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testExistFile() {
		GenDocX myDocument = new GenDocX(xmlTester);
		assertNotNull(myDocument.getXml());
	}

	public void testParseXml() {
		GenDocX generate = new GenDocX(xmlTester);
		boolean size = false;
//		List<String> list = generate.getXmlVars();
//		if(list.size() > 0) {
//			size = true;
//		}
		NodeList list = generate.getXmlAll();
		if(list.getLength() > 0) {
			size = true;
		}
		assertEquals(true, size);
	}

	public void testExistDocx() {
		GenDocX myDocument = new GenDocX(xmlTester);
		// path only works on server, not on testcase
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("to", "TO");
		data.put("bold", "BOLD");
		data.put("gregor","GREGOR");
		data.put("from", "FROM");
		data.put("irgendwas", "IRGENDWAS");
		data.put("title", "TITLE");
		data.put("text", "TEXT");
		HashMap<String, String> metadata = new HashMap<String, String>();
		metadata.put("filename","FILENAME2");
		assertEquals(true, myDocument.generateDocX(data, metadata));
	}




}
