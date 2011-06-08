package konDocxToXml;

import junit.framework.TestCase;
import java.io.File;
import java.util.zip.*;
import java.util.Vector;

//import java.io.IOException;

public class TestDocxToXml extends TestCase{
	
	File docx_;
	File zip_;
	DocxToXml module_;
	
	public void setUp(){
		docx_ = new File("dummy.docx");
		module_ = new DocxToXml();
		
		
	}
	
	public void testConvertToZip()
	{
		module_.convertToZip("dummy.docx");
		zip_ = new File("TEMP.zip");
		assertTrue(zip_.exists());
	}
	
	public void testAddEntry()
	{
		ZipEntry test_it = new ZipEntry("Test");
		module_.addZipEntry(test_it);
		assertNotNull(module_.getZFileVector());
		module_.removeZipEntry(test_it);
		assertEquals(module_.getZFileVector().size(), 0);
	}
	
	public void testOpenZip()
	{
		module_.decompressZip();
		assertNotSame(0, module_.getZFileVector().size());
		
	}

	public void testInfTag()
	{
		assertEquals(module_.findValue("date111","test2.xml"), "");
		assertEquals(module_.findValue("date","test2.xml"), "");
		assertEquals(module_.findValue("author","test2.xml"), "hallo");
	}
	
	
	public void testSearchTag()
	{

		module_.decompressZip();
		module_.searchTags();
		assertNotSame(0, module_.getZFileVector().size());
	}
	
	
	public void testConvertToXml()
	{
		
	}
	
	public void testClean()
	{
		try {
			module_.clean();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zip_ = new File("TEMP.zip");
		assertTrue(!zip_.exists());
		
	}

}
