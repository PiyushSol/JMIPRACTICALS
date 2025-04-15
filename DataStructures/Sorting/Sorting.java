import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        int SIZE = 5000;
        int[] a = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            a[i] = random.nextInt(999) + 1;
        }

        int[][] allCopies = new int[7][];
        for (int i = 0; i < 7; i++) {
            allCopies[i] = Arrays.copyOf(a, a.length);
        }

        long[] durations = new long[7];
        String[] names = {
                "Selection Sort", "Bubble Sort", "Insertion Sort",
                "Merge Sort", "Quick Sort", "Shell Sort", "Shell Sort (Pratt)"
        };

        durations[0] = time(() -> selectionSort(allCopies[0], SIZE));
        durations[1] = time(() -> bubbleSort(allCopies[1], SIZE));
        durations[2] = time(() -> insertionSort(allCopies[2], SIZE));
        durations[3] = time(() -> mergeSort(allCopies[3], 0, SIZE - 1));
        durations[4] = time(() -> quickSort(allCopies[4], 0, SIZE - 1));
        durations[5] = time(() -> shellSort(allCopies[5], SIZE));
        durations[6] = time(() -> shellSortPratt(allCopies[6], SIZE));

        System.out.println("\n" + "=".repeat(45));
        System.out.println("        SORTING TIME SUMMARY (ms)");
        System.out.println("=".repeat(45));
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-25s : %5d ms\n", names[i], durations[i] / 1_000_000);
        }

        int bestIdx = 0;
        for (int i = 1; i < durations.length; i++) {
            if (durations[i] < durations[bestIdx]) bestIdx = i;
        }

        System.out.println("\n🚀 Fastest Algorithm: " + names[bestIdx] +
                " (" + durations[bestIdx] / 1_000_000 + " ms)");
        System.out.println("=".repeat(45));
    }

    public static long time(Runnable sortingMethod) {
        long start = System.nanoTime();
        sortingMethod.run();
        long end = System.nanoTime();
        return end - start;
    }


    //Shell Sort basic
    public static void shellSort(int a[],int n){
       int gap = (n/2);
       while(gap>=1){
           for(int i=gap;i<n;i++){
               int x=a[i];
               int j=i;
               while(j>=gap && a[j-gap]>x){
                   a[j]=a[j-gap];
                   j=j-gap;
               }
               a[j]=x;
           }
           gap =(gap/2);
       }
    }

    //Shell Sort Pratt
    public static void shellSortPratt(int a[], int n){
        int gap = 1;
        while(gap<n/3){
            gap = 3*gap+1;
        }
        while(gap>=1){
            for(int i=gap;i<n;i++){
                int x=a[i];
                int j=i;
                while(j>=gap && a[j-gap]>x){
                    a[j]=a[j-gap];
                    j=j-gap;
                }
                a[j]=x;
            }
            gap = (gap-1)/3;
        }
    }

    //Partition
public static int partition(int [] a , int low , int high){
        int pivot = a[low];
        int j=low;
        for(int i=low+1;i<=high;i++){
            if(a[i]<pivot){
                j++;
                if(i!=j){
                    int temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        int pivot_point =j;
        if(low != pivot_point){
            int temp =a[low];
            a[low]=a[pivot_point];
            a[pivot_point]=temp;
        }
        return pivot_point;
}

//Quick Sort
    public static void quickSort(int a[], int low, int high){
        if(low<high){
            int pivot_point = partition(a,low,high);
            quickSort(a,low,pivot_point);
            quickSort(a,pivot_point+1,high);
        }
    }

    //Merge
    public static void merge(int []a , int low , int mid , int high){
        int b[] = new int[high-low+1];
        int i=low,j=mid+1,k=0;
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                b[k]=a[i];
                i++;
            }
            else{
                b[k]=a[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            b[k]=a[i];
            i++;
            k++;
        }
        while(j<=high){
            b[k]=a[j];
            j++;
            k++;
        }
        for(int m=0;m<high-low;m++){
            a[low+m]=b[m];
        }
    }

    //Merge sort
    public static void mergeSort(int []a , int low,int high){
        if(low<high){
            int mid = (int)Math.floor((low+high)/2);
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    //Insertion Sort
    public static  void insertionSort(int []a , int n){
        for(int i=1;i<n;i++){
            int x = a[i];
            int j=i;
            while (j>0 && a[j-1]>x){
                a[j]=a[j-1];
                j=j-1;
            }
            a[j]=x;
        }
    }

    //Bubble Sort
    public static void bubbleSort(int []a , int n){
        for(int i=0;i<n-1;i++){
            boolean isSorted = true;
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    //Selection sort
    public static void selectionSort(int a[] , int n){
        for(int i=0;i<n-1;i++){
            int minIdx = i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[minIdx]){
                    minIdx=j;
                }
            }
            if(i!=minIdx){
                int temp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = temp;
            }
        }

    }
}
