package com.company.lesson1_Generics;

import java.awt.datatransfer.FlavorEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 @author Abubakar Musanipov
**/
public class Generics {

    public static void main(String[] args) {
    }
    // Задача первая
    public static <T> void changePlace(T[] arr, int firstElemNum, int secondElemNum){
       T elem =  arr[firstElemNum];
       arr[firstElemNum] = arr[secondElemNum];
       arr[secondElemNum] = elem;
    }
    //Вторая задача
    public static <T> void arrayToArrayList(T[] array, ArrayList<T> arrayList){
        Collections.addAll(arrayList, array);
    }
    public static <T> void arrayToArrayList2(T[] array, ArrayList<T> arrayList){
        for (int i = 0; i < array.length ; i++) {
            arrayList.add(array[i]);
        }
    }
}
// Третья задача
class Fruit {
    private float weight;

    Fruit(float weight){
        this.weight = weight;
    }
    public float getWeight(){
        return weight;
    }

}
class Apple extends Fruit{
    public Apple() {
        super(1.0F);
    }
}
class Orange extends Fruit{
    Orange() {
        super(1.5f);
    }
}
class Box<T extends Fruit>  {
    ArrayList<T> fruits = new ArrayList<>();

    public int getSize(){
        return fruits.size();
    }

    public void pourOver(Box<T> otherBox){
        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public Float getWeight(){
        float res = 0.0F;
        for (int i = 0; i < getSize(); i++) {
            T ob =  fruits.get(i);
           res += ob.getWeight();
        }
        return res;
    }

    public void addFruit(T fruit){
        this.fruits.add(fruit);
    }
    public Boolean compare(Box<? extends Fruit> box){
        return Math.abs(this.getWeight() - box.getWeight()) >= 0
                && (Math.abs(this.getWeight() - box.getWeight()) < 0.0001);
    }

}
