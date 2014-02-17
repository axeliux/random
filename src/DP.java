/**
 * Some Dynamic programming problems
 * @author axel
 *
 */
public class DP{
	public static void main(String [] args)
	{
		//int monedas[] = {1,2,25,50,100,200,500};
		//int sum = 55;
		//int result[] = null;
		//minMonedas(monedas,sum);
		char array[] = "abc".toCharArray();
		perms(array,0,array.length);
		
	}
	/**
	 * Complecity  O (n!)
	 * */
	public static void perms(char str [], int i, int n){
		if(i==n){
			System.out.println(str);
		}else{

			for(int j=i; j < n; j++ ){
				swap(str,i,j);
				perms(str,i+1,n);
				swap(str,i,j);
			}
		}
	}
	public static void swap(char str[], int a, int b){
		char tmp = str[a];
		str[a] = str[b];
		str[b] = tmp;
	}
	/**
	 * Longest Increasing Subsequence
	 * Complexity O ( n^2 )
	 * @param array
	 */
	public static void LIS(int array[]){
		int size[] = new int[array.length];
		String path[] = new String[array.length];
				for(int i = 0; i < array.length; i++ ){
			size[i] = 1;
			path[i] = array[i]+"";
		}
		
		for(int i = 1; i < array.length; i++){
			for(int j = 0; j < i; j ++ ){
				if(array[j] <= array[i] && size[j] + 1 > size[i])
				{
					size[i] = size[j] + 1;
					path[i] = path[j] + " " + array[i];
				}
			}
		}
		
		for(int i = 0; i < array.length; i ++ ){
			System.out.print(path[i]);
			System.out.print(" = " + size[i]);
			System.out.println();
		}
		
		
	}
	/**
	 * Road cutting problem
	 * Complexity O ( n^2 )
	 * */
	public static int rod_cutting(int V[], int N){
		int B[] = new int[N+1];
		B[0] = 0;
		
		for(int i = 1; i <= N ; i++){
			int max =  V[i];
			for(int j = 1; j < i; j++){
				int current = V[j] + B[i-j];
				max = Math.max(max,current);
			}
			B[i] = max;
		}
	return B[N];		
	}
	/**
	 * Complexity O ( nC ) where n is T and C the number of Coins at C
	 * */

	public static void MIN_COINS(int C [], int T){
		int result[] = new int[T+1];
		String path [] = new String[T+1];
		result[0] = 0;
		path[0] = "0";

		
		for(int i = 1; i < result.length; i++ ){
			result[i] = Integer.MAX_VALUE;
			path[i] = "";
			for(int j= 0; j < C.length; j++){
				if (C[j] <= i && (result[i - C[j]] + 1) < result[i]){
					result[i] = result[i - C[j]] +1;
					path[i] = path[i - C[j]] + " + " +C[j];
				}
			}
		}
		for(int index = 0; index < result.length; index ++ ){
			System.out.println(path[index] + " = " + index + " (" + result[index] + " coins)");
		}
		
	}
}
