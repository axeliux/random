import java.util.Random;
public class MAX{
	public static void main(String arg []){
		Random ran = new Random();
		int A [] = new int[16];
		for(int i = 0 ; i < A.length; i++){
			int value = ran.nextInt(200);
			A[i] = value > 100? value-250:value;
			System.out.print(A[i] + ", ");
		}
		System.out.println();
		findMaxSubArray(A);
		System.out.println();
	}
	public static void findMaxSubArray(int[] A){
 		int start = 0;
 		int end = 0;
 		int start_so_far = 0;
 		int max = 0;
 		int max_so_far = 0;
 		
 		for( int i = 0; i < A.length; i++)
 		{
 			max_so_far += A[i];
 			
 			if( max_so_far >= max ){
 				max = max_so_far;
 				end = i; 
 				start = start_so_far;
 			}else if(max_so_far < 0){
 				max_so_far = 0;
 				start_so_far = i + 1;
 			}
 		}
 		
 		for(int i= start; i <= end; i++){
 			System.out.print(A[i] + " , ");
 		}
 		System.out.print(" = " + max);
 	}
      
}
