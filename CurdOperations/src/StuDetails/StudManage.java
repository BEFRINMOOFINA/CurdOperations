package StuDetails;
import java.util.*;

class Student {
    private String name;
    private int rollno;
    private String subject;
    private String department;

    Student(String name, int rollno, String subject, String department) {
        this.name = name;
        this.rollno = rollno;
        this.subject = subject;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public String getSubject() {
        return subject;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return name + " " + rollno + " " + subject + " " + department;
    }
}

public class StudManage {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1 INSERT");
            System.out.println("2 DISPLAY");
            System.out.println("3 SEARCH");
            System.out.println("4 DELETE");
            System.out.println("5 UPDATE");
            System.out.println("6 EXIT");
            System.out.println("Enter your choice: ");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    // Insert a new student
                    System.out.print("Enter student name: ");
                    String name = s1.nextLine();
                    System.out.print("Enter student roll no: ");
                    int rollno = s.nextInt();
                    System.out.print("Enter student subject: ");
                    String subject = s1.nextLine();
                    System.out.print("Enter student department: ");
                    String department = s1.nextLine();
                    studentList.add(new Student(name, rollno, subject, department));
                    System.out.println("--------");
                    System.out.println("Student Inserted successfully");
                    System.out.println("-----------------------");
                    break;

                case 2:
                    // Display all students
                    System.out.println("----------");
                    for (Student student : studentList) {
                        System.out.println(student);
                    }
                    System.out.println("---------");
                    break;

                case 3:
                    // Search for a student by roll number
                    boolean found = false;
                    System.out.print("Enter student roll no: ");
                    rollno = s.nextInt();
                    for (Student student : studentList) {
                        if (student.getRollno() == rollno) {
                            found = true;
                            System.out.println("-------");
                            System.out.println(student);
                        }
                    }
                    if (!found) {
                        System.out.println("------");
                        System.out.println("Student not found");
                    }
                    System.out.println("---");
                    break;

                case 4:
                    // Delete a student by roll number
                    found = false;
                    System.out.print("Enter student roll no to delete: ");
                    rollno = s.nextInt();
                    Iterator<Student> i = studentList.iterator();
                    while (i.hasNext()) {
                        Student student = i.next();
                        if (student.getRollno() == rollno) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("-----");
                        System.out.println("Student not found");
                    } else {
                        System.out.println("------");
                        System.out.println("Student Deleted successfully");
                    }
                    System.out.println("--");
                    break;

                case 5:
                    // Update a student's details
                    found = false;
                    System.out.print("Enter student roll no to update: ");
                    rollno = s.nextInt();
                    ListIterator<Student> li = studentList.listIterator();
                    while (li.hasNext()) {
                        Student student = li.next();
                        if (student.getRollno() == rollno) {
                            System.out.print("Enter student name: ");
                            name = s1.nextLine();
                            System.out.print("Enter student subject: ");
                            subject = s1.nextLine();
                            System.out.print("Enter student department: ");
                            department = s1.nextLine();
                            li.set(new Student(name, rollno, subject, department));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("--------");
                        System.out.println("Student not found");
                    } else {
                        System.out.println("Student Updated successfully");
                    }
                    System.out.println("-----");
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
            }
        } while (ch != 6);
    }
}