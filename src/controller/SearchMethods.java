package controller;

import models.Person;

public class SearchMethods {
    public Person binarySearchByAge(Person[] persons,int searchAge) {
        int low=0;
        int high=persons.length-1;

        while(low<=high) {
            int central=(high-low)/2;
            int edad=persons[central].getAge();

            if(edad==searchAge) {
                return persons[central];
            }else if(edad>searchAge) {
                low=central-1;
            }else {
                high=central+1;
            }
        }
        return null;

    }
}

