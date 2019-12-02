package com.hl.io;

import java.io.File;

public class Di {

	public static File getFile(){
		// TODO Auto-generated method stub
		File file=new File("D:/√Ê ‘Ã‚");
		File[] files = file.listFiles();
		for (File file2 : files) {
			System.out.println(file2);
		}
		return file;
	}
	public static void main(String[] args) {
		getFile();
	}

}
