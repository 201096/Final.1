import controllers.Medical_centerControllers;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class MyApplication {
    private final Medical_centerControllers medical_centerControllers;
    private final Scanner scanner;

    public MyApplication(Medical_centerControllers medical_centerControllers) {
        this.medical_centerControllers = medical_centerControllers;
        scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            System.out.println("Choose the option:\n" +
                    "1)Search for a client by name\n" +
                    "2)Get client's info by clients_id\n" +
                    "3)Remove client to DB\n" +
                    "4)Add the client by id\n" +
                    "Input another number to stop");
            int choice = scanner.nextInt();

            if (choice == 1) {
                searchMedical_centerByNameMenu();
            } else if (choice == 2) {
                removeMedical_centerMenu();
            } else if (choice == 3) {
                getMedical_centerById();
            } else if (choice == 4) {
                addMedical_centerMenu();
            }  else {
                break;
            }

            System.out.println("-------------------------------------------------------");
        }
    }

    public void searchMedical_centerByNameMenu(){
        System.out.println("Write the clients name");
        String name = scanner.next();
        String result = medical_centerControllers.searchedMedical_centerByName(name);
        System.out.println(result);
    }

   /* public void searchMedical_centerBySurnameMenu(){
        System.out.println("Write the clients Surname");
        String name = scanner.next();
        String result = medical_centerControllers.searchedMedical_centerBySurname(Surname);
        System.out.println(result);
    }*/



    public void getMedical_centerById(){
        System.out.println("Write the clients id");
        int id = scanner.nextInt();
        String result = medical_centerControllers.getMedical_centerById(id);
        System.out.println(result);
    }

    public void addMedical_centerMenu(){
        System.out.println("Write the clients Name");
        String name = scanner.next();
        System.out.println("Write the clients Surname");
        String Surname = scanner.next();
        System.out.println("Write the clients Phone Number");
        Integer Phone_Number = scanner.nextInt();

        System.out.println("Write the clients Issue");
        String Issue = scanner.next();
        String result = medical_centerControllers.addMedical_center(name,Surname,Phone_Number, Issue);
        System.out.println(result);


    }

    public void removeMedical_centerMenu(){
        System.out.println("Write the clients id to remove");
        int id = scanner.nextInt();
        String result = medical_centerControllers.removeMedical_centerById(id);
        System.out.println(result);

    }

}