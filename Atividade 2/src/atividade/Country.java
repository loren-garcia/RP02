package atividade;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String countryName;
    private String countryNickname;
    
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public void setCountryNickname(String countryNickname) {
        this.countryNickname = countryNickname;
    }
    
    public String getCountryName() {
        return countryName;
    }
    public String getCountryNickname() {
        return countryNickname;
    }
    
    public void checkCountry(String countryName) {
        
        List<Client> list = new ArrayList<Client>();
        
        for(int i = 0; i < list.size(); i++) {                 
            if(countryName.equalsIgnoreCase(list.get(i).getCountryName())) {
                System.out.println("Country already exists!");
            }    
        }
        if(countryName == null || countryName.isEmpty()) {
            System.out.println("Country name cannot be null or empty!");
        }
    }
}
