package p1;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class MyScanner {
    public void functionStart(ArrayList <String> sBarcodes, ArrayList <String> dBarcodes) throws IOException {
        System.out.println("Зіскануйте щоб дізнатись:");
        Scanner scan = new Scanner(System.in);
        String search = scan.nextLine();

        boolean found = false;
        for (String sBarcode : sBarcodes) {
            if (sBarcode.equals(search)) {
                found = true;
            }
        }

        if (found == false) {
            System.out.println("Спробуй ще");
        } else {
            System.out.println("О, це те що тобі потрібно: " + search);

            if (!Arrays.asList(dBarcodes).contains(search)) {
                FileWriter fw = new FileWriter("base.txt", true);
                fw.write(search);
                fw.append('\n');
                fw.close();
                dBarcodes.add(search);
            }


        }

        if(search.equals("stop")) {
            System.out.println("Виходжу:");
        } else {
            functionStart(sBarcodes, dBarcodes);
        }

    }
}