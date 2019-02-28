package lesson5;

public class CountDiv {

	/*
	 * Compute number of integers divisible by k in range [a..b]
	 * Detected time complexity:O(1)
	 * INPUT : range [A...B] , K divisible
	 * OUTPUT : number of integer divisible by K 
	 */
	public static int solution_2(int A, int B, int K){

		int ans=0;
		if (A==B && A%K==0){return 1; }	
		else if (A==B && A%K!=0){return 0;}
	
		else { 
			if(A%K==0) ans++;
			int all = B/K;
			int less_A_first=A/K;
			ans =ans+(all-less_A_first);
		}

		return ans; 
	}
	
	/*
	 * time complexity:O((B-A)/K)
	 */

	public static int solution(int A, int B, int K){

		int ans=0;
		if (A==B && A%K==0){return 1; }	
		else if (A==B && A%K!=0){return 0;}
		else {
			if(A%K==0) ans++;
		int reminder = A%K;
		int add_to_first=K-reminder;
		int first_num = A+add_to_first;
		for (long i=first_num ;i<=B; i=i+K) {
			ans++;
		}
	}

	return ans; 
}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(solution(11, 345, 17));
	System.out.println(solution(0, 14, 2));
	System.out.println(solution(0, Integer.MAX_VALUE, Integer.MAX_VALUE));

	System.out.println(solution_2(11, 345, 17));
	System.out.println(solution_2(0, 14, 2));
	System.out.println(solution_2(0, Integer.MAX_VALUE, Integer.MAX_VALUE));

}

}
