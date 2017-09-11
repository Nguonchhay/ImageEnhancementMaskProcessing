package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTable;

public class FileProcess {
	public static void writeData(String filename,String data){
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(new File(filename)));
			out.write(data);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	
	}
	public static String readData(String filename){
		String str="";
		try {
			FileInputStream fstream=new FileInputStream(filename);
			DataInputStream in=new DataInputStream(fstream);
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			String strLine;
			while((strLine=br.readLine())!=null){
				str+=strLine;
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public static String getCurrentPath(){
		return new File("").getAbsolutePath();
	}
}


