import genDocx.TestgenDocx;
import handleLatex.TestHandleLatex;
import junit.framework.Test;
import junit.framework.TestSuite;
import pdfCreator.PdfCreatorTestCases;
import translator.TestTranslator;
import viewPdf.TestViewPdf;
import CreateTemplate.TestCreateTemplate;
import ErrorHandler.TestErrorHandler;
import ZipFolder.TestChooseFilesForZip;
import ZipFolder.TestZipFolder;
import chooseTemplate.TestChooseTemplate;
import database.DatabaseTest;
import database.HandleDatabaseTest;
import fileHandler.TestFileHandler;


public class AllTests {

	public static Test suite() {
		Class[] testClasses = {DatabaseTest.class,HandleDatabaseTest.class,TestTranslator.class, TestChooseTemplate.class,TestCreateTemplate.class,
				TestFileHandler.class,TestHandleLatex.class, PdfCreatorTestCases.class,
				TestViewPdf.class,TestZipFolder.class,TestgenDocx.class, TestChooseFilesForZip.class, TestErrorHandler.class};
		TestSuite suite = new TestSuite(testClasses);
		//$JUnit-BEGIN$
		//$JUnit-END$
		return suite;
	}

}
