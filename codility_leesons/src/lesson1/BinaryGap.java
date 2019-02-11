package lesson1;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
	
public class BinaryGap {	
	/*
	 * maximal 0's sequence surrounding by 1 of both sides. usning bitwise.
	 * the function using bitwise operation.
	 * INPUT : N number  
	 * OUTPUT: the max 0's sequence surrounding by 1    
	 */
	
	
	 public static int solution(int N) {
		 int count=0; 
		 int max_gap=0;
		 
		 while (N>0 && (N & 1)!=1){
			 	N = N>>1; 
			 	
		 }
		 while (N>0 && (N & 1)==1){
			 	if(count>max_gap) max_gap = count; 
			 		count = 0;
			 		N = N>>1;
			 		
			 	while (N>0 && (N & 1)!=1){
			 			count ++;
			 			N = N>>1;
		 }
	}	 
  
	 return max_gap;
	 }	 
	  
	 /*
		 * maximal 0's sequence surrounding by 1 of both sides. using String 
		 * INPUT : N number  
		 * OUTPUT: the max 0's sequence surrounding by 1     
		 */
		
	 public static int solution_2(int N) {
		 String s = Integer.toBinaryString(N);
		 int max = 0 ; 
		 int count = 0 ;
		 int j=0;
		 boolean st_flag= false ; 
		 boolean end_flag=false; 
		 for (int i=0 ; i<s.length() ;i++){
			 while (i<s.length()&&s.charAt(i)=='1') {
				 if (end_flag==true &&st_flag==true){
					 end_flag=false;
				 }
				 else if(st_flag==true) {
					 end_flag =true;
					 if(count>max) {max = count;
					 count =0;
					 }
				 }
				
				 j=i+1;
				 st_flag=true; 
				 while (j<s.length()&&s.charAt(j)=='0'){
					 count ++; 
					 j++;
				 }
				 if(j>s.length()) return max;
				 i=j;
			 }
		 }
		 
		 return max; 
	 }
	public static void main(String[] args) {
		
int num = 1041;
int arr [] = {1,2,147,483,647};


List<Integer> list = Arrays.asList(0,1,2,147,483,647,1041,32,15);
List<Integer> ans = list.stream().map(BinaryGap::solution). 
collect(Collectors.toList()); 
System.out.println("solution:");
System.out.println(ans);

List<Integer> list2 = Arrays.asList(0,1,2,147,483,647,1041,32,15);
List<Integer> ans2 = list2.stream().map(BinaryGap::solution_2). 
collect(Collectors.toList()); 
System.out.println("solution_2:");
System.out.println(ans2);

	}

}

