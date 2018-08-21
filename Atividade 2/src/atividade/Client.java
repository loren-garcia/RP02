package atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends Country {

    private String clientName;
    private String clientPhone;
    private double clientCredit;
    private Country clientCountry;
    private int clientAge;
    public static List<Client> list = new ArrayList<Client>();

    public Client() {

    }

    public Client(String clientName, String clientPhone, Country clientCountry, int clientAge) {
        this.setClientName(clientName);
        this.setClientPhone(clientPhone);
        this.setClientCountry(clientCountry);
        this.setClientAge(clientAge);
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public void setClientCredit(double clientCredit) {
        this.clientCredit = clientCredit;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public void setClientCountry(Country clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public double getClientCredit() {
        return clientCredit;
    }

    public int getClientAge() {
        return clientAge;
    }

    public Country getClientCountry() {
        return clientCountry;
    }

    public void checkCreditByAge() {

        if (getClientAge() <= 18) {
            this.setClientCredit(100);
        } else if (getClientAge() > 18 && getClientAge() < 35) {
            this.setClientCredit(300);
        } else {
            this.setClientCredit(500);
        }
    }

    public void checkCredit() {

        this.checkCreditByAge();
        if (this.clientCountry.getCountryName() == "Brazil") {
            this.setClientCredit(getClientCredit() + 100);;
        }
    }

    public boolean verifyClientName(List<Client> list, String clientName) {
        final String clientNameVerification = clientName;
        Client clientVerification = list.stream()
                .filter(x -> clientNameVerification.equals(x.getClientName()))
                .findAny()
                .orElse(null);

        if (clientVerification != null) {
            return true;
        } else {
            return false;
        }
    }

    public void registerClient() {
        String clientName;
        String clientPhone;
        int clientAge;
        boolean typeLenght = true;
        boolean typeName = true;
        boolean exitRegistration = false;
        Scanner read = new Scanner(System.in);

        do {
            System.out.println("Type client's name: ");
            clientName = read.next();
            if (clientName.isEmpty() || clientName == null) {
                System.out.println("Client's name cannot be null!");
                typeLenght = false;
            } else if (clientName.length() < 5) {
                System.out.println("Client's name cannot have less then 5 characters!");
                typeLenght = false;
            } else {
                typeLenght = true;
            }
            if (this.verifyClientName(list, clientName)) {
                System.out.println("Client name already exists!");
                typeName = false;
            }
        } while (typeLenght == false || typeName == false);

        System.out.println("Type client's age: ");
        clientAge = read.nextInt();

        //Cliente Country registration and verification
        System.out.println("Type client's country: ");
        String countryName = read.next();
        Country countryNameInstance = new Country();

        if (!countryNameInstance.verifyCountryName(countryName)) {
            int registerCode = -1;
            do {
                System.out.println("Country not found, do you want to register?");
                System.out.println("1 - Yes | 2 - No");
                registerCode = read.nextInt();
                if (registerCode == 1) {
                    countryNameInstance.registerCountry();
                    countryNameInstance = countryNameInstance.verifyAndReturnCountryName(countryName);
                } else if (registerCode == 2) {
                    System.out.println("Exiting client registration.");
                    exitRegistration = true;
                } else {
                    System.out.println("Invalid option, try again.");
                }
            } while (registerCode != 1 && registerCode != 2);
        }
        if (!exitRegistration) {
            //Client Phone registration and verification
            do {
                System.out.println("Type client's phone: ");
                clientPhone = read.next();

                if (clientPhone.isEmpty() || clientName == null) {
                    System.out.println("Client's phone cannot be null!");
                    typeLenght = false;
                } else if (clientPhone.length() < 5) {
                    System.out.println("Client's phone cannot have less then 5 characters!");
                    typeLenght = false;
                } else {
                    typeLenght = true;
                }

                if (!countryNameInstance.verifyCountryTelCode(clientPhone) && typeLenght == true) {
                    System.out.println("Country not found, please type again");
                    typeLenght = false;
                }
            } while (typeLenght == false);

            Client ct = new Client(clientName, clientPhone, countryNameInstance, clientAge);

            ct.checkCredit();

            list.add(ct);
        }
    }

    public void showClients() {
        if (list == null) {
            System.out.println("There is no clients registered.");
        } else {
            System.out.println("Clients:");
            list.stream().forEach((x) -> printClient(x));
        }
    }

    public void printClient(Client cli) {
        System.out.println("-------------------------");
        System.out.println("Name: " + cli.getClientName());
        System.out.println("Age: " + cli.getClientAge());
        System.out.println("Credit: " + cli.getClientCredit());
        System.out.println("Country: " + cli.getClientCountry().getCountryName());
        System.out.println("-------------------------");
    }
}
