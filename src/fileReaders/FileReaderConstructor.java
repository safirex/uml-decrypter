package fileReaders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReaderConstructor {
	List<FileReader> readerList=new ArrayList<FileReader>();
	public FileReaderConstructor() {
		// TODO Auto-generated constructor stub
	}
	public void setReader(File f) {
		String filename=f.getName();
		String extension=filename.substring(filename.lastIndexOf(".")+1);
		System.out.println("extension fichier = "+extension);
		FileReader fr=null;
		if(extension.equals("java")) {
			fr=new JavaFileReader(f);
			readerList.add(fr);
		}
	}
	
	public List<FileReader> getFileReaders(List<File> list) {
		for(File file:list) 
			setReader(file);
		return readerList;
	}
	public List<FileReader> getListFileReader(){
		return readerList;
	}
}
