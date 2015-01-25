import java.util.Stack;



/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * pzou @ 1/23/2015
 * 
 */
public class DayOne {
	
	private static final String OPERATORS = "+-*/";
	
	public static int calculateResult(String[] strs){
		Stack<String> stack = new Stack<String>();
		for (String str : strs){
			int pos = OPERATORS.indexOf(str);
			if (pos == -1){
				stack.push(str);
				continue;
			}
			int data1 = Integer.valueOf(stack.pop());
			int data2 = Integer.valueOf(stack.pop());
			switch(pos){
			case 0:  stack.push(String.valueOf(data2+data1)); break;
			case 1:  stack.push(String.valueOf(data2-data1)); break;
			case 2:  stack.push(String.valueOf(data2*data1)); break;
			case 3:  stack.push(String.valueOf(data2/data1)); break;
			}
			
		}
		return Integer.valueOf(stack.pop());
	}
	public static void main(String[] args) throws Exception{
		String[] strs1 = {"2", "1", "+", "3", "*"};
		String[] strs2 = {"4", "13", "5", "/", "+"};
		System.out.println(calculateResult(strs2));
		System.out.println(calculateResult(strs1));
	}

}
