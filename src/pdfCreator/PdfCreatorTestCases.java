package pdfCreator;



import java.io.File;

import de.nixosoft.jlr.JLROpener;

import junit.framework.TestCase;

public class PdfCreatorTestCases extends TestCase {
	CreatorPdf test = new CreatorPdf();
	
	public void testCreate () {
		
	}
	
	public void testFilePdfExt() {
		test.createPdf();
		String file_name = test.getPdfName();
		boolean check = file_name.contains(".pdf");
		assertEquals(true, check);
	}
	
	public void testFileTexExt() {
		String file_name = test.getTexName();
		boolean check = file_name.contains(".tex");
		assertEquals(true, check);
	}
	
	public void testFolder () {
		
		//File path = new File(file_path + test.getPdfName());
	    String check = test.getFileName();
		
		//JLROpener.open("test.pdf");
		assertEquals("C:/pdfs/", check);
	}
	
	public void testPath () {
		test.setPath();
		String path_string = test.getPathString();
		File path = new File(path_string);
		boolean check = path.exists();
		assertEquals(true, check);
	}
	
	public void testFileTex(){
		test.setPath();
		String path_string = test.getPathString();
		File path = new File(path_string + File.separator + test.getTexName());
		boolean check = path.exists();
		assertEquals(true, check);
	}
	
	public void testFilePdf(){
		test.setPath();
		String path_string = test.getPathString();
		File path = new File(path_string + File.separator + test.getPdfName());
		boolean check = path.exists();
		assertEquals(true, check);
	}
	
}
