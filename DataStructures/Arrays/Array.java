/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements Array data structure and provides the following operations:
 * 1. Insert operation insert(x,idx)
 * 2. Delete Operation del(index)
 * 3. Search Operation indexOf(x)
 * 4. isEmpty
 * 5. Size
 * 6. GetElement
 * 7. Display
 * 8. Exit
 *
 */
public class Array {
    private int a[];
    private int len;
    private int size;

    Array(int len){
        this.len=len;
        this.size=0;
        a=new int[len];
    }

    //isEmpty
    public boolean isEmpty(){
        return size ==0;
    }

    //Size method
    public int size(){
        return size;
    }

    //Index of method
    public int indexOf(int x){
        int index=-1;
        for(int i=0;i<size;i++){
            if(a[i]==x){
                index=i;
                break;
            }
        }
        return index;
    }

    //Get by index
    public int get(int index){
        if(index<0 || index>=size){
            System.out.println("Invalid index.");
            return -1;
        }
        return a[index];
    }

    //Display method
    public void display(){
        for (int e:
             a) {
            System.out.print(e+" ");
        }
        System.out.println();
        return;
    }

    //Delete Method
    public int delete(int index){
        if(size==0){
            System.out.println("Array is empty.");
            return -1;
        }
        if(index<0 || index>=size){
            System.out.println("Invalid index is passed.");
            return -1;
        }
        int x=a[index];
        for(int i=index;i<size-1;i++){
            a[i]=a[i+1];
        }
        size--;
        return x;
    }

    //Insert Method
    public void insert(int x , int index){
        if(size==len){
            System.out.println("Array is full!");
            return;
        }
        if(index<0 || index>size){
            System.out.println("Invalid Index passed.");
            return;
        }
        for(int i=size-1;i>=index;i--){
            a[i+1]=a[i];
        }
        a[index]=x;
        size++;
        return;
    }
}
