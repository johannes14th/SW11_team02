package konDocxToXml;

import handleXML.HandleXML;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.String;
import java.nio.channels.FileChannel;
import java.util.zip.*;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DocxToXml {

	//
	private Vector<ZipEntry> z_files;
	private File zip_;
	
	
	//
	// GETTER / SETTER
	public Vector<ZipEntry> getZFileVector()
	{
		return z_files;
		
	}
		
	
	public DocxToXml()
	{
		z_files = new Vector<ZipEntry>();
		// Create Folders
		String _folder_main_ = "Foo";
		String _folder_rels_ = "Foo/_rels";
		String _folder_docProps_ = "Foo/docProps";
		String _folder_word_ = "Foo/word";
		String _folder_word_rels_ = "Foo/word/_rels";
		String _folder_word_theme_ = "Foo/word/theme";
		
		(new File(_folder_main_)).mkdir();
		(new File(_folder_rels_)).mkdir();
		(new File(_folder_docProps_)).mkdir();
		(new File(_folder_word_)).mkdir();
		(new File(_folder_word_rels_)).mkdir();
		(new File(_folder_word_theme_)).mkdir();

		
		
	}
	
	
	//
    public void clean() throws Throwable
    {
    	z_files.clear();
    	File todelete = new File("TEMP.zip");
    	todelete.delete();
    }
    
	public void convertToZip(String filename)
	{
		try {
			copyFile(filename);
		} catch (IOException e) {

			e.printStackTrace();
		}
		File docx = new File("BACKUP-" + filename);
		
		zip_ = new File("TEMP.zip");
		docx.renameTo(zip_);
	}
	
	
	public void copyFile(String filename) throws IOException
	{
			File destFile = new File("BACKUP-"+filename);
			File orgFile = new File(filename);
			
			FileChannel source = null;
			FileChannel destination = null;
			
			try
			{
				source = new FileInputStream(orgFile).getChannel();
				destination = new FileOutputStream(destFile).getChannel();
				destination.transferFrom(source, 0, source.size());
			}
			finally 
			{
				if (source != null) source.close();
				if (destination != null) destination.close();
			}
		
	}


	public void decompressZip()
	{
		try{
			zip_ = new File("TEMP.zip");
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(zip_);
		
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
			
			int BUFFER = 2048;

			
			
			while((entry = zis.getNextEntry()) != null)
			{
				addZipEntry(entry);
				
				
				int count;
				byte data[] = new byte[BUFFER];
				FileOutputStream fos = new 
				  FileOutputStream("Foo/" + entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) 
			              != -1) {
			               dest.write(data, 0, count);
			            }
			            dest.flush();
			            dest.close();

				}
			
			zis.close();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addZipEntry(ZipEntry zEntry)
	{
		z_files.add(zEntry);
	}
	
	public void removeZipEntry(ZipEntry zEntry)
	{
		z_files.remove(zEntry);
	
	}
	
	public String findValue(String destTag, String Filename)
	{
		File xml = new File(Filename);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		String tag = "";
		try {
			db = dbf.newDocumentBuilder();
			Document doc;
			doc = db.parse(xml);
			NodeList nodelist = doc.getElementsByTagName(destTag);
			if(nodelist.getLength() != 0)
			{
				Node node = nodelist.item(0);
				if(node.hasChildNodes())
					tag = node.getFirstChild().getNodeValue();
			}
			else
				tag = "";
			return tag;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public void searchTags()
	{
			String _author_ = findValue("author","Foo/docProps/core.xml");
	}
	
	
}
			
