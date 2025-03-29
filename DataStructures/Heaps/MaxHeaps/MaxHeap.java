public class MaxHeap {
    //Insert into maxheap
    public void insert(int maxheap[],int n , int x){
        int i=n-1;
        while((i>0) && maxheap[(int)(Math.floor((i-1)/2))]<x){
            maxheap[i]=maxheap[(int)(Math.floor((i-1)/2))];
            i = (int)(Math.floor((i-1)/2));
        }
        maxheap[i]=x;
    }

    //Adjust function to adjust the maxheap
    public void adjust(int maxheap[],int i , int n){
        int j = 2*(i+1)-1;
        int x = maxheap[i];
        while(j<=n-1){
            if((j<n-1) &&(maxheap[j]<maxheap[j+1])){
                j=j+1;
            }
            if(x>=maxheap[j]){
                break;
            }
            maxheap[(int)(Math.floor((j-1)/2))]=maxheap[j];
            j=2*(j+1)-1;
        }
        maxheap[(int)(Math.floor((j-1)/2))]=x;
    }

    //Delete the maxheap
    public int delete(int maxheap[],int n ,int x){
        if(n==0){
            System.out.println("Heap Tree is empty!");
        }
        x = maxheap[0];
        maxheap[0] = maxheap[n-1];
        adjust(maxheap,0,n);
        return x;
    }

    //Function to build heap tree
    public void heapify(int maxheap[],int n){
        for(int i=(int)(Math.floor((n-2)/2)) ; i>=0;i--){
            adjust(maxheap,i,n);
        }
    }

}
