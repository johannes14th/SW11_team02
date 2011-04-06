package handleLatex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import de.nixosoft.jlr.JLRConverter;

public class HandleLatexFiles {
	
	private File inputFile_;
	private File outputFile_;
	private File inputDirectory_;
	private File outputDirectory_;
	List<String> listVar_;
	List<Integer> listInt_;
	
	/**
	 * 
	 * Constructor
	 * 
	 */
	public HandleLatexFiles() {
		inputDirectory_ = new File("/Users/Berni/eclipse-workspace/input_files");
		outputDirectory_ = new File("/Users/Berni/eclipse-workspace/output");
		
		String filename = "first_file.tex";
		inputFile_ = new File(inputDirectory_.getPath() + File.separator + filename);
		outputFile_ = new File(outputDirectory_.getPath() + File.separator + "out_" + filename);
				
		scanLatex();
				
	}
	
	/**
	 * replaces values of Tex Files (given from getLatexVariables())
	 * 
	 * @param input: a String List with data inputs 
	 * @return true if parsing works correct, else false
	 */
	public boolean insertData(List<String> input) {
		HashMap<String, String> data = new HashMap<String, String>();
		for(int i = 0; i < listVar_.size(); i++) {
			data.put(listVar_.get(i), input.get(i));
		}
		
		return parseLatex(data);
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
	 * returns the directory of input
	 * @return input directory
	 */
	public File getInputDirectory() {
		return inputDirectory_;
	}

	/**
	 * sets the input directory
	 * 
	 * @param directory the input directory to set
	 */
	public void setInputDirectory(File directory) {
		inputDirectory_ = directory;
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
	
	public List<Integer> getIntegerList() {
		return listInt_;
	}
	
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
		listInt_ = new ArrayList<Integer>();
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
}
