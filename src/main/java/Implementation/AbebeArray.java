package Implementation;

public class AbebeArray {

    Integer[] A;

    public AbebeArray(Integer[] a) {
        A = a;
    }

    public static Integer[] insertionSort(Integer[] a) {
        for (int i = 1; i < a.length; i++) {
			/*Insert list[i] into a sorted sublist list[0..i-1] so that
		 list[0..i] is sorted. */
            int currentElement = a[i];
            int k;
            for (k = i - 1; k >= 0 && a[k] > currentElement; k--) {
                a[k + 1] = a[k];
            }
            // Insert the current element into list[k + 1]
            a[k + 1] = currentElement;
        }
        return a;
    }

    public static Integer[] bubbleSort(Integer[] a2) {
        boolean needNextPass = true;
        for (int k = 1; k < a2.length && needNextPass; k++) {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < a2.length - k; i++) {
                if (a2[i] > a2[i + 1]) {
                    // Swap list[i] with list[i + 1]
                    int temp = a2[i];
                    a2[i] = a2[i + 1];
                    a2[i + 1] = temp;
                    needNextPass = true; // Next pass still needed
                }
            }
        }
        return a2;
    }

    public static Integer[] mergeSort(Integer[] firstHalf2) {
        if (firstHalf2.length > 1) {
            // Merge sort the first half
            Integer[] firstHalf = new Integer[firstHalf2.length / 2];
            System.arraycopy(firstHalf2, 0, firstHalf, 0, firstHalf2.length / 2);
            mergeSort(firstHalf);
            // Merge sort the second half
            Integer secondHalfLength = firstHalf2.length - firstHalf2.length / 2;
            Integer[] secondHalf = new Integer[secondHalfLength];
            System.arraycopy(firstHalf2, firstHalf2.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, firstHalf2);
        }
        return firstHalf2;
    }

    /**
     * Merge two sorted lists
     */
    public static void merge(Integer[] list1, Integer[] list2, Integer[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static Integer[] quickSort(Integer[] a2) {
        quickSort(a2, 0, a2.length - 1);
        return a2;
    }

    public static void quickSort(Integer[] list, Integer first, Integer last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array list[first..last]
     */
    public static int partition(Integer[] list, Integer first, Integer last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search
        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;
            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;
            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high] >= pivot)
            high--;
        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    public static void SortingTimeComlixity() {
        System.out.println("                          Time Complexity        \n"
                + "                              Best                    Average                    Worst                    \n"
                + "Insertion Sort:               O(n)                 	O(n^2)	                   O(n^2)\n"
                + "Bubble Sort:                  O(n)                 	O(n^2)	                   O(n^2) \n"
                + "Merge Sort:                   O(n log(n))	        O(n log(n))	               O(n log(n))\n"
                + "Quick Sort:                   O(n log(n))	        O(n log(n))	               O(n^2)\n");
        System.out.println("Merg sort has the better time comlexity from all the above sorting algorithms \n"
                + "its worst time complexity is log liner, which is better than qudriatic.\n");
    }

    public static void SortArray(Integer[] a) {
        mergeSort(a);
    }
}