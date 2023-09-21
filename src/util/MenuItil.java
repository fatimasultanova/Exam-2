package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static enums.Options.*;

public class MenuItil {
    public static int printMenu(){

        System.out.println("---------------------> Translator App <---------------------"+
                EXIT.getMessage()+START.getMessage()+ADD.getMessage()+SEE.getMessage());
        return InputUtil.inputInt("Choose option: ");
    }

    public static void applicationLogs(String filename, String log) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));
            bufferedWriter.write(log);
            bufferedWriter.flush();
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}
