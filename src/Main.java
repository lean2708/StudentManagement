package fact;

import fact.service.Examine;
import service.ArrayStudent;
import fact.Student;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Create Student");
            System.out.println("2. Search for Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Percentage Of Academic Performance");
            System.out.println("6. Percentage Points");
            System.out.println("7. Search for academic performance");
            System.out.println("8. Student List");
            System.out.println("9. Exit");
            System.out.print("Your Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    int id = Examine.ExamineID();

                    String name = Examine.ExamineName();

                    LocalDate birthDate = Examine.ExamineBirthday();

                    String address = Examine.ExamineAddress();

                    double height = Examine.ExamineHeight();

                    double weight = Examine.ExamineWeight();

                    String studentCode = Examine.ExamineStudentCode();

                    String university = Examine.ExamineUniversity();

                    int startYear = Examine.ExamineStartYear();

                    double gpa = Examine.ExamineGPA();
                    ArrayStudent.createStudent(id, name, birthDate, address, height, weight, studentCode, university, startYear, gpa);
                    break;
                case 2:
                    System.out.print("Student ID to Find: ");
                    int idFind = scanner.nextInt();
                    scanner.nextLine();
                    Student student = ArrayStudent.findStudent(idFind);
                    if (student != null) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    System.out.print("Student ID to Update: ");
                    int idUpdate = scanner.nextInt();
                    System.out.println("1.Name");
                    System.out.println("2.Birthday (dd/MM/yyyy)");
                    System.out.println("3.Address");
                    System.out.println("4.Height(cm)");
                    System.out.println("5.Weight(kg)");
                    System.out.println("6.Student Code");
                    System.out.println("7.University");
                    System.out.println("8.Start Year");
                    System.out.println("9.GPA");
                    System.out.println("10.Exit");
                    ArrayStudent.updateStudent(idUpdate);
                    break;
                case 4:
                    System.out.print("Student ID to delete: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();
                    ArrayStudent.deleteStudent(idDelete);
                    break;
                case 5:
                    service.ManagerStudent.displayAcademicAbility();
                    break;
                case 6:
                    service.ManagerStudent.percentagePoints();
                    break;
                case 7:
                    System.out.println("1.Xuất Sắc");
                    System.out.println("2.Giỏi");
                    System.out.println("3.Khá");
                    System.out.println("4.Trung Bình");
                    System.out.println("5.Yếu");
                    System.out.println("6.Kém");
                    System.out.print("Your choice : ");
                    int studentFind = scanner.nextInt();
                    service.ManagerStudent.findStudentAcademic(studentFind);
                    break;
                case 8:
                    ArrayStudent.StudentList();
                    break;
                case 9:
                    System.out.println("Exit");
                    scanner.close();
                    ArrayStudent.SaveFile();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
