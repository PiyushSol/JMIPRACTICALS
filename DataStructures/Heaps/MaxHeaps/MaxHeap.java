/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a MaxHeap data structure and provides the following operations:
 * 1. Insert
 * 2. Adjust or Heapify
 * 3. Delete
 * 4. Print
 * 5. GetSize
 *
 */
public class MaxHeap {
    private int size = 0; // Tracks the number of elements

    // Insert into max heap
    public void insert(int maxheap[], int capacity, int x) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        int i = size;  // Insert at last position
        while (i > 0 && maxheap[(i - 1) / 2] < x) {
            maxheap[i] = maxheap[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        maxheap[i] = x;
        size++;
    }

    // Adjust function (Heapify Down)
    public void adjust(int maxheap[], int i, int size) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && maxheap[left] > maxheap[largest])
            largest = left;

        if (right < size && maxheap[right] > maxheap[largest])
            largest = right;

        if (largest != i) {
            int temp = maxheap[i];
            maxheap[i] = maxheap[largest];
            maxheap[largest] = temp;
            adjust(maxheap, largest, size);
        }
    }

    // Delete root from max heap
    public int delete(int maxheap[]) {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int maxValue = maxheap[0];
        maxheap[0] = maxheap[size - 1]; // Replace root with last element
        size--;
        adjust(maxheap, 0, size); // Restore heap property

        return maxValue;
    }

    // Build max heap from array
    public void heapify(int maxheap[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(maxheap, i, n);
        }
    }

    // Print heap
    public void printHeap(int maxheap[]) {
        for (int i = 0; i < size; i++) {
            System.out.print(maxheap[i] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
