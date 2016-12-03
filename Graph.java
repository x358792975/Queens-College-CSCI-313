
import java.util.*;
 
/**
 * Graph class
 * @author SeanCui
 *
 */
public class Graph 
{
    private int V;   // number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List
    //a linked list to store the index of the result
    //the result will be the numbers, so store it to a list to find the position in the vertex list in Split class
    DoublyLinkedList<Integer> index = new DoublyLinkedList<Integer>();
    
    
    //Constructor
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }
    /**
     * 
     * @return the size of linked list adj
     */
    public int size(){
    	return adj.length;
    }
 
    // Function to add an edge into the graph
    /**
     * add an edge between two vertices
     * u is adjacent to v
     * @param v 
     * @param w
     */
    public void addEdge(int u,int v) { 
    	adj[u].add(v); 
    }
 
    // A recursive function used by topologicalSort
    /**
     * Recursive method used for topologicalSort
     * @param j
     * @param visited
     * @param stack
     */
    public void topologicalSortUtil(int j, Boolean visited[],Stack<Integer> stack)
    {
        // set the current node be visited.
        visited[j] = true;
        int i;
 
        // Recursive call for all vertices adjacent to this vertex
        // Using iterator to go over the linked list
        Iterator<Integer> itr = adj[j].iterator();
        while (itr.hasNext())
        {
            i = itr.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
 
        // Push the vertex on the top of the stack
        stack.push(new Integer(j));
    }
 

    /**
     * the method for doing topological sort by using recursion
     * call topologicalSortUtil
     */
    public void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
 
        // set all the vertices to be unvisited
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Using recursive to store and sort the vertices on by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        //  while the stack is not empty
        // store the top element to the index linked list
        // and remove the top of the stack
        while (stack.empty()==false){
        	index.add(stack.pop());	
        }       
    }
    /**
     * print the message
     * call the topologicalSort method to do the sorting
     */
    public void print(){
        System.out.println("This is a Topological sort of the graph: ");
        topologicalSort();
    }
    /**
     * 
     * @return the DoublyLinkedList index which stored the sorted result
     * (as the position at vertexList in Split class)
     */
    public DoublyLinkedList<Integer> getIndex(){
    	return index;
    }

}