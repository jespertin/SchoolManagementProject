package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany
    private List<Education> educations;
    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;

    public Course(String name) {
        this.name = name;
    }

    public Course() {
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

    public List<Education> getEducations() {
        if (educations == null) {
            educations = new ArrayList<>();
        }
        return educations;
    }

    @PreRemove
    public void beforeRemove() {
        educations.forEach(education -> education.getCourses().remove(this));
        teachers.forEach(teacher -> teacher.getCourses().remove(this));

        for (Education education : educations) {
            education.getCourses().remove(this);
        }

        for (Teacher teacher : teachers) {
            teacher.getCourses().remove(this);
        }

    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public void addEducation(Education education) {
        getEducations().add(education);
        education.getCourses().add(this);
    }

    public void removeEducation(Education education) {
        getEducations().remove(education);
        education.getCourses().remove(this);
    }

    public List<Teacher> getTeachers() {
        if (teachers == null) {
            teachers = new ArrayList<>();
        }
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        getTeachers().add(teacher);
        teacher.getCourses().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        getTeachers().remove(teacher);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}