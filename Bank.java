public class Bank{
    private long accNumber;
    private int pin;
    private String master;
    private double balance;

    public Bank(long accNumber,int pin,String master,double balance){
        this.accNumber=accNumber;
        this.pin=pin;
        this.master=master;
        this.balance=balance;
    }
    public long getAccNumber(){
        return this.accNumber;
    }
    public String getMaster(){
        return this.master;
    }
    public double getBalance(){
        return this.balance;

    }
    public void credit(double amount){
        this.balance=this.balance+amount;
        System.out.println(this.accNumber+" Credited with ₹"+amount+" Aval Balance: ₹"+this.balance);

    }
    private boolean isValidPin(int pin){
        return this.pin==pin;
    }
    public boolean isLiable(double amount){
        return this.balance>amount;
    }
    public void debit(double amount , int pin){
        if(isLiable(amount)){
            if(isValidPin(pin)){
                this.balance=this.balance-amount;
            }
            else{
                System.out.println("Invalid pin");
            }
        }else{
                System.out.println("Insufficient Balance"+this.balance);
            }
        }
    }
