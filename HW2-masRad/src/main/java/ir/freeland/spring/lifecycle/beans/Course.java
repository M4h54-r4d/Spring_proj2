package ir.freeland.spring.lifecycle.beans;

public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
