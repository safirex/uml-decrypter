package projectController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fileReaders.FileReader;
import fileReaders.FileReaderConstructor;
import fileReaders.JavaFileReader;

public class ProjectReader {
	
	File projectDir;
	public ProjectReader(File file) {
		projectDir=file;
	}
	public ProjectReader(String directorypath) {
		projectDir=new File(directorypath);
	}

	
	
	public void analyze() {
		System.out.println("analysing");
		List<File> projectFiles=listFilesForFolder(projectDir);				//ok
		FileReaderConstructor constructor=new FileReaderConstructor();
		List<FileReader> frList=constructor.getFileReaders(projectFiles);
		System.out.println(frList);
		for(FileReader reader:frList) {
			reader.getParents();
			System.out.println( reader.getName()+
					"\n\t extends \t"+reader.getExtends()+
					"\n\t implements \t"+reader.getImplements());
		}
	}
	
	
	private List<File> listFilesForFolder(final File folder) {
	
		List<File> fileList=new ArrayList<File>();
		
	    for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	fileList.addAll(listFilesForFolder(fileEntry));
	        } else {
	            System.out.println(fileEntry.getName());
	            File f=fileEntry;
	            fileList.add(fileEntry);
	        }
	    } 
	    return fileList;
	}

	
	
	
	
	
	public static void main(String[] args) {
		ProjectReader pr=new ProjectReader(
				"C:\\Users\\Xxsafirex\\eclipse-workspace\\archive\\src");
		
		//"C:\\Users\\Xxsafirex\\eclipse-workspace\\UML_decripter\\src");
		pr.analyze();
		
	}
}
