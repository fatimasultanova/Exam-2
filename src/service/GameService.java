package service;

import model.Word;
import service.inter.FileServicInter;
import service.inter.GameServiceInter;
import util.InputUtil;
import util.RandomUtil;

import java.time.Duration;
import java.time.LocalTime;

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
        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < 10; i++) {
            int randomIndex = RandomUtil.randomIndex(words.length);
            Word word = words[randomIndex];

            if (!word.isShowed()) {
                String value = InputUtil.inputString(word.getKey() + "=>");

                if (value.equalsIgnoreCase(word.getValue())) {
                    point++;
                    break;
                }
                word.setShowed(true);
            } else {
                i--;
            }
        }
        double time = LocalTime.now().getSecond()-startTime.getSecond();


        System.out.println("----------END------------");
        System.out.println("Your point: " + point + "\n" +
                "Your level: " + level(point) +"\n" +
                "Time: " + time);


    }


    @Override
    public void add() {
        String key = InputUtil.inputString("English: ");
        String value = InputUtil.inputString("Azerbaijan: ");

        boolean isAdded = fileServic.writeFile(new Word(key,value));

        System.out.println(isAdded ? "Successfully added!" : "Failed!");

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

