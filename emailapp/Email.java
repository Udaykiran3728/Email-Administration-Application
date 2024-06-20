import java.util.Scanner;

public class Email{
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int defaultPasswordLength=10;
    private String department;
    private int mailboxCapacity;
    private String alternativeEmail;
    private String companySuffix="vitap";
    private String domain="ac.in";

    //Constructor to receive the first and last name
    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.mailboxCapacity=50;
        //System.out.println("EMAIL CREATED:"+this.firstName+" "+this.lastName);

        //Call a Method asking for department- return the department
        this.department=setDepartment();
        //System.out.println("Department:"+" "+ this.department);

        //Call a method to generate a random password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your random password is:"+ this.password +"\n  You can change this later using changePassword()");

        //Combine elements to generate email
        email= firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+"."+companySuffix+"."+department+"."+domain;
       // System.out.println("Your email is:"+" "+ email);
    }

    //Ask for the department
    private String setDepartment(){
        System.out.println("Department Codes\n1 for Students\n2 for Professors \n3 for Phd Scholars\n0 for none\nEnter department code:");
        Scanner sc=new Scanner(System.in);
        int depChoice=sc.nextInt();
        if(depChoice==1){ return "student"; }
        else if(depChoice==2){ return "professor"; }
        else if(depChoice==3){ return "scholar";}
        else{ return ""; }
    }
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$@!#%";
        char[] password=new char[length];
        for(int i=0; i<length; i++){
            int rand=(int)(Math.random() * passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the emailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }

    //Set the alternative email
    public void setAlternativeEmail(String email){
        this.alternativeEmail=email;
    }

    //Change the password
   public void changePassword(String password){
    this.password=password;
   }

   public int getMailboxCapacity(){
    System.out.println("Your Mail Box Capacity is:");
    return mailboxCapacity;
   }

   public String getAlternativeEmail(){
    System.out.println("Your Alternative Email is:");
    return alternativeEmail;
   }

   public String getPassword(){
    System.out.println("Your Changed Password is:");
    return password;
   }

   public String getInfo(){
    return "DISPLAY NAME:     "+firstName +" "+lastName +
           "\nCOMPANY EMAIL:  "+email+
           "\nMAILBOX CAPACITY:"+mailboxCapacity+ "mb";
   }
}
