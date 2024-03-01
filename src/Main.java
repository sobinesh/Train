import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc=new Scanner(System.in);
    static Train train=new Train();

    public static void main(String[] args) {

        int ID=1;
        while(true){
            System.out.println();
            System.out.println("1.book");
            System.out.println("2.cancel");
            System.out.println("3.display");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");
            int input=sc.nextInt();
            switch (input){
                case 1:
                    if(train.book(generateTicket(ID))!="No Seats Available"){
                    ID++;
                    }
                    break;

                case 2:
                    System.out.print("Enter ID:");
                    int id=sc.nextInt();
                    System.out.print("Enter booking status (Confirmed,RAC,Waiting List):");
                    String status=sc.next();
                    train.Cancel(id,status);
                    break;

                case 3:
                    train.Display();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Enter a valid input");
            }
        }
    }

    public static Ticket generateTicket(int ID){
        System.out.print("Enter name:");
        String name=sc.next();
        System.out.print("Enter age:");
        int age=sc.nextInt();
        System.out.print("Enter gender:");
        String gender=sc.next();
        System.out.print("Enter Prefered Berth:");
        String preferedBerth=sc.next();
        System.out.println();
        return new Ticket(name, age, gender, preferedBerth,ID);
    }
}