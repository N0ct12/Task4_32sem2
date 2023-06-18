import java.util.Arrays;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        int size = 6;
        Integer arr[] = new Integer[size];
        for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 100);
        boolean fix[] = new boolean[]{true,true,false,true,false,true};
        System.out.println(Arrays.toString(arr));
        sort(arr,fix);
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable<T>> void sort(T[] array, boolean[] fixed) {
        int fixIndex = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if(!fixed[j]){
                    fixIndex = j;
                    System.out.println(ANSI_GREEN + "ИНДЕКС = " + j + ANSI_RESET);
                } else if (!fixed[j-1]) {
                    fixIndex = j-1;
                    System.out.println(ANSI_RED + "ИНДЕКС = " + j + ANSI_RESET);
                }
                if (array[j-1].compareTo(array[j]) > 0 && j!=fixIndex && j-1!=fixIndex) {
                    T temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    System.out.println(Arrays.toString(array));
                }
            }
        }
    }
}
