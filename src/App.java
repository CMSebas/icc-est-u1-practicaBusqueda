
import controller.Controller;
import controller.SearchMethods;
import controller.SortingMethods;
import models.Person;
import view.View;

public class App {
    public static void main(String[] args) {

        // Instancia de la vista para gestionar la interacción con el usuario
        View console = new View();

        // Instancia de la clase con métodos de ordenamiento
        SortingMethods sortingMethods = new SortingMethods();

        // Instancia de la clase con métodos de búsqueda y verificación de orden
        SearchMethods searchMethods = new SearchMethods();

        // Controlador principal: orquesta vista, ordenamientos y búsquedas
        Controller controller = new Controller(console, sortingMethods, searchMethods);

        // Inicia la ejecución del sistema mostrando el menú principal
        controller.start();







    }
}