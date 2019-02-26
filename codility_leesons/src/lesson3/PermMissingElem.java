package lesson3;

/*
 * An array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * Your goal is to find that missing element.
 */

public class PermMissingElem {

	/*
	 * O(n)  || O(n*log(n))
	 * overflow when Size is big ~100000 
	 */
	public static int solution_2(int[] A) {
		int size = A.length;
		if(size==0) return 1; 
		int first = 1;
		int num_of_elem = size+1; 
		long expected_sum =(num_of_elem*((2*first)+(num_of_elem-1)*1))/2; 
		long real_sum=0;  
		for (int i=0 ; i<size ; i++){
			real_sum+=A[i];
		}
		long dif = expected_sum-real_sum;
		int missing_num=(int)dif;
		return missing_num; 

	}

	/*
	 * O(n)  
	 * using bitwise op 
	 */

	public static int solution_xor(int[] A) {
		int size = A.length;
		if(size==0) return 1; 
		int final_element = size+1;
		int real_xor = 0;
		int expexted_xor = 0; 
		for (int i=0 ; i<size ; i++){
			real_xor^=A[i];
			expexted_xor^=i+1;
		}
		expexted_xor^=final_element;
		int missing_num = expexted_xor^real_xor;
		return missing_num; 

	}
	/*
	 * O(n)  || O(n*log(n))
	 * solving overflow when Size is big ~100000 
	 */
	public static int solution_count(int[] A) {
		int size = A.length;
		if(size==0) return 1;
		int ans=1;
		int temp_arr[] = new int[size+1];

		if(size==0) return 1;
		for(int i=0 ;i<size;i++){
			temp_arr[A[i]-1]=1;
		}
		for(int i=0 ;i<size+1;i++){
			if (temp_arr[i]==0) return i+1;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={5,3,2,4};
		int arr1[]={1,3,2,5};
		int arr2[]={1,3,2,4};
		System.out.println(solution_count(arr));
		System.out.println(solution_count(arr1));
		System.out.println(solution_count(arr2));


		System.out.println(solution_xor(arr));
		System.out.println(solution_xor(arr1));
		System.out.println(solution_xor(arr2));
	}

}
