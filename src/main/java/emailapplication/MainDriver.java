/*
 * @author Shubhendu Sangam
 * Date : October 16 2020
 *
 */
package emailapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDriver {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Number of Employees joining : ");
      int employeeCount = scanner.nextInt();
      List<Email> emailList = new ArrayList<>();

      for (int i = 0; i < employeeCount; i++) {
         System.out.print("Enter First Name : " );
         Scanner sc1 = new Scanner(System.in);
         String firstName = sc1.nextLine();

         System.out.print("Enter Last Name : " );
         Scanner sc2 = new Scanner(System.in);
         String lastName = sc2.nextLine();

         Email email = new Email(firstName,lastName);
         System.out.println(email.showInfo());
         email.updateInfo();
         emailList.add(email);
      }

      System.out.println("---------------- Employees Info---------------------------");
      emailList.forEach(System.out :: println);

   }
}
