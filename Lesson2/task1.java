/*
Напишите программу, которая проверяет, является ли введенная текстовая строка числом с плавающей точкой (float).
Программа пытается преобразовать введенную строку в число float, и если это успешно, она выводит полученное число.
Если преобразование не удалось, программа выдаёт сообщение об ошибке
Your input is not a float number. Please, try again.
и возвращает специальное значение Float.NaN, чтобы обозначить ошибку.
 */

package Lesson2;

public class task1 {
    class IsFloat {
        public static float isFloat(String input) {
            float newNumber = 0;
            try {
                newNumber = Float.parseFloat(input);
                return newNumber;
            } catch (Exception e) {
                System.out.println("Your input is not a float number. Please, try again.");
                return Float.NaN;
            }
        }
    }
    
    public class Printer {
        public static void main(String[] args) {
            String input;

            if (args.length == 0) {
                input = "3.14";
            } 
            else {
                input = args[0];
            }
    
            float result = IsFloat.isFloat(input);
            System.out.println(result);
        }
    }
}
