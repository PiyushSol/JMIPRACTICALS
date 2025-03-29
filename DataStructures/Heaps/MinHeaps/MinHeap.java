public class MinHeap {

    //Insert into maxheap
    public void insert(int minheap[],int n , int x){
        int i=n-1;
        while((i>0) && minheap[(int)(Math.floor((i-1)/2))]>x){
            minheap[i]=minheap[(int)(Math.floor((i-1)/2))];
            i = (int)(Math.floor((i-1)/2));
        }
        minheap[i]=x;
    }

    //Adjust function to adjust the maxheap
    public void adjust(int minheap[],int i , int n){
        int j = 2*(i+1)-1;
        int x = minheap[i];
        while(j<=n-1){
            if((j<n-1) &&(minheap[j]>minheap[j+1])){
                j=j+1;
            }
            if(x<=minheap[j]){
                break;
            }
            minheap[(int)(Math.floor((j-1)/2))]=minheap[j];
            j=2*(j+1)-1;
        }
        minheap[(int)(Math.floor((j-1)/2))]=x;
    }

    //Delete the maxheap
    public int delete(int minheap[],int n ,int x){
        if(n==0){
            System.out.println("Heap Tree is empty!");
        }
        x = minheap[0];
        minheap[0] = minheap[n-1];
        adjust(minheap,0,n);
        return x;
    }

    //Function to build heap tree
    public void heapify(int minheap[],int n){
        for(int i=(int)(Math.floor((n-2)/2)) ; i>=0;i--){
            adjust(minheap,i,n);
        }
    }

}
