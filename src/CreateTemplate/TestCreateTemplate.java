package CreateTemplate;

import java.io.IOException;

import junit.framework.TestCase;

public class TestCreateTemplate extends TestCase {
	
	public void testCreateTemplate() throws IOException {
		Template template = new Template("test2.tex");
		template.setContent("test");
		assertEquals("test2.tex",template.getFilename());
		assertEquals("tex",template.getExtension());
		assertEquals("test\n",template.getContent());
		assertEquals(true,template.isAllowedExtension("tex"));
		assertEquals(false,template.isAllowedExtension("txt"));
	}
	
	/*public void testSetContentWithStartposition() {
		Template template = new Template("hugo.tex");
		template.setContent("abcd",0);
		template.setContent("test",4);
		assertEquals("abcdtest",template.getContent());
	}*/
}
