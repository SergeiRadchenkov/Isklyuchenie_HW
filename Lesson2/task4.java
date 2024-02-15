/*
Напишите программу, которая принимает символ a в качестве аргумента и выполняет следующую проверку:
если символ a равен пробелу '', программа должна выбрасывать исключение с сообщением
"Пустая строка введена.".
В противном случае программа должна возвращать сообщение
"Ваш ввод - [символ]", где [символ] заменяется на введенный символ a.
 */

public class task4 {
    class Expr {
        public static String expr(char a) throws Exception {
            if (a == ' ') {
                throw new Exception("Пустая строка введена.");
            } else {
                return "Ваш ввод - " + a;
            }
        }
    }
    
    public class Printer {
        public static void main(String[] args) {
            char a;
    
            if (args.length == 0) {
                a = 'J';
            } else {
                a = args[0].charAt(0);
            }
    
            try {
                String result = Expr.expr(a);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
