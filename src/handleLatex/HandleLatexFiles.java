package handleLatex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import de.nixosoft.jlr.JLRConverter;

/**
 * 
 * @author Bernadette Merkinger, David Pichsenmeister
 * 04-06-2011
 *
 */
public class HandleLatexFiles {
	
	private File inputFile_;
	private File outputFile_;
	private File outputDirectory_;
	private List<String> listVar_;
//	private List<Integer> listInt_;
	private List<String> metadata_;
	
	/**
	 * 
	 * Constructor
	 * 
	 * directory paths and filenames are needed
	 * File with inputfilename must already exist
	 * 
	 * @param inputDirectory, outputDirectory: path to input directory, output directory
	 * @param filenameInput, filename Output: filename of template, outputfilename
	 * 
	 */
	public HandleLatexFiles(String filePath) {
		String directory = filePath.substring(0,filePath.lastIndexOf("\\"));
		
//		String[] splitFilename = filePath.split("/");
//		String directory = splitFilename[splitFilename.length-1];
//		
		outputDirectory_ = new File(directory);
		
		inputFile_ = new File(filePath);
		//outputFile_ = new File(directory + File.separator + "outtest.tex");
//		outputFile_ = new File(outputDirectory_.getPath() + File.separator + "out_test.tex");
		metadata_ = new ArrayList<String>();
		metadata_.add("Filename");
		metadata_.add("Author");
				
		scanLatex();
				
	}
	
	/**
	 * replaces values of Tex Files (given from getLatexVariables())
	 * 
	 * @param input: a String List with data inputs 
	 * @return true if parsing works correct, else false
	 */
	public boolean insertData(List<String> input, String filePath) {
		HashMap<String, String> data = new HashMap<String, String>();
		for(int i = 0; i < listVar_.size(); i++) {
			data.put(listVar_.get(i), input.get(i));
		}
		outputFile_ = new File(filePath);
		return parseLatex(data);
	}
	
	/**
	 * 
	 * sets metadata for file, including filename, author and date
	 * 
	 * @param filename filename for file
	 * @param author author
	 * @param date timestamp
	 * @return true, if parsing works correct, else false
	 */
	public boolean insertMetaData(String author, Long date) {
		return insertMetaDataToLatex(author, date.toString());
	}
	
	/**
	 * returns the inputfile/template
	 * 
	 * @return the inputFile (template)
	 */
	public File getInputFile() {
		return inputFile_;
	}

	/**
	 * sets the inputfile/template
	 * 
	 * @param input: the file to set
	 */
	public void setInputFile(File input) {
		this.inputFile_ = input;
	}

	/**
	 * returns the outputfile
	 * 
	 * @return the outputfile
	 */
	public File getOutputFile() {
		return outputFile_;
	}

	/**
	 * sets the outputfile
	 * 
	 * @param outputFile: the file to set
	 */
	public void setOutputFile(File output) {
		outputFile_ = output;
	}
	
	/**
	 * returns the directory of output
	 * @return output directory
	 */
	public File getOutputDirectory() {
		return outputDirectory_;
	}

	/**
	 * sets the output directory
	 * 
	 * @param directory the output directory to set
	 */
	public void setOutputDirectory(File directory) {
		outputDirectory_ = directory;
	}
	
	/**
	 * returns a List with String, these are the variables of the template Latex file
	 * 
	 * @return java.util.List with Strings
	 */
	public List<String> getLatexVariables() {
		return listVar_;
	}
	
	/**
	 * returns a List with String, these are the variables of the template Latex file
	 * 
	 * @return java.util.List with Strings
	 */
	public List<String> getLatexMetadata() {
		return metadata_;
	}
	
//	public List<Integer> getIntegerList() {
//		return listInt_;
//	}
	
	private boolean parseLatex(HashMap<String, String> data) {
		JLRConverter converter = new JLRConverter("::", ":::");
        try {
			converter.parse(inputFile_, outputFile_, data);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void scanLatex() {
		Scanner input;
		listVar_ = new ArrayList<String>();
		//listInt_ = new ArrayList<Integer>();
		try {
			input = new Scanner(inputFile_);
			while(input.hasNextLine()) {
			    String nextToken = input.nextLine();
			    while(nextToken.contains("::") && nextToken.contains(":::")) {
					    int start = nextToken.indexOf("::");
					    int end = nextToken.indexOf(":::");

					    String value = nextToken.substring(start + 2,end);
					    listVar_.add(value);
					    nextToken = nextToken.substring(end + 3, nextToken.length());
				    }
			}

			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean insertMetaDataToLatex(String author, String date) {
		try
        {        
			BufferedReader reader = new BufferedReader(new FileReader(outputFile_));
			String line = "", text = "";
			String meta = author + " " + date + "\n";
			while((line = reader.readLine()) != null)
            {
				if(!line.equals("\\end{document}")) {
					text += line + "\n";
				} else {
					text += meta;
					text += "\\end{document}";
				}
            }
			reader.close();

			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile_));
			writer.write(text);
			writer.flush();
			writer.close();
			return true;
        }
		catch (IOException ioe)
        {
			ioe.printStackTrace();
			return false;
        }
	}
}
