// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Exercise 1
        //int[] arr = {5, 2, 1, 7, 9, 0, 4};
        //printArray(arr);


        // Exercise 2
        var arr1 = createArray(15);
        var arr2 = createArray(15);

        printArray(arr1);
        printArray(arr2);

        // Exercise 3
        //max3(arr1);

        // Exercise 4
        //min3(arr1);

        // Exercise 5
        var distinct = getDistinct(arr1, arr2);
        printArray(distinct);

        // Exercise 6
        int theNumber = createNumber(distinct);
        System.out.println(theNumber);
        int theOppositeNumber = createOppositeNumber(distinct);
        System.out.println(theOppositeNumber);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            String toPrint = i == arr.length - 1 ? arr[i] + "" : arr[i] + ", ";
            System.out.print(toPrint);
        }
        System.out.println("]");
    }

    public static int[] createArray(int capacity) {
        int[] res = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            res[i] = (int) (Math.random() * 10);
        }
        return res;
    }

    public static void max3(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int temp = (arr[i] * 100) + (arr[i + 1] * 10) + arr[i + 2];
            if (temp < 1000)
                max = Math.max(max, temp);
        }
        System.out.println(max);
    }

    public static void min3(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int temp = (arr[i] * 100) + (arr[i + 1] * 10) + arr[i + 2];
            if (temp > 100)
                min = Math.min(min, temp);
        }
        System.out.println(min);
    }

    public static boolean isInArray(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return true;
            }
        }
        return false;
    }

    public static int[] getDistinct(int[] arr1, int[] arr2) {
        int[] res = new int[Math.max(arr1.length, arr2.length)];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }

        int index = 0;

        index = fillDistinct(arr1, arr2, res, index);
        fillDistinct(arr2, arr1, res, index);

        return res;
    }

    public static int fillDistinct(int[] arrSource, int[] arrCompare, int[] arrResult, int resultIndex){
        for (int i = 0; i < arrSource.length; i++) {
            if (
                    !isInArray(arrSource[i], arrCompare)
                            && resultIndex != arrResult.length
                            && !isInArray(arrSource[i], arrResult)) {
                arrResult[resultIndex] = arrSource[i];
                resultIndex++;
            }
        }
        return resultIndex;
    }

    public static int createNumber(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) break;
            res = res * 10 + arr[i];
        }
        return res;
    }

    public static int createOppositeNumber(int[] arr) {
        int theNumber = createNumber(arr);

        int res = 0;

        while (theNumber > 0) {
            res *= 10;
            res += theNumber % 10;
            theNumber /= 10;
        }
        return res;
    }
}