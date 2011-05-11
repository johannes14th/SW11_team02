package viewPdf;

import java.io.File;


public class ViewPdf {
	File filename;
	
	public void setFileName(File file){
		filename = file;
	}
	
	public File getFileName() {
		//filename = new File("C:" + File.separator + "pdfs" + File.separator + "test.pdf");//pfad?
		return filename;
	}
	
	public String getFileNameString(){
		return filename.toString();
	}
	   
	
	
	

}
