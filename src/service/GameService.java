package service;

import model.Word;
import service.inter.FileServicInter;
import service.inter.GameServiceInter;

public class GameService implements GameServiceInter {
    private final FileServicInter fileServic;

    public GameService(){
        fileServic = new FileService();
    }
    @Override
    public void start() {
        Word[] words = fileServic.readFile();
        int point=0;

        System.out.println("------------>Start<------------");
        for (int i = 0; i <10 ; i++) {


        }


    }

    @Override
    public void add() {

    }

    @Override
    public void see() {

    }
}
