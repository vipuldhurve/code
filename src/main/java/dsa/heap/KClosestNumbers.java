package dsa.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestNumbers {
//    Geeks For Geeks ------------------------
//    Given a sorted array arr[] and a value X,
//    find the k closest elements to X in arr[].
//    Note that if the element is present in array, then it should not be in output,
//    only the other closest elements are required.

    //    Input: arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}, x = 35, k = 4
//    Output: {30 39 42 45}
    static class Node {
        int diff;
        int val;

        Node(int diff, int val) {
            this.diff = diff;
            this.val = val;
        }
    }


    //Time Complexity - nlog(k)
    private static int[] kClosest(int[] arr, int num, int k) {
        if (k == arr.length) return arr;
        //Sorting of absolute difference between array element and x to find k closest
        //So we need maxheap
        //{10, 2, 14, 4, 7, 6}, x = 5, k = 3
        //{5, 3, 9, 1, 2, 1}
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n2.diff, n1.diff);
            }
        });

        for (int i = 0; i < arr.length; i++) {

            if (Math.abs(arr[i] - num) != 0) maxHeap.add(new Node(Math.abs(arr[i] - num), arr[i]));
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[] kClosest = new int[k];
        int j = 0;
        while (maxHeap.size() > 0 && j < k) {
            kClosest[j++] = maxHeap.poll().val;
        }

        kClosest = Arrays.stream(kClosest).sorted().toArray();
        return kClosest;
    }

    private static void solve(int[] input, int num, int k) {
        System.out.println("INPUT: "+ Arrays.toString(input) + "  num = " + num  + "  k = " + k);
        System.out.println("OUTPUT: " + Arrays.toString(kClosest(input, num, k)) +"\n");
    }


    public static void main(String[] args) {
        int[] input = new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int num = 35, k = 4;

        solve(input, num, k);

        input = new int[]{1, 2, 3, 4, 5};
        num = 3;
        k = 4;
        solve(input, num, k);
    }

}
