package ZipFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class TestZipFolder extends TestCase {

	String separator = System.getProperty("file.separator");
	public void testCreateZipFolder(){
		
		List<File> files = new ArrayList<File>();
		File file1 = new File("data"+separator+"server_templates"+separator+"Template1.tex");
		File file2 = new File("data"+separator+"server_templates"+separator+"Template2.tex");
		files.add(file1);
		files.add(file2);
		String folder = "data"+separator+"server_templates"+separator+"test";
		ZipFolder zip = new ZipFolder(folder, files);
		assertEquals(true, new File(folder+".zip").exists());
	}
	
	public void testReturnZipFolder() {
		List<File> files = new ArrayList<File>();
		File file1 = new File("data"+separator+"server_templates"+separator+"Template1.tex");
		File file2 = new File("data"+separator+"server_templates"+separator+"Template2.tex");
		files.add(file1);
		files.add(file2);
		String folder = "data"+separator+"server_templates"+separator+"test";
		ZipFolder zip = new ZipFolder(folder, files);
		assertNotNull(zip.getFolder());
	}

}
