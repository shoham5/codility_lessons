package lesson5;



import java.util.Stack;

/*
 * Count the number of passing cars on the road
 * Array A contains only 0s and/or 1s
 * time complexity : O(n)
 */

public class PassingCars {

	public static int solution(int[] A) {
	long counter_pairs=0; 
		Stack<Integer> indexes_0 = new Stack<>() ; 
		for (int i = 0; i < A.length; i++) {
			if (A[i]==0) { 
				indexes_0.push(i);
			}
		}
		int last_index = A.length;

		while (!indexes_0.isEmpty()){
			int stack_size = indexes_0.size();
			int conter_1 =(last_index-1)-indexes_0.peek();
			long mul=conter_1*stack_size ;
			last_index = indexes_0.pop(); 
			counter_pairs +=mul;
			if(counter_pairs>1000000000) return -1;
		}
		if(counter_pairs<0) return -1;
		return (int) counter_pairs;
	}

	public static void main(String[] args) {
		int arr[] = {0,1,0,1,1,0,1,1,1};
		int arr1[] = {0,1,0,1,1};
		int arr2[] = {0,0};
		System.out.println(solution(arr));
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
		double seed =Math.random();
		 int arr3[]=new int[100000]; 
		 for (int i = 0; i < arr3.length; i++) {
			 seed = Math.random();
			 if (seed>0.5) arr3[i]=1;
			 else{
			 arr3[i]=0;
			 }
			
		}
			System.out.println(solution(arr3));

	}

}
