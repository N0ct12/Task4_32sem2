package main;
import utils.SwingUtils;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;


public class Main {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean size;
        public int s;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        Scanner scan = new Scanner(System.in);
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args[0].equals("-s")) {
                params.size = true;
                if (args[1]!=null) {
                    params.s = Integer.parseInt(args[1]);
                }else params.error = true;
                return params;
            }
//            if (args.length < 2) {
//                params.help = true;
//                params.error = true;
//                return params;
//            }
            params.inputFile = args[1];
            if (args.length > 2) {
                params.outputFile = args[2];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }
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
        Scanner scan = new Scanner(System.in);
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            out.println("  <cmd> -s //input size");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            winMain();
        } else {
            if (!params.size) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            }
            Integer[] arr = new Integer[params.s];
            Boolean[] fix = new Boolean[params.s];
            System.out.print("Введите первое число: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scan.nextInt();
                System.out.println("Зафиксировано ли число?(true/false)");
                fix[i] = Boolean.parseBoolean(scan.next());
                if(arr.length-1-i>0) {
                    System.out.println("Введите ещё " + (arr.length - 1 - i) + " чисел");
                }
            }
            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            out.println("Начальный массив: "+Arrays.toString(arr));
            sort(arr,fix);
            out.println("Отсортированный массив: "+ Arrays.toString(arr));
            out.close();
        }
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
    }
//    public static <T> void sort(int[] array, Boolean[] fixed) {
//        Function<String, ? extends T> converter = null;
//        Function<Boolean, ? extends T> conv = null;
//        T[] arr = (T[]) converter.apply(Arrays.toString(array));
//        boolean[] fix = (boolean[]) conv.apply(Boolean.valueOf(Arrays.toString(fixed)));
//        sort(arr,fix);
//    }
}

