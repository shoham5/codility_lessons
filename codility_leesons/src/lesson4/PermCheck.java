package lesson4;

public class PermCheck {

	/*
	 * Check whether array A is a permutation.
	 * A permutation is a sequence containing each element from 1 to N once, and only once.
	 * INPUT : array of integers
	 * OUTPUT : 1 - if the array is permutation , else return 0 . 
	 * 
	 */
	public static int solution(int[] A) {
		int size= A.length; 
		int real_xor = 0; 
		int excpect_xor = 0;

		for(int i=0; i<size; i++){
			real_xor^=i+1;
			excpect_xor^=A[i];
		}
		return real_xor==excpect_xor? 1:0;


	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,1,3,2};
		int arr1[] = {4,1,3};
		int arr2[] = {1};
		System.out.println(solution(arr));
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
	}

}
