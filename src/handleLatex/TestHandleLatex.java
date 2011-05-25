package handleLatex;

import java.io.File;

import javax.xml.transform.Templates;
import javax.xml.transform.sax.TemplatesHandler;

import CreateTemplate.Template;

import fileHandler.FileHandler;

import junit.framework.TestCase;


public class TestHandleLatex extends TestCase{
	
	Template template_;
	Template toInclude_;
	String path_;
	
	public void setUp() {
		try {
			super.setUp();
			File file = new File("");
			template_ = new Template(file.getAbsolutePath() + File.separator + "template.tex");
			template_.createTemplate();
			template_.setContent("includeTemplate(toInclude.tex);");
			
			File file2 = new File("");
			toInclude_ = new Template(file2.getAbsolutePath() + File.separator + "toInclude.tex");
			toInclude_.createTemplate();
			toInclude_.setContent("::include1:::");
			path_ = file2.getAbsolutePath();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testFileInput(){
		HandleLatexFiles latex = new HandleLatexFiles(template_.getAbsolutePath());
		assertNotNull(latex.getInputFile());
	}

	public void testFileFormat(){
		HandleLatexFiles latex = new HandleLatexFiles(template_.getAbsolutePath());
		File file = latex.getInputFile();
		String filename = file.getName();
		String format = filename.substring(filename.length() - 4, filename.length());
		assertEquals(".tex", format);
	}
	
	public void testOutputDirectory(){
		HandleLatexFiles latex = new HandleLatexFiles(template_.getAbsolutePath());
		assertNotNull(latex.getOutputDirectory());
		
	}
	
	public void testParsing(){
		HandleLatexFiles latex = new HandleLatexFiles(template_.getAbsolutePath());
		assertEquals(true, latex.insertData(latex.getLatexVariables(), template_.getAbsolutePath()));
	}
	
	public void testInclude() {
		HandleLatexFiles latex = new HandleLatexFiles(template_.getAbsolutePath());
		latex.includeTemplate(path_);
		assertEquals(true,latex.includeTemplate(path_).contains("::include1:::"));
		assertEquals(true,latex.checkIncludedTemplate(template_.getAbsolutePath(),toInclude_.getAbsolutePath()));
	}
}
