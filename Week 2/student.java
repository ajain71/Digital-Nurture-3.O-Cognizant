
public class Student {
    private int id;
    private String name;
    private char grade;

    public Student(int id, String name, char grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char newGrade) {
        this.grade = newGrade;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

// StudentGrades.java
import java.util.LinkedHashMap;

public class StudentGrades {
    private LinkedHashMap<Integer, Student> students;

    public StudentGrades() {
        students = new LinkedHashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        System.out.println(student.getName() + " added to the system.");
    }

    public void removeStudent(int studentId) {
        Student removedStudent = students.remove(studentId);
        if (removedStudent != null) {
            System.out.println("Student " + removedStudent.getName() + " removed.");
        } else {
            System.out.println("Student ID " + studentId + " not found.");
        }
    }

    public void updateStudentGrade(int studentId, char newGrade) {
        Student student = students.get(studentId);
        if (student != null) {
            student.setGrade(newGrade);
            System.out.println("Updated grade for " + student.getName());
        } else {
            System.out.println("Student ID " + studentId + " not found.");
        }
    }

    public void displayStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
}

public class StudentGradesTest {
    public static void main(String[] args) {
        StudentGrades grades = new StudentGrades();

        Student student1 = new Student(1, "Alice", 'A');
        Student student2 = new Student(2, "Bob", 'B');

        grades.addStudent(student1);
        grades.addStudent(student2);

        grades.displayStudents();

        grades.updateStudentGrade(1, 'A');

        grades.displayStudents();

        grades.removeStudent(2);

        grades.displayStudents();
    }
}
