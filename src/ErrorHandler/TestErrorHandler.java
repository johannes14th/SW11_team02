package ErrorHandler;

import junit.framework.TestCase;

public class TestErrorHandler extends TestCase {

	
	public void testAddErrorMessage()
	{
		ErrorHandler.addErrorMessage("Error");
		assertEquals("Error",ErrorHandler.getErrorMessage(0));
	}

}
