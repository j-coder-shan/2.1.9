public class bankCustomer {
    String accountNumber;
    String customerName;
    String accountType;
    double accountBalance;
    double interestAmount;
    double totalBalance;

    public bankCustomer(String accountNumber, String customerName, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.accountBalance = Math.round(accountBalance * 100.0) / 100.0;
        interestAmount = calculateInterest(accountBalance);
        totalBalance = accountBalance + interestAmount;
    }

    private double calculateInterest(double accountBalance) {
        double interest = 0;
        if (accountBalance < 250000){
            interest = 0.025;
        }else if (accountBalance < 500000) {
            interest = 0.05;
        }else if (accountBalance < 750000) {
            interest = 0.075;
        }else if (accountBalance <1000000) {
            interest = 0.08;
        }else if (accountBalance <1500000) {
            interest = 0.095;
        }
        return Math.round(accountBalance * interest * 100.0) / 100.0;
    }
}
