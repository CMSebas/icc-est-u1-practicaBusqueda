package controller;

import models.Person;
import view.View;

public class Controller {
    private View view;
    private Person[] persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view,SortingMethods sortingMethods,SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;

    }

    public void start() {
        int option=view.showMenu();
        if(option==1) {
            inputPerson();
        }

    }

    public void inputPerson() {
        System.out.print("¿Cuántas personas deseas ingresar? ");
        int n = new java.util.Scanner(System.in).nextInt();
        persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = view.inputPerson();
        }

    }

    public void addPerson() {
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
    public void sortPerson() {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para ordenar.");
            return;
        }

        int optionMethod= view.selectSortingMethod();
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

    public void searchPerson() {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para buscar.");
            return;
        }
        int optionMethod= view.selectSortingMethod();
        int edadSearch=view.inputAge();

        if(optionMethod==1) {
            view.displaySearchResult(searchMethods.binarySearchByAge(persons,edadSearch));
        }
    }


}
