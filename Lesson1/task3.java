/*
Реализуйте метод divArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий новый массив с, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны - верните нулевой массив длины 1.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
Напишите свой код в методе divArrays класса Answer. Метод divArrays принимает на вход два параметра:
int[] a - первый массив
int[] b - второй массив
 */

import java.util.Arrays;

public class task3 {
    public static class Answer {
        public int[] divArrays(int[] a, int[] b){
            if(a == null || b == null || a.length != b.length){
                return new int[1];
            }
            else{
                int[] c = new int[a.length];
                for(int i = 0; i < a.length; i++){
                    if (b[i] == 0) throw new RuntimeException("Division by 0");
                    else c[i] = a[i] / b[i];
                }
                return c;
            }
        }
    }
    
    public class Printer{ 
        public static void main(String[] args) { 
          int[] a = {};
          int[] b = {};
          
          if (args.length == 0) {
            a = new int[]{12, 8, 16};
            b = new int[]{4, 2, 4};
          }
          else{
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
          }     
          
          Answer ans = new Answer(); 
          String itresume_res = Arrays.toString(ans.divArrays(a, b));     
          System.out.println(itresume_res);
        }
    }
}
