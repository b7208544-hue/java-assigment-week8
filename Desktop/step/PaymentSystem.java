import java.util.Scanner;

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) 
            return;
        int n = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String payType = scanner.next();
            double amount = scanner.nextDouble();
            double adjusted = amount;

            if (payType.equals("CARD")) {
                adjusted = amount * 1.02;
            } else if (payType.equals("WALLET")) {
                adjusted = amount * 1.01;
            } else if (payType.equals("BANKTRANSFER")) {
                adjusted = amount;
            }

            total += adjusted;
            System.out.printf("%s: %.2f\n", payType, adjusted);
        }
        
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}