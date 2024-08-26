import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static customerList list;
    static double savingsBalance;
    static double totalBalance;

    private static void loadData() {
        System.out.println("Enter the number of customers :");
        int no = scanner.nextInt();
        System.out.println("-------------------------");

        list = new customerList(no);

        for (int i = 0; i < no; i++) {
            scanner.nextLine();
            System.out.println("Customer " + (i + 1) + " :");

            System.out.println("- Account Number :");
            String accountNumber = scanner.nextLine();

            System.out.println("- Customer Name :");
            String customerName = scanner.nextLine();

            System.out.println("- Account Type :");
            String accountType = scanner.nextLine();

            System.out.println("- Account Balance :");
            double accountBalance = scanner.nextDouble();

            bankCustomer customer = new bankCustomer(accountNumber, customerName, accountType, accountBalance);

            list.insertLast(customer);
            System.out.println("---------------------------------------------------------------");
        }
    }

    private static void CustomersAboveThreshold(){
        System.out.println("Enter a Amount to search accounts :");
        double amount = scanner.nextDouble();
        System.out.println("Customers who have more than " + amount + " in their account :");
        System.out.printf("%-20s %-20s%n", "Account Number", "Customer Name");
        for (int i = 0; i < list.size; i++) {
            bankCustomer customer = list.retrieveList(i);
            if (customer.totalBalance > amount){
                System.out.printf("%-20s %-20s%n", customer.accountNumber, customer.customerName);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void savingCustomer(){
        System.out.println("Customers with savings accounts :");
        System.out.printf("%-20s %-20s%n", "Account Number", "Customer Name");
        savingsBalance = 0;
        for (int i = 0; i < list.size; i++) {
            bankCustomer customer = list.retrieveList(i);
            if (customer.accountType.equalsIgnoreCase("savings")){
                savingsBalance += customer.totalBalance;
                System.out.printf("%-20s %-20s%n", customer.accountNumber, customer.customerName);
            }
        }
        System.out.println("Total balance in savings account : " + Math.round(savingsBalance * 100.0) / 100.0);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void totalAccountBalance(){
        totalBalance = 0;
        for (int i = 0; i < list.size; i++) {
            bankCustomer customer = list.retrieveList(i);
            totalBalance += customer.totalBalance;
        }
        System.out.println("Percentage of the total balance in savings accounts \n" +
                           "relative to the total balance in all accounts       : " + Math.round((savingsBalance * 100 / totalBalance) * 100.0) / 100.0);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        loadData();
        list.traverseList("Initial Information Of Customers :");

        quickSort sortList = new quickSort();
        sortList.sort(0, list.size - 1, list);
        list.traverseList("Sorted customer details according to Total Account Balance :");

        CustomersAboveThreshold();

        savingCustomer();

        totalAccountBalance();

    }
}
