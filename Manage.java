
package Telephone;

import java.util.*;
import java.io.*;


public class Manage {
   
    public static void main(String[]args){
        boolean flag = false; //Uses flag to skip loops bringing it back to the menu interface
        
        MainClass mc = new MainClass(); //Initializing MainClass object
       
        //Initial Directory
        mc.directory.addFirst(new DirectoryEntry("Terris", "A.A.",  "777 Dream St.","Burnaby","200-2345"));
        mc.directory.addFirst(new DirectoryEntry("Taylor", "K.B.", "859 Pacific St.","Maple Ridge", "700-8973"));
        mc.directory.addFirst(new DirectoryEntry("Lee", "R.T.", "444 Pool St.","Coquitlam", "900-5555"));
        mc.directory.addFirst(new DirectoryEntry("Chang", "W.K.", "678 Bay St.","Vancouver", "900-4523"));
        mc.directory.addFirst(new DirectoryEntry("Carriere", "D.D.", "333 York St.","Vancouver", "500-2222"));
        mc.directory.addFirst(new DirectoryEntry("Carlos", "R.F.", "234 Sunset St.","Coquitlam", "900-4563"));

        Scanner scan = new Scanner(System.in);
     
        int k =0 ;
        
        while(k==0){//Infinite while loop until argument changes
            //Menu Interface
            System.out.println("\nWelcome to the Telephone Directory. Enter\n1 To add an entry\n2 To delete an entry\n"
              + "3 To modify an entry\n4 To view all entries\n5 to search and print entries\n6 Exit");
            System.out.println();
            int i = scan.nextInt();
            
            if(i<1 || i>6){//Checks range
            System.out.println('\n' + "Error in Input. Enter one of the following.");
            }
            if(i==1){
              mc.input(); //User inputs
            }
            
            if(i==2){ //Deletion method
                flag=false;
                if(mc.directory==null){ //If list is null
                    System.out.println("No more entries, unable to delete");
                    System.out.println("Try entering an entry to delete");
                    String unable = scan.next();
                    System.out.println("Unable to delete an entry");
                    flag=true;
                }
                while(flag==false){
                    System.out.println("Enter the entry's surname you wish to delete "); //All surnames are unique therefore no need to check repeats
                    String name = scan.next(); 
                    if(mc.directory.size()==0){;
                        mc.directory.isEmpty();
                        mc.directory.remove(mc.directory.get(0));
                        mc.directory=null;
                        flag=true;
                    }
                    while(flag==false){
                        for(int z = 0; z<mc.directory.size()+1;z++){
                            if(mc.directory.get(z).getName().equals(name)){
                                mc.directory.remove(mc.directory.get(z));
                                flag=true;
                            }                
                        }
                    
                        if(flag==false){//Brings error message if the name does not equal
                            System.out.println("Error, no entry found, transferring back to menu");
                            flag=true;
                        }
                    }
                   
                }
            }
            if(i==3){ //Changes telephone of a certain surname that user inputs
                flag=false;
                System.out.println("Enter the entry's surname you wish to modify");
                 while(flag==false){
                    String name = scan.next();
                    for(int z = 0; z<mc.directory.size()+1;z++){
                        if(mc.directory.get(z).getName().equals(name)){
                            System.out.println("Enter new telephone number for this entry");
                            String telephone = scan.next();
                            mc.directory.get(z).setTelephone(telephone);
                            flag=true;
                        }                
                    }
                    if(flag==false){
                        System.out.println("Error, no entry found, transferring back to menu");
                        flag=true;
                    }
                 }
            }
            if(i==4){//Prints the whole directory
                System.out.print(mc.directory);
                System.out.println();
            }
            if(i==5){//Searches a particular user inputted surname and prints the details of that person
                flag=false;
                System.out.println("Enter the entry's surname you wish to search and print: ");
                while(flag==false){
                    String name = scan.next();
                    for(int z = 0; z<mc.directory.size()+1;z++){
                        if(mc.directory.get(z).getName().equals(name)){
                             System.out.println(mc.directory.get(z));
                             flag = true;
                        }                
                    }
                    if(flag==false){
                        System.out.println("Error, no entry found, transferring back to menu");
                        flag=true;
                    }
                }   
            }
            if(i==6){//Infinite while loop terminates after k=1
                k=1;
            }
        
         
        }
    }  
}
