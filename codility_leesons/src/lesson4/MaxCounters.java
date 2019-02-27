package lesson4;

import java.util.Arrays;

public class MaxCounters {

	/*
	 * Calculate the values of counters after applying all alternating operations: increase counter by 1;
	 * set value of all counters to current maximum.
	 * time complexity- O(N+M)
	 */
	
	public static int[] solution(int N, int[] A) {
		int ans_arr[] = new int [N];
		int size = A.length;
		int max=0; 
		int last_max=0;
		for ( int i=0 ; i<size ; i++) { 
			if (A[i]==N+1){
				last_max=max; 	
			}
			else {
				if (ans_arr[A[i]-1]<last_max) {
					ans_arr[A[i]-1]= (last_max+1);
				}
				else{ 
				ans_arr[A[i]-1]++;
				}
				
				if (ans_arr[A[i]-1]>max) { 
					max = ans_arr[A[i]-1] ; 
				}
			}
		}

for (int j=0 ; j<ans_arr.length;j++){
	if (ans_arr[j]<last_max) {
		ans_arr[j]=last_max;
	}
}
		return ans_arr;


	}
	
	/*
	 * Calculate the values of counters after applying all alternating operations: increase counter by 1;
	 * set value of all counters to current maximum.
	 * time complexity -O(n^2)
	 */
	
	public static int[] solution_2(int N, int[] A) {
		int ans_arr[] = new int [N];
		int size = A.length;
		int max=0; 
		for ( int i=0 ; i<size ; i++) { 
			if (A[i]==N+1){
				for ( int j=0 ; j<ans_arr.length ; j++) {
					ans_arr[j] = max; 
				}
			}
			else {
				ans_arr[A[i]-1]++;
				if (ans_arr[A[i]-1]>=max) { 
					max = ans_arr[A[i]-1] ; 
				}
			}
		}
	return ans_arr;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {3,4,4,6,1,4,4} ; 
		int arr1 [] = {3,4,4,6,1,4,6,6,4,4,6,3,4} ; 
		int arr2 [] = {3,4,4,6,1,4,4,3,4,4,6,1,4,4,6,4,6,6,1,4,4} ; 
		System.out.println(Arrays.toString(solution_2(5, arr)));
		System.out.println(Arrays.toString(solution_2(5, arr1)));
		System.out.println(Arrays.toString(solution(5, arr1)));
		System.out.println(Arrays.toString(solution(5, arr2)));
		

	}
}


