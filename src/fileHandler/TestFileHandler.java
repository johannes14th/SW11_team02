package fileHandler;

import junit.framework.TestCase;

public class TestFileHandler extends TestCase {
//Must run on server. No testcases possible!!!!
	//But we've tried!!! ;-)
	String expectedSystemPath;
	String expectedUserPath;
	String directory_name;
	//User user;
	
	protected void setUp() throws Exception {
		super.setUp();
		expectedSystemPath = "";
		expectedUserPath = "";
		directory_name = "test_make_dir";
		//user = new User("Sepp");
	}

	public void testGetSystemPath()
	{
		//check if empty
		//assertNotNull(FileHandler.getSystemPath());
		//check if valid
		//assertEquals(FileHandler.getSystemPath(), expectedSystemPath);
	}
	
	public void testGetUserPath()
	{
		//check if empty
		//assertNotNull(FileHandler.getUserPath(user.getName()));
		//check if valid
		//assertEquals(FileHandler.getUserPath(user.getName()), expectedUserPath);
	}
	
}
