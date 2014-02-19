import java.util.Random;
public class A{
	public static void main(String args[]){
		Random r = new Random();
		int N = 20;
		int A[] = new int[N];
		
		for(int i = 0; i < A.length; i++){
			A[i] = r.nextInt(10);
			System.out.print(A[i] + ", ");
		}
		System.out.println();
		printAll(A);
	}
	
	public static void printAll(int A[]){
		int LMin [] = new int [A.length];
		int RMax [] = new int [A.length];
		int min = A[0];
		int minIndex = 0;
		for(int i = 1; i < A.length; i++){
			if(A[i] < min){
				min = A[i];
				minIndex = i;
			}
			LMin[i] = minIndex;
		}
		int max = A[A.length-1];
		int maxIndex = A.length-1;
		for(int i = A.length-1; i >= 0; i--){
			if(A[i] > max){
				max = A[i];
				maxIndex = i;
			}
			RMax[i] = maxIndex;
		}
		
		for(int i = 0; i < A.length; i++){
			if(A[LMin[i]] < A[i] && A[i] < A[RMax[i]]){
				System.out.println(A[LMin[i]] + " < " + A[i] + " < " + A[RMax[i]]);
			}
		}
	}
}
