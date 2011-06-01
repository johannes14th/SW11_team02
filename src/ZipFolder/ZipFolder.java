package ZipFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import ErrorHandler.ErrorHandler;

public class ZipFolder {

	byte[] buf = new byte[1024];
	private String folder_;


	/**
	 * Constructor
	 * 
	 * @param zipName name of zip folder including full path
	 * @param files files to be added
	 */
	public ZipFolder(String zipName, List<File> files) {
		if(files.size() > 1) {
			if(zipName.contains(".zip")) {
				folder_ = zipName;
				createZipFolder(folder_, files);
			} else {
				folder_ = zipName + ".zip";
				createZipFolder(folder_, files);
			}
		} else {
			ErrorHandler.addErrorMessage("More than 1 file needed");
		}
			
	}
	
	/**
	 * creates a zip folder with given files
	 * @param foldername the foldername including path
	 * @param files the files to add
	 * @return true if works, otherwise false
	 */
	public boolean createZipFolder(String foldername, List<File> files) {		
		try {
	        // Create the ZIP file
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(foldername));
	    
	        // Compress the files
	        for (File file : files) {
	            FileInputStream in = new FileInputStream(file);
	    
	            // Add ZIP entry to output stream.
	            out.putNextEntry(new ZipEntry(file.getName()));
	    
	            // Transfer bytes from the file to the ZIP file
	            int len;
	            while ((len = in.read(buf)) > 0) {
	                out.write(buf, 0, len);
	            }
	    
	            // Complete the entry
	            out.closeEntry();
	            in.close();
	        }
	    
	        // Complete the ZIP file
	        out.close();
	        return true;
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	return false;
	    }
	}
	
	public File getFolder() {
		File file = new File(folder_);
		return file;
	}
	
}
