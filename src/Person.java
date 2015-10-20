/**
 * Created by earlbozarth on 10/19/15.
 */
public class Person implements Comparable{
    String id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ipAddress;

    public Person(String id, String firstName, String lastName, String email, String country, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ipAddress = ipAddress;
    }//End of Constructor

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        int result = lastName.compareTo(p.lastName);
        return result;
    }//End of Compare To

    @Override
    public String toString(){
        return String.format("%s %s is from %s\n", firstName, lastName, country);
    }//End of toString

}//End of Person Class
