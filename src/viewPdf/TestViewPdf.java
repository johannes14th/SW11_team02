package viewPdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import pdfCreator.CreatorPdf;

import junit.framework.TestCase;

public class TestViewPdf extends TestCase {
	ViewPdf test = new ViewPdf();

	
	public void testPath(){
		File file = new File("C:" + File.separator + "pdfs" + File.separator + "test.pdf");
		test.setFileName(file);
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File filename = test.getFileName();
		boolean check = filename.exists();
		assertEquals(true, check);
	}
	
	public void testString(){
		File file = new File("C:" + File.separator + "pdfs" + File.separator + "test.pdf");
		test.setFileName(file);
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File filename = new File(test.getFileNameString());
		boolean check = filename.exists();
		assertEquals(true, check);
	}
	
}
