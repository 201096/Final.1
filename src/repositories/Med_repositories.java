package repositories;

import data.interfaces.IDBManager;
import entities.Medical_center;
import repositories.interfaces.IMed_repositories;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Med_repositories implements IMed_repositories {
    private final IDBManager dbManager;

    public Med_repositories(IDBManager dbManager) {
        this.dbManager = dbManager;
    }


    @Override
    public ArrayList<Medical_center> searchMedical_centerByName(String Name) {

        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  Medicalcenter WHERE name LIKE'%" + Name + "'");

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Medical_center> medical_centers = new ArrayList<>();
            while (resultSet.next()) {
                Medical_center medical_center = new Medical_center(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getInt("Phone_Number"),
                        resultSet.getDate("Date_of_Birth").toLocalDate(),
                        resultSet.getString("Issue"));

                medical_centers.add(medical_center);

            }
            return medical_centers;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public Medical_center getMedical_centerById(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  Medicalcenter WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Medical_center medical_center = new Medical_center();
            if (resultSet.next()) {
                medical_center.setId(resultSet.getInt("id"));
                medical_center.setName(resultSet.getString("Name"));
                medical_center.setSurname(resultSet.getString("Surname"));
                medical_center.setPhone_Number(resultSet.getInt("Phone_Number"));
                medical_center.setDate_of_Birth(resultSet.getDate("Date_of_Birth").toLocalDate());
                medical_center.setIssue(resultSet.getString("Issue"));

            }
            return medical_center;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean addMedical_center(Medical_center medical_center) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Medicalcenter(Name,Surname,Phone_Number, Date_of_Birth, Issue) VALUES (?,?,?,?,?)");

            preparedStatement.setString(1, medical_center.getName());
            preparedStatement.setString(2, medical_center.getSurname());
            preparedStatement.setInt(3, medical_center.getPhone_Number());
            preparedStatement.setDate(4, Date.valueOf(medical_center.getDate_of_Birth()));
            preparedStatement.setString(5, medical_center.getIssue());

            preparedStatement.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean removeMedical_centerById(int id) {

        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Medicalcenter WHERE id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}