package com.example.flooddetectionsystem;

public abstract class Recordings {
    public static boolean sensor1;
    public static boolean sensor2;
    public static boolean sensor3;

    public static void getSensorData(){
        sensor1 = true;
        sensor2 = false;
        sensor3 = false;
        // This function will initialize all the sensor boolean variables
        // I don't have anything to do with IOT
    }
}