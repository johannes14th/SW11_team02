package chooseTemplate;

import junit.framework.TestCase;

public class TestChooseTemplate extends TestCase {
	String path; //server template path
	String file_extension;
	String test_filepath;
	String file_name;
	
	
	int dummy = -1;
	public void setUp()
	{
		this.path = "data//server_templates";
		this.file_extension = ".tex";
		this.test_filepath = "data\\server_templates\\template.tex";
		this.file_name = "template.tex";
	}
	
	public void testGetTemplateNames()
	{
		ChooseTemplate servTempl = new ChooseTemplate(this.path,this.file_extension);
		assertTrue(servTempl.getTemplateNames()); //returns false wenn Pfad nicht existiert
	}
	
	public void testValidExtension()
	{
		ChooseTemplate servTempl = new ChooseTemplate(this.path,this.file_extension);
		assertEquals(file_extension, servTempl.getFileExtension(test_filepath));
	}
	
	public void testGetChosenFileName()
	{
		ChooseTemplate servTempl = new ChooseTemplate(this.path, this.file_extension);
		servTempl.setFileName(file_name);
		assertEquals(file_name,servTempl.getChosenFileName());	
	}
}
