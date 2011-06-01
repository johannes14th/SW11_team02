package CreateTemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileHandler.FileHandler;

public class Template {

	private File file;
	private String extension;
	
	public Template(String string) {
		// TODO Auto-generated constructor stub
		file = new File(string);
		
		String[] splitFilename = string.split("\\.");
		extension = splitFilename[splitFilename.length-1];
	
	}
	
	public Template(String string, String username) {
		// TODO Auto-generated constructor stub
		//file = new File(string);
		file = new File(FileHandler.getUserPath(username));
		
		System.out.println(file.getAbsolutePath());
		
		String[] splitFilename = string.split("\\.");
		extension = splitFilename[splitFilename.length-1];
		
	}

	public String getFilename() {
		// TODO Auto-generated method stub
		return file.getName();
	}
	
	public String getAbsolutePath() {
		// TODO Auto-generated method stub
		return file.getAbsolutePath();
	}

	public String getExtension() {
		// TODO Auto-generated method stub
		return extension;
	}

	public void createTemplate() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setContent(String content) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getContent()  {
		// TODO Auto-generated method stub
	    BufferedReader reader = null;
	    String line;
	    StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
		    while ((line = reader.readLine()) != null)
		    {
		      sb.append(line);
		      sb.append("\n");
		    }
		    reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    return sb.toString();
	}

	public boolean isAllowedExtension(String string) {
		// TODO Auto-generated method stub
		
		if(string.equalsIgnoreCase("tex"))
			return true;
		
		return false;
	}

}
