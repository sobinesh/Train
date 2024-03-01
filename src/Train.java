import java.util.ArrayList;

public class Train {
    ArrayList<Ticket> confirmedTickets=new ArrayList<>();
    ArrayList<Ticket> RACTickets=new ArrayList<>();
    ArrayList<Ticket> waitingList=new ArrayList<>();
    Berth berth=new Berth();

    public String book(Ticket ticket){
        if(confirmedTickets.size()<63){
            berth.allocateBerth(ticket);
            confirmedTickets.add(ticket);
        }
        else if(RACTickets.size()<18){
            ticket.setConfirmationStatus("booked RAC");
            RACTickets.add(ticket);
        } else if (waitingList.size()<10) {
            ticket.setConfirmationStatus("booked waiting List");
            waitingList.add(ticket);
        }
        else{
            System.out.println("No Seats Available");
            return "No Seats Available";
        }
        displayTicket(ticket);
        return ticket.getConfirmationStatus();
    }
    public void Cancel(int id,String status) {
        switch (status) {
            case "Confirmed" -> {
                for (Ticket token : confirmedTickets) {
                    if (token.ID == id) {
                        confirmedTickets.remove(token);
                        if (!RACTickets.isEmpty()) {
                            confirmedTickets.add(RACTickets.getFirst());
                            RACTickets.removeFirst();
                            if (!waitingList.isEmpty()) {
                                RACTickets.add(waitingList.getFirst());
                                waitingList.removeFirst();
                            }
                        }
                        System.out.println("ticked cacelled, confirmed ticket ID.no:" + id);
                    }
                }
            }
            case "RAC" -> {
                for (Ticket token : RACTickets) {
                    if (token.ID == id) {
                        RACTickets.remove(token);
                        if (!waitingList.isEmpty()) {
                            RACTickets.add(waitingList.getFirst());
                            waitingList.removeFirst();
                        }
                        System.out.println("ticked cacelled, RAC ticket ID.no:" + id);
                    }
                }
            }
            case "Waiting List" -> {
                for (Ticket token : waitingList) {
                    if (token.ID == id) {
                        waitingList.remove(token);
                        System.out.println("ticked cacelled, Waiting List ID.no:" + id);
                    }
                }
            }
            case null, default -> System.out.println("ID not found");
        }
    }

    public void Display(){
        System.out.println("Confirm available tickets are " + (63 - confirmedTickets.size()));
        System.out.println("Rac available tickets are " + (18 - RACTickets.size()));
        System.out.println("Waiting list available tickets are " + (10 - waitingList.size()));
    }

    public void displayTicket(Ticket ticket){
        System.out.println("ID.no : "+ticket.ID);
        System.out.println("Name  : "+ticket.name);
        System.out.println("Age   : "+ticket.age);
        System.out.println("Status: "+ticket.getConfirmationStatus());
    }

}
