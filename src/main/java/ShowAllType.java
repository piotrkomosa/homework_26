import java.util.Scanner;

public class ShowAllType {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.showAll(type);

        while (true) {
            System.out.println("Wpisz  przychód(1) czy wydatek(0)");


            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    break;
                case "2":
                    TransactionsModify.main(new String[0]);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Nie ma takiej opcji");
            }

        }
    }
}
