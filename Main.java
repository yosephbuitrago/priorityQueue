import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        // variable to hold temporary information that user insert
        int menuOption;
        Person newPerson;
        int position;
        int nPersons;
        LinkedList newList = new LinkedList();
        Scanner sc = new Scanner(System.in);

        // print the menu
        while (true){


            System.out.println("********************************************************************");
            System.out.println("*                    Welcome To the Queue APP                      *");
            System.out.println("*                                                                  *");
            System.out.println("********************************************************************");
            System.out.println("Please select one of the options:");
            System.out.println("1. Get a Number for the Queue");
            System.out.println("2. Get a Number in the from of the queue");
            System.out.println("3. Get a number in a custom position");
            System.out.println("4. Print your position in the queue");
            System.out.println("5. Delete a person from the queue using ID");
            System.out.println("6. Delete X number of people from the end of the queue");
            System.out.println("7. Call the next person in the queue");
            System.out.println("8. Print the queue");
            System.out.println("9. Update Person details by ID");
            menuOption=validateMenuNumber(sc,1,9);
            System.out.println(menuOption);
            // check which option was selected
            switch(menuOption) {
                case 1 :
                    newPerson=getPersonDetails(sc);
                    newList.appendPerson(newPerson.name,newPerson.lname,newPerson.passportNo);
                    System.out.println("The person has been added to the queue.");
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case 2 :
                    newPerson=getPersonDetails(sc);
                    newList.preAppendPesorn(newPerson.name,newPerson.lname,newPerson.passportNo);
                    System.out.println("The person has been added to the queue.");
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case 3 :
                    nPersons=newList.printNumberPersonInQueue();
                    System.out.println("What position do you want?");
                    position=validatePositiveNumbers(sc);
                    newPerson=getPersonDetails(sc);
                    newList.insertPersonAtPositionX(position,newPerson.name,newPerson.lname,newPerson.passportNo);
                    System.out.println("The person has been added to the queue");
                    TimeUnit.SECONDS.sleep(2);
                    break;
                case 4 :
                    newList.display();
                    System.out.println("What is your ID number?");
                    position=validatePositiveNumbers(sc);
                    newList.getPositionByID(position);
                    TimeUnit.SECONDS.sleep(3);
                    break;
                case 5 :
                    newList.display();
                    System.out.println("What ID do you want to delete?");
                    position=validatePositiveNumbers(sc);
                    newList.deleteByID(position);
                    newList.display();
                    TimeUnit.SECONDS.sleep(3);
                    break;
                case 6 :
                    newList.display();
                    System.out.println("How many persons do you want to delete?");
                    position=validatePositiveNumbers(sc);
                    newList.deletePersonsAtEnd(position);
                    System.out.println(position+" People were removed from the end of the queue");
                    newList.display();
                    TimeUnit.SECONDS.sleep(3);
                    break;
                case 7 :
                    newList.dequeuePerson();
                    TimeUnit.SECONDS.sleep(3);
                    break;
                case 8 :
                    newList.display();
                    TimeUnit.SECONDS.sleep(3);
                    break;
                case 9 :
                    newList.display();
                    System.out.println("What is your ID number?");
                    position=validatePositiveNumbers(sc);
                    newPerson=getPersonDetails(sc);
                    newList.updatePersonDetailsByID(position,newPerson.name,newPerson.lname,newPerson.passportNo);
                    System.out.println("your details have been updated!");
                    newList.display();
                    TimeUnit.SECONDS.sleep(3);
                    break;
            }
        }



        }
    // this method is used to getting the info of the new person in the queue
    private static Person getPersonDetails(Scanner sc) {
        String name;
        String lname;
        int passportNo;

        System.out.println("Please enter your details");
        System.out.println("Enter first Name");
        name = getString(sc);
        System.out.println("Enter Last name");
        lname = getString(sc);
        System.out.println("Enter passport number ");
        passportNo=validatePositiveNumbers(sc);

        return new Person(name,lname,passportNo);
    }

    // validate that the user insert string
    private static String getString(Scanner sc) {
        String str=null;
        do{
            while (!sc.hasNext(".*[a-zA-Z]+.*")){
                System.out.println("Please enter Strings");
                sc.next();
            }
            str=sc.next();
        }while(str==null);
        return str;
    }

    // validate the number inserted is in between of a range
    public static int validateMenuNumber(Scanner sc, int from, int to){
        int userInput=0;
        do {
            System.out.println("Please enter the number option");
            while (!sc.hasNextInt() && (userInput <from || userInput>to)) {
                System.out.println("That's not a number or is not an option!");
                sc.next(); // this is important!
            }
            userInput = sc.nextInt();
        } while (userInput <from || userInput>to);
        return userInput;
    }

    // validate the number inserted is positive
    public static int validatePositiveNumbers(Scanner sc){
        int number;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            number = sc.nextInt();
        } while (number <= 0);
        return number;
    }
}
