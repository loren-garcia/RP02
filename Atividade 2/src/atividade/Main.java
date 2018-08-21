package atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    

    public static void main(String[] args) {

        Client client = new Client();
        Country country = new Country();
        Scanner read = new Scanner(System.in);

        
        int option = 0;
        boolean typeLenght = true;
        boolean typeName = true;
        boolean typeCountry = true;

        while (option != 5) {

            Client ct = new Client();
            System.out.println("Credit system verification");
            System.out.println("--------------------------");
            System.out.println("1 - Register client");
            System.out.println("2 - Register country");
            System.out.println("3 - Show client");
            System.out.println("4 - Show country");
            System.out.println("5 - Exit");
            System.out.println("--------------------------");
            System.out.println("Choose an option: ");
            option = read.nextInt();

            if (option == 1) {
                client.registerClient();
            }else if (option == 2) {
                country.registerCountry();
            }else if (option == 3) {
                client.showClients();
            }else if (option == 4) {
                country.showCountries();
            }else if (option == 5) {
                System.out.println("Bye");
                break;
            }else{
                System.out.println("Wrong option! Type again!");
            }
        }
    }
}
