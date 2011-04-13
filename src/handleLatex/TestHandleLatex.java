package handleLatex;

import java.io.File;

import junit.framework.TestCase;


public class TestHandleLatex extends TestCase{
	
	public void testFileInput(){
		HandleLatexFiles latex = new HandleLatexFiles("C:\\Users\\Uni\\workspace\\latex.tex");
		assertNotNull(latex.getInputFile());
	}

	public void testFileFormat(){
		HandleLatexFiles latex = new HandleLatexFiles("C:\\Users\\Uni\\workspace\\latex.tex");
		File file = latex.getInputFile();
		String filename = file.getName();
		String format = filename.substring(filename.length() - 4, filename.length());
		assertEquals(".tex", format);
	}
	
	public void testOutputDirectory(){
		HandleLatexFiles latex = new HandleLatexFiles("C:\\Users\\Uni\\workspace\\latex.tex");
		assertNotNull(latex.getOutputDirectory());
		
	}
	
	public void testParsing(){
		HandleLatexFiles latex = new HandleLatexFiles("C:\\Users\\Uni\\workspace\\latex.tex");
		assertEquals(true, latex.insertData(latex.getLatexVariables(), "C:\\Users\\Uni\\workspace\\latex_out.tex"));
	}
	
	public void testInsertMetaData() {
		HandleLatexFiles latex = new HandleLatexFiles("C:\\Users\\Uni\\workspace\\latex.tex");
		assertEquals(true, latex.insertData(latex.getLatexVariables(), "C:\\Users\\Uni\\workspace\\latex_meta.tex"));
		assertEquals(true, latex.insertMetaData("David", System.currentTimeMillis()));
	}
}
