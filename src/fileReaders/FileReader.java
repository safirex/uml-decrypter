package fileReaders;

import java.util.List;

public interface FileReader {
	void getParents();
	String getName();
	String getExtends();
	List<String>  getImplements();
}
