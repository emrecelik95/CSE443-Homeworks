package sample;

import java.util.ArrayList;
import java.util.List;

/**
 *  Group emails
 */
public class GroupEmail extends Email {

    /**
     *  personel emails
     */
    private List<IEmail> emails = new ArrayList<>();

    /**
     *  Constructor
     * @param email
     * email adress
     * @param name
     * name
     */
    public GroupEmail(String email, String name){
        super(email, name);
    }

    public void ListEmails(){
        System.out.println(name + " , " + getEmailAdress());
        for(int i = 0; i < emails.size(); i++)
            System.out.println(emails.get(i).getDescription());
    }

    /**
     * Add new personal email
     * @param email
     * email adress
     * @return
     * process is successful or not
     */
    public boolean addEmail(IEmail email){
        return emails.add(email);
    }

    /**
     * Remove a personel email
     * @param email
     * email adress
     * @return
     * process is successful or not
     */
    public boolean removeEmail(IEmail email){
        return emails.remove(email);
    }
}
