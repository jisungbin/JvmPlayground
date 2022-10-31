public class Main {
    public static void main(String[] args) {
        System.out.println("20221031 지성빈 클래스");

        Student stud1 = new Student("201901", "홍길동", 3);
        stud1.exam[0].setExamScore("", 88);

        stud1.exam[0].setSubject("자바");
        stud1.exam[1].setSubject("C");
        stud1.exam[2].setSubject("C++");
        stud1.exam[0].setScore(89);
        stud1.exam[1].setScore(90);
        stud1.exam[2].setScore(100);
        stud1.printGPA();
    }
}

class Student {
    String studNo, name;
    int totSubject;
    Exam[] exam;

    public Student(String studNo, String name, int totSubject) {
        this.studNo = studNo;
        this.name = name;
        this.totSubject = totSubject;
        exam = new Exam[totSubject];
        for (int i = 0; i < exam.length; i++) exam[i] = new Exam();
    }

    public void setStudNo(String studNo) {
        this.studNo = studNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getGPA() {
        int sum = 0;
        for (Exam value : exam) sum = sum + value.getScore();
        return sum;
    }

    public void printGPA() {
        for (Exam value : exam) {
            System.out.println("과목명:" + value.getSubject() + "점수=" + value.getScore());
        }
        System.out.println("과목합계=" + this.getGPA());
    }
}

class Exam {
    String subject;
    int score;

    public void setExamScore(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;

    }
}
