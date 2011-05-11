package fileHandler;

import java.io.File;

public class FileHandler {
	
	public static String getSystemPath() {
		String path = System.getProperty("wtp.deploy");
		String separator = System.getProperty("file.separator");
		path += separator + "WebTEXter";
		return path;
	}
	
	public static String getUserPath(String username) {
		String path = System.getProperty("wtp.deploy");
		String separator = System.getProperty("file.separator");
		
		path += separator + "WebTEXter" + separator + "users";
		if(!(new File(path).exists())) {
			makeDirectory(path);
		}
		
		path += separator + username;

		
		if(new File(path).exists()) {
			return path;
		} else {
			return makeDirectory(path);
		}
	}
	
	private static String makeDirectory(String directory) {
		File file = new File(directory);
		try{
			file.mkdir();
			return directory;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		} 
	}
	

}
