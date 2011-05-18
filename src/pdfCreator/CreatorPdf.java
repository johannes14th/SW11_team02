package pdfCreator;
import java.io.File;
import java.io.IOException;

import chooseTemplate.ChooseTemplate;
import de.nixosoft.jlr.JLRGenerator;

public class CreatorPdf {
String file_name_pdf = "test.pdf";
String file_name_tex = "test.tex";
File filePDF;
File fileTex;
String path = "C:/pdfs/";

	public CreatorPdf(String path) {
		filePDF = new File(path + File.separator + "pdfs");
		fileTex = new File(path);
	}

	public CreatorPdf() {
		
	}
	
	public void setPath(){
		filePDF = new File("C:" + File.separator + "pdfs"); //TODO Path on server
	}
	
	public File createPdf(String filename){
		//setPath();
		File template = new File(fileTex + File.separator + filename);
		System.out.println("FILENAME: " + fileTex + File.separator + filename);
		//File template = new File(filename);
		
		JLRGenerator pdfGen = new JLRGenerator();
		pdfGen.deleteTempTexFile(false);
		
		try {
			pdfGen.generate(template.getAbsoluteFile(), filePDF, fileTex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Fertig");
		
		return pdfGen.getPDF();


	}

	public String getPdfName() {		
		return file_name_pdf;
	}
	public String getTexName() {
		// TODO Auto-generated method stub
		return file_name_tex;
	}


	public String getFileName() {
		return path;
	}

	public String getPathString() {
		String return_file = filePDF.getAbsolutePath(); 
		return return_file;
	}



}
