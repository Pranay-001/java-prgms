import java.util.*;
class Sudoku{
	static Scanner sc=new Scanner(System.in);
	static int a[][]=new int[0][0];
	public static void main(String args[]){
		// int n=sc.nextInt();
		a=new int[][]
		{ 
            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
    	}; 
		// for(int i=0;i<n;i++){
		// 	for(int j=0;j<n;j++){
		// 		a[i][j]=sc.nextInt();
		// 	}
		// }
		if(get_ans()){
			for(int i=0;i<a.length;i++){
				for(int j=0;j<a.length;j++)
					System.out.print(a[i][j]);
				System.out.println();
			}
		}	
		else System.out.println("no ans");
	}
	public static boolean get_ans(){
		boolean f=true;int r=-1,c=-1;
		// System.out.println(Arrays.deepToString(a));
outer:	for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				if(a[i][j]==0){
					f=false;r=i;c=j;
					break outer;
				}
			}
		}
		if(f){
			return true;
		}		
		for(int k=1;k<10;k++){
			if(isSafe(k,r,c)){
				// System.out.println(k);
				a[r][c]=k;
				if(get_ans()) return true;
				else a[r][c]=0;
			}
		}
		
		return false;
	}
	public static boolean isSafe(int k,int cr,int cc){
		for(int j=0;j<a.length;j++)
			if(a[cr][j]==k || a[j][cc]==k)
				return false;
		int sqrt=(int)Math.sqrt(a.length);
		cr=cr-cr%sqrt;
		cc=cc-cc%sqrt;
		for(int i=cr;i<cr+sqrt;i++)
			for(int j=cc;j<cc+sqrt;j++)
				if(a[i][j]==k)
					return false;
		return true;
	}
	
}