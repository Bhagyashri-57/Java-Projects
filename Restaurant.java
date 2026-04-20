public class Restaurant {
    String food;
    int orderNumber;
    double price;
    String category;

    public Restaurant(String food,int orderNumber,double price,String category){
        this.food=food;
        this.orderNumber=orderNumber;
        this.price=price;
        this.category=category;


    }
    public String getfood(){
        return this.food;
    }
    public int getorderNumber(){
        return this.orderNumber;
    }
    public double getprice(){
        return this.price;
    }
    public String getcategory(){
        return this.category;
    }

    
}
