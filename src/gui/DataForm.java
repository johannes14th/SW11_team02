package gui;

import java.util.List;

import handleLatex.HandleLatexFiles;

public class DataForm {

	private List<String> vars_;
	private List<String> newVars_;
	private HandleLatexFiles handle_;
	
	public DataForm(String absolutePath) {
		 handle_ = new HandleLatexFiles(absolutePath);
		 vars_ = handle_.getLatexVariables();
	}

	public List<String> getVars() {
		return vars_;
	}
	
	public HandleLatexFiles getHandle() {
		return handle_;
	}
	
	public void setNewVars(List<String> newVars) {
		newVars_ = newVars;
	}

}
