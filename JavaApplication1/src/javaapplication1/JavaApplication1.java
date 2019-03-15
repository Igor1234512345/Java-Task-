/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.sun.javafx.collections.MappingChange.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author ййй
 */
public class JavaApplication1 {

public static class Passenger {
    private String name;
    private String passport;
    private int flightNumber;

    Passenger(String name, String passport, int flightNumber) {
        this.name = name;
        this.passport = passport;
        this.flightNumber = flightNumber;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setPassport(String passport) {
        this.passport = passport;
    }

    String getPassport() {
        return passport;
    }

    void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    int getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return getName() + " " + getPassport();
    }
}
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        TreeMap<Integer, List<Passenger>> passengersMap = new TreeMap<Integer, List<Passenger>>();

        //List of flights
        List<Passenger> flight1 = new ArrayList<>();
        List<Passenger> flight2 = new ArrayList<>();
        List<Passenger> flight3 = new ArrayList<>();
        List<Passenger> flight4 = new ArrayList<>();

        System.out.println("Valid flight numbers: 1, 2, 3, 4\n");

        //Registration
        for (int i = 1; i < 4; i++) {
            System.out.println("Register passenger №" + i);
            System.out.println("enter: name passport flightNumber");
            String name = sc.next();
            String passport = sc.next();
            int flightNumber = sc.nextInt();
            
            switch (flightNumber) {
                case 1 : flight1.add(new Passenger(name, passport, flightNumber)); break;
                case 2 : flight2.add(new Passenger(name, passport, flightNumber)); break;
                case 3 : flight3.add(new Passenger(name, passport, flightNumber)); break;
                case 4 : flight4.add(new Passenger(name, passport, flightNumber)); break;
                default : System.out.println("invalid flight number");
            }
        }

        //Sort by name
        Comparator<Passenger> c = (name1, name2) -> name1.getName().compareToIgnoreCase(name2.getName());
        flight1.sort(c);
        flight2.sort(c);
        flight3.sort(c);
        flight4.sort(c);

        //Add to map
        passengersMap.put(1, flight1);
        passengersMap.put(2, flight2);
        passengersMap.put(3, flight3);
        passengersMap.put(4, flight4);

    //View map
    passengersMap.entrySet().stream().map((e) -> {
        System.out.println("FLIGHT NUMBER " + e.getKey() + " passengers:");
        return e;
    }).map((e) -> {
        for (Passenger pp : (ArrayList<Passenger>)e.getValue()) {
            System.out.println("  " + pp.getName() + " " + pp.getPassport());
        }
        return e;
    }).forEachOrdered((e) -> {
        System.out.println("Total passengers count: " + ((ArrayList<Passenger>) e.getValue()).size() + "\n");
    });
    }
    }
    
