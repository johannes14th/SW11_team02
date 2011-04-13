package gui;

import java.util.List;

import handleLatex.HandleLatexFiles;

public class DataForm {

	private List<String> vars_;
	@SuppressWarnings("unused")
	private List<String> newVars_;
	private HandleLatexFiles handle_;
	private List<String> metadata_;
	
	/**
	 * Constructor
	 * 
	 * 
	 */
	public DataForm(String absolutePath) {
		 handle_ = new HandleLatexFiles(absolutePath);
		 vars_ = handle_.getLatexVariables();
		 metadata_ = handle_.getLatexMetadata();
	}

	/**
	 * Variables to set up in LatexFile
	 * @return List with variables
	 */
	public List<String> getVars() {
		return vars_;
	}
	
	/**
	 * Metadata to set up in LatexFile
	 * @return list with metadata variables
	 * 
	 */
	public List<String> getMetadata() {
		return metadata_;
	}
	
	public HandleLatexFiles getHandle() {
		return handle_;
	}
	
	public void setNewVars(List<String> newVars) {
		newVars_ = newVars;
	}
	
	public void setMetadata(List<String> newMetadata) {
		metadata_ = newMetadata;
	}

}
