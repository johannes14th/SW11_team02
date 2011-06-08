package pdfCreator;



import java.io.File;

import junit.framework.TestCase;
import CreateTemplate.Template;

public class PdfCreatorTestCases extends TestCase {
	CreatorPdf test = new CreatorPdf();
	Template template_;
	String separator = System.getProperty("file.separator");

	@Override
	public void setUp() {
		try {
			super.setUp();

			new File("pdfs").mkdir();

			template_ = new Template("pdfs" + separator +"test.tex");
			template_.createEmptyTemplate();

			template_ = new Template("pdfs" + separator +"test.pdf");
			template_.createEmptyTemplate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void testFilePdfExt() {
		test.createPdf("test.pdf", "neuerTest");
		String file_name = test.getPdfName();
		boolean check = file_name.contains(".pdf");
		assertEquals(true, check);
	}

	public void testFileTexExt() {
		String file_name = test.getTexName();
		boolean check = file_name.contains(".tex");
		assertEquals(true, check);
	}

	public void testPath () {
		test.filePDF = new File("pdfs");
		String path_string = test.getPathString();
		File path = new File(path_string);
		boolean check = path.exists();
		assertEquals(true, check);
	}

	public void testFileTex(){
		test.fileTex = new File("pdfs");
		String path_string = test.getTexPathString();
		File path = new File(path_string + File.separator + test.getTexName());
		System.out.println(path.getAbsolutePath());
		boolean check = path.exists();
		assertEquals(true, check);
	}

	public void testFilePdf(){
		test.filePDF = new File("pdfs");
		String path_string = test.getPathString();
		File path = new File(path_string + File.separator + test.getPdfName());
		boolean check = path.exists();
		assertEquals(true, check);
	}

}
