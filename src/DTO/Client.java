package DTO;

import java.time.LocalDate;

public final class Client extends Person {
    private String code;
    private String adress;

    public Client(String firstname, String lastname, LocalDate dateOfbirth, String phonenumber, String Code, String Aderess) {
        super(firstname, lastname, dateOfbirth, phonenumber);
        this.adress = Aderess;
        this.code = Code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

}
