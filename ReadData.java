/**
 * most of the processing of the project happened here
 * @author SeanCui
 *
 */
public class ReadData {
	//two counters for left/right parenthesis, curly bracket, or square bracket
	private int  numOfLeft=0;
	private int  numOfRight=0;
	// creat a dynamicarraystack called stack
	DynamicArrayStack<String> stack = new DynamicArrayStack<String>();
	/**
	 * convert the info that was read from the file from type char to string
	 * @param info
	 */
	public void convert(char info){
		String s = String.valueOf(info);
		System.out.print(checkIsSymbol(s));	
	}
	/**
	 * check if a character that was read is a (,{, or [, if it is increase the numOfLeft, and push
	 * it into the stack and return "". else if it is a ), }, or ] and the top of the stack saved the same type of 
	 * symbol, then numOfRight increases and popped out the top element in the stack, and return "".
	 * else if it is only a ), } or ], increase the numOfRight and return "". otherwise, return s itself.
	 * @param s
	 * @return
	 */
	public String checkIsSymbol(String s){
		if(checkLeftParenthesis(s)
				|| checkLeftCurlyBracket(s) 
				|| checkLeftSquareBracket(s)){
			numOfLeft++;
			stack.push(s);
			return "";
		}	
		else 
		if((checkRightParenthesis(s) && stack.top().equals("("))
				|| (checkRightCurlyBracket(s) && stack.top().equals("{"))
				|| (checkRightSquareBracket(s) && stack.top().equals("[")))
				{
				numOfRight++;
				stack.pop();
				return "";
				}
		else
		if(checkRightParenthesis(s)
					|| checkRightCurlyBracket(s) 
					|| checkRightSquareBracket(s)){
				numOfRight++;
				return "";}
		
		return s;
	}
	/**
	 * check if the str equals to ( or not
	 * @param str
	 * @return
	 */
	public boolean checkLeftParenthesis(String str){
		return (str.equals("("));
	}
	/**
	 * check if the str equals to { or not
	 * @param str
	 * @return
	 */
	public boolean checkLeftCurlyBracket(String str){
		return (str.equals("{"));
	}
	/**
	 * check if the str equals to [ or not
	 * @param str
	 * @return
	 */
	public boolean checkLeftSquareBracket(String str){
		return (str.equals("["));
	}
	/**
	 * check if the str equals to ) or not
	 * @param str
	 * @return
	 */
	public boolean checkRightParenthesis(String str){
		return (str.equals(")"));
	}
    /**
     * check if the str equals to } or not
     * @param str
     * @return
     */
	public boolean checkRightCurlyBracket(String str){
		return (str.equals("}"));
	}
	/**
	 * check if the str equals to ] or not
	 * @param str
	 * @return
	 */
	public boolean checkRightSquareBracket(String str){
		return (str.equals("]"));
}
	/**
	 * compare numOfLeft and NumOfRight
	 * if they are equal and the stack is empty, the input is well balanced.
	 * otherwise it is not well balanced.
	 */
	public void compute(){
		if ((numOfLeft == numOfRight) && stack.isEmpty()){
			System.out.println("Congrats! The input has well-balanced parentheses,"
							+ " curly bracket, and square bracket!");
		}
		else
			if(numOfLeft > numOfRight)
			System.out.println("Sorry, the input does not have well_balanced parentheses, "
						+ "curly bracket, and square bracket. It has more '(', '{', or '[' ");
		else
			System.out.println("Sorry, the input does not have well-balanced parentheses, "
					+ "curly bracket, and square bracket. It has more ')', '}', or ']' ");
		
	
	}

}
