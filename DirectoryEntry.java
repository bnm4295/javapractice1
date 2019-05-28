
package Telephone;

public class DirectoryEntry {
    
    protected String name, initials,  address, city, telephone;//Attributes
    
    public DirectoryEntry(String surname, String qinitial, String qAddress, String qCity, String qTelephone){//Constructor
        name = surname;
        initials = qinitial;     
        address = qAddress;
        telephone = qTelephone;
        city = qCity;
    }
    public String getName(){//returns a name as specified
        return name;
    }
    public void setTelephone(String tele){ //replaces the current telephone number to a different one
        telephone = tele;
    }
    @Override
    public String toString(){//String representation using string format
        String format = "%1$-13s %2$-9s %3$-19s %4$-14s %5$s";
        String result =  String.format(format, name, initials, address, city, telephone);
      
        return '\n' + result;
    }
}
