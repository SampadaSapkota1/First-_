import java.util.Scanner;
import java.util.ArrayList;

public class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double productCost = 0;
        double totalCost = 0;
        double costWithVAT = 0;
        double costWithDiscount = 0;
        int userIdentifier, password;

        System.out.println("Enter your user ID: ");
        userIdentifier = scanner.nextInt();

        System.out.println("Enter your password: ");
        password = scanner.nextInt();

        ArrayList<Double> productCostList = new ArrayList<Double>();
        System.out.println("Enter the price of the items you purchased");
        System.out.println("Provide 23 if you want to exit!!");


        while (true) {
            productCost = scanner.nextFloat();
            if (productCost == 0) {
                break;
            }
            productCostList.add(productCost);
        }

        for (double cost : productCostList) {
            totalCost += cost;
        }

        System.out.println("Total = " + totalCost);
        System.out.println("Do you want to add VAT? (y/n)");
        String vatResponse = scanner.next().toLowerCase();

        if (vatResponse.equals("y")) {
            costWithVAT = totalCost + (0.13 * totalCost);
            System.out.println("Your new price with VAT is: Rs " + costWithVAT);
        } else {
            costWithVAT = totalCost;
            System.out.println("Your new price without VAT is: Rs " + costWithVAT);
        }

        System.out.println("Do you want a discount? (y/n)");
        String discountResponse = scanner.next().toLowerCase();

        if (discountResponse.equals("y")) {
            System.out.println("How much discount percentage do you want? " +
                    "***Applicable only below 50%***");
            double discountPercentage = scanner.nextDouble();
            if (discountPercentage < 50) {
                costWithDiscount = costWithVAT - ((discountPercentage / 100) * costWithVAT);
            } else {
                costWithDiscount = costWithVAT;
            }
        } else {
            costWithDiscount = costWithVAT;
        }

        System.out.println("Your total amount is " + costWithDiscount);

        System.out.println("How would you like to pay?");
        double cashGiven = scanner.nextDouble();

        if (cashGiven < costWithDiscount) {
            System.out.println("Your total amount is " + costWithDiscount + ". Insufficient amount.");
        } else if (cashGiven == costWithDiscount) {
            System.out.println("Thank you, visit again!!");
        } else if (cashGiven > costWithDiscount) {
            int change = (int) (cashGiven - costWithDiscount);

            if (change >= 1000) {
                int count = change / 1000;
                System.out.println("1000 * " + count);
                change -= (1000 * count);
            }

            if (change >= 500) {
                int count = change / 500;
                System.out.println("500 * " + count);
                change -= (500 * count);
            }

            if (change >= 100) {
                int count = change / 100;
                System.out.println("100 * " + count);
                change -= (100 * count);
            }

            if (change >= 50) {
                int count = change / 50;
                System.out.println("50 * " + count);
                change -= (50 * count);
            }

            if (change >= 20) {
                int count = change / 20;
                System.out.println("20 * " + count);
                change -= (20 * count);
            }

            if (change >= 10) {
                int count = change / 10;
                System.out.println("10 * " + count);
                change -= (10 * count);
            }

            if (change >= 5) {
                int count = change / 5;
                System.out.println("5 * " + count);
                change -= (5 * count);
            }

            if (change >= 1) {
                int count = change / 1;
                System.out.println("1 * " + count);
                change -= (1 * count);
            }
            System.out.println("Your change amount is: Rs " + (cashGiven - costWithDiscount));

            System.out.println("Thank you, visit again!!");
        }

        scanner.close();
    }
}

