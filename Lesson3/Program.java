/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество дата _ рождения номер _ телефона пол

Форматы данных:

фамилия, имя, отчество - строки
дата _ рождения - строка формата dd.mm.yyyy
номер _ телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

package Lesson3;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        String[] clientData = null;
        while (clientData == null) {
            try {
                clientData = data();
            } catch (WrongDataException e) {
                System.out.println(e.getMessage());
            }
        }
        makeFile(clientData);
    }
    
    static String[] data() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Введите данные пользователя, разделенные пробелом");
        System.out.println("Фамилия Имя Отчество дата _ рождения номер _ телефона пол");
        System.out.println("Пол укажите латиницей f - женский, m - мужской");
        System.out.println("Пример: Иванов Иван Иванович 01.01.2001 89009009090 m");
        String clientData = scanner.nextLine();
        String[] userData = clientData.split("\\s+");
        if (userData.length != 6) {
            throw new WrongDataException("Неверные данные: введите данные клиента согласно примеру.");
        }
        if (userData[0].length() < 3 || userData[1].length() < 3 || userData[2].length() < 3) {
            throw new WrongNameException("Неверные данные: фамилия, имя и отчество должны содержать не менее трех символов.");
        }
        dateFormat.setLenient(false);
        try {
            Date birthDate = dateFormat.parse(userData[3]);
        } catch (ParseException e) {
            throw new WrongDateException("Неверные данные: дата рождения должна быть в формате dd.mm.yyyy.");
        }
        if (!userData[4].matches("\\d{11}")) {
            throw new WrongPhoneNumberException("Неверные данные: номер телефона должен состоять из 11 цифр без пробелов и других символов.");
        }
        if (!userData[5].equals("f") && !userData[5].equals("m")) {
            throw new WrongGenderException("Неверные данные: пол должен быть указан как f (женский) или m (мужской).");
        }
        return userData;
    }

    private static void makeFile(String[] array){
        String lastName = array[0];
        String fileName = lastName + ".txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (int i = 0; i < array.length - 1; i++) {
                fileWriter.write(array[i] + " ");
            }
            fileWriter.write(array[array.length - 1] + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }
}
