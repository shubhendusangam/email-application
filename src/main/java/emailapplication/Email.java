/*
 * @author Shubhendu Sangam
 * Date : October 16 2020
 *
 */
package emailapplication;

import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;

import static java.lang.System.*;

public class Email {
   private String firstName;
   private String lastName;
   private String department;
   private String password;
   private String alternateEmail;
   private String email;

   private static int mailBoxCapacity = 500;
   private static final int passwordLength = 8;
   private static final String companyPrefix = "sstechhnologies.com";

   // Constructor to receive the first name and last name
   public Email(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.department = setDepartment();
      this.password = generatePassword(passwordLength);
      this.email = generateEmailId();
   }

   // Ask for the Department
   private String setDepartment() {
      out.print("DEPARTMENT CODE \n1 for Sales \n2 for Development \n3 for Accounting \nEnter Department Code: ");
      Scanner scanner = new Scanner(in);
      int departmentCode = scanner.nextInt();
      if (departmentCode == 1) return "Sales";
      else if (departmentCode == 2) return "Dev";
      else if (departmentCode == 1) return "accounting";
      else return "";
   }

   // Generate a random Password
   private String generatePassword(int passwordLength) {
      return RandomStringUtils.randomAlphanumeric(passwordLength);
   }

   // Email Generation
   private String generateEmailId() {
      String departmentId = (!this.department.isEmpty()) ? (this.department.toLowerCase() + ".") : this.department;
      return (this.firstName.toLowerCase()) + "." + (this.lastName.toLowerCase()) + "@" + departmentId + companyPrefix;
   }

   // Set the mailbox capacity
   public void setMailBoxCapacity() {
      out.print("Enter mailbox capacity: ");
      Scanner mailBoxCapacityScanner = new Scanner(in);
      int capacity = mailBoxCapacityScanner.nextInt();
      Email.mailBoxCapacity = capacity;
      out.println("Mailbox capacity updated: " + mailBoxCapacity);
   }

   // set the alternate Email
   public void setAlternateEmail() {
      out.print("Enter personal email id ");
      Scanner alternateEmailScanner = new Scanner(in);
      String alternateEmailID = alternateEmailScanner.nextLine();
      this.alternateEmail = alternateEmailID;
      out.println("Alternate email :" + this.alternateEmail);
   }

   // change the password
   public void setPassword() {
      out.print("Enter new Password" + "(length should not be more than " + passwordLength + ") :");
      Scanner passwordScanner = new Scanner(in);
      String newPassword = passwordScanner.nextLine();
      this.password = newPassword;
      out.println("updated password : " + this.password);
   }

   // show employee info
   public String showInfo() {
      out.println("---------------- Employee Info---------------------------");
      return employeeInfo();
   }

   // Update Employee info
   public void  updateInfo() {
      do{
         out.println("P for update password \nA for update alternate Email \nM for update Mailbox capacity \nQ for Not to update anything");
         Scanner updateEmployeeScanner = new Scanner(in);
         String update = updateEmployeeScanner.nextLine();
         if ("P".equalsIgnoreCase(update.toUpperCase())) {
            setPassword();
         } else if ("A".equalsIgnoreCase(update.toUpperCase())) {
            setAlternateEmail();
         } else if ("M".equalsIgnoreCase(update.toUpperCase())) {
            setMailBoxCapacity();
         } else break;
      } while ( 1!= 0);
   }

   @Override
   public String toString() {
      return employeeInfo();
   }

   public String employeeInfo() {
      return "Name : " + (firstName + " " +lastName) + "\n"
            +"Department : " + department + "\n"
            +"Organization EmailID : " + email + "\n"
            +"Password : " + password + "\n"
            +"MailBox Capacity : " + mailBoxCapacity + "\n"
            +"Alternate EmailID : " + alternateEmail + "\n";
   }
}
