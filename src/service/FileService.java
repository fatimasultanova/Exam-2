package service;

import globalStrings.GlobalStrings;
import model.Word;
import service.inter.FileServicInter;

import java.io.*;

public class FileService implements FileServicInter {
    @Override
    public Word[] readFile() {
        File file = new File(GlobalStrings.GAME_DICTIONARY_FILE_NAME);
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            String wordsOfFile = new String(bytes);
            String [] keyAndValues = wordsOfFile.split("\n");
            Word [] words = new Word[keyAndValues.length];

            for (int i = 0; i < words.length; i++) {
                String [] keyAndValue = keyAndValues[i].split(" : ");
                words[i] =new Word(keyAndValue[0], keyAndValue[1]);
            }

            return words;

        }catch (IOException exception){
           throw new RuntimeException(exception);

        }
    }

    @Override
    public boolean writeFile(Word word) {
       File file = new File(GlobalStrings.GAME_DICTIONARY_FILE_NAME);

       try (OutputStream outputStream = new FileOutputStream(file,true);
       BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)){

           bufferedOutputStream.write(word.toString().getBytes());
           return true;

       }catch (IOException ex){
           return false;
       }
    }
}
