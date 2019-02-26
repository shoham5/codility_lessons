package lesson3;

public class FrogJmp {



	/*
	 * finding the greatest common multiply
	 * INPOUT : first integer , second integer 
	 * OUTPUT: greatest common multiply
	 */
	public static int gcd(int first , int second) {
		if (second == 0) return first; 
		return gcd(second, first % second);  
	} 

	/*
	 *calculate the minimal number of jump
	 *
	 */

	public static int solution_2(int X, int Y, int D) {
		if (X==Y) return 0;
		int gcd_distance = gcd(X,Y);
		int gcd_final=gcd(gcd_distance,D);
		X/=gcd_final;
		Y/=gcd_final;
		D/=gcd_final;
		int steps =0 ; 
		while ((X+D)<=Y){
			X+=D;
			steps++;

		}
		return steps;
	}

	/*
	 *calculate the minimal number of jump
	 *
	 */

	public static int solution(int X, int Y, int D) {
		if (X==Y) return 0;
		Y=Y-X;
		X=0;
		int multiply_num=Y/D;
		int steps=multiply_num;
		if(multiply_num*D<Y) steps++;
		return steps;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println(solution(10, 102, 30));
		System.out.println(solution(10,100, 30));
	}

}
