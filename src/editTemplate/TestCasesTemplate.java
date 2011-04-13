package editTemplate;
import junit.framework.TestCase;
import editTemplate.Data;

public class TestCasesTemplate extends TestCase
{
	public void testOpen()
	{
		Data test = new Data();
		assertNotNull(test.getInput(), test);
	}	
}
