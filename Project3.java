import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**Project1: Topological Sort Project
 * CSCI 313
 * @author Xiang Cui
 *
 */
public class Project3 {

	// create a static DoublyLinkedList result to store the position of the result
	// and using for vertexList
	static DoublyLinkedList<Integer> result = new DoublyLinkedList<Integer>();
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
			BufferedReader reader = new BufferedReader(new FileReader("project3.txt"));
			String info =""; //for the adjacency matrix
			String vetx =""; // for the vertices
			
			//read the first line
			vetx = reader.readLine();
			// first line of the file stored all the vertices
			sp.storeVertex(vetx);	
			
			// creat a new class called Graph for topological sort
			Graph graph = new Graph(sp.getNum());
			// Copy the linkedList from graph class
			result = graph.getIndex();
			//while loop, when it reads to the end of file
			// store the read data into variable info			
			while ((info = reader.readLine())!= null) { 
				// Call token method in Split class
				// passing the data read from the file and object graph to the method
				sp.token(info, graph);
				}

			sp.printAdjList();	 // print the adjcency list	
			graph.print();	 // print the message and start doing sorting
			sp.printResult(result);  // print the final result

			reader.close();
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
	}	
}
