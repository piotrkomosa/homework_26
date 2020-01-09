import java.util.Scanner;

public class ShowAllType {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz czy przychód(true) czy wydatek(false)");
        boolean type = scanner.nextBoolean();
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.showAll(type);
       if(type = true){
           System.out.println("Wplaty to: ");
    }
       else System.out.println("Wydatko to: ");
    }
}
