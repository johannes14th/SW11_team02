package pdfCreator;
import java.io.File;
import java.io.IOException;

import de.nixosoft.jlr.JLRGenerator;
import fileHandler.FileHandler;

public class CreatorPdf {
String file_name_pdf = "test.pdf";
String file_name_tex = "test.tex";
File filePDF;
File fileTex;
//String path = "C:/pdfs/";

	public CreatorPdf(String path) {
		filePDF = new File(path + File.separator + "pdfs");
		fileTex = new File(path);
	}

	public CreatorPdf() {

	}

	public void setPath(){
		filePDF = new File(FileHandler.getSystemPath() + File.separator + "pdfs");
	}

	public File createPdf(String filename,String username){
		//setPath();

		filename = filename.toLowerCase();

		if(!filename.contains(".tex")) {
			filename += ".tex";
		}

		File template = new File(FileHandler.getUserPath(username) + File.separator + filename);
		System.out.println("FILENAME: " + fileTex + File.separator + filename);
		//File template = new File(filename);

		JLRGenerator pdfGen = new JLRGenerator();
		pdfGen.deleteTempTexFile(false);

		File pdf;

		System.out.println("USERNAME: " + username + " " + FileHandler.getUserPath(username));

		if(username != "") {
			pdf = new File(FileHandler.getUserPath(username));
		} else {
			pdf = filePDF;
		}


		try {
			pdfGen.generate(template.getAbsoluteFile(), pdf, fileTex);
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


	/*public String getFileName() {
		return path;
	}*/

	public String getPathString() {
		String return_file = filePDF.getAbsolutePath();
		return return_file;
	}

	public String getTexPathString() {
		String return_file = fileTex.getAbsolutePath();
		return return_file;
	}



}
