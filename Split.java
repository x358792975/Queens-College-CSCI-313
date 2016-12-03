import java.util.Iterator;
/**
 * Split class
 * @author SeanCui
 *
 */
public class Split {
	DoublyLinkedList<Vertex> vertexList = new DoublyLinkedList<Vertex>();
	DoublyLinkedList<String> adjList = new DoublyLinkedList<String>();

	
	private int numOfVertex = 0;
	private int numOfAdj =0;
	private int count =0;
	
	/**
	 * the first line in the txt file
	 * split the first by spaces and store it to the vertexList
	 * increase the number of vertex(numOfVertex)
	 * @param str
	 */
	public void storeVertex(String str){
		String[] firstLine = str.split("\\s+");
		for(int i=0; i<firstLine.length;i++){
			Vertex v = new Vertex(firstLine[i]);
			numOfVertex++;
			vertexList.add(v);
			}
	}
	
	/**
	 * 
	 * @param s
	 */
	public void token(String s, Graph graph){
		//split the string that was read from file by space
		//and store it to an array called myStringArray
		String[] myStringArray = s.split("\\s+");

		//for loop to go over the array
		for(int i =0; i<myStringArray.length;i++){
			//check if the read element is number
			// if it is save it to the adjList
			// increase the numOfAdj
			if (isNumberic(myStringArray[i])){
				//
				adjList.add(String.valueOf(myStringArray[i]));
				numOfAdj++;}
			//check if the number is 1
			if(checkAdjacency(myStringArray[i]))
				graph.addEdge(count,i);
		}
		count++;
	}
	
	public boolean checkAdjacency(String str){
		
		return (str.equals("1"));
		
	}
	// if the data is a number not a space
	public boolean isNumberic(String s){
		return (s.matches("^[0-9]+$"));
	}
	//getter for numOfVertex
	public int getNum(){
		return numOfVertex;
	}
	//getter for numOfAdj
	public int getAdj(){
		return numOfAdj;
	}
	// getter for count
	public int getCount(){
		return count;
	}
	
	/**
	 * The method for printing out the result.
	 * because the first column of the result are the vertices, and the rest of 
	 * column displays the adjacency. So the result has two parts, one is the vertices and 
	 * the other part is the adjacency vertices. basicly, first row of the file contains all 
	 * the vertices. And from the second row to the end of file, it is showing the adjacency matrix.
	 * Using 'printNeighbors()' method to print the second part of result.
	 */
	public void printAdjList(){
		/*for (int i = 0; i<numOfVertex;i++){
			System.out.println(vertexList.get(i) + ": " + printNeighbors(i) );
		}*/		
		System.out.println("This is the Adjacency List: ");
		int n=0;
		Iterator<Vertex> itrVertex = vertexList.iterator();
		while (itrVertex.hasNext()){
			Object v = itrVertex.next();
			System.out.println(v + " : " + printNeighbors(n));
			n++;
		}
		//System.out.println(" ");
		System.out.println("-----------------------");
	}	
/**
 * the for loop here just for splitting the adjList to the number of vertices parts.
 * For example, there are 3 vertices, so it should have 3 rows(which for adjacency matrix) + 1 row
 * (which is for showing all the vertices. Moreover, each row should contain 3 elements as well(as 
 * same as the number of vertices)
 *   int j =n*(getNum());j< (n+1)*(getNum()) ;j++
 *   is to make every time the loop go through (numOfVertex) times
 *   j % (getNum() is to get the position(column) of the vertex.
 * 
 * @param n
 * @return
 */
	public String printNeighbors(int n){
		String result = "";
		for(int j =n*(getNum());j< (n+1)*(getNum()) ;j++){
				if (adjList.get(j).equals("1")){
					result += " "+ vertexList.get(j % (getNum()));
					}
		}
		return result;
	}
	public void printResult(DoublyLinkedList<Integer> result){
		Iterator<Integer> itr = result.iterator();
		while (itr.hasNext()){
			Integer v = itr.next();
			System.out.print(vertexList.get(v)+ " ");
		}
		System.out.println("");


	}

}