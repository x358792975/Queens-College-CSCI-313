/**
 * Vertex class
 * @author SeanCui
 *
 */
public class Vertex {
	
	private String name;
	//constructor
	public Vertex(String name){
		this.name = name;
	}
	//getter
	public String getName(){
		return name;
	}
	//setter
	public void setName(String name){
		this.name = name;
	}
	//toString method
	public String toString(){
		return name + " ";
		
	}
	
}
