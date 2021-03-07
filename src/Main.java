import controllers.Medical_centerControllers;
import data.DBManager;
import data.interfaces.IDBManager;
import repositories.Med_repositories;
import repositories.interfaces.IMed_repositories;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IMed_repositories med_repositories = new Med_repositories(dbManager);
        Medical_centerControllers medical_centerControllers = new Medical_centerControllers(med_repositories);
        MyApplication myApplication = new MyApplication(medical_centerControllers);
        myApplication.start();
    }
}
