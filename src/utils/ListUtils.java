package utils;

import java.util.ArrayList;
//import main.MyLL;

public class ListUtils {
    public static ArrayList<Integer> convertMatrixToList(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            list.add(matrix[0][i]);
        }
        return list;
    }
    public static ArrayList<Integer> convertArrayToList(int[] array){
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : array) {
            list.add(j);
        }
        return list;
    }
    public static int[] convertListToArray(ArrayList<Integer> arrayList) {
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }
//    public static MyLL convertListToLL(ArrayList<Integer> arrayList){
//        MyLL list = new MyLL();
//        for (int i = 0; i < arrayList.size(); i++) {
//            list.addLast(arrayList.get(i));
//        }
//        return list;
//    }
//    public static MyLL convertArrayToLL(int[] arr){
//        MyLL list = new MyLL();
//        for (int i = 0; i < arr.length; i++) {
//            list.addLast(arr[i]);
//        }
//        return list;
//    }
}
