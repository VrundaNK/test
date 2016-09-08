package com.company.datastructures.queue;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnagpurkar on 7/2/16.
 */
public class AnimalQueue<E> {

    List<Animal> dogs;
    List<Animal> cats;
    int headDog;
    int tailDog;
    int headCat;
    int tailCat;
    int SIZE = 10;

    public AnimalQueue(){

        dogs = new ArrayList<Animal>();
        cats = new ArrayList<Animal>();
        headDog = -1;
        tailDog = -1;
        headCat = -1;
        tailCat = -1;
    }

    public void enqueue(Animal animal) {

        if(animal.getType().equals(Type.CAT)) {
            headCat=++headCat;
            if(headCat < SIZE){
                cats.add(headCat, animal);
            }
            if(tailCat == -1){
               tailCat = headCat;
            }
        } else if(animal.getType().equals(Type.DOG)) {
            headDog=++headDog;
            if(headDog < SIZE){
                dogs.add(headDog, animal);
            }
            if(tailDog == -1){
                tailDog = tailCat;
            }
        }
    }

    public Animal dequeueAny(){
        Animal currentDog = dogs.get(tailDog);
        Animal currentCat = cats.get(tailCat);

        if(currentDog.getTimeStamp() < currentCat.getTimeStamp()){
            dogs.remove(tailDog);
            tailDog = tailDog + 1;
            return currentDog;
        } else {
            cats.remove(tailCat);
            tailCat = tailCat - 1;
            return currentCat;
        }
    }
    public Animal dequeueCat(){

        Animal currentCat = cats.get(tailCat);
        cats.remove(tailCat);
        tailCat = tailCat - 1;
        return currentCat;

    }
    public Animal dequeueDog(){
        Animal currentDog = dogs.get(tailDog);
        dogs.remove(tailDog);
        tailDog = tailDog + 1;
        return currentDog;
    }

}

class Animal {

    Type type;
    int timeStamp;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}

enum Type {

    CAT,
    DOG
}


