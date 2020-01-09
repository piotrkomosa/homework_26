import java.sql.SQLException;
import java.util.Scanner;

public class Flows {


    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Dodawanie");
            System.out.println("2. Aktualizacja");
            System.out.println("3. Usuwanie");
            System.out.println("4. Pokaż przychody i wydatki");
            System.out.println("0. Koniec");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    TransactionAdd.main(new String[0]);
                    break;
                case "2":
                    TransactionsModify.main(new String[0]);
                    break;
                case "3":
                    TransactionDelete.main(new String[0]);
                    break;
                case "4":
                    ShowAllType.main(new String[0]);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Nie ma takiej opcji!");
            }
        }
    }
}
