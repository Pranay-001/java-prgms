import java.util.*;
class NQueens{
	static Scanner sc=new Scanner(System.in);
	static int a[][]=new int[0][0];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		placeNQueens(n);	
	}
	public static boolean isSafe(int r,int c){
		for(int i=r-1;i>=0;i--)
			if(a[i][c]==1)
				return false;
		for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
			if(a[i][j]==1)
				return false;
		for(int i=r-1,j=c+1;i>=0 && j<a.length;i--,j++)
			if(a[i][j]==1)
				return false;
		return true;
	}
	public static void NQueens(int row) {
		if(row==a.length){
			System.out.println(Arrays.deepToString(a));
			System.out.println();
			return;
		}
		// System.out.println(Arrays.deepToString(a));
		for(int i=0;i<a.length;i++){
			if(isSafe(row,i)){
					a[row][i]=1;
					NQueens(row+1);
					a[row][i]=0;
			}
		}
	}
	public static void placeNQueens(int n){
		a=new int[n][n];
		NQueens(0);
	}

	
}