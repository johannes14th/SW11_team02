package ZipFolder;

import java.io.File;
import java.util.ArrayList;

import junit.framework.TestCase;

public class TestChooseFilesForZip extends TestCase {
	
	String path;
	
	public void setUp() {
		try {
			super.setUp();
			this.path = "data//server_templates";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetFiles() {
		ChooseFilesForZip zip = new ChooseFilesForZip(path);
		assertNotNull(zip.getFiles());
	}
	
	public void testGetChosenFiles() {
		ChooseFilesForZip zip = new ChooseFilesForZip(path);
		ArrayList<File> files = zip.getFiles();
		zip.setChosenFiles(files);
		
		assertNotNull(zip.getChosenFiles());
	}
	
}
