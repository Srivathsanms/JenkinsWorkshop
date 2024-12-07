package com.learn.learning.test;

import java.util.PriorityQueue;
import java.util.Collections;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        // Use a max heap to store the stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Continue until there is one or no stone left
        while (maxHeap.size() > 1) {
            // Get the two heaviest stones
            int stone1 = maxHeap.poll(); // Largest stone
            int stone2 = maxHeap.poll(); // Second largest stone

            // If they are not equal, the remaining stone is the difference
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }

        // If there is one stone left, return it; otherwise, return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        // Test cases
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Last Stone Weight: " + lastStoneWeight(stones1)); // Output: 1

        int[] stones2 = {1};
        System.out.println("Last Stone Weight: " + lastStoneWeight(stones2)); // Output: 1
    }
}

