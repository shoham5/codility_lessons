package lesson4;

public class MissingInteger {

	/*
	 * Find the smallest positive integer that does not occur in a given sequence
	 * time complexity- O(N)
	 */
	public static int solution(int[] A) {
        int arr_size=1000001;
		int size = A.length;
        //if(size==0) return 1;
        int count_arr[] = new int [arr_size]; 
        
        for ( int i = 0 ; i<size ; i++ ) { 
        	if (A[i]<1) continue ; 
        	count_arr[A[i]]++;
        }
        for (int j=1 ;j<count_arr.length ; j++){
        	if(count_arr[j]==0) return j;
        }
        
        return 1;
    }
 
	
	
	public static void main(String[] args) {
		 
int arr[]={1, 2, 3};
int arr1[]={-1, -3, -2};


System.out.println(solution(arr));
System.out.println(solution(arr1));

	}

}
