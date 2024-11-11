import java.util.Objects;

/**
 * A class for working with an array of students that allows sorting students
 * by specified fields and sorting order.
 */

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private int course;

    // Constructor of the class Student
    public Student(String firstName, String lastName, int age, String gender, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.course = course;
    }

    // getters and setters for class fields
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }

    // Override equals to compare two values
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                age == student.age &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender, course);
    }

    // Output information about the student
    @Override
    public String toString() {
        return "Student:\t" +
                "name=" + firstName +
                ", lastname=" + lastName +
                ", age=" + age +
                ", gender=" + gender +
                ", course=" + course;
    }

}
