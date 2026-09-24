public class Program7 {
    private boolean[] results;
    private int count;

    public Program7(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (count < results.length) {
            results[count] = isCorrect;
            count++;
        } else {
            System.out.println("Cannot record more answers!");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Program7 sc = new Program7(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore()); // 3
    }
}
