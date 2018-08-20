package atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Client cl = new Client();
        Scanner read = new Scanner(System.in);
        List<Client> list = new ArrayList<Client>();
        
        String clientName;
        String countryName;
        String clientPhone;
        int clientAge;
        int option = 0;
        boolean typeLenght = true;
        boolean typeName = true;
        
        while(option != 3){
            
            Client ct = new Client();
            System.out.println("Choose an option: ");
            option = read.nextInt();
            
            if(option == 1){
                do{
                    System.out.println("Type client's name: ");
                    clientName = read.next();
                    
                    if(clientName.length() < 5) {
                        System.out.println("Client's name cannot have less then 5 characters!");
                        typeLenght = false;
                    }else if(clientName.contains("0")) {
                        System.out.println("Client's name cannot be null!");
                        typeLenght = false;
                    }else {
                        typeLenght = true;
                    }
                    
                    for(int i = 0; i < list.size(); i++) {
                        if(clientName.equalsIgnoreCase(list.get(i).getClientName())) {
                            System.out.println("Client name already exists!");
                            typeName = false;
                        }else {
                            typeName = true;
                        }
                    }                    
                }while(typeLenght == false || typeName == false);
                ct.setClientName(clientName);
                
                System.out.println("Type client's age: ");
                clientAge = read.nextInt();
                ct.setClientAge(clientAge);
                
                System.out.println("Type client's phone: ");
                clientPhone = read.next();
                ct.setClientPhone(clientPhone);

                System.out.println("Type client's country: ");
                countryName = read.next();
                ct.checkCountry(countryName);
                ct.setCountryName(countryName);
                ct.checkCredit();
                
                list.add(ct);
            }
            if(option == 2){
                for(int i = 0; i < list.size(); i++){
                    System.out.println(list.get(i).getClientName());
                    System.out.printf("%.2f %n", list.get(i).getClientCredit());
                }
            }
            if(option == 3){
                System.out.println("Bye");
                break;
            }
        }
    }
}
