import java.util.*;
class Rat_Maze{
	static Scanner sc=new Scanner(System.in);
	static int maze[][]=new int[0][0],path[][]=new int[0][0];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		maze=new int[n][n];
		path=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				maze[i][j]=sc.nextInt();
		find_path(0,0);	
	}
	public static void find_path(int r,int c){
		if(r==maze.length-1 && c==maze.length-1){
			path[r][c]=1;
			System.out.println(Arrays.deepToString(path));
			System.out.println();
			return;
		}
		if(r>=maze.length || c>=maze.length || r<0 || c<0 || maze[r][c]==0 || path[r][c]==1)
			return;
		
		path[r][c]=1;
		find_path(r-1,c);
		
		find_path(r+1,c);
		
		find_path(r,c+1);
		
		find_path(r,c-1);
		path[r][c]=0;
	}
}