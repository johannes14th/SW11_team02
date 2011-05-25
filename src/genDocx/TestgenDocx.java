package genDocx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.NodeList;

import junit.framework.TestCase;


public class TestgenDocx extends TestCase {
	File xmlTester;
	
	public void setUp() {
		try {
			super.setUp();
			xmlTester = new File ("test.xml");
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(xmlTester));
				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?><value>We are the best, shit on the rest.</value>");
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
		NodeList list = generate.getXmlVars();
		if(list.getLength() > 0) {
			size = true;
		}
		assertEquals(true, size);
	}
	
	public void testExistDocx() {
		GenDocX myDocument = new GenDocX(xmlTester); 
		// path only works on server, not on testcase
		assertEquals(true, myDocument.generateDocX());
	}
	
	
	

}
