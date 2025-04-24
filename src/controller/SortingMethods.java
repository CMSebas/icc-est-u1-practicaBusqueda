package controller;

import models.Person;

public class SortingMethods {
    public void sortByNameWithBubble(Person[] persons){
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

    public void sortByNameWithSelection(Person[] persons){
        for (int i = 0; i < persons.length - 1; i++) {
            int minimo = i;

            for (int j = i + 1; j < persons.length; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[minimo].getName()) < 0) {
                    minimo = j;
                }
            }

            Person temp = persons[minimo];
            persons[minimo] = persons[i];
            persons[i] = temp;
        }

    }

    public void sortByAgeWithInsertion(Person[] persons){
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

    public void sortByNameWithInsertion(Person[] persons){
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

