import be.howest.tiemenvermote.products.domain.Product;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class PrintProgram {
    public static void main(String[] args) {
        new PrintProgram().run();
    }

    private File f = new File("products.txt");

    private void run(){
        try (FileInputStream fis = new FileInputStream(f);
             Scanner s = new Scanner(fis)){
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }
            System.out.close();
        } catch (FileNotFoundException ex){
            System.err.println(ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
