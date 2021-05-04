package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class IOEample {

	public static void main(String[] args) throws IOException{
		byte[] src = {1,2,3,4};
		byte[] dest=null;
		InputStream is = new ByteArrayInputStream(src);
		OutputStream os = new ByteArrayOutputStream();
		
		int data = -1;
		while((is.read()) != -1) {
			os.write(data);
		}
		
		dest= ((ByteArrayOutputStream)os).toByteArray();//다운캐스팅

		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
	}
}
