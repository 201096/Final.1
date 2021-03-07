package controllers;
import repositories.Med_repositories;
import repositories.interfaces.IMed_repositories;
import entities.Medical_center;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medical_centerControllers {
    private final IMed_repositories med_repositories;

    public Medical_centerControllers(IMed_repositories med_repositories) {
        this.med_repositories = med_repositories;
    }

    public String searchedMedical_centerByName (String name) {
        String result = med_repositories.searchMedical_centerByName(name).toString();

        return result;
    }

   /* public String searchedMedical_centerBySurname (String Surname) {
        String result = med_repositories.searchMedical_centerBySurname(Surname).toString();

        return result;
    }*/



    public String getMedical_centerById(int id){

        String result = med_repositories.getMedical_centerById(id).toString();
        return result;
    }

    public String addMedical_center( String name, String Surname, Integer Phone_Number, String Issue ){

        LocalDate Date_of_Birth = LocalDate.now();
        boolean added = med_repositories.addMedical_center(new Medical_center(name,Surname,Phone_Number,Date_of_Birth,Issue));

        if(added){
            return "You were added to Medical center database";
        }
        return "You were not added to Medical center database";
    }


    public String removeMedical_centerById(int id){
        boolean removed = med_repositories.removeMedical_centerById(id);
        if(removed){
            return "the Client was removed";
        }
        return "the Client was not removed";
    }

}
