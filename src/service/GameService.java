package service;

import exceptions.AppExceptions;
import exceptions.ExceptionsMessage;
import globalStrings.GlobalStrings;
import model.Word;
import service.inter.FileServicInter;
import service.inter.GameServiceInter;
import util.InputUtil;
import util.MenuItil;
import util.RandomUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class GameService implements GameServiceInter {
    private final FileServicInter fileServic;

    public GameService() {
        fileServic = new FileService();
    }

    @Override
    public void start() {

        Word[] words = fileServic.readFile();
        int point = 0;
        boolean check = true;


        System.out.println("------------>Start<------------");


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
        String localDateTime = LocalDateTime.now().format(dateTimeFormatter);
        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < 10; i++) {
            int randomIndex = RandomUtil.randomIndex(words.length);
            Word word = words[randomIndex];

            if (!word.isShowed()) {
                String value = InputUtil.inputString(word.getKey() + "=>");

                if (value.equalsIgnoreCase(word.getValue())) {
                    point++;
                }
                word.setShowed(true);
            } else {
                i--;
            }
        }

        double time = ChronoUnit.SECONDS.between(startTime,LocalTime.now());


        System.out.println("----------END------------");
        System.out.println("Your point: " + point + "\n" +
                "Your level: " + level(point) +"\n" +
                "Time: " + time);
        String log = "New game started at -> Time: "+localDateTime +", Point - " + point+
                " Game Time: " + time;
        MenuItil.applicationLogs(GlobalStrings.GAME_LOGS_FILE_NAME,log);


    }


    @Override
    public void add() {
       try {
           String key = InputUtil.inputString("English: ");
           char [] keyCharArray = key.toCharArray();
           for (int i = 0; i < keyCharArray.length; i++) {
               if (keyCharArray[i]>=32 && keyCharArray[i]<=47 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
               if (keyCharArray[i]>=58 && keyCharArray[i]<=64 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
               if (keyCharArray[i]>=91 && keyCharArray[i]<=96 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
               if (keyCharArray[i]>=123 && keyCharArray[i]<=126 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
           }

           String value = InputUtil.inputString("Azerbaijan: ");
           char [] valueCharArray = key.toCharArray();
           for (int i = 0; i < keyCharArray.length; i++) {
               if (valueCharArray[i]>=32 && valueCharArray[i]<=47 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
               if (valueCharArray[i]>=58 && valueCharArray[i]<=64 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
               if (valueCharArray[i]>=91 && valueCharArray[i]<=96 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
               if (valueCharArray[i]>=123 && valueCharArray[i]<=126 ){
                   throw new AppExceptions(ExceptionsMessage.ILLEGAL_CHARACTER_EXCEPTION);
               }
           }


           boolean isAdded = fileServic.writeFile(new Word(key,value));

           System.out.println(isAdded ? "Successfully added!" : "Failed!");

       }catch (Exception ex){
           System.out.println(ex.getMessage());

       }

    }

    @Override
    public void see() {
        Word[] words = fileServic.readFile();

        System.out.println("-------------- See history --------------");

        for (Word word: words) {
            System.out.println(word);
        }

        System.out.println("-----------------------------------------");

    }

    public static String  level(int point){
       if (point<=2){
           return "A0";
       }
        if (point>=3 && point<=4){
            return "A1";
        }
        if (point>=5 && point<=6){
            return "B1";
        }
        if (point>=7 && point<=8){
            return "C1";
        }
        if (point>=9 && point<=10){
            return "C2";
        }
        return null;
    }
}

