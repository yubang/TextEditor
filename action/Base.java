package action;

import java.io.BufferedReader;
import java.io.FileReader;

public class Base {
	
	public static String openFilePath = null;
	
	public static String readFromFile(String path){
		StringBuilder builder =new StringBuilder();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while(reader.ready()){
				builder.append(reader.readLine()).append("\n");
			}
			reader.close();
		}
		catch(Exception error){}
		return builder.toString();
	}
	
}
