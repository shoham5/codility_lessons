package lesson3;



public class TapeEquilibrium {


	/*
	 * 
	 */
	public static int solution(int[] A) {
		int size = A.length;
		long sum_a=A[0];
		long sum_b=sum(A);
		int min_dif = (int)Math.abs(sum_a-sum_b);
		int curr_dif;
		for ( int i=1 ; i<size-1 ; i++){
			sum_a+= A[i];
			sum_b-= A[i];
			curr_dif = (int)Math.abs(sum_a-sum_b);
			if (curr_dif<min_dif)
			{ min_dif=curr_dif;}
		}
		return min_dif;
	}

	public static int sum(int arr[]) { 
		int sum=0;
		for ( int i=1 ; i<arr.length ; i++) { 
			sum+=arr[i];
		}
		return sum;
	}
	/*
	 * 76% 
	 * couldn't handling with 1/-1's
	 */
	public static int solution_1(int[] A) {
		int size = A.length;
		long sum_a=A[0];
		long sum_b=A[size-1];
		long left_side;
		long right_side;
		int min_dif;
		int i=1 , j=size-2;
		while (j>i){
			left_side = (Math.abs(((sum_a+A[i]))-sum_b)); 
			right_side=(Math.abs(((sum_b+A[j]))-sum_a));
			if (left_side==right_side)
			{ 
				sum_a+=A[i];
				sum_b+=A[j];
				i++; 
				j--;
			}
			else if(left_side>right_side){
				sum_b+=A[j];
				j--;

			}
			else{
				sum_a+=A[i];
				i++;
			}

		}
		if(i==j&&Math.abs(((sum_a+A[i])-sum_b))<(Math.abs(sum_a-(sum_b+A[i])))){
			sum_a+=A[i];
		}
		else if(i==j&&Math.abs(((sum_a+A[i])-sum_b))>=(Math.abs(sum_a-(sum_b+A[i])))){
			sum_b+=A[i];
		}

		min_dif = (int)Math.abs(sum_a-sum_b);	
		return min_dif;
	}		

	public static void main(String[] args) {
		int arr[] = {2,1,2,4,-3}; // 0
		int arr0[] = {-3,1,2,4,3}; // 1
		int arr1[] = {3,1,2,4,3};// 1
		int arr2[] = {3,1,2,3};  // 1
		int arr3[] = {2,1,0,4,-3}; // 0
		int arr4[] = {3,3};  // 0
		int arr5[] = {3,1};  // 2
		int arr6[] = {-3,1};  // 4
		int arr7[] = {1,1,3};  // 1
		int arr8[] = {-1,-1,-3,-3,-4,-6};  // 2
		int arr9[] = {-1,-1,3,-3,-4,-6};  // 0
		int arr10[]={-10, -20, -30, -40, 100};//20 
		int arr11[]={-1, -1, -1, 1, 1,1,1,1,1,1,1,1,-1,-1,-1,-1,1,1};//0 
		int arr12[]={-1, -1, 1,1};



		System.out.println(solution(arr));
		System.out.println(solution(arr0));
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));
		System.out.println(solution(arr4));
		System.out.println(solution(arr5));
		System.out.println(solution(arr6));
		System.out.println(solution(arr7));
		System.out.println(solution(arr8));
		System.out.println(solution(arr9));
		System.out.println(solution(arr10));
		System.out.println(solution(arr11));
		System.out.println(solution(arr12));


	}

}
