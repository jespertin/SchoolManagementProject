package entity;

import javax.persistence.*;


@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    @ManyToOne
    private Education education;

    public Student() {
    }

    public Student(String name, int age, Education education) {
        this.name = name;
        this.age = age;
        this.education = education;
    }
    @PreRemove
    public void removeEducation(){
        this.getEducation().removeStudent(this);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
        education.addStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", education=" + education +
                '}';
    }
}