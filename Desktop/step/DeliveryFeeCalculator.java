import java.util.Scanner;

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String deliveryType = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            double fee = 0.0;

            if (deliveryType.equals("STANDARD")) {
                fee = 5.0 + (0.50 * weight) + (0.10 * distance);
            } else if (deliveryType.equals("EXPRESS")) {
                fee = 15.0 + (1.00 * weight) + (0.20 * distance);
            } else if (deliveryType.equals("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                fee = 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
            }

            grandTotal += fee;
            System.out.printf("%s: %.2f\n", deliveryType, fee);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}