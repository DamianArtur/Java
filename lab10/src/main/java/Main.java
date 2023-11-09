import entity.PersonEntity;
import jdk.javadoc.internal.doclets.toolkit.util.Utils;

import javax.persistence.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory fac;s
        fac = Persistence.createEntityManagerFactory("default");
        EntityManager man = fac.createEntityManager();
        EntityTransaction tr = man.getTransaction();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of new record: ");
        int counter = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new records separated with spaces:");
        System.out.println("Name Surname E-mail");

        try {

            for (int i = 0; i < counter; i++) {
                tr.begin();

                System.out.print(i+1 + ": ");
                String newRecord = scanner.nextLine();
                String[] newRecordSplit = newRecord.split("\\s+");

                PersonEntity major = new PersonEntity();
                major.setpName(newRecordSplit[0]);
                major.setpSurname(newRecordSplit[1]);
                major.setpEmail(newRecordSplit[2]);

                man.persist(major);
                tr.commit();
            }
        } finally {
            if (tr.isActive())tr.rollback();
            man.close();
            fac.close();
        }
    }
}
