package controller;

import models.Person;

public class SortingMethods {
    public void sortByNameWithBubble(Person[] persons){//Metodo para ordenar en orden alfabetico con burbuja
        for (int i = 0; i < persons.length-1; i++) {
            for(int j = 0; j < persons.length - i - 1; j++){
                if(persons[j].getName().compareTo(persons[j+1].getName()) > 0){
                    Person temp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }
            }
        }

    }

    public void sortByNameWithSelection(Person[] persons){//ordena por la edad de manera ascdente con seleccion
        for (int i = 0; i < persons.length - 1; i++) {
            int max = i;

            for (int j = i + 1; j < persons.length; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[max].getName()) > 0) {
                    max = j;
                }
            }

            Person temp = persons[i];
            persons[i] = persons[max];
            persons[max] = temp;
        }

    }

    public void sortByAgeWithInsertion(Person[] persons){//ordena por medio de la edad usando insertion
        for (int i = 1; i < persons.length; i++) {
            int actual=persons[i].getAge();
            int j=i-1;
            Person temp=persons[i];

            while(j>=0 && persons[j].getAge()>actual){
                persons[j+1]=persons[j];
                j--;

            }
            persons[j+1]=temp;
        }

    }

    public void sortByNameWithInsertion(Person[] persons){//ordena por el nombre con insertion
        for (int i = 1; i < persons.length; i++) {

            int j=i-1;
            Person temp=persons[i];

            while(j>=0 && persons[j].getName().compareToIgnoreCase(temp.getName()) > 0){
                persons[j+1]=persons[j];
                j--;

            }
            persons[j+1]=temp;
        }

    }




}
