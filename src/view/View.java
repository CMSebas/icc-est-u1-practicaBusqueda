package view;

import models.Person;


import java.util.Scanner;

public class View {
    Scanner leer = new Scanner(System.in);
    /**
     * Muestra el menú principal y retorna la opción seleccionada.
     * Realiza validación para aceptar solo valores entre 1 y 6.
     */
    public int showMenu() {
        int option;
        do {
            System.out.println("\n--------------MENÚ PRINCIPAL -------");
            System.out.println("1. Ingresar varias personas");
            System.out.println("2. Agregar una persona adicional");
            System.out.println("3. Mostrar todas las personas");
            System.out.println("4. Ordenar personas");
            System.out.println("5. Buscar persona");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción (1-6): ");
            option = leer.nextInt();
        } while (option < 1 || option > 6);
        return option;
    }

    public Person inputPerson(){//Solicita los datos de la persona y retorna un objeto con los datos ingresados
        System.out.println("Ingrese el nombre: ");
        String nombre=leer.next();
        System.out.println("Ingresa la edad de la persona: ");
        int edad=leer.nextInt();
        System.out.println("");
        Person p=new Person(nombre,edad);
        return p;

    }

    public void displayPerson(Person[] p){//Muestra en consola el arreglo de las personas
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }

    public int selectSortingMethod() {//El usuario selecciona un metodo de ordenamiento
        int option;
        do {
            System.out.println("\nSelecciona el método de ordenamiento:");
            System.out.println("1. Burbuja por nombre (ascendente)");
            System.out.println("2. Selección por nombre (descendente)");
            System.out.println("3. Inserción por edad (ascendente)");
            System.out.println("4. Inserción por nombre (ascendente)");
            System.out.print("Opción: ");
            option = leer.nextInt();
        } while (option < 1 || option > 4);
        return option;
    }

    public void displaySearchResult(Person p) {//Muestra si encontro algun resultado en la busqueda
        if (p != null) {
            System.out.println("Resultado encontrado: " + p);
        } else {
            System.out.println("No se encontró ninguna persona.");
        }
    }


    public int inputAge() {//El usuario ingresa la edad que desea
        System.out.println("Ingresa la edad de la persona que quieres buscar: ");
        int age=leer.nextInt();
        return age;

    }

    public String inputName() {//El usuario ingresa el nombre que quiere buscar
        System.out.println("Ingresa el nombre de la persona que quieres buscar: ");
        String name=leer.next();
        return name;

    }

    public int selectSearchCriterion() {//Permite elegir si buscar por nombre o edad y ver si estan ordenados
        int option;
        do {
            System.out.println("\nSelecciona si deseas buscar o ver:");
            System.out.println("1. Buscar por edad");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Mira si esta ordenado por edad");
            System.out.println("4. Mira si esta ordenado por nombre");
            System.out.print("Opción: ");
            option = leer.nextInt();
        } while (option < 1 || option > 4);
        return option;
    }
}
