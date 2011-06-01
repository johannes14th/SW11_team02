package handleLatex;

import java.io.File;

import junit.framework.TestCase;


public class TestHandleLatex extends TestCase{
	/*
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
	}*/
	
	public void testInclude() {
		HandleLatexFiles latex = new HandleLatexFiles("C:\\Users\\johannes\\SW11\\test.tex");
		latex.includeTemplate("C:\\Users\\johannes\\SW11\\");
		assertEquals(true,latex.includeTemplate("C:\\Users\\johannes\\SW11\\").contains(" :: include1 :::"));
		assertEquals(true,latex.checkIncludedTemplate("C:\\Users\\johannes\\SW11\\test.tex","C:\\Users\\johannes\\SW11\\toInclude.tex"));
	}
}
