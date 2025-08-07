public class Sorting {
    public static void main(String[] args) {

    }

    // Partition
    public static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (a[i] < pivot) {
                j++;
                if (i != j) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        int pivot_point = j;
        if (low != pivot_point) {
            int temp = a[low];
            a[low] = a[pivot_point];
            a[pivot_point] = temp;
        }
        return pivot_point;
    }

    // Quick Sort
    public static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int pivot_point = partition(a, low, high);
            quickSort(a, low, pivot_point);
            quickSort(a, pivot_point + 1, high);
        }
    }

    // Merge
    public static void merge(int[] a, int low, int mid, int high) {
        int b[] = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            b[k] = a[i];
            i++;
            k++;
        }
        while (j <= high) {
            b[k] = a[j];
            j++;
            k++;
        }
        for (int m = 0; m < high - low; m++) {
            a[low + m] = b[m];
        }
    }

    // Merge sort
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (int) Math.floor((low + high) / 2);
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    // Adjust function (Heapify Down)
    public void adjust(int heap[], int i, int size) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            int temp =heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            adjust(heap, largest, size);
        }
    }

    public void heapify(int heap[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(heap, i, n);
        }
    }

    public void heapSort(int arr[]) {
        int n = arr.length;
        heapify(arr, n);

        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            adjust(arr, 0, i);
        }
    }

}
