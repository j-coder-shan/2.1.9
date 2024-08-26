public class customerList {
    int size;
    bankCustomer[] list;
    int position;

    public customerList(int size) {
        this.size = size;
        list = new bankCustomer[size];
        position = -1;
    }

    private boolean isEmpty(){
        return position == -1;
    }

    private boolean isFull(){
        return (position + 1 == size);
    }

    public void insertLast(bankCustomer element){
        if(isFull()){
            System.out.println("List is full !");
        }else {
            list[++position] = element;
        }
    }

    public void traverseList(String str){
        if (isEmpty()){
            System.out.println("List is empty !");
        }
        else {
            System.out.println(str);
            System.out.printf("%-20s %-20s %-20s %20s %20s %20s%n", "Account Number", "Customer Name", "Account Type", "Account Balance", "Interest Amount", "Total Balance");
            for (bankCustomer bankCustomer : list) {
                if (bankCustomer != null) {
                    System.out.printf("%-20s %-20s %-20s %20s %20s %20s%n", bankCustomer.accountNumber, bankCustomer.customerName, bankCustomer.accountType, bankCustomer.accountBalance, bankCustomer.interestAmount, bankCustomer.totalBalance);
                }
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        }
}

    public bankCustomer retrieveList(int i) {
        if(isEmpty()){
            System.out.println("List is Empty !");
            return null;
        } else if (i < 0 || i >= list.length) {
            System.out.println("Entered index is out of bound !");
            return null;
        } else {
            return list[i];
        }
    }
}
