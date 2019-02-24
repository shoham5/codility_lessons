package lesson2;

import java.util.HashMap;
import java.util.Iterator;

public class OddOccurrencesInArray {

	
	/*
	 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value,
	 * except for one element that is left unpaired.
	 */
	
	public static int solution(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>(); 
		for (int i = 0 ; i<A.length ; i++ ){ 
			if (map.containsKey(A[i]))
				{
				map.remove(A[i]);
				}
			else{
		map.put(A[i], 1);
			}
			}
		 Iterator<Integer> it = map.keySet().iterator();
		 int ans = it.next();   
		return ans ;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr [] = {9,3,9,3,7,7,100000};
		System.out.println(solution(arr));
	}

}
