package chooseTemplate;

import java.io.File;
import java.util.ArrayList;

public class ChooseTemplate
{
	ArrayList<String> template_names = new ArrayList<String>();
	String templates_path = "";
	String file_extension = "";
	String file_name = "";
	
	public ChooseTemplate(String path, String extension)
	{
		this.templates_path = path;
		this.file_extension = extension;
	}
	
	public int getSize()
	{
		return template_names.size();
	}
	
	public void setFileName(String file_name)
	{
		this.file_name = file_name;
	}
	
	public String getChosenFileName()
	{
		if(file_name.isEmpty())
			return "";
		else
			return file_name;
	}
	
	public String getTemplateName (int index)
	{
		try
		{
			return template_names.get(index);
		}catch(IndexOutOfBoundsException iex)
		{
			return "";
		}
		
	}
	
	public String getFileExtension(String filePath)
	{
		int index = filePath.lastIndexOf('.');
		return filePath.substring(index);
	}
	
	public boolean getTemplateNames()
	{
		try
		{
			File dir = new File(templates_path);
			
			if(!dir.exists())
			{
				return false;	// director doesn't exist
			}
			
			File[] fileList = dir.listFiles();
			
			//this.test = getFileExtension("C:\\template.latex");
			
			for(File f : fileList) 
			{
				if(file_extension.compareToIgnoreCase(getFileExtension(f.getPath())) == 0)
				{
					template_names.add(f.getName());
				}
			}
			
			return true;
		
		}catch(NullPointerException npex)
		{
			return false;
		}
	}
	
		
	
}
