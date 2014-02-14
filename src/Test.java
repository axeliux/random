
public class Test {

		public static void main(String str[]){
			int M[][] = {
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16}
			};
			
			for(int i = 0; i < M.length; i++){
				for(int j = 0; j < M.length; j++)
				{
					System.out.print(M[i][j]+", ");
				}
				System.out.println();
			}
			Test.rotate(M, M.length);
			System.out.println("Rotate:");
			for(int i = 0; i < M.length; i++){
				for(int j = 0; j < M.length; j++)
				{
					System.out.print(M[i][j]+", ");
				}
				System.out.println();
			}
		}
		
		public static void rotate(int M[][],int N){
			for(int layer = 0; layer < N/2; layer++){
				
				int last =  N - 1 - layer;
				for( int i = layer ; i < last; i++){
					int offset = i -layer;
					// Save top
					int top = M[layer][i];
					// left ->  top
					M[layer][i] = M[last-offset][layer];
					// botton -> left
					M[last-offset][layer] = M[last][last-offset];
					// right -> botton
					M[last][last - offset]  = M[i][last];
					
					// top ->  right
					M[i][last] = top;
					
				}
			}
		}
}
