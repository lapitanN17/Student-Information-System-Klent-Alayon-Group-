import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] studentNumber = { "69420", "42069" };
        String[] studentName = { "Klent Alayon", "Nathaniel Lapitan" };
        String[] accounts = new String[studentNumber.length];


        while (true) {
            for (int i = 0; i < studentNumber.length; i++) {
                accounts[i] = studentNumber[i] + "," + studentName[i];
            }
            int existingAccounts = accounts.length;
            
            System.out.print("\n*-----ACES TAGUM STUDENT PORTAL-----*\n" +
            "Enter 'LOGIN' to continue\n" + "-------------------------------------\n" + "Input: "
            );

            String selectedChoice = null;
            try {
                selectedChoice = br.readLine();
            } catch (IOException e) {
                System.out.println("Error!");
                continue;
            }

            if (selectedChoice == null || selectedChoice.trim().isEmpty()) {
                return;
            }

            switch (selectedChoice.toUpperCase().trim()) {
                case "LOGIN": //Login
                    boolean loggedIn = login(br, accounts, existingAccounts, studentNumber, studentName);
                    if (loggedIn) {
                        mainInterface(br, accounts, studentNumber, studentName);
                    }
                    break;

                default:
                    System.out.println("Invalid Input! Try Again!");
            }
        }
    }

    //Login
    public static boolean login(BufferedReader br, String[] accounts, int existingAccounts, String[] studentNumber, String[] studentName) {
        while (true) {
            System.out.print("\nEnter your Student Number: ");
            String enterStudentNumber = null;
            try {
                enterStudentNumber = br.readLine();
                if (enterStudentNumber == null || enterStudentNumber.trim().isEmpty()) return false;
            } catch (IOException e) {
                System.out.println("Error");
                continue;
            }
            
            for (int i = 0; i < existingAccounts; i++) {
                String[] accountPart = accounts[i].split(",");
                String checkStudentNumber = accountPart[0];
                String checkStudentName = accountPart[1];
                
                if (enterStudentNumber.equals(checkStudentNumber)) {
                    System.out.println("\nHELLO " + checkStudentName);
                    return true;
                }
            }

            System.out.println("\nInvalid Student Number! Try Again\n");
        }
    }
    
    //Main Interface
    public static void mainInterface(BufferedReader br, String[] accounts, String[] studentNumber, String[] studentName) {
        while (true) {
            System.out.println("\n---SELECT MENU OPTIONS---\n" + "'GRADES'\n" + "'BALANCE'");
            String enterInput = null;
            
            try {
                enterInput = br.readLine();
                if (enterInput == null || enterInput.trim().isEmpty()) return;
            } catch (IOException e) {
                System.out.println("Error");
                continue;
            }
        }
    }
}
