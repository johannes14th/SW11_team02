package CreateTemplate;

import java.io.IOException;

import junit.framework.TestCase;

public class TestCreateTemplate extends TestCase {
	
	public void testCreateTemplate() throws IOException {
		Template template = new Template("test.tex");
		template.setContent("test");
		assertEquals("test.tex",template.getFilename());
		assertEquals("tex",template.getExtension());
		assertEquals("test",template.getContent());
		assertEquals(true,template.isAllowedExtension("tex"));
		assertEquals(false,template.isAllowedExtension("txt"));
	}
}
