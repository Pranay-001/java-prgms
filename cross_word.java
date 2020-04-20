import java.util.*;
class cross_word{
	static char puzzle[][]=new char[0][0];
	static String w[]=new String[0];
	// static boolean b[]=new boolean[0];
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		puzzle=new char[10][10];
		for(int i=0;i<10;i++){
			String s=sc.nextLine();
			for(int j=0;j<s.length();j++){
				puzzle[i][j]=s.charAt(j);
			}
		}
		// System.out.println(Arrays.deepToString(puzzle));
		String s=sc.nextLine();
		w=s.split(";");
		find_loc(0);
		for(char []i:puzzle){
			for(char j:i)
			System.out.print(j);
		System.out.println();
		}
	}
	public static boolean find_loc(int s){
		boolean b[];
		if(s==w.length)
			return true;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(puzzle[i][j]=='-' || puzzle[i][j]==w[s].charAt(0)){
					if(isPossibleHori(w[s],i,j)){
						b=new boolean[w[s].length()];
						putHori(w[s],i,j,b);
						if(find_loc(s+1)) return true;
						resetHori(i,j,b);
					}
					if(isPossibleVer(w[s],i,j)){
						b=new boolean[w[s].length()];
						putVer(w[s],i,j,b);
						if(find_loc(s+1)) return true;
						resetVer(i,j,b);
					}
				}
			}
		}
		return false;
	}
	public static boolean isPossibleHori(String s,int r,int c){
		for(int i=0;i<s.length();i++){
			if(i+c>=puzzle.length || (puzzle[r][i+c]!='-' && puzzle[r][i+c]!=s.charAt(i)))
				return false;
		}
		return true;
	}
	public static boolean isPossibleVer(String s,int r,int c){
		for(int i=0;i<s.length();i++){
			if(i+r>=puzzle.length || (puzzle[i+r][c]!='-' && puzzle[i+r][c]!=s.charAt(i)))
				return false;
		}
		return true;
	}
	public static void putHori(String s,int r,int c,boolean []b){
		for(int i=0;i<s.length();i++){
			if(puzzle[r][i+c]=='-'){
				puzzle[r][i+c]=s.charAt(i);
				b[i]=true;
			}
		}
	}
	public static void putVer(String s,int r,int c,boolean []b){
		for(int i=0;i<s.length();i++){
			if(puzzle[i+r][c]=='-'){
				puzzle[i+r][c]=s.charAt(i);
				b[i]=true;
			}
		}
	}
	public static void resetVer(int r,int c,boolean []b){
		for(int i=0;i<b.length;i++){
			if(b[i]){
				puzzle[i+r][c]='-';
			}
		}
	}
	public static void resetHori(int r,int c,boolean []b){
		for(int i=0;i<b.length;i++){
			if(b[i]){
				puzzle[r][c+i]='-';
			}
		}
	}

}