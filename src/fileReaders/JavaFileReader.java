package fileReaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFileReader implements FileReader {
	File file;
	String extend="none";
	List<String> implement=new ArrayList<String>();

	public JavaFileReader(File f) {
		file=f;
	}




	@Override
	public void getParents() {
		// TODO Auto-generated method stub
		Scanner sc;
		try {
			sc = new Scanner(file);
			String data=null;
			while (sc.hasNextLine()){
				data = sc.nextLine();


				String extStrings="extends",implStrings="implements";


				if(data.contains(extStrings)) {
					String str=data.substring(data.indexOf(extStrings)+extStrings.length()+1,data.indexOf("{"));
					str=str.replace(" ","");
					if(str.contains(implStrings)) {
						str=str.substring(0, str.indexOf(implStrings));
					}
					extend=str;
				}

				if(data.contains(implStrings)) {
					String str=data.substring(data.indexOf(implStrings)+implStrings.length());//+implStrings.length());

					str=str.strip();
					do {
						str=str.strip();
						String tmp="";
						if(str.indexOf(" ")==-1 && str.indexOf("{")!=-1) {
							tmp=str.substring(0,str.indexOf("{"));
							
						}else if(str.indexOf(" ")==-1 )
							tmp=str;
						else
							tmp=str.substring(0, str.indexOf(" "));
						
						implement.add(tmp);
						str=str.substring(str.indexOf(" ")+1);
					}while(str.contains(" "));
					
				}

				if(data.contains("{"))
					break;

			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("couldn't read the java file");
			e.printStackTrace();
		}

	}


	@Override
	public String getName() {
		return file.getName();
	}


	@Override
	public String getExtends() {
		return extend;
	}
	
	@Override
	public List<String>  getImplements() {
		return implement;
	}
}
