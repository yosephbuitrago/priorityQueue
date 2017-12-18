/*
 * Authors
 * Yoseph Buitrago    2016292
 * Jin Lim            2015158
 *
 *
 */
public class LinkedList {

    Person head;
    Person tail;
    int countPersonInqueue=0;

    // add a person to the end of the queue
    public void appendPerson(String name,String lname,int passport){
        Person newPersonInQueue = new Person(name,lname,passport);
        countPersonInqueue++;
        //check if list is empty
        if(isEmpty()){
            this.head=newPersonInQueue;
            this.tail=newPersonInQueue;
            return;
        }else{
            // at the person to the tail
            this.tail.next=newPersonInQueue;
            newPersonInQueue.behind=tail;
            this.tail=newPersonInQueue;
        }
    }

    //add a person to the beginning of the queue
    public void preAppendPesorn(String name,String lname,int passport){
        Person newPersonInQueue = new Person(name,lname,passport);
        countPersonInqueue++;
        if(isEmpty()){
            this.tail=newPersonInQueue;
            this.head=newPersonInQueue;
            return;
        }else{
            this.head.behind=newPersonInQueue;
            newPersonInQueue.next=this.head;
            this.head=newPersonInQueue;
        }

    }

    public void insertPersonAtPositionX(int position,String name,String lname,int passport){
        position--;
        countPersonInqueue++;
        Person newPersonInQueue = new Person(name,lname,passport);
        if(isEmpty()){
            this.tail=newPersonInQueue;
            this.head=newPersonInQueue;
            return;
        }else if(position == 0){ // check if the position is 0 the person become the head of the queue
            newPersonInQueue.next = head;
            this.head.behind=newPersonInQueue;
            this.head=newPersonInQueue;
            return ;
        }
        // otherwise we go through the list looking for the position
        Person currentPerson = this.head;
        int temp=0;
        while(temp!=position && currentPerson.next!=null){
            currentPerson = currentPerson.next;
            temp++;
        }
        // if the current.next is null and the position to insert is bigger that elements in the list the new person become the tail
        if(currentPerson.next==null && position>temp){
            this.tail=newPersonInQueue;
            currentPerson.next=newPersonInQueue;
            newPersonInQueue.behind=currentPerson;
            return;
        }
        // if insertion is to the end of the current list. the new person is behind the tail
        if (currentPerson.next==null)this.tail=currentPerson;
        newPersonInQueue.next=currentPerson;
        currentPerson.behind.next=newPersonInQueue;
        newPersonInQueue.behind=currentPerson.behind;
        currentPerson.behind=newPersonInQueue;

    }

    // Update the details of a person by specifying their unique ID number
    public void updatePersonDetailsByID(int id,String name, String lname,int passport){
        if (isEmpty())return;
        Person currentPerson = head;
        while(currentPerson.id!=id && currentPerson.next!=null){
            //System.out.println(currentPerson.id);
            currentPerson = currentPerson.next;
        }
        if (currentPerson.id==id){
            if(name!=null && name!="") {
                currentPerson.name=name;
            }
            if(lname!=null && lname!=""){
                currentPerson.lname=lname;
            }
            if(passport>0) {
                currentPerson.passportNo=passport;
            }
        }
    }


    // print the position of a person in the queue by specifying the ID number
    public void getPositionByID(int id){
        if (isEmpty())return;
        Person currentPerson = head;
        int position=1;
        while(currentPerson.id!=id && currentPerson.next!=null){
            //System.out.println(currentPerson.id);
            currentPerson = currentPerson.next;
            position++;
        }
        if (currentPerson.id==id){
            System.out.println("Your Position is: "+position);
            return;

        }
        System.out.println("Sorry you are not in the list");
    }

    // delete a person from the front od the queue
    public void dequeuePerson(){

        if (isEmpty()){
            System.out.println("Sorry the queue is empty");
            return;
        }
        // check if there is one person in the queue
        if(this.tail==this.head){
            System.out.println("Please the next Number is: "+this.head.id+" "+this.head.name+" "+this.head.lname);
            this.head=null;
            this.tail=null;
        }else {
            System.out.println("Please the next Number is: "+this.head.id+" "+this.head.name+" "+this.head.lname);
            this.head=this.head.next;
        }
        countPersonInqueue--;

    }

    // delete a person by the unique ID number
    public void deleteByID(int id){

        Person currentPerson = head;

        if(isEmpty()) {
            System.out.println("Sorry the queue is empty");
            return;
        }else if(this.head.id==id) {
            if (this.head.next==null){
                this.head=null;
                this.tail=null;
                countPersonInqueue--;
                return;
            }
            this.head=head.next;
            countPersonInqueue--;
            return;
        }

        while(currentPerson.id!=id && currentPerson.next!=null){
            currentPerson = currentPerson.next;
        }
        if (currentPerson.next==null && currentPerson.id==id) {
            this.tail=currentPerson.behind;
            currentPerson.behind.next =null;
            countPersonInqueue--;
        }
        if (currentPerson.id==id && currentPerson.next!=null){
            currentPerson.behind.next = currentPerson.next;
            countPersonInqueue--;
        }

    }

    // Delete N number of persons from the end of the queue
    public void deletePersonsAtEnd(int NoToDelete){
        Person currentPerson=this.tail;
        if (NoToDelete>=countPersonInqueue){
            this.head=null;
            this.tail=null;
            System.out.println("Now the queue is empty");
        }else{
            countPersonInqueue-=NoToDelete;
            int temp=0;
            while (temp!=NoToDelete && currentPerson.behind!=null){
                currentPerson=currentPerson.behind;
                temp++;
            }
            this.tail=currentPerson;
            this.tail.next=null;
        }


    }

    // check if the list is empty
    public boolean isEmpty(){
        return (this.head==null && this.tail==null);
    }

    // print the person's ID and their name
    public void display(){
        if(isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        Person current = head;
        System.out.println("These are the persons in the queue");

        while(current.next!=null){
            System.out.println("ID: "+current.id+" Name: "+current.name+" "+current.lname);
            current=current.next;
        }
        System.out.println("ID: "+current.id+" Name: "+current.name+" "+current.lname);
        System.out.println("Number of person in queue: "+countPersonInqueue);
    }

    public int  printNumberPersonInQueue(){
        System.out.println("There are "+countPersonInqueue+" people in queue");
        return countPersonInqueue;
    }
}
