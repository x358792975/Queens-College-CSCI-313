import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**Project1: Vertex Convension
 * CSCI 313
 * @author Xiang Cui
 *
 */
public class Project1 {
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException{

		//creat a new class called Split which does processing and computing
		//for the project.
			Split sp = new Split();		
		try {
			// read the file
			BufferedReader reader = new BufferedReader(new FileReader("project1.txt"));
			String info =""; 
			//whole loop, when it reads to the end of file
			// store the read data into variable info
			while ((info = reader.readLine())!= null) { 
				/**
				 * call token method in split class,
				 * param(info)
				 */
					sp.token(info);}
			//exception for can't find the file.
		}catch (FileNotFoundException e){
			e.printStackTrace();
			System.out.print("File can't be found! ");
		}
		// failure of reading the file.
		catch (IOException e) {
			e.printStackTrace();
			System.out.print("Faild to read the file!");
		}	
		/**
		 * call the prinVertex method which is in class Split to 
		 * display the result(adjacency list)
		 */
		sp.printVertex();
	}
}
