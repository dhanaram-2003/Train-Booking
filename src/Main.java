import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int numGen = 1;
    static List<Ticket> booked = new ArrayList<>();
    static int upper = 1;
    static int lower = 1;
    static int middle = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("----- Welcome to Train Booking -----");
            System.out.println("1.Booking");
            System.out.println("2.Display");
            System.out.println("3.Cancel");
            System.out.println("4.Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    if(bookTicket())
                        System.out.println("Booking Confirmed!");
                    break;

                case 2:
                    viewTicketDetails();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    System.exit(0);
                    //exit
                default:
                    System.out.println("!!! Enter Valid Choice !!!");
            }

        }
    }

    public static boolean bookTicket(){
        Scanner sc = new Scanner(System.in);
        if(booked.size()<3){
            System.out.print("Enter Your Name: ");
            String name = sc.nextLine();
            System.out.print("from: ");
            String from = sc.nextLine();
            System.out.print("to: ");
            String to = sc.nextLine();
            char pref = 'l';
            boolean flag=true;
            while(flag){
                System.out.print("Berth Preference [U/M/L]: ");
                pref = sc.nextLine().charAt(0);
                if(Character.toLowerCase(pref) != 'u' && Character.toLowerCase(pref) != 'm'&& Character.toLowerCase(pref) != 'l'){
                    System.out.println("Enter valid berth!!!");
                }
                else flag=false;
            }
            Ticket ticket = new Ticket(numGen++,name,from,to,Character.toLowerCase(pref));
            if(Character.toLowerCase(pref) == 'l'){
                if(lower!=0){
                    booked.add(ticket);
                    lower--;
                } else if (middle!=0) {
                    ticket.setBerthPref('m');
                    booked.add(ticket);
                    System.out.println("Lower Berth Not Available! Middle Berth Confirmed!");
                    middle--;
                }
                else {
                    ticket.setBerthPref('u');
                    booked.add(ticket);
                    System.out.println("Lower Berth Not Available! Upper Berth Confirmed!");
                    upper--;
                }
            } else if (Character.toLowerCase(pref) == 'm') {
                if(middle!=0){
                    booked.add(ticket);
                    middle--;
                } else if (lower!=0) {
                    ticket.setBerthPref('l');
                    booked.add(ticket);
                    System.out.println("Middle Berth Not Available! Lower Berth Confirmed!");
                    lower--;
                }
                else {
                    ticket.setBerthPref('u');
                    booked.add(ticket);
                    System.out.println("Middle Berth Not Available! Upper Berth Confirmed!");
                    upper--;
                }
            }
            else {
                if(upper!=0){
                    booked.add(ticket);
                    upper--;
                } else if (middle!=0) {
                    ticket.setBerthPref('m');
                    booked.add(ticket);
                    System.out.println("Upper Berth Not Available! Middle Berth Confirmed!");
                    middle--;
                }
                else {
                    ticket.setBerthPref('l');
                    booked.add(ticket);
                    System.out.println("Upper Berth Not Available! Lower Berth Confirmed!");
                    lower--;
                }
            }
            return true;
        }
        else{
            System.out.println("Bookings full !!!");
            return false;
        }
    }

    public static void viewTicketDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Ticket Number: ");
        int ticketNum = sc.nextInt();

        Ticket ticket = null;
        for(Ticket t:booked){
            if(t.getNum() == ticketNum)
                ticket = t;
        }
        if(ticket != null){
            System.out.println("Ticket Number:" + ticket.getNum());
            System.out.println("Name:" + ticket.getpName());
            System.out.println("From:" + ticket.getFrom());
            System.out.println("T0:" + ticket.getTo());
            System.out.println("Berth:"+ ticket.getBerthPref());
        }
        else System.out.println("Ticket Not Available !!!");
    }

    public static void cancelTicket(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Ticket Number: ");
        int ticketNum = sc.nextInt();
        boolean flag = false;
        for(Ticket t:booked){
            if(t.getNum() == ticketNum) {
                char pref = t.getBerthPref();
                if(pref == 'u') upper++;
                else if(pref == 'm') middle++;
                else lower++;
                flag = booked.remove(t);
                break;
            }
        }
        if(flag) System.out.println("Cancelled Successfully!");
        else System.out.println("Invalid Ticket Detail !!!");

    }
}