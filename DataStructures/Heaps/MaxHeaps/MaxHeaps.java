import java.util.Arrays;

public class MaxHeaps {
    public static void main(String []args){
        MaxHeap mxh= new MaxHeap();
        int max [] = new int[8];
        mxh.insert(max,8,40);
        mxh.insert(max,8,35);
        mxh.insert(max,8,45);
        mxh.insert(max,8,60);
        mxh.insert(max,8,90);
        mxh.insert(max,8,70);
        mxh.insert(max,8,80);
        mxh.heapify(max,8);
        System.out.println(Arrays.toString(max));
    }
}
