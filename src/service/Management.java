package service;

import service.inter.GameServiceInter;
import service.inter.ManagementInter;
import util.MenuItil;

public class Management implements ManagementInter {
    GameServiceInter gameService;

    public Management() {
        gameService = new GameService();
    }

    @Override
    public void manage() {
        while (true) {
            int option = MenuItil.printMenu();
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    gameService.start();
                    break;
                case 2:
                    gameService.add();
                    break;
                case 3:
                    gameService.see();
                    break;
                default:
                    System.out.println("Invalid option!");


            }

        }
    }
}
