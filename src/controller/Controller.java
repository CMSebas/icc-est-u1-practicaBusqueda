package controller;

import models.Person;
import view.View;
/**
 * Clase Controller: Coordina la lógica de la aplicación.
 * Conecta la vista (entrada/salida del usuario), los métodos de ordenamiento y búsqueda,
 * y gestiona las acciones sobre el arreglo de personas.
 */
public class Controller {
    private View view;//Objeto para manejar como se ve y el ingreso de datos
    private Person[] persons; //Arreglo de personas gestionado por el sistema
    private SortingMethods sortingMethods;//objeto para manejar los metodos de ordenamiento
    private SearchMethods searchMethods;//objeto para manejar las busquedas

    /**
     * Constructor de la clase Controller.
     * Inicializa los componentes esenciales del controlador.
     *
     */


    public Controller(View view,SortingMethods sortingMethods,SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;

    }

    public void start() {//INICIA Y CONTROLA EL FLUJO DEL PROGRAMA
        boolean begin=true;
        while (begin) {
            int option=view.showMenu();
            switch(option) {
                case 1:
                    inputPerson();//LLAMA AL METODO PARA INGRESAR LAS PERSONAS
                    break;
                case 2:
                    addPerson();//PERMITE AGREGAR PERSONAS A UNA LISTA
                    break;
                case 3:
                    view.displayPerson(persons);//IMPRIME EL ARREGLO DE COMO ESTAN AHORA LAS PERSONAS
                    break;
                case 4:
                    sortPerson();//LLAMA AL METODO PARA PODER ORDENAR
                    break;
                case 5:
                    searchPerson();//LLAMA AL METODO PARA PODER BUSCAR
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    begin = false;
                    break;
                default:

            }

        }

    }

    public void inputPerson() {//INGRESA multiples personas desde la consola
        System.out.print("¿Cuántas personas deseas ingresar? ");
        int n = new java.util.Scanner(System.in).nextInt();
        persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = view.inputPerson();
        }

    }

    public void addPerson() {//Agrega una persona a una lista
        Person newPerson = view.inputPerson();
        if (persons == null) {
            persons = new Person[] { newPerson };
        } else {
            Person[] temp = new Person[persons.length + 1];
            for (int i = 0; i < persons.length; i++) {
                temp[i] = persons[i];
            }
            temp[persons.length] = newPerson;
            persons = temp;
        }

    }
    public void sortPerson() {//Ordena dependiendo que eliga el usuario
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para ordenar.");
            return;
        }


        int optionMethod= view.selectSortingMethod();
        //Muestra los métodos de ordenamiento disponibles y aplica el seleccionado
        if(optionMethod==1) {
            sortingMethods.sortByNameWithBubble(persons);
            view.displayPerson(persons);
        }else if(optionMethod==2) {
            sortingMethods.sortByNameWithSelection(persons);
            view.displayPerson(persons);
        }else if(optionMethod==3) {
            sortingMethods.sortByAgeWithInsertion(persons);
            view.displayPerson(persons);
        }else if(optionMethod==4) {
            sortingMethods.sortByNameWithInsertion(persons);
            view.displayPerson(persons);
        }

    }

    /**
     * Permite al usuario buscar una persona por nombre o edad,
     * o verificar si el arreglo está ordenado por edad o nombre.
     */

    public void searchPerson() {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para buscar.");
            return;
        }
        int optionMethod= view.selectSearchCriterion();



        if(optionMethod==1) {
            int ageSearch=view.inputAge();
            view.displaySearchResult(searchMethods.binarySearchByAge(persons,ageSearch));
        }else if(optionMethod==2) {
            String nameSearch=view.inputName();
            view.displaySearchResult(searchMethods.binarySearchByName(persons,nameSearch));
        }else if(optionMethod==3) {
            if (persons == null || persons.length == 0) {
                System.out.println("No hay personas ingresadas para verificar orden.");
                return;
            }
            boolean estado=searchMethods.isSortedByAge(persons);
            if(estado) {
                System.out.println("Si esta ordenado por edad");
            }else {
                System.out.println("No esta ordenado por edad");
            }
        } else if (optionMethod==4) {
            boolean estado2=searchMethods.isSortedByName(persons);
            if(estado2) {
                System.out.println("Si esta ordenado por Nombre");
            }else {
                System.out.println("No esta ordenado por Nombre de forma ascedente");
            }

        }
    }


}
