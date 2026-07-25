import java.util.Scanner;
public class Welcome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter your First name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter your Last name: ");
        String lname = scanner.nextLine();

        System.out.println("Welcome to the Second Year " + fname + " " + lname);

        scanner.close();

    }
}