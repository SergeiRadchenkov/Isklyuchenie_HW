/*
Напишите программу для выполнения арифметической операции деления двух целых чисел a и b.
При этом программа должна проверить, что делитель b не равен нулю, и выполнить деление только в этом случае.
Если b равен нулю, программа должна вывести сообщение о невозможности выполнения операции и вернуть результат равный нулю.
После выполнения операции деления, программа также должна вывести сумму чисел a и b с помощью метода printSum.
Если аргументы не переданы через командную строку, используйте значения по умолчанию.
 */

public class task3 {
    class Expr {
        public static double expr(int a, int b) {
            System.out.println(a + b);
            double c;
            if (b != 0) {
                c = (double) a / b;
                return c;
            }
            else return 0;
    }
    
        public static void printSum(int a, int b) {
            System.out.println(a + b);
        }
    }
    
    public class Printer {
        public static void main(String[] args) {
            int a;
            int b;
    
            if (args.length == 0) {
                a = 5;
                b = 0;
            } else {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
            } 
    
            double result = Expr.expr(a, b);
            System.out.println(result);
        }
    }
}
