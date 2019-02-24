package lesson2;

import java.util.Arrays;

public class CyclicRotation {

	
	/*
	 * changing the array by K rotation
	 * INPUT :  A array of integer , K number of rotation 
	 * OUTPUT : A array after the change.   
	 */
	public static int[] solution(int[] A, int K) {
		int size = A.length;
		if (size==0) return A;
		int f_index=size-1;
		int num_of_iter=K%size ;
		for(int l = 1 ;l<=num_of_iter ; l++){
			int temp_val = A[f_index];
		for ( int i=0 ; i<size-1 ; i++) {
			A[(f_index-i)]=A[(f_index-i-1)];
		}
			A[0]=temp_val;
		}
		return A; 
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[] = {3,8,9,7,6};
int arr1[] = {3,8,9,7};
int arr2[] = {3,8};
int arr3[] = {3};
int arr4[] = {};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(solution(arr,5)));
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(solution(arr1,100)));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(solution(arr2,2)));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(solution(arr3,10)));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(solution(arr4,10)));
		
		
		
		
	}
}
