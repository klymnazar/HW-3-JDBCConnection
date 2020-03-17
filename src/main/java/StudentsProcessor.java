import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsProcessor {

    StudentsService studentsService = new StudentsService();
    MarksService marksService = new MarksService();
    SubjectsService subjectsService = new SubjectsService();

    public void scanConsol() {

        selectList();

        List<String> studentList = new ArrayList<>();
        List<String> subjectList = new ArrayList<>();
        List<String> selectedStudentList = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {

                String type = scanner.nextLine();

                if (type.equals("1")) {

                    String name = createStudentName(scanner);
                    String lastName = createStudentLastName(scanner);
                    Integer phone = createStudentPhone(scanner);

                    studentList = studentsService.createStudent(name, lastName, phone);
                    System.out.println("AddStudent: ");
                    System.out.println("name: " + studentList.get(0) + "; " + "last_name: " + studentList.get(1) + "; " + "phone: " + studentList.get(2));
                    System.out.println("Success");

                    selectList();

                } else if (type.equals("2")) {

                    String id = getStudentIdFromConsol(scanner);

                    selectedStudentList = studentsService.selectStudentById(id);

                    System.out.println("Student for edit: ");
                    System.out.println("id: " + selectedStudentList.get(0) + "; " + "name: " + selectedStudentList.get(1) + "; " + "last_name: " + selectedStudentList.get(2) + "; " + "phone: " + selectedStudentList.get(3));

                    String name = createStudentName(scanner);
                    String lastName = createStudentLastName(scanner);
                    Integer phone = createStudentPhone(scanner);

                    studentList = studentsService.editStudent(name, lastName, phone, id);

                    System.out.println("EditStudent: ");
                    System.out.println("id: " + studentList.get(0) + "; " + "name: " + studentList.get(1) + "; " + "last_name: " + studentList.get(2) + "; " + "phone: " + studentList.get(3));
                    System.out.println("Success");

                    selectList();

                } else if (type.equals("3")) {

                    String id = getStudentIdFromConsol(scanner);

                    selectedStudentList = studentsService.selectStudentById(id);

                    studentsService.deleteStudent(id);
                    System.out.println("Delete Student: ");
                    System.out.println("id: " + selectedStudentList.get(0) + "; " + "name: " + selectedStudentList.get(1) + "; " + "last_name: " + selectedStudentList.get(2) + "; " + "phone: " + selectedStudentList.get(3));
                    System.out.println("Success");

                    studentsService.selectStudentById(id);

                    selectList();

                } else if (type.equals("4")) {

                    String mark = getStudentMarkFromConsol(scanner);
                    String subjectId = getSubjectIdFromConsol(scanner);
                    String studentId = getStudentIdFromConsol(scanner);

                    selectedStudentList = marksService.createMark(mark, subjectId, studentId);
                    subjectList = subjectsService.selectSubjectById(selectedStudentList.get(1));
                    studentList = studentsService.selectStudentById(selectedStudentList.get(2));

                    System.out.println("AddMark: ");
                    System.out.println("mark: " + selectedStudentList.get(0) + "; " + "subject_name: " + subjectList.get(1) + "; " + "name: " + studentList.get(1) + "; " + "last_name: " + studentList.get(2));
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
