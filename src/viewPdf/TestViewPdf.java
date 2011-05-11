package viewPdf;

import java.io.File;

import pdfCreator.CreatorPdf;

import junit.framework.TestCase;

public class TestViewPdf extends TestCase {
	ViewPdf test = new ViewPdf();

	
	public void testPath(){
		File file = new File("C:" + File.separator + "pdfs" + File.separator + "test.pdf");
		test.setFileName(file);
		File filename = test.getFileName();
		boolean check = filename.exists();
		assertEquals(true, check);
	}
	
	public void testString(){
		File file = new File("C:" + File.separator + "pdfs" + File.separator + "test.pdf");
		test.setFileName(file);
		File filename = new File(test.getFileNameString());
		boolean check = filename.exists();
		assertEquals(true, check);
	}
	
}
