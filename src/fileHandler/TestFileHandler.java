package fileHandler;

import junit.framework.TestCase;

public class TestFileHandler extends TestCase {
//Must run on server. No testcases possible!!!!
	//But we've tried!!! ;-)
	String expectedSystemPathWin;
	String expectedSystemPathLin;
	String expectedUserPath;
	String directory_name;
	//User user;
	
	protected void setUp() throws Exception {
		super.setUp();
		expectedSystemPathWin = "";
		expectedSystemPathLin = "";
		expectedUserPath = "";
		directory_name = "test_make_dir";
		//user = new User("Sepp");
	}

	public void testGetSystemPath()
	{
		//check if empty
		//assertNotNull(FileHandler.getSystemPath());
		//check if valid		
		
		//int start = FileHandler.getSystemPath().indexOf("\\.metadata");
		//String compare = FileHandler.getSystemPath().substring(start, FileHandler.getSystemPath().length());
		//assertEquals(compare, expectedSystemPathWin);
	}
	
	public void testGetUserPath()
	{
		//check if empty
		//assertNotNull(FileHandler.getUserPath(user.getName()));
		//check if valid
		//assertEquals(FileHandler.getUserPath(user.getName()), expectedUserPath);
	}
	
}
