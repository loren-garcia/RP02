package atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Country {

    private String countryName;
    private String countryNickname;
    private String countryTelCode;
    public static List<Country> listCountry = new ArrayList<Country>();

    public Country() {

    }

    public Country(String countryName, String countryNickname, String countryTelCode) {
        this.countryName = countryName;
        this.countryNickname = countryNickname;
        this.countryTelCode = countryTelCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryNickname(String countryNickname) {
        this.countryNickname = countryNickname;
    }

    public void setCountryTelCode(String countryTelCode) {
        this.countryTelCode = countryTelCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryNickname() {
        return countryNickname;
    }

    public String getCountryTelCode() {
        return countryTelCode;
    }

    public static boolean verifyCountryName(String countryName) {
        final String countryNameVerification = countryName;
        Country countryVerification = listCountry.stream()
                .filter(x -> countryNameVerification.equals(x.getCountryName()))
                .findAny()
                .orElse(null);

        if (countryVerification != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verifyCountryNickname(String countryNickame) {
        final String countryNameVerification = countryNickame;
        Country countryVerification = listCountry.stream()
                .filter(x -> countryNameVerification.equals(x.getCountryNickname()))
                .findAny()
                .orElse(null);

        if (countryVerification != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verifyCountryTelCode(String countryTelCode) {
        final String countryNameVerification = countryTelCode.substring(0,3);
        Country countryVerification = listCountry.stream()
                .filter(x -> countryNameVerification.equals(x.getCountryTelCode()))
                .findAny()
                .orElse(null);

        if (countryVerification != null) {
            return true;
        } else {
            return false;
        }
    }

    public static Country verifyAndReturnCountryName(String countryName) {
        final String countryNameVerification = countryName;
        Country countryVerification = listCountry.stream()
                .filter(x -> countryNameVerification.equals(x.getCountryName()))
                .findAny()
                .orElse(null);

        if (countryVerification != null) {
            return countryVerification;
        } else {
            return null;
        }
    }

    public void registerCountry() {
        Scanner read = new Scanner(System.in);
        String countryName;
        String countryNickName;
        String countryTelCode;
        boolean typeVerification = true;

        do {
            //Save the name
            System.out.println("Type country's name: ");
            countryName = read.next();
            if (countryName.isEmpty() || countryName == null) {
                System.out.println("Country's name cannot be null!");
                typeVerification = false;
            } else if (countryName.length() < 5) {
                System.out.println("Country's name cannot have less then 5 characters!");
                typeVerification = false;
            }

            if (this.verifyCountryName(countryName)) {
                System.out.println("Country name already exists!");
                typeVerification = false;
            }
        } while (typeVerification == false);

        do {
            System.out.println("Type country's nickname: ");
            countryNickName = read.next();
            if (countryNickName.isEmpty() || countryNickName == null) {
                System.out.println("Country's nickname cannot be null!");
                typeVerification = false;
            } else if (countryNickName.length() > 5) {
                System.out.println("Country's nickname cannot have more then 5 characters!");
                typeVerification = false;
            }
            //
            if (this.verifyCountryNickname(countryName)) {
                System.out.println("Country nickname already exists!");
                typeVerification = false;
            }
        } while (typeVerification == false);

        do {
            //
            System.out.println("Type country's phonecode: ");
            countryTelCode = read.next();
            if (countryTelCode.isEmpty() || countryTelCode == null) {
                System.out.println("Country's phonecode cannot be null!");
                typeVerification = false;
            } else if (countryTelCode.length() > 5) {
                System.out.println("Country's phonecode cannot have more then 5 characters!");
                typeVerification = false;
            }

            if (this.verifyCountryTelCode(countryTelCode)) {
                System.out.println("Country's phonecode already exists!");
                typeVerification = false;
            }
        } while (typeVerification == false);

        Country registrationCountry = new Country(countryName, countryNickName, countryTelCode);
        listCountry.add(registrationCountry);
    }

    public void showCountries() {
        if (listCountry == null) {
            System.out.println("There is no country registered.");
        } else {
            System.out.println("Countries:");
            listCountry.stream().forEach((x) -> printCountry(x));
        }
    }
    
    public void printCountry(Country ct){
        System.out.println("-------------------------");
        System.out.println("Name: "+ct.getCountryName());
        System.out.println("Nickname: "+ct.getCountryNickname());
        System.out.println("Phone Code: "+ct.getCountryTelCode());
        System.out.println("-------------------------");
    }

}
