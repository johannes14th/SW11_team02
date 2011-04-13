package ZipFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class TestZipFolder extends TestCase {

	public void testCreateZipFolder(){
		List<File> files = new ArrayList<File>();
		File file1 = new File("data/server_templates/Template1.tex");
		File file2 = new File("data/server_templates/Template2.tex");
		files.add(file1);
		files.add(file2);
		String test = "test";
		ZipFolder zip = new ZipFolder(test, files);
		//assertEquals(true, zip.createZipFolder(test, files)); //function is private, to test, set funtion to public
	}
	
	public void testReturnZipFolder() {
		List<File> files = new ArrayList<File>();
		File file1 = new File("data/server_templates/Template1.tex");
		File file2 = new File("data/server_templates/Template2.tex");
		files.add(file1);
		files.add(file2);
		String test = "data/server_templates";
		ZipFolder zip = new ZipFolder(test, files);
		assertNotNull(zip.getFolder());
	}

}
