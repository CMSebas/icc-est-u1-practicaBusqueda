package view;

import models.Person;


import java.util.Scanner;

public class View {
    Scanner leer = new Scanner(System.in);

    public int showMenu(){
        System.out.println("Ingresa la opcion que deseas buscar");
        int option = leer.nextInt();
        return option;
    }

    public Person inputPerson(){
        System.out.println("Ingrese el nombre: ");
        String nombre=leer.next();
        System.out.println("Ingresa la edad de la persona: ");
        int edad=leer.nextInt();
        System.out.println("");
        Person p=new Person(nombre,edad);
        return p;

    }

    public void displayPerson(Person[] p){
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }

    public int selectSortingMethod() {
        System.out.println("\nSelecciona el método de ordenamiento:");
        System.out.println("1. Burbuja por nombre (ascendente)");
        System.out.println("2. Selección por nombre (descendente)");
        System.out.println("3. Inserción por edad (ascendente)");
        System.out.println("4. Inserción por nombre (ascendente)");
        System.out.print("Opción: ");
        return leer.nextInt();
    }

    public void displaySearchResult(Person p) {
        if (p != null) {
            System.out.println("Resultado encontrado: " + p);
        } else {
            System.out.println("No se encontró ninguna persona.");
        }
    }


    public int inputAge() {
        System.out.println("Ingresa la edad de la persona que quieres buscar: ");
        int edad=leer.nextInt();
        return edad;

    }
}
