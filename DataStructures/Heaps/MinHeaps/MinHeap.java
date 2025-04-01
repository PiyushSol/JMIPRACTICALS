/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 * This program implements a MaxHeap data structure and provides the following operations:
 * 1. Insert
 * 2. Adjust or Heapify
 * 3. Delete
 * 4. Print
 * 5. GetSize
 *
 */
public class MinHeap {
    private int size = 0; // Tracks the number of elements

    // Insert into min heap
    public void insert(int minheap[], int capacity, int x) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        int i = size;
        while (i > 0 && minheap[(i - 1) / 2] > x) {
            minheap[i] = minheap[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        minheap[i] = x;
        size++;
    }

    // Adjust function (Heapify Down)
    public void adjust(int minheap[], int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && minheap[left] < minheap[smallest])
            smallest = left;

        if (right < size && minheap[right] < minheap[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = minheap[i];
            minheap[i] = minheap[smallest];
            minheap[smallest] = temp;
            adjust(minheap, smallest, size);
        }
    }

    // Delete root from min heap
    public int delete(int minheap[]) {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int minValue = minheap[0];
        minheap[0] = minheap[size - 1];
        size--;
        adjust(minheap, 0, size);

        return minValue;
    }

    // Build min heap from array
    public void heapify(int minheap[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(minheap, i, n);
        }
    }

    // Print heap
    public void printHeap(int minheap[]) {
        for (int i = 0; i < size; i++) {
            System.out.print(minheap[i] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
