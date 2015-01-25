import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
/*
 * Largest integer from concatenated integers
 * pzou @ 1/24/2015
 * 
 */
public class DayTwo {

	public static String largestNumber(int[] number){
		List<String> list = new ArrayList<String>(number.length);
		for(int i: number){
			list.add(String.valueOf(i));
		}
		Collections.sort(list, sortData);
		StringBuilder sb = new StringBuilder();
		for (int i = number.length-1; i >=0; i--){
			sb.append(list.get(i));
		}
		return sb.toString();
	}
	
	public static Comparator<String> sortData = new Comparator<String>(){
		@Override
		public int compare(String s1 , String s2){
			int len1 = s1.length();
			int len2 = s2.length();
			if ( len1 == len2){
				return s1.compareTo(s2);
			}
			int maxLen = Math.max(len1, len2);
			while (s1.length() <2*maxLen){
				s1 += s1;
			}
			while (s2.length()<2*maxLen){
				s2 +=s2;
			}
			return s1.compareTo(s2);

		}
	}	;

	
	public static void main(String[] args){
		int[] noList = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(noList));
	}

}
