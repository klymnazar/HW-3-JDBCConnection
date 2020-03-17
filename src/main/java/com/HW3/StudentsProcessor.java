package com.HW3;

import com.HW3.model.Mark;
import com.HW3.model.Student;
import com.HW3.model.Subject;
import com.HW3.service.MarksService;
import com.HW3.service.StudentsService;
import com.HW3.service.SubjectsService;

import java.util.Scanner;

public class StudentsProcessor {

    private StudentsService studentsService = new StudentsService();
    private MarksService marksService = new MarksService();
    private SubjectsService subjectsService = new SubjectsService();

    private Student student = new Student();
    private Mark mark = new Mark();
    private Subject subject = new Subject();

    public void scanConsol() {

        selectList();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {

                String type = scanner.nextLine();

                if (type.equals("1")) {

                    String name = createStudentName(scanner);
                    String lastName = createStudentLastName(scanner);
                    Integer phone = createStudentPhone(scanner);

                    student = studentsService.createStudent(name, lastName, phone);

                    System.out.println("AddStudent: ");
                    System.out.println("name: " + student.getName() + "; " + "last_name: " + student.getLastName() + "; " + "phone: " + student.getPhone());

                    System.out.println("Success");

                    selectList();

                } else if (type.equals("2")) {

                    int id = Integer.parseInt(getStudentIdFromConsol(scanner));

                    student = studentsService.selectStudentById(id);

                    System.out.println("Student for edit: ");
                    System.out.println("id: " + student.getId() + "; " + "name: " + student.getName() + "; " + "last_name: " + student.getLastName() + "; " + "phone: " + student.getPhone());

                    String name = createStudentName(scanner);
                    String lastName = createStudentLastName(scanner);
                    Integer phone = createStudentPhone(scanner);

                    student = studentsService.editStudent(name, lastName, phone, id);

                    System.out.println("EditStudent: ");
                    System.out.println("name: " + student.getName() + "; " + "last_name: " + student.getLastName() + "; " + "phone: " + student.getPhone());

                    System.out.println("Success");

                    selectList();

                } else if (type.equals("3")) {

                    int id = Integer.parseInt(getStudentIdFromConsol(scanner));

                    student = studentsService.selectStudentById(id);

                    studentsService.deleteStudent(id);
                    System.out.println("Delete Student: ");
                    System.out.println("id: " + student.getId() + "; " + "name: " + student.getName() + "; " + "last_name: " + student.getLastName() + "; " + "phone: " + student.getPhone());

                    System.out.println("Success");

                    selectList();

                } else if (type.equals("4")) {

                    int marks = Integer.parseInt(getStudentMarkFromConsol(scanner));
                    int subjectId = Integer.parseInt(getSubjectIdFromConsol(scanner));
                    int studentId = Integer.parseInt(getStudentIdFromConsol(scanner));

                    mark = marksService.createMark(marks, subjectId, studentId);
                    subject = subjectsService.selectSubjectById(subjectId);
                    student = studentsService.selectStudentById(studentId);

                    System.out.println("AddMark: ");
                    System.out.println("mark: " + mark.getMark() + "; " + "subject_name: " + subject.getSubjectName() + "; " + "name: " + student.getName() + "; " + "last_name: " + student.getLastName());

                    System.out.println("Success");

                    selectList();

                } else if (type.equals("5")) {

                    System.out.println("Exit...");
                    System.exit(0);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getStudentIdFromConsol(Scanner scanner) {
        System.out.println("enter student id: ");
        return scanner.nextLine();
    }

    public String createStudentName(Scanner scanner) {
        System.out.println("enter name: ");
        return scanner.nextLine();
    }

    public String createStudentLastName(Scanner scanner) {
        System.out.println("enter last_name: ");
        return scanner.nextLine();
    }

    public Integer createStudentPhone(Scanner scanner) {
        System.out.println("enter phone: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getStudentMarkFromConsol(Scanner scanner) {
        System.out.println("enter student mark: ");
        return scanner.nextLine();
    }

    public String getSubjectIdFromConsol(Scanner scanner) {
        System.out.println("enter subject id: ");
        return scanner.nextLine();
    }

    public void selectList() {
        System.out.println("Select action:");
        System.out.println("1 - add");
        System.out.println("2 - edit");
        System.out.println("3 - delete");
        System.out.println("4 - marks");
        System.out.println("5 - exit");
    }


}
