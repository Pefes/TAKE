/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.PrimeFaces;

/**
 *
 * @author Pefes
 */
public class Student {
    private String name;
    private String surname;
    private long average;
    
    public Student(String name, String surname, long average) {
        this.name = name;
        this.surname = surname;
        this.average = average;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the average
     */
    public long getAverage() {
        return average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(long average) {
        this.average = average;
    }
}
