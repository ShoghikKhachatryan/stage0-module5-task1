package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"Winter", "Spring", "Summer", "Autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] integers = new int [length];
        int index = 0;
        while (index < length) {
            integers[index] = ++index;
        }

        return integers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int index : arr) {
            sum += index;
        }

        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] == number) {
                return index;
            }
        }

        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        for (int index = 0; index < arr.length / 2; index++) {
            String temp = arr[index];
            arr[index] = arr[arr.length - index - 1];
            arr[arr.length - index - 1] = temp;
        }

        return arr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int[] newArr = new int[arr.length];

        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                newArr[j] = arr[i];
                j++;
            }
        }

        int[] positiveArr = new int[j];

        for (int i = 0; i < j; i++) {
            positiveArr[i] = newArr[i];
        }

        return positiveArr;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        /*
        int k = 0;
        int[][] arrTmp = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].length <= arr[j].length) {
                    arrTmp[k] = arr[i];
                    k++;
                    i++;
                }
            }
        }
        *
         */
        printArrey(arr);
        printArrey(sortArray(arr, 0, arr.length));
        return arr;//sortArray(arr, 0, arr.length);
    }

    private int[][] sortArray(int[][] arr, int start, int end) {
        int length = end - start;

        if (length <= 1) {
            return arr;
        }

        if (length == 2) {
            if (arr[start].length > arr[end - 1].length) {
                int[] tmp = arr[start];
                arr[start] = arr[end - 1];
                arr[end - 1] = tmp;
            }
            return arr;
        }

        int mid = length / 2;
        int leftArrayEnd= mid + start + 1;
        int rightArrayStart = mid + start + 1;

        sortArray(arr, start, leftArrayEnd);

        sortArray(arr, rightArrayStart, end);

        int i = start, j = rightArrayStart, k = 0;
        int[][] arrTmp = new int[end][];

        while (i < leftArrayEnd && (j < end) ) {
            if (arr[i].length < arr[j].length) {
                arrTmp[k] = arr[i];
                k++;
                i++;
            } else {
                arrTmp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i < leftArrayEnd) {
            arrTmp[k] = arr[i];
            k++;
            i++;
        }

        while (j < end) {
            arrTmp[k] = arr[j];
            k++;
            j++;
        }

        System.out.println("arrTmp.length = " + arrTmp.length);
        return arrTmp;
    }

    public void printArrey (int[][] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" { ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("}");
        }
        System.out.println(" }");
    }
}
