package Project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

interface regi  // interface
{
    void logIn();
    void registration();

}
class register implements regi{ // abstraction

    private String name;  // data hiding
    private long contactNo = 9967422942L;
    private String password="v123" ;
    private String email ;
    private int otp;
    String address ;

    static ArrayList<String> address1 =new ArrayList<>(); // Collections using

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo() {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the contact no.: ");
        try {
            contactNo = sc.nextLong();

            if ((contactNo > 999999999L) && (contactNo < 10000000000L)) {
                System.out.println("Valid contact no. please continue");
            } else {
                System.out.println("!!!!!!!!!!!! Invalid contact no.,please enter valid 10 digit contact no. !!!!!!!!!!!!");
                setContactNo();
            }
        }catch (Exception e){
            System.out.println(" Invalid contact no.,please enter valid 10 digit contact number............: /");
            setContactNo();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your email: ");
            email = sc.nextLine();

            if (email.contains("@") && email.contains(".com")) {

                address1.add(email);
                System.out.println("valid email id ,please continue : )");

            } else {
                System.out.println("please, enter valid email id : (");
                setEmail();
            }
        }catch (Exception e){
            System.out.println("please, enter valid email id...................: /");
            setEmail();
        }
    }

    public void setOtp() { // Random class is used to generate pseudo-random numbers in java

        Random r=new Random(); //Random(): Creates a new random number generator
        int n=r.nextInt(1000,9999);//	nextInt(origin, bound): returns a pseudorandom chosen integer value between the specified 'origin' and 'bound'.

        System.out.println("--------------------------------------------------------------------");
        System.out.println("                                                  Messages:");
        System.out.println("                                                  OTP: "+n);
        System.out.println("--------------------------------------------------------------------");

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        try {

            otp = sc.nextInt();
            if (otp == n) {
                System.out.println("Your entered a valid OTP,please Continue :).....");
            } else {
                System.out.println("Your entered a Invalid OTP,please try again :/.....");
                setOtp();
            }
        }catch (Exception e){
            System.out.println("Your entered a Invalid OTP,please try again :/.....");
            setOtp();
        }
    }

    public void logIn() {

        Scanner sc=new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("|                                                                   |");
        System.out.println("|            {-------------- Log In --------------}                 |");
        System.out.println("|                                                                   |");
        System.out.println("|===================================================================|");

        System.out.print("Enter your Contact no.: ");

        // Exception handling -

        try {
            long contactNo = sc.nextLong();

            sc.nextLine();

            System.out.print("Enter your password: ");
            String pass = sc.nextLine();

            if ((this.contactNo == contactNo) && (password.equals(pass))) {
                System.out.println("Your are loginIn successfully ................... :)");
                setOtp();
            } else {
                System.out.println("Invalid input,please enter valid contact no. and password ................ :/");
                logIn();
            }
        }catch (Exception e){
            System.out.println("Invalid input,please enter valid contact no. and password ................ :/");
            logIn();
        }
    }

    public void registration() {

        Scanner sc= new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("|                                                                   |");
        System.out.println("|            {-------------- Sign Up --------------}                |");
        System.out.println("|                                                                   |");
        System.out.println("|===================================================================|");

        System.out.print("Enter your name: ");
        String name1=sc.nextLine();
        setName(name1);
        setContactNo();

        System.out.print("Enter your password: ");
        password=sc.nextLine();

        setEmail();

        System.out.print("Enter your address: ");
        address= sc.nextLine();

        setOtp();

        System.out.println("Your are Register successfully");

        logIn();
    }
}

class Category extends UserDetails{

    static ArrayList<String>a =new ArrayList(); // Collection - it is a group of object
    static ArrayList <Integer>b =new ArrayList();
    static int bill=0; // global variable
    static int discount;
    static int Coupon;
    static int count=0;

    public void totalBill() {

        if(count==0) {
            for (int i : b) {  // for each loop - to print collection object or items
                bill = bill + i;
            }
            count++;
        }
        System.out.println("|===================================================================|");

        System.out.println("Your total bill amount is " + bill);
        int prevBill=bill;
        System.out.println("|===================================================================|");

        System.out.println("If you have a coupon for yes press Y then no for press N");
        Scanner sc=new Scanner(System.in);
        String co= sc.next();
        if(co.equals("Y")|| co.equals("y")){

            System.out.println("Enter the Coupon code:");
            System.out.print("NV");
            int coupon= sc.nextInt();

            System.out.println("--------------------------------------------------------------");
            if (Coupon == coupon && coupon <=49){
                System.out.println(".....Congratulation you get 10% discount.....");
                bill=bill- (int) (bill * 0.1);
            }
            else if (Coupon == coupon && (coupon>=50 && coupon <=94)){
                System.out.println(".....Congratulation you get 20% discount.....");
                bill=bill- (int) (bill * 0.2);
            }
            else if(Coupon == coupon && (coupon>=95 && coupon<=100)){
                System.out.println(".....Congratulation you get 50% discount.....");
                bill=bill- (int) (bill * 0.5);
            }
            else{
                System.out.println("Please the give input...... :/");
                totalBill();
            }
            System.out.println("--------------------------------------------------------------");
        }
        else {
            System.out.println("Ok.... Continue.... : ) ");
        }

        int discountBill=bill;

        System.out.println("After discount the bill is " + bill);
        System.out.println("|===================================================================|");

        discount=prevBill-discountBill;
        System.out.println(bill);
        paymentBill();
        Bill(bill);
        category();
    }

    public void paymentBill(){

        System.out.println("-----------------------------------------------------");
        System.out.println("                      total bill");
        System.out.println("-----------------------------------------------------");
        for (int i=0;i<a.size();i++){
            System.out.println((i+1)+". "+a.get(i));
            System.out.println("                                           "+b.get(i));
        }
        System.out.println("-----------------------------------------------------");

        System.out.println("     DISCOUNT                          :  -"+discount);
        int sgst=(int)(bill*0.09);
        System.out.println("     SGST                              :   "+sgst);
        int cgst=(int)(bill*0.09);
        System.out.println("     CGST                              :   "+cgst);
        System.out.println("-----------------------------------------------------");
        bill=(bill+sgst+cgst);
        System.out.println("              total                    :   "+bill);
        System.out.println("-----------------------------------------------------");

        System.out.println("|===================================================================|");

    }
    public void OTP(){

        Random r=new Random();
        int n=r.nextInt(1000,9999);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("                                                  Messages:");
        System.out.println("                                                  OTP: "+n);
        System.out.println("--------------------------------------------------------------------");

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        int otp=sc.nextInt();
        if(otp==n){
            System.out.println("Your entered a valid OTP,please Continue :).....");
        }
        else{
            System.out.println("Your entered a Invalid OTP,please try again :/.....");
            OTP();
        }
    }

    public long paymentContanctno(){

        System.out.print("Enter the contact number: ");
        Scanner sc = new Scanner(System.in);
        long contact = sc.nextLong();
        if ((contact>999999999L) && (contact<10000000000L)){
            System.out.println("Valid contact no. please continue");
            OTP();
            return contact;
        }
        else{
            System.out.println("!!!!!!!!!!!! Invalid contact no.,please enter valid 10 digit contact no. !!!!!!!!!!!!");
            paymentContanctno();
        }
        return contact;

    }
    public void Bill(int bill1){

        Scanner sc = new Scanner(System.in);

        System.out.println("Press 1 for UPI");
        System.out.println("Press 2 for cash");

        System.out.print("->");

        int n = sc.nextInt();
        switch (n) {
            case 1:
                long contact=paymentContanctno();
                payment(contact,bill);
                break;
            case 2:
                payment(bill);
                break;
            default:
                totalBill();
                break;
        }
    }

    public void payment(long upi,int bill) {  // method overloading - a class have a different method with the same name
                                                    // but different formal argument either in length or different in datatype

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        int amount = sc.nextInt();

        if (bill==amount) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("thank you for paying "+amount);

            delivery();

            System.out.println("Please, visit again... :)");
            System.out.println("-------------------------------------------------------------------");
            a.clear();
            b.clear();
            Category.bill=0;
            discount=0;
            Coupon=0;
            count=0;
        }
        else {
            System.out.println("Please, enter the given amount ");
            payment(upi,bill);
        }

    }
    public void payment(int cash) { // method overloading

        System.out.println("-------------------------------------------------------------------");
        System.out.println("thank you for paying "+cash);

        delivery();

        System.out.println("                    Please, visit again... :)");
        System.out.println("-------------------------------------------------------------------");
        a.clear();
        b.clear();
        bill=0;
        discount=0;
        Coupon=0;
        count=0;
    }
    public void delivery(){

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Delivery address details");
        System.out.println("-------------------------------------------------------------------");
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter address for delivery:");
        String s=sc.nextLine();

        deliveryTime(s,deliveryDate());
    }
    public String deliveryDate(){ // no argument method

        //Java provides a built-in class called Calendar to handle date and time-related operations.

        Calendar c=Calendar.getInstance(); //Calendar.getInstance(): return a Calendar instance based on the current time in the
                                            // default time zone with the default locale.
        int dd=c.get(Calendar.DATE);
        int mm=c.get(Calendar.MONTH)+1;

        if(dd==31){
            return (""+mm);
        }else{
            return (""+(dd+5)+"/"+mm+"/"+c.get(Calendar.YEAR));
        }
    }

    public void deliveryTime(String s,String s1){ // parameterized method

        Scanner sc=new Scanner(System.in);
        Random r=new Random();

        Order o = new Order();



        int n1=r.nextInt(1000,9999);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Delivery Timing");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Press 1 for 9AM to 1PM");
        System.out.println("Press 2 for 1PM to 5PM");
        System.out.println("Press 3 for 5PM to 9PM");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("-> ");

        try {
            int n = sc.nextInt();
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                Your order delivery details");
            System.out.println("-------------------------------------------------------------------");

            switch (n){
                case 1:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Order no.: "+n1);
                    System.out.println("Your order delivery address is"+ s);
                    System.out.println("Your order delivery date is"+s1);
                    System.out.println("Your order delivery Timing is 9AM to 1PM");
                    System.out.println("-------------------------------------------------------------------");
                    o.Order(n1,s,s1,"9AM to 1PM",bill,a.size());
                    break;
                case 2:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Order no.: "+n1);
                    System.out.println("Your order delivery address is"+ s);
                    System.out.println("Your order delivery date is"+s1);
                    System.out.println("Your order delivery Timing is 1PM to 5PM");
                    System.out.println("-------------------------------------------------------------------");
                    o.Order(n1,s,s1,"1PM to 5PM",bill,a.size());
                    break;
                case 3:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Order no.: "+n1);
                    System.out.println("Your order delivery address is"+ s);
                    System.out.println("Your order delivery date is"+s1);
                    System.out.println("Your order delivery Timing is 5PM to 9PM");
                    System.out.println("-------------------------------------------------------------------");
                    o.Order(n1,s,s1,"5PM to 9PM",bill,a.size());
                    break;
                default:
                    System.out.println("You entered a wrong input");
                    deliveryTime(s,s1);
            }
        }catch (Exception e){
            System.out.println("You entered a wrong input.......: /");
            deliveryTime(s,s1);
        }
    }
    public void discountDhamaka()
    {
        Random r=new Random();
        int n=r.nextInt(0,100);
        Coupon=n;
        System.out.println("Coupon code : NV"+n);
        category();
    }
    public void category() {  // Home page method

        Scanner sc = new Scanner(System.in);

        System.out.println("|=========================================================================================|");
        System.out.println("|                                                                                         |");
        System.out.println("|                              +------------------------+                                 |");
        System.out.println("|                              |  -----HOME PAGE------  |                                 |");
        System.out.println("|                              +------------------------+                                 |");
        System.out.println("|                                                                                         |");
        System.out.println("|                               Press 9 for Order Details                                 |");
        System.out.println("|                                                                                         |");
        System.out.println("|  Press 7 for User Details                                             Press 6 for Cart  |");
        System.out.println("|                                     ~~~~~~~~~~                                          |");
        System.out.println("|                                     -Category-                                          |");
        System.out.println("|                                     ~~~~~~~~~~                                          |");
        System.out.println("|                                                                                         |");
        System.out.println("|                                 Press 1 for Carpenter                                   |");
        System.out.println("|                                 Press 2 for Painter                                     |");
        System.out.println("|                                 Press 3 for Plumber                                     |");
        System.out.println("|                                 Press 4 for Civil                                       |");
        System.out.println("|                                 Press 5 for Electrician                                 |");
        System.out.println("|                                 Press 0 for Exit                                        |");
        System.out.println("|                                                                                         |");
        System.out.println("|         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         |");
        System.out.println("|         !!!!!!DIWALI DHAMAKA OFFER TO GET THE DISCOUNT COUPON CODE PRESS 8!!!!!         |");
        System.out.println("|         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         |");
        System.out.println("|                                                                                         |");
        System.out.println("|=========================================================================================|");

        System.out.print("->");
        try {

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("1.Product of Carpenter");
                    Carpenter c1 = new Carpenter();
                    c1.Carpenter();
                    break;
                case 2:
                    System.out.println("2.Product of Painter");
                    Painter P1 = new Painter();
                    P1.Painter();
                    break;
                case 3:
                    System.out.println("3.Product of Plumber");
                    Plumber P2 = new Plumber();
                    P2.Plumber();
                    break;
                case 4:
                    System.out.println("4.Product of Civil");
                    Civil c2 = new Civil();
                    c2.Civil();
                    break;
                case 5:
                    System.out.println("5.Product of Electrician");
                    Electrician e = new Electrician();
                    e.Electrician();
                    break;
                case 0:
                    System.exit(0);
                    break;
                case 6:
                    System.out.println("Welcome to Govind hardware Cart");
                    Cart c3 = new Cart();
                    c3.cart();
                    break;
                case 7:
                    System.out.println("--------------------------------------");
                    System.out.println("User Details.......");
                    System.out.println("--------------------------------------");
                    userDetails();
                    break;
                case 8:
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("                   WELCOME TO NAVRATRI DHAMAKA");
                    System.out.println("--------------------------------------------------------------------");
                    discountDhamaka();
                    break;
                case 9:
                    System.out.println("--------------------------------------");
                    System.out.println("Order Details.......");
                    System.out.println("--------------------------------------");
                    Order o =new Order();
                    o.orderDetails();
                    break;
                default:
                    System.out.println("Please enter valid input");
                    System.out.println("-------------------------------");
                    category();
                    break;
            }
        }catch (Exception e){
            System.out.println("Please enter valid input................: /");
            System.out.println("-------------------------------------------");
            category();
        }
    }
}


class Order extends Category{

    static ArrayList orderID =new ArrayList<>();
    static ArrayList orderPlace = new ArrayList<>();
    static ArrayList orderDate = new ArrayList<>();
    static ArrayList orderTime = new ArrayList<>();
    static ArrayList orderAmount =new ArrayList<>();
    static ArrayList orderItem = new ArrayList<>();
     public void Order(int i,String place,String date,String time,int amount,int item){

            orderID.add(i);
            orderPlace.add(place);
            orderDate.add(date);
            orderTime.add(time);
            orderAmount.add(amount);
            orderItem.add(item);
    }
    public void orderDetails(){
        System.out.println("|===================================================================|");
        System.out.println("|                                                                   |");
        System.out.println("|                         ~~~~~~~~~~~~~                             |");
        System.out.println("|                         Order Details                             |");
        System.out.println("|                         ~~~~~~~~~~~~~                             |");
        System.out.println("|                                                                   |");
        System.out.println("|===================================================================|");

        for (int i = 0; i < orderID.size(); i++) {

            System.out.println((i+1)+".");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Order ID            : "+orderID.get(i));
            System.out.println("Order Items counts  : "+orderItem.get(i));
            System.out.println("Order Place         : "+orderPlace.get(i));
            System.out.println("Order date          : "+orderDate.get(i));
            System.out.println("Order time          : "+orderTime.get(i));
            System.out.println("Order Total amount  : "+orderAmount.get(i));
            System.out.println("---------------------------------------------------------------------");

        }
        System.out.println("Press 1 for back to category");
        System.out.println("|===================================================================|");

        Scanner sc=new Scanner(System.in);
        System.out.print("->");

        try {
            int n = sc.nextInt();
            if (n == 1) {
                category();
            } else {
                System.out.println("Please enter the given number");
                orderDetails();
            }
        }catch (Exception e){
            System.out.println("Please enter the given number............: /");
            orderDetails();
        }
    }
}
class UserDetails extends register{

    public void userDetails(){
        try {
            Category c=new Category();
            System.out.println("|===================================================================|");
            System.out.println("|                                                                   |");
            System.out.println("|                          ~~~~~~~~~~~~                             |");
            System.out.println("|                          User Details                             |");
            System.out.println("|                          ~~~~~~~~~~~~                             |");
            System.out.println("|                                                                   |");
            System.out.println("|===================================================================|");

            System.out.println();

            System.out.println("  1. Name         : "+getName());
            System.out.println("  2. address      : "+address);
            System.out.println("  3. E-mail       : "+getEmail());
            System.out.println("  4. Contact No.  : "+getContactNo());
            System.out.println("  5. Password     : "+getPassword());

            System.out.println();

            System.out.println("|===================================================================|");

            System.out.println("Press 1 for back to category");
            System.out.println("Press 2 for edit the User Details");

            System.out.println("|===================================================================|");

            Scanner sc=new Scanner(System.in);
            System.out.print("->");

            int n = sc.nextInt();

            if (n == 1) {
                c.category();
            } else if (n == 2) {
                editUser();
            } else {
                System.out.println("Please enter the given number");
                userDetails();
            }
        }catch (Exception e){
            System.out.println("Please enter the given number............: /");
            userDetails();
        }
    }
    public void editUser(){
        try {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("                  ......Edit user details...... ");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Press 1 for edit Name");
        System.out.println("Press 2 for edit Address");
        System.out.println("Press 3 for edit Email");
        System.out.println("Press 4 for edit Contact No.");
        System.out.println("Press 5 for edit Password");
        System.out.println("Press 6 for Back to User Details");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("->");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        switch (n) {
            case 1:
                editName();
                break;
            case 2:
                editAddress();
                break;
            case 3:
                editEmail();
                break;
            case 4:
                editContact();
                break;
            case 5:
                editPass();
                break;
            case 6:
                System.out.println("Back to User Details");
                System.out.println("------------------------------------");
                userDetails();
                break;
            default:
                editUser();
                break;
            }
        }catch (Exception e){
            System.out.println("Back to User Details...... : /");
            System.out.println("------------------------------------");
            userDetails();
        }
    }
    public void editName(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name=sc.nextLine();

        setName(name);

        System.out.println("If you want edit any thing");

        editUser();
    }
    public void editAddress(){

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Address: ");

        String Add=sc.nextLine();

        address=Add;

        address1.add(Add);

        System.out.println("If you want edit any thing");
        editUser();
    }
    public void editEmail(){

        setEmail();
        setOtp();
        System.out.println("If you want edit any thing");
        editUser();
    }
    public void editContact(){

        setContactNo();
        setOtp();
        System.out.println("If you want edit any thing");
        editUser();
    }
    public void editPass(){

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Password: ");
        String pass=sc.nextLine();
        setPassword(pass);

        System.out.println("If you want edit any thing");
        editUser();
    }
}
class Cart extends Category{
    public void cart(){

        int cartBill = 0;
        for (int i:b){
            cartBill=cartBill+i;
        }

        Scanner sc=new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("|                                                                   |");
        System.out.println("|                             ~~~~~~                                |");
        System.out.println("|                             MyCart                                |");
        System.out.println("|                             ~~~~~~                                |");
        System.out.println("|                                                                   |");
        System.out.println("|===================================================================|");
        for (int i=0;i<a.size();i++){
            System.out.println((i+1)+". "+a.get(i));
            System.out.println("                                           "+b.get(i)); // get() is used to get the object or data from the ArrayList(collection)
        }
        System.out.println("|===================================================================|");
        System.out.println("                your total bill                :      "+cartBill);
        System.out.println("|===================================================================|");

        System.out.println("Press 1 for back to Bill");
        System.out.println("Press 2 for remove any product");
        System.out.println("Press 3 for back to Category");

        System.out.println("|===================================================================|");
        System.out.println();
        System.out.print("->");
        int n=sc.nextInt();

        if (n==1){
            totalBill();
        } else if (n==2) {
            removeProduct();
        } else if (n==3){
            category();
        }
        else {
            System.out.println("Please enter valid input");
            System.out.println("-------------------------------");
            cart();
        }

    }
    public void removeProduct(){

        System.out.println("Press product number to remove product");
        System.out.println("|===================================================================|");
        Scanner sc=new Scanner(System.in);
        System.out.print("-> ");
        int n=sc.nextInt();

        if (n>0 && n<=a.size()) {
            a.remove(n-1);  // remove() - it is used to remove the object or data from where ArrayList(collection)
            b.remove(n-1);
            System.out.println("|===================================================================|");
            cart();
        }
        else {
            System.out.println("Please , enter the give product number");
            removeProduct();
        }
        cart();
    }
}
class Carpenter extends Category
{
    public void Carpenter()
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Carpentering Tools");
        System.out.println("Press 2 for Carpentering Product");
        System.out.println("Press 3 for Back to Category");
        System.out.println("|===================================================================|");

        System.out.print("->");
        try {
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("1.Carpentering Tools");
                    CarpenterTools();
                    break;
                case 2:
                    System.out.println("2.Carpentering Products");
                    CarpenterProduct();
                    break;
                case 3:
                    System.out.println("3.Back to category");
                    category();
                    break;
                default:
                    System.out.println("Please, Enter valid input");
                    System.out.println("-------------------------------------------");
                    Carpenter();
                    break;
            }
        }catch (Exception e){
            System.out.println("Please, Enter valid input...................: /");
            System.out.println("-----------------------------------------------");
            Carpenter();
        }
    }
    public void CarpenterTools() {

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Hammer");
        System.out.println("Press 2 for Hand Saw");
        System.out.println("Press 3 for Planner");
        System.out.println("Press 4 for Measure Tape");
        System.out.println("Press 5 for Screwdriver");
        System.out.println("Press 6 for Drill machine");
        System.out.println("Press 7 for Portable circular saw machine");
        System.out.println("Press 8 for back to Carpenter");
        System.out.println("|===================================================================|");

        System.out.print("->");

        try {
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Brand: BUILDSKILL\n" +
                            "Head Material: Carbon Steel\n" +
                            "Colour: Silver, Yellow, Black\n" +
                            "Item Dimensions LxWxH: 27 x 15 x 4 Centimeters\n" +
                            "Item Weight: 430 Grams");
                    System.out.println("Price: 189");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 189;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Hammer");
                            b.add(189);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterTools();
                    }
                    break;
                case 2:
                    System.out.println("Brand: Tomahawk\n" +
                            "Colour: Yellow\n" +
                            "Blade Material: Aluminium Oxide\n" +
                            "Surface Recommendation: Wood, Plastic\n" +
                            "Power Source: Corded Electric\n" +
                            "Special Feature: Ergonomic handle\n" +
                            "Included Components: Circular Saw Blade\n" +
                            "Product Dimensions: 66L x 16W x 4.2H Centimeters\n" +
                            "Amperage: 3.4 Amps\n" +
                            "Item Weight: 330 Grams");
                    System.out.println("Price: 268");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 268;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Hand Saw");
                            b.add(268);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterTools();
                    }
                    break;
                case 3:
                    System.out.println("Brand: KROST\n" +
                            "Material: Alloy Steel\n" +
                            "Colour: Red\n" +
                            "Item Dimensions LxWxH: 20 x 10 x 8 Centimeters\n" +
                            "Style: 10\"");
                    System.out.println("Price: 1050");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 1050;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Planner");
                            b.add(1050);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterTools();
                    }
                    break;
                case 4:
                    System.out.println("Colour: Yellow\n" +
                            "Brand: Asian Paints\n" +
                            "Item Dimensions LxWxH: 7 x 5.7 x 2.7 Centimeters\n" +
                            "Item Weight: 170 Grams\n" +
                            "Blade Length: 3 Metres");
                    System.out.println("Price: 99");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 99;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Measure Tape");
                            b.add(99);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterTools();
                    }
                    break;
                case 5:
                    System.out.println("Brand: TAPARIA\n" +
                            "Number of Items: 1\n" +
                            "Head Style: Phillips\n" +
                            "Material: Alloy Steel\n" +
                            "Colour: Green and Silver\n" +
                            "Recommended Uses For Product: Multipurpose\n" +
                            "Special Feature: Magnetic Tip\n" +
                            "Item Dimensions LxWxH: 125 x 14 x 14 Centimeters\n" +
                            "Included Components: 10 N Screw Driver\n" +
                            "Item Weight: 20 Grams");
                    System.out.println("Price: 50");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 50;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Screwdriver");
                            b.add(50);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterTools();
                    }
                    break;
                case 6:
                    System.out.println("Brand: Black + Decker\n" +
                            "Power Source: Corded Electric\n" +
                            "Maximum Rotational Speed: 2800 RPM\n" +
                            "Voltage: 230 Volts\n" +
                            "Maximum Chuck Size: 13 Millimeters\n" +
                            "Colour: Red\n" +
                            "Included Components: 1 Kr554re Drill Machine, 1 Chuck Key, 1 Depth Gauge, 1 Auxiliary Handle And 4 Drill Bits\n" +
                            "Special Feature: Lightweight, Reverse Rotation, Variable Speed\n" +
                            "Product Dimensions: 5.5L x 2.5W x 6.5H Centimeters\n" +
                            "Material: Plastic");
                    System.out.println("Price: 1899");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 1899;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Drill machine");
                            b.add(1899);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterTools();
                    }
                    break;
                case 7:
                    System.out.println("Brand: Bosch\n" +
                            "Colour: Blue\n" +
                            "Blade Material: Stainless Steel\n" +
                            "Surface Recommendation: Wood\n" +
                            "Power Source: Corded Electric\n" +
                            "Special Feature: Dishwasher Safe\n" +
                            "Included Components: Tool\n" +
                            "Product Dimensions: 14.2L x 8.1W x 10.6H Centimeters\n" +
                            "Voltage: 240 Volts\n" +
                            "Amperage: 15 Amps");
                    System.out.println("Price: 7999");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 7999;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Portable circular saw machine");
                            b.add(7999);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterTools();
                    }
                    break;
                case 8:
                    System.out.println("BacK to a Carpenter");
                    System.out.println("---------------------------------------------------------------------");
                    Carpenter();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    CarpenterTools();
                    break;
            }
            System.out.println("Do you want to choose another tool?");
            System.out.println("If yes then press Y and for No press N");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                CarpenterTools();
            } else {
                category();
            }
        }catch (Exception e) {
            System.out.println("You have selected wrong option...........: /");
            CarpenterTools();
        }
    }
    public void CarpenterProduct() {

        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Press 1 for Wood");
        System.out.println("Press 2 for Plywood");
        System.out.println("Press 3 for Nails");
        System.out.println("Press 4 for screw");
        System.out.println("Press 5 for Fevicol");
        System.out.println("Press 6 for BacK to a category");
        System.out.println("---------------------------------------------------------------------");

        try {
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Material: Wood\n" +
                            "Brand: BGH\n" +
                            "Item Dimensions LxWxH: 25 x 25 x 305 Millimeters\n" +
                            "Number of Pieces: 20");
                    System.out.println("Price: 265");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 265;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Wood");
                            b.add(265);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterProduct();
                    }
                    break;
                case 2:
                    System.out.println("Brand: PD Craftozone\n" +
                            "Colour: Light brown\n" +
                            "Material: Pine MDF\n" +
                            "Product Dimensions: 30L x 30W Centimeters\n" +
                            "Size: 12 inch x 12 inch\n");
                    System.out.println("Price: 352");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 352;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Plywood");
                            b.add(352);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterProduct();
                    }
                    break;
                case 3:
                    System.out.println("Size: 405\n" +
                            "Material: Iron\n" +
                            "Brand: BUILDSKILL\n" +
                            "Item Dimensions LxWxH: 15 x 8 x 3 Centimeters\n" +
                            "Number of Pieces: 405");
                    System.out.println("Price: 159");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {

//                            bill = bill + 159;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");

                            a.add("Nails");
                            b.add(159);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterProduct();
                    }
                    break;
                case 4:
                    System.out.println("Size: 129\n" +
                            "Material: Iron\n" +
                            "Brand: BUILDSKILL\n" +
                            "Item Dimensions LxWxH: 15 x 8 x 3 Centimeters\n" +
                            "Fastener Type: Bolt, Standard\n");
                    System.out.println("Price: 149");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    n = sc.nextInt();

                    try {
                        if (n == 1) {
//                    bill = bill + 149;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Screw");
                            b.add(149);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterProduct();
                    }
                    break;
                case 5:
                    System.out.println("Pattern Name: Fevicol SH 500GM\n" +
                            "Brand: Pidilite\n" +
                            "Specific Uses For Product: Wood\n" +
                            "Material: Adhesives; sealants\n" +
                            "Compatible Material: Wood\n" +
                            "Item Form: Sh\n");
                    System.out.println("Price: 166");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 166;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Fevicol");
                            b.add(166);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            CarpenterProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        CarpenterProduct();
                    }
                    break;
                case 6:
                    System.out.println("BacK to a Carpenter");
                    System.out.println("---------------------------------------------------------------------");
                    Carpenter();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    CarpenterProduct();
                    break;
            }
            System.out.println("|===================================================================|");
            System.out.println("Do you want to choose another tool?");
            System.out.println("If yes then press Y and for No press N");
            System.out.println("|===================================================================|");
            System.out.println("->");

            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                CarpenterProduct();
            } else {
                category();
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option..............: /");
            CarpenterProduct();
        }
    }
}
class Painter extends Category
{
    public void Painter(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Painting Tools");
        System.out.println("Press 2 for Painting Product");
        System.out.println("Press 3 for Back to Category");
        System.out.println("|===================================================================|");

        System.out.print("->");
        try {
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("1.Painting Tools");
                    painterTools();
                    break;
                case 2:
                    System.out.println("2.Painting Products");
                    painterProduct();
                    break;
                case 3:
                    System.out.println("3.Back to category");
                    category();
                    break;
                default:
                    System.out.println("Please, Enter valid input");
                    System.out.println("-------------------------------");
                    Painter();
                    break;
            }
        } catch (Exception e){
            System.out.println("Please, Enter valid input");
            System.out.println("-------------------------------");
            Painter();
        }
    }
    public void painterTools(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Brush");
        System.out.println("Press 2 for Roller");
        System.out.println("Press 3 for Paint Tray");
        System.out.println("Press 4 for Painter tape");
        System.out.println("Press 5 for Back to a Painter");
        System.out.println("|===================================================================|");
        System.out.print("->");

        try {
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Colour: Red\n" +
                            "Material: Wood\n" +
                            "Size: 25 , 38 & 50 mm\n" +
                            "Brand: Arora\n" +
                            "Paint Type: Oil, Acrylic");
                    System.out.println("Price: 325");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 325;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Brush");
                            b.add(325);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            painterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        painterTools();
                    }
                    break;
                case 2:
                    System.out.println("Brand: Itzu 5D\n" +
                            "Colour: Random Color\n" +
                            "Finish Type: Gloss\n" +
                            "Size: 1 count (Pack of 1)\n" +
                            "Special Feature: Handheld");
                    System.out.println("Price: 275");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 275;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Roller");
                            b.add(275);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            painterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        painterTools();
                    }
                    break;
                case 3:
                    System.out.println("Material: Plastic\n" +
                            "Colour: Black\n" +
                            "Brand: The Paint Hub\n" +
                            "Style: Paint Tray\n" +
                            "Item Dimensions LxWxH: 20 x 10 x 10 Centimeters");
                    System.out.println("Price: 180");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 180;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Paint Tray");
                            b.add(180);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            painterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        painterTools();
                    }
                    break;
                case 4:
                    System.out.println("Brand: VCR\n" +
                            "Colour: Off White\n" +
                            "Material: Crepe Paper\n" +
                            "Number of Items: 1\n" +
                            "Recommended Uses For Product: Painting");
                    System.out.println("Price: 204");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 204;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Painter tape");
                            b.add(204);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            painterTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        painterTools();
                    }
                    break;
                case 5:
                    System.out.println("Back to Painter");
                    System.out.println("---------------------------------------------------------------------");
                    Painter();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    painterTools();
                    break;
            }
        }catch (Exception e) {
            System.out.println("You have selected wrong option....................: /");
            painterTools();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            painterTools();
        }else {
            category();
        }
    }
    public void painterProduct(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Paint");
        System.out.println("Press 2 for White cement");
        System.out.println("Press 3 for Plaster Of Paris (P.O.P) Powder");
        System.out.println("Press 4 for Back to painter");
        System.out.println("|===================================================================|");

        try {

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Which colour do you want.....");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 for Red paint");
                    System.out.println("Press 2 for Blue paint");
                    System.out.println("Press 3 for Green paint");
                    System.out.println("Press 4 for Black paint");
                    System.out.println("Press 5 for White paint");
                    System.out.println("Press 6 for Back to Painting Products");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("->");

                    n = sc.nextInt();

                    switch (n) {
                        case 1:
                            System.out.println("Brand: Dulux\n" +
                                    "Colour: RED\n" +
                                    "Finish Type: Gloss\n" +
                                    "Size: 1 Liter\n" +
                                    "Item Volume: 1 Litres");
                            System.out.println("Price: 800");

                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Press 1 to place order or press any number to go back");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.print("->");

                            try {
                                n = sc.nextInt();

                                if (n == 1) {
//                            bill = bill + 800;
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                        Item is added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    a.add("Red paint");
                                    b.add(800);
                                } else {
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                      Item is not added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    painterProduct();
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                                painterProduct();
                            }
                            break;
                        case 2:
                            System.out.println("Brand: Dulux\n" +
                                    "Colour: BLUE\n" +
                                    "Finish Type: Gloss\n" +
                                    "Size: 1 Liter\n" +
                                    "Item Volume: 1 Litres");
                            System.out.println("Price: 800");

                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Press 1 to place order or press any number to go back");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.print("->");

                            try {
                                n = sc.nextInt();

                                if (n == 1) {
//                            bill = bill + 800;
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                        Item is added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    a.add("Blue paint");
                                    b.add(800);
                                } else {
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                      Item is not added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    painterProduct();
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                                painterProduct();
                            }
                            break;
                        case 3:
                            System.out.println("Brand: Dulux\n" +
                                    "Colour: GREEN\n" +
                                    "Finish Type: Gloss\n" +
                                    "Size: 1 Liter\n" +
                                    "Item Volume: 1 Litres");
                            System.out.println("Price: 800");

                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Press 1 to place order or press any number to go back");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.print("->");

                            try {
                                n = sc.nextInt();

                                if (n == 1) {
//                            bill = bill + 800;
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                        Item is added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    a.add("Green paint");
                                    b.add(800);
                                } else {
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                      Item is not added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    painterProduct();
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                                painterProduct();
                            }
                            break;
                        case 4:
                            System.out.println("Brand: Dulux\n" +
                                    "Colour: BLACK\n" +
                                    "Finish Type: Gloss\n" +
                                    "Size: 1 Liter\n" +
                                    "Item Volume: 1 Litres");
                            System.out.println("Price: 800");

                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Press 1 to place order or press any number to go back");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.print("->");

                            try {
                                n = sc.nextInt();

                                if (n == 1) {
//                            bill = bill + 800;
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                        Item is added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    a.add("Black paint");
                                    b.add(800);
                                } else {
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                      Item is not added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    painterProduct();
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                                painterProduct();
                            }
                            break;
                        case 5:
                            System.out.println("Brand: Dulux\n" +
                                    "Colour: WHITE\n" +
                                    "Finish Type: Gloss\n" +
                                    "Size: 1 Liter\n" +
                                    "Item Volume: 1 Litres");
                            System.out.println("Price: 800");

                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Press 1 to place order or press any number to go back");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.print("->");

                            try {
                                n = sc.nextInt();

                                if (n == 1) {
//                            bill = bill + 800;
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                        Item is added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    a.add("White paint");
                                    b.add(800);
                                } else {
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                      Item is not added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    painterProduct();
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                                painterProduct();
                            }
                            break;
                        case 6:
                            System.out.println("Back to Painter product");
                            painterProduct();
                            break;
                        default:
                            System.out.println("You have selected wrong option");
                            painterProduct();
                            break;
                    }
                case 2:
                    System.out.println("Brand: J.K\n" +
                            "Specific Uses For Product: Interior\n" +
                            "Material: Others\n" +
                            "Item Form: Solid\n" +
                            "Colour: White");
                    System.out.println("Price: 180");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 180;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("White cement");
                            b.add(180);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            painterProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        painterProduct();
                    }
                    break;
                case 3:
                    System.out.println("Brand: AAHKELS\n" +
                            "Colour: White\n" +
                            "Age Range (Description): Adult\n" +
                            "Material: Ceramic\n" +
                            "Item Weight: 5 Kilograms");
                    System.out.println("Price: 250");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 250;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Plaster Of Paris (P.O.P) Powder");
                            b.add(250);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            painterProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        painterProduct();
                    }
                    break;
                case 4:
                    System.out.println("Back to Painter");
                    System.out.println("---------------------------------------------------------------------");
                    Painter();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    painterProduct();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option..............: /");
            painterProduct();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            painterProduct();
        }else {
            category();
        }
    }
}
class Plumber extends Category
{
    public void Plumber(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Plumbing Tools");
        System.out.println("Press 2 for Plumbing Product");
        System.out.println("Press 3 for Back to Category");
        System.out.println("|===================================================================|");

        System.out.print("->");

        try {
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("1.Plumbing Tools");
                    plumberTools();
                    break;
                case 2:
                    System.out.println("2.Plumbing Products");
                    plumberProduct();
                    break;
                case 3:
                    System.out.println("3.Back to category");
                    category();
                    break;
                default:
                    System.out.println("Please, Enter valid input");
                    System.out.println("-------------------------------");
                    Plumber();
                    break;
            }
        }catch (Exception e){
            System.out.println("Please, Enter valid input....................: /");
            System.out.println("------------------------------------------------");
            Plumber();
        }
    }
    public void plumberTools(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Pipe Wrench");
        System.out.println("Press 2 for Pipe Handsaw");
        System.out.println("Press 3 for Sealing Tape");
        System.out.println("Press 4 for Back to a Plumber");
        System.out.println("|===================================================================|");

        System.out.println("->");

        try {

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Colour: Green\n" +
                            "Brand: Wulf\n" +
                            "Material: Chrome Vanadium Steel\n" +
                            "Item Package Quantity: 1\n" +
                            "Head Style: Round\n");
                    System.out.println("Price: 250");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 250;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Pipe Wrench");
                            b.add(250);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            plumberTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        plumberTools();
                    }
                    break;
                case 2:
                    System.out.println("Brand: Bosch\n" +
                            "Colour: Blue\n" +
                            "Blade Material: Tubular,Metal,Steel\n" +
                            "Surface Recommendation: Stainless Steel\n" +
                            "Power Source: Hand-powered\n" +
                            "Special Feature: Tubular steel\n" +
                            "Included Components: 1 Metal Compact Frame Hacksaw With (24t) Blade (blue)\n" +
                            "Product Dimensions: 17.1L x 5.6W x 1.5H Centimeters\n" +
                            "Voltage: 28 Volts\n" +
                            "Amperage: 16 Amps");

                    System.out.println("Price: 500");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 500;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Pipe Handsaw");
                            b.add(500);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            plumberTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        plumberTools();
                    }
                    break;
                case 3:
                    System.out.println("Brand: Generic\n" +
                            "Colour: White\n" +
                            "Number of Items: 1\n" +
                            "Recommended Uses For Product: Plumbing");
                    System.out.println("Price: 115");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    n = sc.nextInt();

                    try {
                        if (n == 1) {
//                    bill = bill + 115;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Sealing Tape");
                            b.add(115);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            plumberTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        plumberTools();
                    }
                    break;
                case 4:
                    System.out.println("Back to Plumber");
                    System.out.println("---------------------------------------------------------------------");
                    Plumber();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    plumberTools();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option.........: /");
            plumberTools();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            plumberTools();
        }else {
            category();
        }
    }
    public void plumberProduct(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Pipe");
        System.out.println("Press 2 for T- shape pipe");
        System.out.println("Press 3 for L- shape pipe");
        System.out.println("Press 4 for back to Plumber");
        System.out.println("|===================================================================|");

        try {

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("which type of pipe");
                    System.out.println("Press 1 for PVC Pipe");
                    System.out.println("Press 2 for Metal Pipe");
                    System.out.print("->");
                    n = sc.nextInt();

                    switch (n) {
                        case 1:
                            System.out.println("Brand: Charlotte Pipe\n" +
                                    "Material: As shown in the image\n" +
                                    "Colour: As Shown in Image\n" +
                                    "Item Dimensions LxWxH: 6.3 x 1.5 x 25 Centimeters\n" +
                                    "Maximum Pressure: 40 Kilopascal\n" +
                                    "Product Dimensions: 5.1L x 5.1W Centimeters");
                            System.out.println("Price: 100");

                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Press 1 to place order or press any number to go back");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.print("->");

                            try {

                                n = sc.nextInt();

                                if (n == 1) {
//                            bill = bill + 100;
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                        Item is added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    a.add("PVC Pipe");
                                    b.add(100);
                                } else {
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                      Item is not added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    plumberProduct();
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                                plumberProduct();
                            }
                            break;
                        case 2:
                            System.out.println("Brand: Infinite tech\n" +
                                    "Material: Stainless Steel\n" +
                                    "Colour: Silver\n" +
                                    "Item Dimensions LxWxH: 68 x 1.2 x 1.2 Centimeters\n" +
                                    "Product Dimensions: 30L x 1.3W Centimeters\n");
                            System.out.println("Price: 200");

                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Press 1 to place order or press any number to go back");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.print("->");

                            try {
                                n = sc.nextInt();

                                if (n == 1) {
//                            bill = bill + 200;
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                        Item is added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    a.add("MetalPipe");
                                    b.add(200);
                                } else {
                                    System.out.println("--------------------------------------------------------------------");
                                    System.out.println("                      Item is not added in cart");
                                    System.out.println("--------------------------------------------------------------------");
                                    plumberProduct();
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                                plumberProduct();
                            }
                            break;
                        default:
                            System.out.println("You enter the wrong option");
                            plumberProduct();
                            break;
                    }
                case 2:
                    System.out.println("Size: Small\n" +
                            "Material: Brass\n" +
                            "Brand: Ruhe\n" +
                            "Colour: Silver\n" +
                            "Item Dimensions LxWxH: 25 x 25 x 50 Millimeters\n" +
                            "Connector Type: Tee\n" +
                            "Exterior Finish: Brass\n" +
                            "Item Weight: 90 Grams\n" +
                            "Number of Pieces: 1");
                    System.out.println("Price: 226");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {

                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 226;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("T- shape pipe");
                            b.add(226);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            plumberProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        plumberProduct();
                    }
                    break;
                case 3:
                    System.out.println("Size: Small\n" +
                            "Material: Brass\n" +
                            "Brand: Ruhe\n" +
                            "Colour: Silver\n" +
                            "Item Dimensions LxWxH: 40 x 40 x 25 Millimeters\n" +
                            "Connector Type: Elbow\n" +
                            "Exterior Finish: Brass\n" +
                            "Thread Type: Elbow\n" +
                            "Item Weight: 95 Grams\n" +
                            "Number of Pieces: 1");
                    System.out.println("Price: 50");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 50;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("L- shape pipe");
                            b.add(50);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            plumberProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        plumberProduct();
                    }
                    break;
                case 4:
                    System.out.println("Back to a plumber");
                    System.out.println("---------------------------------------------------------------------");
                    Plumber();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    plumberProduct();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option.................: /");
            plumberProduct();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            plumberTools();
        }else {
            category();
        }
    }
}
class Civil extends Category
{
    public void Civil(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Civil Tools");
        System.out.println("Press 2 for Civil Product");
        System.out.println("Press 3 for Back to Category");
        System.out.println("|===================================================================|");


        System.out.print("->");
        try {
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("1.Civil Tools");
                    civilTools();
                    break;
                case 2:
                    System.out.println("2.CivilProducts");
                    civilProduct();
                    break;
                case 3:
                    System.out.println("3.Back to category");
                    category();
                    break;
                default:
                    System.out.println("Please, Enter valid input");
                    System.out.println("-------------------------------");
                    Civil();
                    break;
            }
        }catch (Exception e){
            System.out.println("Please, Enter valid input.................: /");
            System.out.println("---------------------------------------------");
            Civil();
        }
    }
    public void civilTools(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Brick Trowel");
        System.out.println("Press 2 for Wooden Float");
        System.out.println("Press 3 for Plumb bob");
        System.out.println("Press 4 for Shovel");
        System.out.println("Press 5 for Back to Civil");
        System.out.println("|===================================================================|");

        System.out.println("->");

        try {

            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Material: Metal\n" +
                            "Colour: Brown, Black\n" +
                            "Brand: Generic\n" +
                            "Style: Trowel\n" +
                            "Handle Material: Metal\n" +
                            "Blade Material: Metal");
                    System.out.println("Price: 175");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
                            //                    bill = bill + 175;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Brick Trowel");
                            b.add(175);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            civilTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        civilTools();
                    }
                    break;
                case 2:
                    System.out.println("Colour: Silver,brown\n" +
                            "Brand: Hind Tools\n" +
                            "Item Dimensions LxWxH: 15.2 x 5.1 x 5.1 Centimeters\n" +
                            "Style: Premium\n" +
                            "Handle Material: Wooden Handle");
                    System.out.println("Price: 115");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 115;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Wooden Float");
                            b.add(115);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            civilTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        civilTools();
                    }
                    break;
                case 3:
                    System.out.println("Brand: Goodyear\n" +
                            "Material: Metal\n" +
                            "Colour: Blue\n" +
                            "Product Dimensions: 10L x 10W x 10H Millimeters");
                    System.out.println("Price: 125");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 125;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Plumb bob");
                            b.add(125);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            civilTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        civilTools();
                    }
                    break;
                case 4:
                    System.out.println("Material: Wood, Iron\n" +
                            "Colour: Black\n" +
                            "Brand: A. SHARIF\n" +
                            "Item Weight: 1800 Grams\n" +
                            "Style: Traditional\n" +
                            "Handle Material: Wood\n" +
                            "Grip Type: Non-slip");
                    System.out.println("Price: 550");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 550;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Shovel");
                            b.add(550);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            civilTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        civilTools();
                    }
                    break;
                case 5:
                    System.out.println("Back to Civil");
                    System.out.println("---------------------------------------------------------------------");
                    Civil();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    civilTools();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option...........: /");
            civilTools();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            civilTools();
        }else {
            category();
        }
    }
    public void civilProduct(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Cement");
        System.out.println("Press 2 for Sand");
        System.out.println("Press 3 for Brick");
        System.out.println("Press 4 for back to Civil");
        System.out.println("|===================================================================|");
        System.out.println("->");

        try {

            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Brand: Ambuja\n" +
                            "Specific Uses For Product: Concrete\n" +
                            "Material: Cement\n" +
                            "Compatible Material: Industrial\n" +
                            "Item Form: Powder\n");
                    System.out.println("Price: 456");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 456;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Cement");
                            b.add(456);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            civilProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        civilProduct();
                    }
                    break;
                case 2:
                    System.out.println("Brand: UR LITTLE SHOP\n" +
                            "Weight: 50Kg\n" +
                            "Colour: BROWN\n" +
                            "Theme: Sand\n" +
                            "Material: Grade A");
                    System.out.println("Price: 299");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 299;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Sand");
                            b.add(299);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            civilProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                    }
                    break;
                case 3:
                    System.out.println("Brand: Civaner\n" +
                            "Minimum Manufacturer Age Recommended: 168.00\n" +
                            "Material: Clay\n" +
                            "Colour: Yellow\n" +
                            "Educational Objective: Creative Thinking");
                    System.out.println("Price: 999");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 999;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Brick");
                            b.add(999);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            civilProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        civilProduct();
                    }
                    break;
                case 4:
                    System.out.println("Back to a Civil");
                    System.out.println("---------------------------------------------------------------------");
                    Civil();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    civilProduct();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option....................: /");
            civilProduct();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            civilTools();
        }else {
            category();
        }
    }
}
class Electrician extends Category{
    public void Electrician(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Electrical Tools");
        System.out.println("Press 2 for Electrical Product");
        System.out.println("Press 3 for Back to Category");
        System.out.println("|===================================================================|");


        System.out.print("->");
        try {
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("1.Electrical Tools");
                    electricianTools();
                    break;
                case 2:
                    System.out.println("2.Electrical Products");
                    electricianProduct();
                    break;
                case 3:
                    System.out.println("3.Back to category");
                    category();
                    break;
                default:
                    System.out.println("Please, Enter valid input");
                    System.out.println("-------------------------------");
                    Electrician();
                    break;
            }
        }catch (Exception e){
            System.out.println("Please, Enter valid input................: /");
            System.out.println("---------------------------------------------------");
            Electrician();
        }
    }
    public void electricianTools(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for 2in1 Screwdriver");
        System.out.println("Press 2 for Electric Tape");
        System.out.println("Press 3 for Electric Tester");
        System.out.println("Press 4 for Wire Cutter");
        System.out.println("Press 5 for Electrical Piler");
        System.out.println("Press 6 for Back to Civil");
        System.out.println("|===================================================================|");

        System.out.print("->");

        try {

            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Brand: INDURO\n" +
                            "Number of Items: 1\n" +
                            "Head Style: Phillips\n" +
                            "Material: Chrome Vanadium Steel\n" +
                            "Colour: Black,Orange\n" +
                            "Item Dimensions LxWxH: 15 x 2 x 2 Centimeters\n" +
                            "Included Components: Handle, Screwdriver Bits");
                    System.out.println("Price: 125");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 125;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("2in1 Screwdriver");
                            b.add(125);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianTools();
                    }
                    break;
                case 2:
                    System.out.println("Brand: Jyoti\n" +
                            "Colour: Multicolored\n" +
                            "Material: Polyvinyl Chloride\n" +
                            "Number of Items: 5\n" +
                            "Recommended Uses For Product: Electrical\n");
                    System.out.println("Price: 50");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 50;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Electric Tape");
                            b.add(50);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianTools();
                    }
                case 3:
                    System.out.println("Brand: Taparia\n" +
                            "Power Source: Corded Electric\n" +
                            "Colour: Yellow\n" +
                            "Item Weight: 35 Grams\n" +
                            "Item Dimensions LxWxH: 10 x 175 x 175 Centimeters");
                    System.out.println("Price: 70");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 70;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Electric Tester");
                            b.add(70);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianTools();
                    }
                case 4:
                    System.out.println("Brand: Taparia\n" +
                            "Material: Alloy Steel\n" +
                            "Colour: Green and Black\n" +
                            "Item Dimensions LxWxH: 16.5 x 7.1 x 1.2 Centimeters\n" +
                            "Handle Material: Plastic");
                    System.out.println("Price: 69");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 69;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Wire Cutter");
                            b.add(69);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianTools();
                    }
                case 5:
                    System.out.println("Brand: Homdum\n" +
                            "Material: Chromium-Vanadium Steel\n" +
                            "Item Dimensions LxWxH: 31 x 10 x 5 Centimeters\n" +
                            "Colour: Yellow\n" +
                            "Handle Material: Alloy Steel\n" +
                            "Grip Type: Ergonomic\n" +
                            "Product Dimensions: 31L x 10W Centimeters");
                    System.out.println("Price: 500");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 500;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Electrical Piler");
                            b.add(500);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianTools();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianTools();
                    }
                case 6:
                    System.out.println("Back to Electrician");
                    System.out.println("---------------------------------------------------------------------");
                    Electrician();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    electricianTools();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option................: /");
            electricianTools();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            electricianTools();
        }else {
            category();
        }
    }
    public void electricianProduct(){

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("Press 1 for Wire");
        System.out.println("Press 2 for Electrical Switch");
        System.out.println("Press 3 for Electrical Socket");
        System.out.println("Press 4 for Bulb");
        System.out.println("Press 5 for Electrical Fan");
        System.out.println("Press 6 for back to Civil");
        System.out.println("|===================================================================|");
        System.out.print("->");

        try {

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Colour: Blue\n" +
                            "Brand: Polycab\n" +
                            "Material: Polyvinyl Chloride\n" +
                            "Number of Cable Strands: Multi Strand\n" +
                            "Voltage: 1100 Volts\n" +
                            "Size:1.5 SQMM");
                    System.out.println("Price: 1500");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 1500;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Wire");
                            b.add(1500);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianProduct();
                    }
                    break;
                case 2:
                    System.out.println("Operation Mode: ON-OFF\n" +
                            "Current Rating: 10 Amps\n" +
                            "Operating Voltage: 240 Volts\n" +
                            "Brand: ANCHOR\n" +
                            "Item Dimensions LxWxH: 8 x 7 x 2 Centimeters\n");
                    System.out.println("Price: 50");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 50;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Electrical Switch");
                            b.add(50);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianProduct();
                    }
                    break;
                case 3:
                    System.out.println("Brand: Anchor by panasonic\n" +
                            "Colour: White\n" +
                            "Compatible Devices: Laptop, Desktop, Television, Oven, Refrigerator, Home Theater\n" +
                            "Material: Polycarbonate (PC)\n" +
                            "Item Dimensions LxWxH: 10 x 8 x 4 Centimeters\n");
                    System.out.println("Price: 50");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 50;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Electrical Socket");
                            b.add(50);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            electricianProduct();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        electricianProduct();
                    }
                    break;
                case 4:
                    System.out.println("Bulb");
                    System.out.println("---------------------------------------------------------------------");
                    bulbs();
                    break;
                case 5:
                    System.out.println("Fans");
                    System.out.println("---------------------------------------------------------------------");
                    Fans();
                    break;
                case 6:
                    System.out.println("Back to a Electrician");
                    System.out.println("---------------------------------------------------------------------");
                    Electrician();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    electricianProduct();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option................: /");
            electricianProduct();
        }
        System.out.println("|===================================================================|");
        System.out.println("Do you want to choose another tool?");
        System.out.println("If yes then press Y and for No press N");
        System.out.println("|===================================================================|");
        System.out.println("->");

        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            electricianProduct();
        } else {
            category();
        }
    }
    public void bulbs(){

        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                      WHICH TYPE OF BULBS");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Press 1 for CFL Bulb");
        System.out.println("Press 2 for LED Bulb");
        System.out.println("Press 3 for Back to Electrical Products");
        System.out.println("---------------------------------------------------------------------");

        System.out.print("->");

        try {

            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("1.CFL Bulb");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("Price: 300");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 300;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("CFL Bulb");
                            b.add(300);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            bulbs();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        bulbs();
                    }
                    break;
                case 2:
                    System.out.println("2.LED Bulb");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("Price: 249");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 249;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("LED Bulb");
                            b.add(249);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            bulbs();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        bulbs();
                    }
                    break;
                case 3:
                    electricianProduct();
                    break;
                default:
                    System.out.println("You have selected wrong option");
                    bulbs();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option...........:/");
            electricianProduct();
        }
    }
    public void Fans(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("                      WHICH TYPE OF FANS");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Press 1 for Ceiling Fan");
        System.out.println("Press 2 for Wall Mounting Fan");
        System.out.println("Press 3 for Table Fan");
        System.out.println("Press 4 for Back to Electrical Products");
        System.out.println("---------------------------------------------------------------------");

        System.out.print("->");

        try {

            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("1.Ceiling Fan");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("Price: 1400");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 300;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Brick");
                            b.add(300);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            Fans();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        Fans();
                    }
                    break;
                case 2:
                    System.out.println("2.Wall Mounting Fan");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("Price: 1249");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 249;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Brick");
                            b.add(249);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            Fans();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        Fans();
                    }
                    break;
                case 3:
                    System.out.println("3.Table Fan");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("Price: 949");

                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Press 1 to place order or press any number to go back");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("->");

                    try {
                        n = sc.nextInt();

                        if (n == 1) {
//                    bill = bill + 249;
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                        Item is added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            a.add("Brick");
                            b.add(249);
                        } else {
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("                      Item is not added in cart");
                            System.out.println("--------------------------------------------------------------------");
                            Fans();
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid date Must be enter please enter 1 for place order or press any number to go back");
                        Fans();
                    }
                    break;
                case 4:
                    electricianProduct();
                    break;
                default:
                    Fans();
                    break;
            }
        }catch (Exception e){
            System.out.println("You have selected wrong option................: /");
            Fans();
        }
    }
}
class  HardwareShops {

    static // SIB - some set of statement before the main method
    {
        System.out.println("|===================================================================|");
        System.out.println("|                                                                   |");
        System.out.println("|        {-------- WELCOME TO VIVEK HARDWARE SHOP --------}         |");
        System.out.println("|                                                                   |");
        System.out.println("|===================================================================|");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("|===================================================================|");
        System.out.println("|                                                                   |");
        System.out.println("|                       Press 1 for Signup                          |");
        System.out.println("|                       Press 2 for Login                           |");
        System.out.println("|                       Press 3 for Exit                            |");
        System.out.println("|                                                                   |");
        System.out.println("|===================================================================|");

        System.out.print("->");
        try {
            int n = sc.nextInt();

            regi ref = new Category(); // UpCasting - subclass into super class


            switch (n) {
                case 1:
                    ref.registration();
                    break;
                case 2:
                    ref.logIn();
                    break;
                case 3:
                    System.out.println("Bye Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter the correct input");
                    main(null);
                    break;
            }

            Category c = (Category) ref; //DownCasting - super class into subclass
            c.category();
        }catch (Exception e){
            System.out.println("|===================================================================|");
            System.out.println("Something get wrong please enter only number......: /");
            main(null);
        }
    }
}
