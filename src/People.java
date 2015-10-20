import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by earlbozarth on 10/19/15.
 */
public class People {
    public static void main(String[] args) {
        String filename = "people.csv";
        String peopleContent = readFile(filename);
        HashMap<String, ArrayList<Person>> peopleMap = new HashMap<>();
        String [] lines = peopleContent.split("\n");

        int index = 0;

        for(String line : lines){
            if (index != 0) {
                String[] columns = line.split(",");
                String id = columns[0];
                String firstName = columns[1];
                String lastName = columns[2];
                String email = columns[3];
                String country = columns[4];
                String ipAddress = columns[5];

                Person person1 = new Person(id, firstName, lastName, email, country, ipAddress);

                String countryName = String.valueOf(columns[4]);
                ArrayList<Person> pCountry = peopleMap.get(countryName);

                if (pCountry == null) {
                    pCountry = new ArrayList<>();
                    pCountry.add(person1);
                    peopleMap.put(countryName, pCountry);
                }//End of if Statement
                else {
                    pCountry.add(person1);
                }//End of else statement

                //Collections.sort(pCountry);
                //Sorting the collection of pCountry List by Last na

            }//End of If index does not equal 0
            index++;
            //Index is used to help skip over the first line of field names

            for(ArrayList<Person> list : peopleMap.values()){
                Collections.sort(list);
            }//End of inner for Loop

        }//End of outer For Loop

        System.out.println(peopleMap);

    }//End of Main Method

    static String readFile(String fileName){
        File f = new File(fileName);
        try{
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char [] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        }//End of try
        catch (Exception e){
            System.out.println("Error...Error...Error");
            return null;
        }//End of catch
    }//end of readFile

    static void writeFile(String fileName,String fileContent){
        File f = new File(fileName);
        try{
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        }//End of Try
        catch(Exception e){
            System.out.println("Error...Error...Error");
        }//End of Catch
    }//End of writeFile

}//End of People Class