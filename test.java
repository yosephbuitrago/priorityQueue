

public class test {
    public static void main(String[] args) {

        LinkedList newList = new LinkedList();

        newList.preAppendPesorn("Arcelia","Labrador",321);
        newList.appendPerson("Yoseph","Buitrago",123);
        newList.appendPerson("Michel","Gayon",123);
        newList.preAppendPesorn("Yenny","radwan",321);
       // newList.deleteByID(2);
       // newList.updatePersonDetailsByID(4,"","Buitrago",0);

        System.out.println("----------insert 4 people----------");
        newList.display();
        //newList.getPositionByID(1);

        System.out.println("----------insert pedro at 4----------");
        newList.insertPersonAtPositionX(4,"pedro","rojas",98);
        newList.display();

        System.out.println("----------delete 3 people from end----------");
        newList.deletePersonsAtEnd(3);
        newList.display();

        System.out.println("---------- add jesus at 2----------");
        newList.insertPersonAtPositionX(2,"Jesus","Guardiola",321);
        newList.display();

        System.out.println("---------- add anell to end----------");
        newList.appendPerson("Annel","Jaimes",123);
        newList.display();

        System.out.println("----------add cindy in front----------");
        newList.preAppendPesorn("Cindy","Jimenes",123);
        newList.display();

        System.out.println("----------add jim to end----------");
        newList.appendPerson("jim","lim",123);
        newList.display();

        System.out.println("----------delete id 8----------");
        newList.deleteByID(8);
        newList.display();

        System.out.println("----------delete 1 people from the end----------");
        newList.deletePersonsAtEnd(1);
        newList.display();

        System.out.println("----------delete by id id 7----------");
        newList.deleteByID(7);
        newList.display();

        System.out.println("----------delete 1 people from end----------");
        newList.deletePersonsAtEnd(1);
        newList.display();

        System.out.println("----------add anell to end----------");
        newList.appendPerson("Annel","Jaimes",123);
        newList.display();

        System.out.println("----------get position by id 3----------");
        newList.getPositionByID(3);
        newList.display();

        System.out.println("---------- dequeue ----------");
        newList.dequeuePerson();
        newList.display();

        System.out.println("---------- dequeue ----------");
        newList.dequeuePerson();
        newList.display();

        System.out.println("---------- dequeue ----------");
        newList.dequeuePerson();
        newList.display();

        System.out.println("---------- insert pedro at 1----------");
        newList.insertPersonAtPositionX(1,"pedro","rojas",98);
        newList.display();

        System.out.println("----------delete by id 10----------");
        newList.deleteByID(10);
        newList.display();

        System.out.println("----------insert pedro at 1----------");
        newList.insertPersonAtPositionX(1,"pedro","rojas",98);
        newList.display();

        System.out.println("----------insert arcelia to front----------");
        newList.preAppendPesorn("Arcelia","Labrador",321);
        newList.display();

        System.out.println("---------- dequeue ----------");
        newList.dequeuePerson();
        newList.display();

        System.out.println("---------- dequeue ----------");
        newList.dequeuePerson();
        newList.display();

        System.out.println("----------delete by id 10----------");
        newList.deleteByID(10);
        newList.display();

        System.out.println("----------insert pedro at 2----------");
        newList.insertPersonAtPositionX(6,"pedro","rojas",98);
        newList.display();

        System.out.println("----------add anell to end----------");
        newList.appendPerson("Annel","Jaimes",123);
        newList.display();
    }
}
