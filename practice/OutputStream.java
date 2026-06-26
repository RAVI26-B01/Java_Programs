package practice;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class OutputStream  {

	public static void main(String[] args) throws IOException {
		
		demo d = new demo("ravi", 28, 68.6, 52);
		
		String path = "E://abc.txt";
		
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oo = new ObjectOutputStream(bos);
		
		oo.writeObject(d);
		oo.flush();
		
	}
}
