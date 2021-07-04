package com.PK;

public class Student implements MaxMin {
private String name;
private float[] grades;
    Student(String name,float[] grades){
        this.name=name;
        this.grades=grades;
    }
    public void getTotalGrades(){
        float total=0;
        for (int i=0;i<this.grades.length;i++){
            total+=this.grades[i];
        }
        System.out.println("the student "+this.name+" scored a total of "+total);
    }
    public void getMaxGrade() {
        float maxGrade = this.grades[0];
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] > maxGrade) {
                maxGrade = this.grades[i];
            }
        }
        System.out.println("the student "+this.name+"'s highest score was "+maxGrade);
    }

    public void getMinGrade(){
            float minGrade=this.grades[0];
            for (int i=0;i<this.grades.length;i++){
                if (this.grades[i]<minGrade){
                    minGrade=this.grades[i];
                }
            }
            System.out.println("the student "+this.name+"'s lowest score was "+minGrade);
    }


    }

