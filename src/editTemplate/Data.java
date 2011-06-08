package editTemplate;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import fileHandler.FileHandler;

public class Data {
	String input = "";
	String saved = "";
	String file_name = "";

	public Data(String filename)
	{
		file_name = filename;
		try
		{
			Scanner in = new Scanner(new File(file_name));
			while (in.hasNextLine())
			{
				input = input + in.nextLine() + "\n";
			}
			in.close();
		}

		catch (Exception e)
		{
			input = "Loading Data Failed";
		}
	}

	public Data(String filename, String username)
	{
		file_name = FileHandler.getUserPath(username) + File.separator +  filename;

		try
		{
			Scanner in = new Scanner(new File(file_name));
			while (in.hasNextLine())
			{
				input = input + in.nextLine() + "\n";
			}
			in.close();
		}

		catch (Exception e)
		{
			input = "";
		}
	}



    public void setInput( String value )
    {
    	input = value;

    	if (value == null) {
			return;
		}
    	try {

    		FileWriter writer = new FileWriter(file_name);
    		writer.write(value);
    		writer.close();
    		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
    		Date now = new Date();
    	    saved = file_name + " saved at " + sdfDate.format(now);


    	}

    	catch (Exception e)
    	{
    		saved = file_name + " was not saved successfully";
    	}

    }

    public String getInput() { return input; }
    public String getSaved() { return saved; }

}
