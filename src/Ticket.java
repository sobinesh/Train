public class Ticket {

    String name;
    int age;
    String gender;
    String preferedBerth;
    private String confirmationStatus;
    int ID;
    public Ticket(String name,int age,String gender,String preferedBerth, int ID){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.preferedBerth=preferedBerth;
        this.ID=ID;
    }
    public String getConfirmationStatus(){
        return confirmationStatus;
    }
    public void setConfirmationStatus(String confirmationStatus){
        this.confirmationStatus=confirmationStatus;
    }

}
