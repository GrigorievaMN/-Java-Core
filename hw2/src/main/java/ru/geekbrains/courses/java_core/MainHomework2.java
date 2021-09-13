package ru.geekbrains.courses.java_core;

import java.util.Arrays;
import java.util.Scanner;

public class MainHomework2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        taskSelection();
    }


    private static void taskSelection() {
        System.out.println("Выбор задачи:\n Введите номер задачи (всего 7); 0 - Выход");
        int task = sc.nextInt();
        switch (task) {
            case 1:
                invertArray(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
                break;
            case 2:
                fillArray(new int[8]);
                break;
            case 3:
                changeArray(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
                break;
            case 4:
                fillDiagonal();

                break;
            case 5:
                minMaxArray(new int[]{100, 5, 3, 2, -11, 4, 5, 2, 4, 895, -9, 1});
                break;
            case 6:
                System.out.println(checkBalance(new int[]{1, 5, 3, 3, 6}));
                taskSelection();
                break;
            case 7:
                System.out.println("У данной задачи 2 варианта решения:\n Введите номер варианта (1/2); 0 - Выход");
                int task7 = sc.nextInt();
                switch (task7) {
                    case 1:
                        shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},- 103);
                        break;
                    case 2:
                        arrayShift(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},- 103);
                        break;
                }
                break;
        }
    }

    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
        taskSelection();
    }

    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
        taskSelection();
    }

    public static void changeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
        taskSelection();
    }

    public static void fillDiagonal(){
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++){
            arr[i][i] = 1;
            arr[i][arr.length-1-i] = 1;
        }
        System.out.println(Arrays.deepToString(arr));

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        taskSelection();
    }

    public static void minMaxArray(int[] arr) {
        int minValue = arr[0] ;
        int maxValue = arr[0];
        for (int value: arr) {
            if (value< minValue) {
                minValue = value;
            }
            if (value > maxValue){
                maxValue = value;
            }
        }
        System.out.println("В массиве "+ Arrays.toString(arr));
        System.out.println("Минимальное значение = "+ minValue);
        System.out.println("Максимальное значение = "+ maxValue);
        taskSelection();

    }

    public static boolean checkBalance(int[] arr) {
        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            int sumRight = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    public static  void shiftArray(int[] arr, int shift) {
        shift = shift % arr.length;
        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                int buffer = arr[arr.length - 1];

                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = buffer;
            }
        } else {
            shift = Math.abs(shift);
            for (int i = 0; i < shift; i++) {
                int buffer = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = buffer;
            }
        }
        System.out.println(Arrays.toString(arr));
        taskSelection();
    }

    static void arrayShift(int[] arr, int shift)
    {
        shift = shift % arr.length;
        if (shift <= 0) {
            shift = Math.abs(shift);
        } else {
            shift = arr.length - shift;
        }
        reverseArray(arr, 0,shift-1);
        reverseArray(arr, shift, arr.length - 1);
        reverseArray(arr);

        System.out.println(Arrays.toString(arr));
        taskSelection();

    }

    static void reverseArray(int[] arr, int from, int to)
    {
        int tmpItem;
        int cnt = (to + 1 - from) / 2 - 1;
        for(int i = 0; i <= cnt; i++)
        {
            tmpItem = arr[i + from];
            arr[i + from] = arr[to - i];
            arr[to - i] = tmpItem;
        }
    }

    static void reverseArray(int[] arr)
    {
        reverseArray(arr, 0, arr.length - 1);

    }
}
