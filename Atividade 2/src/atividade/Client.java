package atividade;

public class Client extends Country {
    
    private String clientName;
    private String clientPhone;
    private double clientCredit;
    private int clientAge;
    
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
    
    public void checkCreditByAge() {
        
        if(getClientAge() <= 18) {
            setClientCredit(100);
        }else if(getClientAge() > 18 && getClientAge() < 35) {
            setClientCredit(300);
        }else {
            setClientCredit(500);
        }
    }
    
    public void checkCredit() {
        
        checkCreditByAge();
        if(getCountryName().equalsIgnoreCase("Brasil")) {
            setClientCredit(getClientCredit() + 100);;
        }
    }
}
