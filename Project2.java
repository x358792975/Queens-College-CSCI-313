import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class: CSCI 313
 * Project2: Well Balanced Project
 * @author Xiang Cui
 *
 */
public class Project2 {
	public static void main(String[] args) throws IOException{
		//create a new Object ReadData, named read    
		ReadData read = new ReadData();
		try {
			//create new file input stream
			FileInputStream fstream = new FileInputStream("project2.txt");
			int n=0;
			char c = 0;
			//read until the end of fill
			while((n = fstream.read())!= -1){
				//convert integer to character
				c= (char)n;
				//passing c as a parameter to the method in ReadData class
				read.convert(c);
				//System.out.println(c);
			}
			//close the stream
			fstream.close();
		} catch (FileNotFoundException e) {
			// if any errors occur
			e.printStackTrace();
		}
		System.out.println("");		
		read.compute();
	}
}
