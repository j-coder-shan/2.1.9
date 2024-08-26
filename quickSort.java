public class quickSort {

    public void sort(int start, int end, customerList list){
        if (start < end){
            int partitionIndex = partition(start, end, list);
            sort(start, partitionIndex - 1, list);
            sort(partitionIndex + 1, end, list);
        }
    }

    private int partition(int start, int end, customerList list) {
        double pivot = list.list[end].accountBalance;
        int partitionIndex = start - 1;
        for (int j = start; j < end; j++){
            if (list.list[j].accountBalance < pivot){
                partitionIndex++;
                bankCustomer temp = list.list[j];
                list.list[j] = list.list[partitionIndex];
                list.list[partitionIndex] = temp;
            }
        }
        bankCustomer temp = list.list[partitionIndex + 1];
        list.list[partitionIndex + 1] = list.list[end];
        list.list[end] = temp;
        return partitionIndex + 1;
    }
}

