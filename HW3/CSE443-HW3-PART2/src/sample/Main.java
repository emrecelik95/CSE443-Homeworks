package sample;


public class Main {


    public static void main(String[] args) {

        System.out.println("Personel Emails :");
        Email mail1 = new PersonEmail("ahmetcan@email.com","Ahmetcan");
        Email mail2 = new PersonEmail("mehmet@mehmet.com", "Mehmet");
        Email mail3 = new PersonEmail("cem@cem.com", "Cem");

        System.out.println(mail1.getDescription());
        System.out.println(mail2.getDescription());
        System.out.println(mail3.getDescription());
        System.out.println();

        Email mail4 = new PersonEmail("halil@group.com", "Halil");
        Email mail5 = new PersonEmail("mertcan@group.com", "Mertcan");
        Email mail6 = new PersonEmail("ihsan@group.com", "İhsan");

        GroupEmail group = new GroupEmail("group@group.com", "Group");

        group.addEmail(mail4);
        group.addEmail(mail5);
        group.addEmail(mail6);

        System.out.println("Group Emails : ");
        group.ListEmails();



    }
}
