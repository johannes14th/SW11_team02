package ZipFolder;
import java.io.File;
import java.util.ArrayList;


public class ChooseFilesForZip 
{
	ArrayList<File> files = new ArrayList<File>();
	ArrayList<File> chosenFiles = new ArrayList<File>();
	String file_path = "";
	
	public ChooseFilesForZip(String path)
	{
		this.file_path = path;
	}
	
	public void setChosenFiles(ArrayList<File> filesChosen)
	{
		chosenFiles = filesChosen;
	}
	
	public ArrayList<File> getChosenFiles()
	{
		return chosenFiles;
	}
	
	public ArrayList<File> getFiles()
	{
		try
		{
			File dir = new File(file_path);
			
			if(!dir.exists())
			{
				return null;	// directory doesn't exist
			}
			
			File[] fileList = dir.listFiles();
			
			for(File f : fileList) 
			{ 
				if(f.getName().endsWith(".tex") || f.getName().endsWith(".docx") || f.getName().endsWith(".pdf")) {
					files.add(f);
				}
			
			}
			
			return files;
		
		}catch(NullPointerException npex)
		{
			return null;
		}
	}
	
}
