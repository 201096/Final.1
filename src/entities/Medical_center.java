package entities;

import java.time.LocalDate;

public class Medical_center {
    private int id;
    private String Name;
    private String Surname;
    private int Phone_Number;
    private LocalDate Date_of_Birth;
    private String Issue;

    public Medical_center(){

    }

    public Medical_center(int id, String name, String surname, int phone_Number, LocalDate date_of_Birth, String issue) {
        this.id = id;
        this.Name = name;
        this.Surname = surname;
        this.Phone_Number = phone_Number;
        this.Date_of_Birth = date_of_Birth;
        this.Issue = issue;
    }

    public Medical_center(String name, String surname, int phone_Number, LocalDate date_of_Birth, String issue) {
        Name = name;
        Surname = surname;
        Phone_Number = phone_Number;
        Date_of_Birth = date_of_Birth;
        Issue = issue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        Phone_Number = phone_Number;
    }

    public LocalDate getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(LocalDate date_of_Birth) {
        Date_of_Birth = date_of_Birth;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }

    @Override
    public String toString() {
        return "Medical_center{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Phone_Number=" + Phone_Number +
                ", Date_of_Birth=" + Date_of_Birth +
                ", Issue='" + Issue + '\'' +
                '}';
    }
}



