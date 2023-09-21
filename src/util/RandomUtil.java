package util;

import java.util.Random;

public class RandomUtil {
    public static int randomIndex(int size){
        Random random = new Random();
        return random.nextInt(size);
    }
}
