package ru.bstu.it31.romashenko.lab1;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

/** @author Ромащенко Н.А.
 *
 * @version 1. 21.02.19
 *
 * Имя класса: Main
 *
 * Назначение: Дана последовательность целых чисел а1,а2,...,ап. Выяснить, какое число встречается раньше — положительное или отрицательное.
 */


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Работа с массивом.");
        System.out.println("\t> 1. Ввести с клавиатуры;");
        System.out.println("\t> 2. Считать из файла;");
        System.out.println("\t> 9. Выход.");
        // Режим ввода данных
        // 1 - клавиатура
        // 2 - файл
        // 9 - выход
        //
        int intArray[];
        //
        int k = 0;
        // Инициализация объекта "Сканер"
        Scanner scanner = new Scanner(System.in);
        //
        int mode = scanner.nextInt();
        // Обработка режима работы
        switch (mode) {
            // Клавиатура
            case 1: {
                // Ввод сторон треугольника
                System.out.print("Количество символов в массиве: ");
                //
                k = scanner.nextInt();
                //
                scanner.close();
                //
                intArray = new int[k];
                //
                intArray = getArrayRand(k, -100, 100);
                break;
            }
            // Файл
            case 2: {
                // Функция для считывания из файла
                FileInputStream inFile = new FileInputStream("ex4.txt");
                //
                byte[] str = new byte[inFile.available()];
                //
                inFile.read(str);
                //
                String text = new String(str);
                //
                //String[] numbers = text.split("([^-\\d])|(-\\D)");
                String[] numbers = text.split("([\\s])");
                //
                k = Integer.parseInt(numbers[0]);
                //
                intArray = new int[k];
                //
                int pos = 1;
                //
                for (int i = 0; i < intArray.length; ++i, ++pos) {
                    //
                    if (!"".equals(numbers[pos])) {
                        //
                        intArray[i] = Integer.parseInt(numbers[pos]);
                    }
                }
                break;
            }
            // Выход
            case 9: {
                return;
            }
            // Ошибка ввода
            default: {
                System.out.println("Неправильный ввод.");
                return;
            }
        }
        printArrayConsole(intArray, k);
        //
        checkEx(intArray, k);
    }

    //
    private static int[] getArrayRand(int size, int rMin, int rMax) {
        int intArray[] = new int[size];

        for (int i = 0; i < intArray.length; i++) {
            // рандом в рэндже [rMin;rMax]
            intArray[i] = (int) (Math.random() * (rMax - rMin + 1) + rMin);
        }
        return intArray;
    }

    //
    private static void printArrayConsole(int[] arr, int size) {
        for (int i = 0; i < arr.length; ++i) {
            if ((i + 1) % 5 == 0) {
                System.out.println("A[" + i + "] = " + arr[i] + '\t');
            } else {
                System.out.print("A[" + i + "] = " + arr[i] + '\t');
            }
        }
        System.out.println();
    }

    //
    private static void checkEx(int[] intArray, int k) {
        for (int i = 0; i < intArray.length; ++i) {
            if (0 != intArray[i]) {
                if (0 > intArray[i]) {
                    System.out.println("Первее встречается отрицательное число. Индекс: " + i);
                } else {
                    System.out.println("Первее встречается положительное число. Индекс: " + i);
                }
                return;
            }
        }
        System.out.println("В массиве одни нули.");
    }
}