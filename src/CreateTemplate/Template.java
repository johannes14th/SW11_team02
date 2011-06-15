package CreateTemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Template {

	private File file;
	private String extension;
	private List<String> content_;

	public Template(String string) {
		file = new File(string);
		content_ = new ArrayList<String>();

		String[] splitFilename = string.split("\\.");
		extension = splitFilename[splitFilename.length-1];

	}

	public Template(String path, String filename) {
		if(!filename.contains(".xml")) {
			filename += ".xml";
		}

		file = new File(path + File.separator + filename);

		//String[] splitFilename = string.split("\\.");
		extension = "xml";//splitFilename[splitFilename.length-1];

	}

	public String getFilename() {
		return file.getName();
	}

	public File getFile() {
		return file;
	}

	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	public String getExtension() {
		return extension;
	}

	public boolean isValid() {
		Document doc;
		DocumentBuilder db;
		try
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			doc = db.parse(file);
			NodeList nodes = doc.getElementsByTagName("template");

			if(nodes.getLength() > 0) {
				nodes = nodes.item(0).getChildNodes();
				if(nodes.getLength() == 2) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

	public void createEmptyTemplate() {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setContent(String content) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setContent(List<String> content) {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(file));
			for(int index = 0; index < content.size(); index++) {
				writer.write(content.get(index));
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getContent()  {
	    BufferedReader reader = null;
	    String line;
	    StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
		    while ((line = reader.readLine()) != null)
		    {
		      sb.append(line);
		      sb.append("\n");
		    }
		    reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	    return sb.toString();
	}

	public boolean isAllowedExtension(String string) {

		if(string.equalsIgnoreCase("xml")) {
			return true;
		}

		return false;
	}

	public void addContent(String content,HashMap<Integer, HashMap<String, String>> styleMap) {
		boolean center = false;
		boolean right = false;
		boolean left = false;
		boolean underline = false;
		boolean color = false;
		boolean bold = false;
		boolean italic = false;

		for(int index = 0; index < styleMap.size(); index++) {

			if(styleMap.get(index).containsKey("font")) {
				content_.add("\\fontfamily{pcr}\\selectfont");
			} else if(styleMap.get(index).containsKey("b")) {
				bold = true;
				content_.add("\\textbf{");
			} else if(styleMap.get(index).containsKey("i")) {
				italic = true;
				content_.add("\\textit{");
			} else if(styleMap.get(index).containsKey("u")) {
				underline = true;
				content_.add("\\underline{");
			} else if(styleMap.get(index).containsKey("color")) {
				color = true;
				content_.add("\\color{" + styleMap.get(index).get("color") + "}");
			} else if(styleMap.get(index).containsKey("jc")) {
				if(styleMap.get(index).get("jc").equals("center")) {
					center = true;
					content_.add("\\begin{center}");
				} else if(styleMap.get(index).get("jc").equals("left")) {
					left = true;
					content_.add("\\begin{flushright}");
				} else if(styleMap.get(index).get("jc").equals("right")) {
					right = true;
					content_.add("\\begin{flushleft}");
				}
			}
		}

		if(!color) {
			content_.add("\\color{black}");
		}

		content_.add(content);

		if(underline) {
			content_.add("}");
		}

		if(bold) {
			content_.add("}");
		}

		if(italic) {
			content_.add("}");
		}


		if(center) {
			content_.add("\\end{center}");
		}


		if(left) {
			content_.add("\\end{flushright}");
		}

		if(right) {
			content_.add("\\end{flushleft}");
		}

		content_.add("\n \n");


	}

	public void createTexTemplate(String file) {
		this.file= new File(file);

		List<String> document = new ArrayList<String>();
		document.add("\\documentclass[12pt,a4paper]{article}"
		+ "\\usepackage[latin2]{inputenc}\n"
		+ "\\usepackage{graphicx}\n"
		+ "\\usepackage{ulem}\n"
		+ "\\usepackage{amsmath}\n"
		+ "\\usepackage{color}\n"
		+ "\\usepackage{times}\n"
		+ "\\usepackage{helvet}\n"
		+ "\\usepackage{courier}\n"
		+ "\\begin{document}");

		document.addAll(content_);

		document.add("\\end{document}");
		setContent(document);

	}



}
