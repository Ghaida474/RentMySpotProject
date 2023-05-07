package com.example.rentmyspot;

public class Seating {

    String userneme;
    String Sname;
    String Scategory;
    int Sprice;
    String Sdescription;

    public Seating(String userneme, String Sname, String Scatogary, int Sprice, String Sdescription) {
       this.userneme = userneme;
        this.Sname = Sname;
        this.Scategory = Scatogary;
        this.Sprice = Sprice;
        this.Sdescription = Sdescription;
    }

    public Seating(){}


 public String getUserneme() {
        return userneme;
    }

    public void setUserneme(String userneme) {
        this.userneme = userneme;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getScategory() {
        return Scategory;
    }

    public void setScategory(String scatogary) {
        Scategory = scatogary;
    }

    public int getSprice() {
        return Sprice;
    }

    public void setSprice(int sprice) {
        Sprice = sprice;
    }

    public String getSdescription() {
        return Sdescription;
    }

    public void setSdescription(String sdescription) {
        Sdescription = sdescription;
    }

    @Override
    public String toString() {
        return "Seating{" +
                "userneme='" + userneme + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Scategory='" + Scategory + '\'' +
                ", Sprice=" + Sprice +
                ", Sdescription='" + Sdescription + '\'' +
                '}';
    }
}
