import java.util.Random;
public class ArrayProblems{
	public static void main(String arg[]){
		int N = 25;
		int A[] = new int[N];
		Random r = new Random();
		
		for(int i  = 0; i < A.length; i++){
			int v = r.nextInt(30);
			A[i] = v > 10? v-30:v;
			System.out.print(A[i] + ", ");
		}
		int k = r.nextInt(20);
		System.out.println();
		sumK(A,k);	
			
	}
	
	public static void sumK(int A[], int k){
		int start = 0;
		int currentSum = 0;
		int counter = 0;
		for(int i = 0; i < A.length; i++){
			currentSum += A[i];
			
			if(currentSum == k ){
				counter++;
				for(int j = start; j <= i; j++){
					System.out.print(A[j] + ", ");
				}
				System.out.println(" = " + k);
				currentSum -=A[start++];
			}
			
			while( currentSum > k){
				currentSum -= A[start++];
			}
		}
		if(counter == 0) {
			System.out.println("cannot find Sum K = "+ k);
		}
	}
}
