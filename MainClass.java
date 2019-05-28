
package Telephone;

import java.util.*;
import java.io.*;


public class MainClass {
  private String surname;
  private String initial;
  private String telephone;
  private String address;
  private String city;
  
  LinkedList<DirectoryEntry> directory = new LinkedList(); //Initializes linked list

  
    public void input () { //Input method
        int counter = 0;
        boolean flag = false;
        
        try {
            //User inputs
            InputStreamReader reader = new InputStreamReader(System.in); 
            BufferedReader console = new BufferedReader(reader); 
            System.out.println ( "Please input surname: ");
            String surname = console.readLine();
            for(int z = 0; z<directory.size()+1;z++){
                if(surname.equals(directory.get(z).getName())){
                    System.out.println("Entry is already in the directory, transferring back to menu");
                    flag=true;
                }
            }
            while(flag==false){
                System.out.println ( "Please input two initials: "); 
                String initial = console.readLine(); 
                System.out.println( "Please input telephone number: ");
                String telephone = console.readLine();
                System.out.println( "Please input the address ");
                String address = console.readLine();
                System.out.println( "Please input the city");
                String city = console.readLine();
            
                for(int z = 0; z<directory.size()+1;z++){ //Adds a node alphabetically by surname
                    if(surname.compareToIgnoreCase(directory.get(counter).getName())>0){ //User input surname is being compared to other node's surnames as the list interates
                        counter++;
                        if(surname.compareToIgnoreCase(directory.getLast().getName())>0){ //If user input surname is greater than the last node's surname, the tail, it is added to the end of the list
                            directory.addLast(new DirectoryEntry(surname,initial,address, city, telephone));
                            flag=true;                   
                        }    
                    }   
                    else if(surname.compareToIgnoreCase(directory.get(0).getName())<0){ //If user input surname is less than the first node's surname, the head, it is added to the front of the list.
                        directory.addFirst(new DirectoryEntry(surname,initial,address, city, telephone));
                        flag=true;
                    }   
                    else{
                       while(flag==false){
                            directory.insertAfter(directory.get(counter-1), new DirectoryEntry(surname, initial, address, city, telephone)); //If the previous node's surname is less, user input surname is inserted after its previous node 
                            flag = true;
                       }
                    }
                }
            }
            } 
            catch ( IOException e ) { 
                System.out.println ( "IO Exception." ); 
            }
    }
 
}
