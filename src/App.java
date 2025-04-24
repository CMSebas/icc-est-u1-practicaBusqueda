
import controller.Controller;
import controller.SearchMethods;
import controller.SortingMethods;
import models.Person;
import view.View;

public class App {
    public static void main(String[] args) {

        View console=new View();
        SortingMethods sortingMethods=new SortingMethods();
        SearchMethods searchMethods=new SearchMethods();
        Controller controller=new Controller(console,sortingMethods,searchMethods);
        controller.inputPerson();
        controller.sortPerson();







    }
}
