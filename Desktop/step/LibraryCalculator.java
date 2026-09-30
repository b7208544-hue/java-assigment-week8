import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LibraryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String itemType = line.substring(0, firstSpace);
            String itemTitle = line.substring(firstSpace + 1).replace("\"", "").trim();

            int days = 0;
            if (itemType.equals("BOOK")) {
                days = 14;
            } else if (itemType.equals("DVD")) {
                days = 7;
            } else if (itemType.equals("MAGAZINE")) {
                days = 3;
            }

            LocalDate dueDate = currentDate.plusDays(days);
            System.out.println(itemTitle + ": " + dueDate.format(formatter));
        }
        scanner.close();
    }
}
