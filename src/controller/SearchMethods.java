package controller;

import models.Person;

public class SearchMethods {
    public Person binarySearchByAge(Person[] persons,int searchAge) {//realiza busqueda binaria buscando por una edad especifica
        int low=0;
        int high=persons.length-1;

        while(low<=high) {
            int central=(high+low)/2;
            int age=persons[central].getAge();

            if(age==searchAge) {
                return persons[central];
            }else if(age>searchAge) {
                high=central-1;
            }else {
                low=central+1;
            }
        }
        return null;

    }

    public Person binarySearchByName(Person[] persons,String searchName) {//realiza busqueda binaria buscando un nombre especifico
        int low=0;
        int high=persons.length-1;


        while(low<=high) {
            int central=(high+low)/2;
            String name=persons[central].getName();
            int compare = name.compareToIgnoreCase(searchName);

            if(compare==0) {
                return persons[central];
            }else if(compare>0) {
                high=central-1;
            }else {
                low=central+1;
            }
        }
        return null;

    }
    public boolean isSortedByAge(Person[] persons){//retorna un true o false viendo si esta ordenado por numeros
        for (int i = 1; i < persons.length; i++) {
            if (persons[i-1].getAge() > persons[i].getAge()) {
                return false;
            }
        }
        return true;

    }

    public boolean isSortedByName(Person[] persons){//retorna un true o false viendo si esta ordenado por nombres
        if (persons == null || persons.length == 0) {
            return true; // Consideramos que un arreglo vacío está "ordenado"
        }

        for (int i = 1; i < persons.length; i++) {
            if (persons[i - 1].getName().compareToIgnoreCase(persons[i].getName()) > 0) {
                return false; // Si el anterior es "mayor", no está ordenado A → Z
            }
        }

        return true;

    }
}
