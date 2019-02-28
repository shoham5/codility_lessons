package lesson5;

import java.util.Arrays;
import java.util.HashMap;

public class GenomicRangeQuery {

	/*
	 * Find the minimal nucleotide from a range of sequence DNA
	 *  DNA string represent by ACGT nucleotide
	 *  INPUT : DNA string ,
	 *  		query represent by :array of start position ,
	 *  							array of end position. 
	 * OUTPUT : array of minimum factor for each query 
	 * time complexity -O(N + M)
	 */
	
	public static int[] solution(String S, int[] P, int[] Q){
		int size = S.length();
		int mat_count_prefix[][] = new int [5][size+1];

		//finding to right position in the mat
		HashMap<Character, Integer> impact_factor = new HashMap<>();
		impact_factor.put('A', 1);
		impact_factor.put('C', 2);
		impact_factor.put('G', 3);
		impact_factor.put('T', 0);		

		//checking  P & Q  size ,  we will chose the smaller array
		int p_length =P.length;
		int q_length =Q.length;
		int length = Math.min(p_length, q_length);

		int ans[] = new int[length];

		//String preprocessing 
		for (int i = 0 ; i<size ; i++){
			int index=impact_factor.get(S.charAt(i));
			mat_count_prefix[index][i+1]=mat_count_prefix[index][i]+1;
			mat_count_prefix[(index+1)%4][i+1]=mat_count_prefix[(index+1)%4][i];
			mat_count_prefix[(index+2)%4][i+1]=mat_count_prefix[(index+2)%4][i];
			mat_count_prefix[(index+3)%4][i+1]=mat_count_prefix[(index+3)%4][i];
		}

		// Query handling
		for (int i = 0; i < length; i++) {
			int start = P[i]; 
			int end = Q[i];
			if (mat_count_prefix[1][end+1]-mat_count_prefix[1][start]>0){
				ans[i]=1;
				continue;
			}
			else if (mat_count_prefix[2][end+1]-mat_count_prefix[2][start]>0) 
			{
				ans[i]=2;
				continue;	
			}
			else if (mat_count_prefix[3][end+1]-mat_count_prefix[3][start]>0) 
			{
				ans[i]=3;
				continue;	
			}
			else { 
				ans[i]=4;
				continue;
			}


		} 
		return ans; 
	}



	/*
	 * 
	 * can't handling with extreme large array
	 * time complexity : O(N^2) 
	 */
	public static int[] solution_2(String S, int[] P, int[] Q){
		HashMap<Character, Integer> impact_factor = new HashMap<>();
		impact_factor.put('A', 1);
		impact_factor.put('C', 2);
		impact_factor.put('G', 3);
		impact_factor.put('T', 4);		
		int p_length =P.length;
		int q_length =Q.length;
		int length = Math.min(p_length, q_length);
		int ans[] = new int[length];

		for (int i = 0 ; i<length ; i++){
			int start = P[i];
			int end = Q[i];	 		
			char min_char = S.charAt(start);
			for ( int j=start+1 ;j<=end ; j++){
				char temp =S.charAt(j);
				if (temp<min_char) min_char=temp;
			}
			ans[i]= impact_factor.get(min_char);
		}
		return ans; 
	}



	public static void main(String[] args) {
		String s= "CAGCCTA";
		int p[]={2,5,0};
		int q[]={4,5,6};
		System.out.println(Arrays.toString(solution_2(s,p,q)));
		System.out.println(Arrays.toString(solution(s,p,q)));

		String s1= "TC";
		int p1[]={0, 0, 1};
		int q1[]={0, 1, 1};
		System.out.println(Arrays.toString(solution_2(s1,p1,q1)));
		System.out.println(Arrays.toString(solution(s1,p1,q1)));
		
		StringBuilder sb = new StringBuilder('C');
		for (int i = 0; i < 100000; i++) {
			sb.insert(0, 'C');
			sb.insert(0, 'C');
			sb.insert(0, 'C');
			sb.insert(0, 'T');
		}
		String s3=sb.toString();
		int p3[]={2,15,1100};
		int q3[]={4,55,23506};
		//System.out.println(s3);
		System.out.println(Arrays.toString(solution_2(s3,p3,q3)));
		System.out.println(Arrays.toString(solution(s3,p3,q3)));
		 
		

	}

}
