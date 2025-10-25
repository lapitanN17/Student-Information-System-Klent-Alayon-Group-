import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] studentNumber = { "69420", "42069", "12345", "14334" };
        String[] studentName = { "Klent Alayon", "Stanley Comidoy", "Micah Ella Dela Peña", "John Evan Abaya" };
        String[] studentGrades = { "75,80,85,90,95", "80,81,82,83,84", "95,75,85,80,90", "95,96,97,98,99" };
        String[] studentBalance = { "11490", "8640", "15400", "3101" };
        String[] subjects = { "Computer Programming 1", "Algebra and Trigonometry", "Philippine History", "Mathematics in the Modern World", "Physical Education 1"};
        String[] timeSchedule = { "10:00 A.M. - 12:00 P.M.", "3:00 P.M. - 5:00 P.M.", "1:00 P.M. - 2:00 P.M.", "3:00 P.M. - 5:00 P.M.", "9:00 A.M. - 11:00 A.M." };
        String[] daySchedule = { "Monday & Tuesday", "Tuesday & Wednesday", "Wednesday & Thursday", "Thursday & Friday", "Friday" }; 
        String[] accounts = new String[studentNumber.length];
        
        
        boolean logout = false;
        while (!logout) {
            for (int i = 0; i < studentNumber.length; i++) {
                accounts[i] = studentNumber[i] + "," + studentName[i] + "," + studentBalance[i];
            }
            int existingAccounts = accounts.length;
            
            System.out.print("\n*-----STUDENT PORTAL-----*\n" +
            "Enter 'LOGIN' to continue\n" + "(Press Enter to Exit)\n" + "-------------------------------------\n" + "Input: "
            );

            String selectedChoice = null;
            try {
                selectedChoice = br.readLine();
            } catch (IOException e) {
                System.out.println("Error!");
                continue;
            }
            
            switch (selectedChoice.toUpperCase().trim()) {
                case "LOGIN":
                    String loggedIn = login(br, accounts, existingAccounts, studentNumber, studentName);
                    if (loggedIn != null) {
                        mainInterface(br, accounts, studentNumber, studentName, studentGrades, studentBalance, subjects, timeSchedule, daySchedule, existingAccounts, loggedIn);
                    }
            }
            
            
            if (selectedChoice == null || selectedChoice.trim().isEmpty()) {
                while (true) {
                    System.out.print("\n-----ARE YOU SURE YOU WANT TO EXIT?-----\nEnter 'YES' to exit\n(Press Enter to return)\nInput: ");
                    
                    String selectedChoice2 = null;
                    try {
                        selectedChoice2 = br.readLine();
                        if (selectedChoice2 == null || selectedChoice2.trim().isEmpty()) break;
                    } catch (IOException e) {
                        System.out.println("Error!");
                        continue;
                    }
                
                    switch (selectedChoice2.toUpperCase().trim()) {
                        case "YES":
                            logout = true;
                    }
                    break;
                }
            }
        }
    }

    //Login
    public static String login(BufferedReader br, String[] accounts, int existingAccounts, String[] studentNumber, String[] studentName) {
        while (true) {
            System.out.print("\nEnter your Student Number: ");
            String enterStudentNumber = null;
            try {
                enterStudentNumber = br.readLine();
                if (enterStudentNumber == null || enterStudentNumber.trim().isEmpty()) return null;
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
                    return enterStudentNumber;
                }
            }

            System.out.println("\nInvalid Student Number! Try Again\n");
        }
    }

    //Main Interface
    public static void mainInterface(BufferedReader br, String[] accounts, String[] studentNumber, String[] studentName, String[] studentGrades, String[] studentBalance, String[] subjects, String[] timeSchedule, String[] daySchedule, int existingAccounts, String loggedIn) {
        while (true) {
            System.out.print("\n---SELECT MENU OPTIONS---\n" + "'GRADES'\n" + "'BALANCE'\n" + "'SCHEDULE'\n" + "'EVALUATION'\n" + "Input: " );
            String enterInput = null;
            
            try {
                enterInput = br.readLine();
                if (enterInput == null || enterInput.trim().isEmpty()) return;
            } catch (IOException e) {
                System.out.println("Error");
                continue;
            }
            
            switch (enterInput.toUpperCase().trim()) {
                case "GRADES":
                    System.out.print("\n-----GRADES-----\n");
                    
                    for (int i = 0; i < existingAccounts; i++) {
                        String[] accountPart = accounts[i].split(",");
                        String checkStudentNumber = accountPart[0];
                        
                        if (checkStudentNumber.equals(loggedIn)) {
                            for (int j = 0; j < subjects.length; j++) {
                                String[] gradePart = studentGrades[i].split(",");
                                System.out.println(subjects[j] + "\nAverage: " + gradePart[j] + "\n");
                            }
                            break;
                        }
                    }
                    
                    String input1 = null;
                    try {
                        input1 = br.readLine();
                        if (input1 == null || input1.trim().isEmpty()) break;
                    } catch (IOException e) {
                        System.out.println("Error");
                        continue;
                    }
                  break;
                  
                case "BALANCE":
                    System.out.print("\n-----BALANCE-----\n");
                    for (int i = 0; i < existingAccounts; i++) {
                        String[] accountPart = accounts[i].split(",");
                        String checkStudentNumber = accountPart[0];
                        String checkStudentBalance = accountPart[2];
                        
                        if (checkStudentNumber.equals(loggedIn)) {
                            System.out.println("Your Remaining Balance is: " + checkStudentBalance + "\n");
                        }
                    }
                    
                    String input2 = null;
                    try {
                        input2 = br.readLine();
                        if (input2 == null || input2.trim().isEmpty()) break;
                    } catch (IOException e) {
                        System.out.println("Error");
                        continue;
                    }
                  break;
                  
                case "SCHEDULE":
                    System.out.print("\n-----SCHEDULE-----\n");
                    
                    for (int i = 0; i < subjects.length; i++) {
                        System.out.println(subjects[i] + "\nTime: " + timeSchedule[i] + "\nDay: " + daySchedule[i] + "\n");
                    }
                    
                    String input3 = null;
                    try {
                        input3 = br.readLine();
                        if (input3 == null || input3.trim().isEmpty()) break;
                    } catch (IOException e) {
                        System.out.println("Error");
                        continue;
                    }
                  break;
                  
                case "EVALUATION":
                    while (true ) {
                        System.out.print("\nHow would you rate [INSERT INTRUCTOR] teaching method?\n");
                        System.out.print("1 - MEH\n");
                        System.out.print("2 - OK\n");
                        System.out.print("3 - GOOD\n");
                        System.out.print("4 - GREAT\n");
                        System.out.print("5 - EXCELLENT\n" + "Input: ");
                        
                        String rating = null;
                        try {
                            rating = br.readLine();
                            if (rating == null || rating.trim().isEmpty()) break;
                        } catch (IOException e) {
                            System.out.println("Error");
                            continue;
                        }
                        
                        if (!rating.trim().equals("1") && !rating.trim().equals("2") && !rating.trim().equals("3") && !rating.trim().equals("4") && !rating.trim().equals("5")) {
                            System.out.println("Invalid Input!\n");
                            continue;
                        } else {
                            System.out.println("\nThank You for Evaluating!\n");
                        }
                      break;
                    }
                  break;
                  
                default:
                  System.out.println("Invalid Input! Try Again");
                  break;
            }
        }
    }
}