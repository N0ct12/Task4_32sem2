import java.util.Arrays;

public class Main2 {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        int size = 6;
        Integer arr[] = new Integer[size];
        for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 100);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = array.length - 1; j > i; j--) {
                if (array[j-1].compareTo(array[j]) > 0) {
                    T temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }
}
