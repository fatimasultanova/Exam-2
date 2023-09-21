package util;

import static enums.Options.*;

public class MenuItil {
    public static int printMenu(){

        System.out.println("---------------------> Translator App <---------------------"+
                EXIT.getMessage()+START.getMessage()+ADD.getMessage()+SEE.getMessage());
        return InputUtil.inputInt("Choose option: ");

    }
}
