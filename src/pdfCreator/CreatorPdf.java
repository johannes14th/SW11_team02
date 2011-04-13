package pdfCreator;
import java.io.File;
import java.io.IOException;

import chooseTemplate.ChooseTemplate;
import de.nixosoft.jlr.JLRGenerator;

public class CreatorPdf {
String file_name_pdf = "test.pdf";
String file_name_tex = "test.tex";
File file;
String path = "C:/pdfs/";


	public void setPath(){
		file = new File("C:" + File.separator + "pdfs"); //TODO Path on server
	}
	
	public void createPdf(){
		setPath();
		File template = new File(file + File.separator + file_name_tex);
		
		JLRGenerator pdfGen = new JLRGenerator();
		pdfGen.deleteTempTexFile(false);
		
		try {
			pdfGen.generate(template, file, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File pdf1 = pdfGen.getPDF();


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
		String return_file = file.getAbsolutePath(); 
		return return_file;
	}



}
