package action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
	
	public static boolean writeToFile(String path,String text){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(path)); 
			out.write(text);
			out.close();
		}
		catch(Exception error){return false;}
		return true;
	}
	
}
