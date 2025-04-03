/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Queue data structure using Arrays and provides the following operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 */
public class Queue {
    private int[] arr;
    private static int size;
    private int front = 0;
    private int rear;

    Queue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
    }

    //Checking queue is empty
    public boolean isEmpty() {
        return rear == -1;
    }

    //Add
    public void add(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear = rear + 1;
        arr[rear] = data;
    }

    //Remove
    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int data = arr[front];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear = rear - 1;
        return data;
    }

    //Peek
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[0];
    }


    //Railroad Rearrangement Problem Using Queue
    public boolean railRoad(int inputOrder[], int n, int k) {
        Queue track[] = new Queue[k];

        for (int i = 0; i < k; i++) {
            track[i] = new Queue(n);
        }

        int nextCartToOutput = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (inputOrder[i] == nextCartToOutput) {
                System.out.println("Move car " + inputOrder[i] + " from input track to output track.");
                nextCartToOutput++;

                // Move cars from holding tracks if they match the next expected output
                boolean moved;
                do {
                    moved = false;
                    for (int j = 0; j < k; j++) {
                        if (!track[j].isEmpty() && track[j].peek() == nextCartToOutput) {
                            System.out.println("Move car " + track[j].remove() + " from holding track " + j + " to output track.");
                            nextCartToOutput++;
                            moved = true;
                        }
                    }
                } while (moved);
            } else {
                int c = inputOrder[i];
                int bestTrack = -1;
                int bestLast = Integer.MIN_VALUE;
                for (int j = 0; j < k; j++) {
                    if (!track[j].isEmpty()) {
                        int lastCar = track[j].peek();
                        if (c > lastCar && lastCar > bestLast) {
                            bestLast = lastCar;
                            bestTrack = j;
                        }
                    } else if (bestTrack == -1) {
                        bestTrack = j; // Use the first empty track found
                    }
                }

                if (bestTrack == -1) {
                    return false; // No valid track found
                }

                track[bestTrack].add(c);
                System.out.println("Move car " + c + " from input track to holding track " + bestTrack);
            }
        }
        return true;
    }
}