import java.sql.SQLException;
import java.util.Scanner;

public class TransactionAdd {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj date");
        double date = scanner.nextDouble();

        System.out.println("Podaj opis");
        String description= scanner.nextLine();
        scanner.nextLine();

        System.out.println("Podaj kwote");
        int amount = scanner.nextInt();

        System.out.println("Podaj typ");
        String type= scanner.nextLine();
        scanner.nextLine();
        Transaction transaction = new Transaction(date,description,amount,type);
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.add(transaction);

    }
}


