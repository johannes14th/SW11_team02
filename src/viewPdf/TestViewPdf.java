package viewPdf;

import java.io.File;

import pdfCreator.CreatorPdf;

import junit.framework.TestCase;

public class TestViewPdf extends TestCase {
	ViewPdf test = new ViewPdf();
	
	public void testPath(){
		File filename = test.getFileName();
		boolean check = filename.exists();
		assertEquals(true, check);
	}
	
	
}
