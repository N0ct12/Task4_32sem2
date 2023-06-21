package main;

import utils.SwingUtils;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;

public class Main {
    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Table().setVisible(true);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        winMain();
//        int size = 6;
//        Integer[] arr = new Integer[size];
//        //for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 100);
//        //boolean fix[] = new boolean[]{true,true,false,true,false,true};
//        arr = new Integer[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        boolean[] fix = {false, false, true, false, false, true, true, false, false};
//        System.out.println(Arrays.toString(arr));
//        sort(arr,fix);
//        System.out.println(Arrays.toString(arr));
    }
    public static <T extends Comparable<T>> void sort(T[] array, Boolean[] fixed) {
        int k = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (!fixed[j]){
                    while((j - k > 0) && fixed[j-k]){
                        k++;
                    }
                    if (array[j-k].compareTo(array[j]) > 0 ) {
                        T temp = array[j-k];
                        array[j-k] = array[j];
                        array[j] = temp;
                    }
                    k = 1;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
//    public static <T> void sort(int[] array, Boolean[] fixed) {
//        Function<String, ? extends T> converter = null;
//        Function<Boolean, ? extends T> conv = null;
//        T[] arr = (T[]) converter.apply(Arrays.toString(array));
//        boolean[] fix = (boolean[]) conv.apply(Boolean.valueOf(Arrays.toString(fixed)));
//        sort(arr,fix);
//    }
}

