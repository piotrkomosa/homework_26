import java.util.Scanner;

public class ShowAllType {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz czy przychód(0) czy wydatek(1)");
        String type = scanner.nextLine();
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.showAll(type);
    }
}
