package StudentList;

import java.util.*;

public class Main {public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Сколько студентов участвовало?");

    int numStudents = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < numStudents; i++) {
        System.out.println("Введите имя студента:");
        String name = scanner.nextLine().trim();

        System.out.println("Введите фамилию студента:");
        String surname = scanner.nextLine().trim();

        System.out.println("Введите отчество студента:");
        String patronymic = scanner.nextLine().trim();

        System.out.println("Введите баллы студента по каждому заданию (через пробел):");
        String[] scoresInput = scanner.nextLine().split(" ");
        List<Integer> scores = new ArrayList<>();

        for (String score : scoresInput) {
            scores.add(Integer.parseInt(score));
        }

        students.add(new Student(name, surname, patronymic, scores));
    }
    scanner.close();

    findAndPrintWinners(students);
}

    public static void findAndPrintWinners(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.calculateAverageScore(), s1.calculateAverageScore());
            }
        });

        for (int i = 0; i < 3 && i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + " место: " + student.getSurname() + " " + student.getName() + " " + student.getPatronymic());
        }
    }
}