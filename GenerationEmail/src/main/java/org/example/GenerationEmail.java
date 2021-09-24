package org.example;

public class GenerationEmail {

    public static void main(String[] args) {
        Email email = new Email("Nikita", "Chernenko");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(email.info());
    }
}
