package lesson4;

public class FrogRiverOne {


	/*
	 * Find the earliest time when a frog can jump to the other side of a river.
	 * you are given an array A consisting of N integers representing the falling leaves.
	 * A[K] represents the position where one leaf falls at time K, measured in seconds
	 * INPUT : X frog position ,A array of falling leafs.  
	 * OUTPUT: minimum time to cross the river represent by seconds.
	 * time complexity - O(n^2)
	 */
	public static int solution_2(int X, int[] A) {
		int size = A.length;
		boolean count_arr[] = new boolean [X]; 
		if (X>size) return -1; 
		int count = 0 ; 
		for ( int i=0; i<size ; i++) { 

			if(A[i]>X) {continue;	
			}
			else{
				if (count_arr[A[i]-1]) 
				{
					continue;
				}
				else {
					count_arr[A[i]-1]=true;
					count ++ ;
					if (count>=X){
						for (int j=0 ; j<X ;j++){
							if (!count_arr[j]) {break;}
							else if(j==X-1) return i;
						}
					}

				}
			}
		}
		return -1; 
	}


	/*
	 * 
	 * Find the earliest time when a frog can jump to the other side of a river.
	 * you are given an array A consisting of N integers representing the falling leaves.
	 * A[K] represents the position where one leaf falls at time K, measured in seconds
	 * INPUT : X frog position ,A array of falling leafs.  
	 * OUTPUT: minimum time to cross the river represent by seconds.
	 * better solution - handling large arrays
	 * time complexity- O(n)
	 */
	
	public static int solution(int X, int[] A) {
		int size = A.length;
		boolean count_arr[] = new boolean [X]; 
		if (X>size) return -1; 
		int count = 0 ; 
		for ( int i=0; i<size ; i++) { 

			if(A[i]>X) {continue;	
			}
			else{
				if (count_arr[A[i]-1]) 
				{
					continue;
				}
				else {
					count_arr[A[i]-1]=true;
					count ++ ;
					if (count==X){return i;}
				}

			}
		}
		return -1; 
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,1,4,2,3,5,4};
		int arr1[] = {1};
		System.out.println(solution(5, arr));
		System.out.println(solution(1, arr1));

		System.out.println(solution_2(5, arr));
		System.out.println(solution_2(1, arr1));
	}

}
