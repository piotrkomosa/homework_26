import java.util.Scanner;

public class TransactionsModify {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id operacji którą chcesz zaktualizować");
        int id= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj date");
        double date = scanner.nextDouble();

        System.out.println("Podaj opis");
        String description= scanner.nextLine();
        scanner.nextLine();

        System.out.println("Podaj kwote");
        int amount = scanner.nextInt();

        System.out.println("Podaj typ");
        Boolean type= scanner.nextBoolean();
        scanner.nextLine();;

        Transaction transaction = new Transaction(id,date,description,amount,type);

       TransactionDao transactionDao = new TransactionDao();
       transactionDao.modify(transaction);

    }
}

