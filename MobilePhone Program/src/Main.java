import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MobilePhone mobilePhone = new MobilePhone("0039 330 4404");

        boolean quit = false;

        MobilePhone.printActions();

        while (!quit) {
            System.out.print("\nEnter action: (6 to show available actions) ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    MobilePhone.printContact();
                    break;
                case 2:
                    MobilePhone.addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }
    }

  private static void removeContact() {
    }

    private static void updateContact() {
    }

    private static void printContact() {
    }

    private static void printActions() {
    }
    private static void queryContact() {
    }


}
