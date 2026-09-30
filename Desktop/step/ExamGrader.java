import java.util.Scanner;

public class ExamGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        double overallScore = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = parseLine(line);
            String qType = parts[0];

            if (qType.equals("MCQ") || qType.equals("TF")) {
                String correctAns = parts[1];
                String studentAns = parts[2];
                double points = Double.parseDouble(parts[3]);
                double score = studentAns.equals(correctAns) ? points : 0.0;
                overallScore += score;
                System.out.printf("%s: %.2f\n", qType, score);
            } else if (qType.equals("ESSAY")) {
                String[] keywords = parts[1].split(",");
                for (int k = 0; k < keywords.length; k++) {
                    keywords[k] = keywords[k].trim().toLowerCase();
                }
                String studentAns = parts[2].toLowerCase();
                double points = Double.parseDouble(parts[3]);

                int matchCount = 0;
                for (String kw : keywords) {
                    if (studentAns.contains(kw)) {
                        matchCount++;
                    }
                }

                double score = 0.0;
                if (matchCount >= 2) {
                    score = points * 0.75;
                } else if (matchCount == 1) {
                    score = points * 0.50;
                }

                overallScore += score;
                System.out.printf("ESSAY: %.2f\n", score);
            }
        }
        System.out.printf("Total Score: %.2f\n", overallScore);
        scanner.close();
    }

    private static String[] parseLine(String line) {
        java.util.List<String> list = new java.util.ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
                continue;
            }
            if (c == ' ' && !inQuotes) {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        return list.toArray(new String[0]);
    }
}