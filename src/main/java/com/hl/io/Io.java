package com.hl.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

public class Io {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file=new File("D:/a.txt");
		file.createNewFile();
		//¸øa.txtÖÐÐ´Èëhelloworld
		Writer w = new FileWriter(file);
		w.write("helloworld");
		w.flush();
		w.close();
		File file1=new File("D:/b.txt");
		InputStream in=new FileInputStream(file);
		OutputStream out=new FileOutputStream(file1);
		int c=0;
		while((c=in.read())!=-1){
			out.write(c);
			out.flush();
		}
		out.close();
		in.close();
	}

}
