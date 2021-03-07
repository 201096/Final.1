package repositories.interfaces;

import entities.Medical_center;
import java.util.ArrayList;

public interface IMed_repositories {
    public ArrayList<Medical_center> searchMedical_centerByName(String Name);
    //public ArrayList<Medical_center> searchMedical_centerBySurname(String Surname);

    public Medical_center getMedical_centerById(int id);
    public boolean addMedical_center (Medical_center medical_center);
    public boolean removeMedical_centerById(int id);

}
