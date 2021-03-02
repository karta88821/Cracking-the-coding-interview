import java.io.*;

import javax.annotation.processing.FilerException;

public class IOO {
    public static void main(String[] args) {

        File file = new File("Foo.txt");


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private String name;

    Person(String name) {
        this.name = name;
    }
}