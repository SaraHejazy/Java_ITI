package com.PK;
import java.util.Random;
import java.time.Clock;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float[] grades={50,50,49,48};
        Student ahmed=new Student("ahmed",grades);
        ahmed.getTotalGrades();
        ahmed.getMaxGrade();
        ahmed.getMinGrade();
    }

        }



