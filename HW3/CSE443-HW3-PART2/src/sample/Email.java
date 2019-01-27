package sample;

/**
 * Abstract class for Email
 *
 */
public abstract class Email implements IEmail{

    /**
     *  e-mail adress
     */
    protected String emailAdress;

    /**
     * name
     */
    protected String name;

    /**
     * name getter
     * @return
     * name
     */
    public String getName() {
        return name;
    }

    public String getDescription(){
        return getName() + " , " + getEmailAdress();
    }

    /**
     * Constructor takes email as string
     * @param email
     * email adress
     * @param name
     * name
     */
    public Email(String email, String name){
        this.emailAdress = email;
        this.name = name;
    }

    /**
     * email adress getter
     * @return
     * email adress
     */
    @Override
    public String getEmailAdress() {
        return emailAdress;
    }
}
