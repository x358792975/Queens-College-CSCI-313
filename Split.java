
/**
 * Split class
 * @author SeanCui
 *
 */
public class Split {
	DoublyLinkedList<Vertex> vertexList = new DoublyLinkedList<Vertex>();
	DoublyLinkedList<String> adjList = new DoublyLinkedList<String>();
	//DoublyLinkedList<String> resultList = new DoublyLinkedList<String>();
	private int numOfVertex = 0;
	private int numOfAdj =0;
	/**
	 * 
	 * @param s
	 */
	public void token(String s){
		//split the string that was read from file by space
		//and store it to an array called myStringArray
		String[] myStringArray = s.split(" ");
		
		//for loop to go over the array
		for(int i =0; i<myStringArray.length;i++){
			//if the element of array is a letter
			//add it to vertexList
			if(isAlphabet(myStringArray[i])) {
				Vertex vertex = new Vertex(myStringArray[i]);
				vertexList.add(vertex);
				numOfVertex++; 
			}
			else if (isNumberic(myStringArray[i])){
				//otherwise add it to adjList
				adjList.add(String.valueOf(myStringArray[i]));
				numOfAdj++;
			}
		}
	}
	// if it is a letter from A to Z, return true
	/**
	 * To check if the String s matches that pattern that from A - Z
	 * 
	 * @param s
	 * @return
	 */
	public boolean isAlphabet(String s){
		return(s.matches("^[A-Z]+$"));
	}
	/**
	 * TO check is the String is numbers from 0-9;
	 * @param s
	 * @return
	 */
	public boolean isNumberic(String s){
		return (s.matches("^[0-9]+$"));
	}
	public int getNum(){
		return numOfVertex;
	}
	public int getAdj(){
		return numOfAdj;
	}
	
	/**
	 * The method for printing out the result.
	 * because the first column of the result are the vertices, and the rest of 
	 * column displays the adjacency. So the result has two parts, one is the vertices and 
	 * the other part is the adjacency vertices. basicly, first row of the file contains all 
	 * the vertices. And from the second row to the end of file, it is showing the adjacency matrix.
	 * Using 'printNeighbors()' method to print the second part of result.
	 */
	public void printVertex(){
		for (int i = 0; i<numOfVertex;i++){
			System.out.println(vertexList.get(i) + ": " + printNeighbors(i) );
		}		
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
}