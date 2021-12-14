package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
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

    public List<Course> getCourses() {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
        course.getTeachers().add(this);
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
        course.getTeachers().remove(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" +
                '}';
    }
}