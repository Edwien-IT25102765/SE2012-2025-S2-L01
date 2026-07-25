import java.util.Scanner;
public class Marks1 {
    public static String getGrade(double score) {
        if (score == -1) {
            return "N/A";
        } else if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "Fail";
        }
    }
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         System.out.print("Enter the number of students (n): ");
         int n = scanner.nextInt();

         while (n <= 0) {
             System.out.print("Invalid input. Please enter a number greater than 0 for the number of students: ");
             n = scanner.nextInt();
         }

         double[][] marks = new double[n][3];

         for (int i = 0; i < n; i++) {
             for (int j = 0; j < 3; j++) {
                 marks[i][j] = -1; 
               }
            }

         while (true) {
             System.out.print("\n------ Menu ------\n");
             System.out.print("1. Add Marks (add)\n");
             System.out.print("2. Update Marks (update)\n");
             System.out.print("3. Calculate Average for a Subject (average_s)\n");
             System.out.print("4. Calculate Average for a Student (average)\n");
             System.out.print("5. Calculate Total for a Student (total)\n");
             System.out.print("6. Display Grades of Students (grades)\n");
             System.out.print("7. Exit\n");
             System.out.print("\nEnter the Command: ");
             String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
               System.out.println("Exiting the program.");
               break;
            }
            
            switch (command.toLowerCase()) {
                case "add" : {
                  System.out.print("Enter student ID (1 to " + n + "): ");
                  int studentID = scanner.nextInt();

                  while (studentID < 1 || studentID > n) {
                      System.out.println("Invalid student ID. Please enter a value between 1 and " + n);
                      studentID = scanner.nextInt();
                  }

                  int index = studentID - 1;

                  if (marks[index][0] != -1) {
                      System.out.println("Marks for Student " + studentID + " already exist. Use 'update' to modify.");
                      break;
                  }

                  System.out.print("Enter marks for Student " + studentID + ":\n");
                  System.out.print("Subject 1 (Math): ");
                  double math = scanner.nextDouble();

                  while (math < 0 || math > 100) {
                      System.out.print("Invalid mark. Please enter a value between 0 and 100: ");
                      math = scanner.nextDouble();
                  }
                  marks[index][0] = math;
                  
                  System.out.print("Subject 2 (Chemistry): ");
                  double chemistry = scanner.nextDouble();
                  while (chemistry < 0 || chemistry > 100) {
                      System.out.print("Invalid mark. Please enter a value between 0 and 100: ");
                      chemistry = scanner.nextDouble();
                  }
                  marks[index][1] = chemistry;

                  System.out.print("Subject 3 (Physics): ");
                  double physics = scanner.nextDouble();
                  while (physics < 0 || physics > 100) {
                      System.out.print("Invalid mark. Please enter a value between 0 and 100: ");
                      physics = scanner.nextDouble();
                  }
                  marks[index][2] = physics;
                  break;
                }
                case "update" : {
                  System.out.print("Enter student ID (1 to " + n + "): ");
                  int studentID = scanner.nextInt();

                  while (studentID < 1 || studentID > n) {
                      System.out.println("Invalid student ID. Please enter a value between 1 and " + n);
                      studentID = scanner.nextInt();
                  }

                  int index = studentID - 1;

                  System.out.print("Enter subject ID (1 for Math, 2 for Chemistry, 3 for Physics): ");
                  int subjectID = scanner.nextInt();
                  
                  while (subjectID < 1 || subjectID > 3) {
                      System.out.println("Invalid subject ID. Please enter a value between 1 and 3.");
                      subjectID = scanner.nextInt();
                  }

                   int subjectIndex = subjectID - 1;

                  if (marks[index][0] == -1 || marks[index][1] == -1 || marks[index][2] == -1) {
                      System.out.println("Marks for Student " + studentID + " do not exist. Please add marks first.");
                      break;
                  }

                  System.out.print("Enter new mark: ");
                  double newMark = scanner.nextDouble();

                  while (newMark < 0 || newMark > 100) {
                      System.out.print("Invalid mark. Please enter a value between 0 and 100: ");
                      newMark = scanner.nextDouble();
                  }

                   if (marks[index][subjectIndex] == newMark) {
                         System.out.println("The mark is already " + newMark + ". No update needed!");
                      } else {
                         marks[index][subjectIndex] = newMark;
                         System.out.println("Marks updated successfully.");
                  }
                  break;
                }
                case "average_s": {
                  System.out.print("Enter subject ID (1 for Math, 2 for Chemistry, 3 for Physics): ");
                  int subjectID = scanner.nextInt();

                  while (subjectID < 1 || subjectID > 3) {
                      System.out.println("Invalid subject ID. Please enter a value between 1 and 3.");
                      subjectID = scanner.nextInt();
                  }

                  int index = subjectID - 1;
                  double total = 0;
                  int count = 0;

                  for (int i = 0; i < n; i++) {
                     if (marks[i][index] != -1) {
                         total += marks[i][index];
                         count++;
                     }
                  }

                  if (count == 0) {
                      System.out.println("No marks available for Subject " + subjectID);
                      break;
                  }else{
                     double average = total / count;
                     System.out.println("Average for Subject " + subjectID + ": " + average);
                  }
                  break;
                }
                case "average": {
                  System.out.print("Enter student ID (1 to " + n + "): ");
                  int studentID = scanner.nextInt();

                  while (studentID < 1 || studentID > n) {
                      System.out.println("Invalid student ID. Please enter a value between 1 and " + n);
                      studentID = scanner.nextInt();
                  }

                  int index = studentID - 1;

                  if (marks[index][0] == -1 || marks[index][1] == -1 || marks[index][2] == -1) {
                      System.out.println("Marks for Student " + studentID + " do not exist. Please add marks first.");
                      break;
                  }

                  double total = marks[index][0] + marks[index][1] + marks[index][2];
                  double average = total / 3.0;
                  System.out.println("Average for student " + studentID + ": " + average);
                  break;
                }
                case "total": {
                  System.out.print("Enter student ID (1 to " + n + "): ");
                  int studentID = scanner.nextInt();

                  while (studentID < 1 || studentID > n) {
                      System.out.println("Invalid student ID. Please enter a value between 1 and " + n);
                      studentID = scanner.nextInt();
                  }

                  int index = studentID - 1;

                  if (marks[index][0] == -1 || marks[index][1] == -1 || marks[index][2] == -1) {
                      System.out.println("Marks for Student " + studentID + " do not exist. Please add marks first.");
                      break;
                  }

                  double total = marks[index][0] + marks[index][1] + marks[index][2];
                  System.out.println("Total for student " + studentID + ": " + total);
                  break;
                }
                case "grades": {
                  System.out.println("--------------------------------------------------");
                  System.out.println("Student ID | Math      | Chemistry  | Physics   ");
                  System.out.println("--------------------------------------------------");

                    for (int i = 0; i < n; i++) {
                        String mathGrade = getGrade(marks[i][0]);
                        String chemistryGrade = getGrade(marks[i][1]);
                        String physicsGrade = getGrade(marks[i][2]);

                        int studentID = i + 1;
    
                        System.out.printf("Student %d  | %s         | %s          | %s%n", studentID, mathGrade, chemistryGrade, physicsGrade);
                    }
                    System.out.println("--------------------------------------------------");
                  break;
                }
                default:
                  System.out.println("Invalid command. Please try again.");   
                  break;
            }
         } 
   scanner.close();
   }
}
