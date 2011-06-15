package CreateTemplate;

import junit.framework.TestCase;

public class TestCreateTemplate extends TestCase {
	Template template;

	@Override
	public void setUp() {
		template = new Template("test2.tex");
		template.setContent("test");
	}

	public void testContent() {
		assertEquals("test\n",template.getContent());
	}

	public void testFilename() {
		assertEquals("test2.tex",template.getFilename());
	}

	public void testExtension() {
		assertEquals("tex",template.getExtension());
	}

	public void testAllowedExtension() {
		assertEquals(true,template.isAllowedExtension("xml"));
	}

	public void testNotAllowdExtension() {
		assertEquals(false,template.isAllowedExtension("txt"));
	}

}
