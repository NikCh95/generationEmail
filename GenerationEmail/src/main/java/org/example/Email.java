package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

/**
 * Класс данных для генерации email по типу (lastNamefirstName@departament.com)
 * @author Никита Черненко
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    //Имя пользователя
    private String firstName;
    //Фамилия пользователя
    private String lastName;
    //пароль входа в почту
    private String password;
    //департамент (отдел)
    private String department;
    //вместимость постового ящика
    private int mailBox;
    //альтернативная электронная почта
    private String alternateEmail;
    // сгенерированный email
    private String email;

    private String resultEmail;
    private final String com = "company.com";

    private  int defaultPasswordLenght = 8;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Информация о клиенте: " + this.firstName+ " " + this.lastName);

        this.department = setDepartment();
        System.out.println("Department:"+ this.department);

        this.password = randomPassword(defaultPasswordLenght);
        System.out.println("Твой пароль: " + this.password);

        this.resultEmail = generationEmail();
        System.out.println("Твоя электронная почта:" +this.resultEmail);
    }

    /**
     * Метод по выбору отдела для которого создается почта
     * @return
     */
    private String setDepartment() {

        System.out.println("Ввойди в департамен: \n1 Продажи \n2 Разработка \n3 Бугалтерия " +
                "\n0 for none! \n Введите код для продолжения: " );

        Scanner in = new Scanner(System.in);

        while (true) {
            int choosing = in.nextInt();
            boolean u = (choosing == 1 || choosing == 2 || choosing == 3 || choosing == 0);
            if (choosing == 1) {
                return "sales";
            } else if (choosing == 2) {
                return "development";
            } else if (choosing == 3) {
                return "accounting";
            } else {
                break;
            }
        }
        return setDepartment();
    }

    /**
     * Метод для генерации пароля
     */
    private String randomPassword(int password) {
        String alphabet = "ABCDEFGHIKLMNOPQRSTVXYZ";
        String alphabet1 = alphabet.toLowerCase();
        String number = "123456789";
        String sim = "!#@%&";
        String common = alphabet + number + sim + alphabet1;

        char[] password1 = new char[password];
        for(int i = 0; i < password; i++) {
            int rand = (int) (Math.random() * common.length());
            password1[i] = common.charAt(rand);
        }
        return new String(password1);
    }

    /**
     * Метод получения готовой электронной почты
     * @return
     */
    private String generationEmail() {
      email = lastName.toLowerCase() + "." +firstName.toLowerCase() +"@"+ department+ "." +com;
     return email;
    }

    /**
     * Метод по установлению максимальной вместительности почты
     * @param max
     */
    public void setMailBox(int max) {
        this.mailBox = max;
    }

    /**
     * Метод для установления собственного email
     * @param altEmail
     */
    public void setSpareEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public int getMailBox() {
        return mailBox;
    }

    public String getSpareEmail() {
        return alternateEmail;
    }

    public String info() {
        return "Фамилия и Имя: "+lastName+ " " +firstName +"\n"+
                "Email: " +email+ "\n"+
                "password: "+ password;

    }
}
