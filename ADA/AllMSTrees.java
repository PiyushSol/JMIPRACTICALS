import java.util.Scanner;
class DisjointSet{
   int u[], n;
   DisjointSet(int n){
      u = new int[n];
	  this.n = n;
	  for(int i=0; i<n; i++)
	     u[i] = i;
   }
   DisjointSet(DisjointSet s){
      n = s.n;
      u = new int[n];
	  for(int i=0; i<n; i++)
	     u[i] = s.u[i];
   }
   int find(int i){
      int j = i;
	  while(u[j] != j){
	     j = u[j];
	  }
	  return j;
   }
   void merge(int i, int j){
      if(i < j){
	     u[j] = i;
	  }else{
	     u[i] = j;
	  }
   }
   boolean isEqual(int i, int j){
      if(i == j) return true;
	  else return false;
   }
   public String toString(){
      String s = "u = [";
	  for(int i=0; i<n-1; i++)
	     s = s + u[i] + ", ";
	  s = s + u[n-1] + "]";
	  return s;
	  
   }   
}

class Edge{
	int s, d, w;
	void read(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an edge in (s, d, w) ");
		s = in.nextInt();
		d = in.nextInt();
		w = in.nextInt();
	}
	public String toString(){
      String x = "(" + s + ", " + d + ")=" + w ;
	  return x;
   } 
} 

class Demo{
   static int getWeight(Edge E[]){
	   int w = 0;
	   for(int i=0; i<E.length; i++)
		   w += E[i].w;
	   return w;
   }
   static int kruskal(Edge E[], int n){
      int m = E.length;
	  Edge F[] = new Edge[n-1];
	  DisjointSet d_s = new DisjointSet(n);
	  int k = 0;
	  for(int i=0; i<m; i++){
		  Edge e = E[i];
		  int s = e.s, d = e.d;
		  int p = d_s.find(s);
		  int q = d_s.find(d);
		  if(p != q){
			  F[k++] = e;
			  d_s.merge(p, q);
		  }
	  }
	  System.out.println("Edges of minimum spanning tree");
	  print(F);
	  return getWeight(F);
   }	   
   static void read(Edge E[]){
	   System.out.println("Enter " + E.length + " edges in non-decreasing order of their weights");
	   for(int i=0; i<E.length; i++)
		   E[i].read();
   }
   static void print(Edge E[]){
	   System.out.print("E = [");
	   for(int i=0; i<E.length-1; i++)
		   System.out.print(E[i]+", ");
	   System.out.print(E[E.length-1]+"]\n");
   }
   public static void main(String abc[]){
      Scanner in = new Scanner(System.in);
	  System.out.print("How many vertices? ");
	  int n = in.nextInt();
	  System.out.print("How many edges? ");
	  int m = in.nextInt();
	  Edge E[] = new Edge[m];
	  for(int i=0; i<E.length; i++)
		  E[i] = new Edge();
	  read(E);
	  print(E);
	  int w = kruskal(E, n);
	  System.out.println("Total weight of Minimum Spanning Tree = " + w);
   }
 }