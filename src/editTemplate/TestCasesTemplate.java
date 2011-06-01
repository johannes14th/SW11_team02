package editTemplate;
import junit.framework.TestCase;
import editTemplate.Data;

public class TestCasesTemplate extends TestCase
{
	public void testOpenFile()
	{
		Data test = new Data("latex1.tex");
		assertNotNull(test.getInput(), test);
	}	
	
	public void testSaveFile()
	{
		Data test = new Data("latex1.tex");
		test.setInput("testSaveFile\n");
		assertEquals("testSaveFile\n",test.getInput());
	}
}
