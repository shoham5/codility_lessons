package lesson5;


public class MinAvgTwoSlice {

	/*
	 * Find the minimal average of any slice containing at least two elements
	 *The goal is to find the starting position of a slice whose average is minimal
	 * time complexity: O(N)
	 * INPUT : array of numbers
	 * OUTPUT : starting index of the minimal slice  
	 */
	public static int solution(int[] A){
		int N = A.length ; 
		double prefix_avg[] = new double [N-1];
		double min=Integer.MAX_VALUE;
		int index=-1;
		int counter;
		for (int i = 0; i <N-1; i++) {
			prefix_avg[i] = (A[i]+A[i+1])/2.;
			if(prefix_avg[i]<min) {
				min = prefix_avg[i];
				index=i;
			}
		}
		double prefix_sum;
		double temp_avg_prefix;
		for (int i = 0; i <N-2; i++) {
			counter=3;
			prefix_sum =prefix_avg[i]*2; 
			temp_avg_prefix = (prefix_sum+A[i+2])/counter;
			if (temp_avg_prefix<prefix_avg[i]){
				if (temp_avg_prefix<min){
					min = temp_avg_prefix;
					index=i;
				}
			}	
		}
			return index ; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {4,2,2,5,1,5,8}; // 1  (2) 
		System.out.println("index: "+solution(arr1));
		int arr2[] = {-600,-300,-700,-535}; // 2 (-617.5 )
		System.out.println("index: "+solution(arr2));
		int arr3[] = {-600,-300,-700}; // 0  (-533.33)
		System.out.println("index: "+solution(arr3));
		int arr4[] = {4,2,-100,10}; //1
		System.out.println("index: "+solution(arr4));
	}

}
