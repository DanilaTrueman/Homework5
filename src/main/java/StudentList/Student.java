package StudentList;

import java.util.List;

public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private List<Integer> scores;

    public Student(String name, String surname, String patronymic, List<Integer> scores) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.scores = scores;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public double calculateAverageScore() {
        if (scores.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }
}