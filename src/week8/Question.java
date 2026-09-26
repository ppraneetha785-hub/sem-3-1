package week8;

import java.util.*;

abstract class Question {
    String correct, student;
    double points;
    Question(String c, String s, double p) { correct = c; student = s; points = p; }
    abstract double score();
}

class MCQ extends Question {
    MCQ(String c, String s, double p) { super(c, s, p); }
    double score() { return student.equalsIgnoreCase(correct) ? points : 0; }
}

class TF extends Question {
    TF(String c, String s, double p) { super(c, s, p); }
    double score() { return student.equalsIgnoreCase(correct) ? points : 0; }
}

class Essay extends Question {
    Essay(String c, String s, double p) { super(c, s, p); }
    double score() {
        String[] keywords = correct.split(",");
        int match = 0;
        for (String k : keywords) {
            if (student.toLowerCase().contains(k.trim().toLowerCase())) match++;
        }
        if (match >= 2) return points * 0.75;
        else if (match == 1) return points * 0.5;
        else return 0;
    }
}

class ExamGraderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        double total = 0;
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim().split(" ")[0];
            String correct = parts[2].trim();
            String student = parts[4].trim();
            double pts = Double.parseDouble(parts[5].trim());
            Question q;
            switch (type) {
                case "MCQ": q = new MCQ(correct, student, pts); break;
                case "TF": q = new TF(correct, student, pts); break;
                default: q = new Essay(correct, student, pts);
            }
            double s = q.score();
            System.out.printf("%s: %.2f%n", type, s);
            total += s;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
