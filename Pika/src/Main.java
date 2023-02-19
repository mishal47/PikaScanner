import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import p1.MyScanner;
public class Main {
    public static void main(String[] args) throws IOException {
        MyScanner ms = new MyScanner();
        BufferedReader br = null;
        try {
            File file = new File("barkody.txt");
            functionExist(file);

            br = new BufferedReader(new FileReader(file));
            String str;
            
            ArrayList <String> sBarcodes = new ArrayList<>();
            while ((str = br.readLine()) != null) {
                sBarcodes.add(str);
            }

            File file2 = new File("base.txt");
            functionExist(file);
            br = new BufferedReader(new FileReader(file2));

            ArrayList <String> dBarcodes = new ArrayList<>();
            while ((str = br.readLine()) != null) {
                dBarcodes.add(str);
            }
            ms.functionStart(sBarcodes, dBarcodes);


        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
    private static void functionExist(File file) {
        if (!file.exists()) {
            System.out.println("File not exist");
        } else {
            System.out.println("File exist");
        }
    }

}