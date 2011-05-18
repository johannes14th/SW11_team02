import ZipFolder.TestZipFolder;
import pdfCreator.PdfCreatorTestCases;
import viewPdf.TestViewPdf;
import CreateTemplate.TestCreateTemplate;
import chooseTemplate.TestChooseTemplate;
import database.DatabaseTest;
import database.HandleDatabaseTest;
import editTemplate.TestCasesTemplate;
import fileHandler.TestFileHandler;
import gui.TestDataForm;
import handleLatex.TestHandleLatex;
import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
		Class[] testClasses = {HandleDatabaseTest.class, DatabaseTest.class,TestChooseTemplate.class,TestCreateTemplate.class,
				TestCasesTemplate.class,TestFileHandler.class,TestDataForm.class,TestHandleLatex.class,PdfCreatorTestCases.class,
				TestViewPdf.class,TestZipFolder.class};
		TestSuite suite = new TestSuite(testClasses);
		//$JUnit-BEGIN$
		//$JUnit-END$
		return suite;
	}

}
