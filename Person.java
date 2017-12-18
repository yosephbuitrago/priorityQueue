import java.util.Date;
public class Person {
    static int counter=0;
    int id ;
    String name;
    String lname;
    int passportNo;
    Date date;
    Person next;
    Person behind;

    Person(String name,String lname,int passportNo){
        this.name=name;
        this.lname=lname;
        this.passportNo=passportNo;
        this.date=new Date();
        this.behind=null;
        this.next=null;
        this.id=counter;
        counter++;
    }




}
