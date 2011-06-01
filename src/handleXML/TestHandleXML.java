package handleXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import junit.framework.TestCase;

public class TestHandleXML extends TestCase {

	File xml_;

	@Override
	public void setUp() {
		xml_ = new File("test.xml");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(xml_));
			writer.write("<?xml version=\"1.0\"?><note><metadata><author></author><date></date><filename></filename></metadata>Send To: <var id=\"to\"></var>From: <var id=\"from\"></var>Title: <title></title>Text: <text></text></note>");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void testCheckXML() {
		HandleXML handle = new HandleXML(xml_);
		assertEquals(true, handle.checkXML());

	}

	public void testListHasContents()
	{
		HandleXML handle = new HandleXML(xml_);
		assertNotNull(handle.getVarList());
	}

	public void testGetMetaData() {
		HandleXML handle = new HandleXML(xml_);
		assertNotNull(handle.getMetaData());
	}

}
