import java.util.*;
class ConvexHull{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<int []> points=new ArrayList<>();
        int[] start=null;
        for(int i=0;i<n;i++){
        	int t[]=new int[]{sc.nextInt(),sc.nextInt()};
           	points.add(t);
           	if(start==null || start[0]>t[0])	start=t;
        }
        int curr[]=start;
        Set<int []> res=new TreeSet<>((e1,e2)->{
            if(e1[0]!=e2[0])  return e1[0]-e2[0];
            return e1[1]-e2[1];
        });
        res.add(curr);
        while(true){
        	List<int []> colinear=new ArrayList<>();
        	int next[]=points.get(0);
        	for(int i=1;i<n;i++){
        		if(curr!=points.get(i)){
        			int val=crossProduct(curr,next,points.get(i));
        			if(val>0){
        				next=points.get(i);
        				colinear.clear();
        			}
        			else if(val==0){
        				if(distance(curr,next,points.get(i))<0){
        					colinear.add(next);
        					next=points.get(i);
        				}
        				else colinear.add(points.get(i));
        			}
        		}
        	}
        	for(int i[]:colinear)	res.add(i);
        	if(next==start)	break;
        	res.add(next);
        	curr=next;
        }
	    for(int i[]:res)    System.out.print(Arrays.toString(i)+",");
    }
    private static int crossProduct(int curr[],int []next,int []point){
    	int x1=curr[0]-next[0];
    	int x2=curr[0]-point[0];
    	int y1=curr[1]-next[1];
    	int y2=curr[1]-point[1];
    	return y2*x1-y1*x2;
    }
    private static int distance(int curr[],int []next,int []point){
    	int x1=curr[0]-next[0];
    	int x2=curr[0]-point[0];
    	int y1=curr[1]-next[1];
    	int y2=curr[1]-point[1];
    	return y1*y1+x1*x1-y2*y2-x2*x2;
    }
}
