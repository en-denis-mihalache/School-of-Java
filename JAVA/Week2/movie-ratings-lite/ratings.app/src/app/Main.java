package app;

import core.Store;
import core.Logic;

public class Main {

    public static void main(String[] args) {
        
        ConsoleIO io = new ConsoleIO();
        Store store = new Store();
        store.seed();
        Logic logic = new Logic();
        Menu menu = new Menu();

        boolean running = true;
        while (running) {
            
            menu.show(io);
            int opt = io.readMenuOption(1, 7);
            if (opt == 0){
                continue;
            }
            switch (opt) {
                case 1 -> menu.handleListUsers(store, io);
                case 2 -> menu.handleListMovies(store, io);
                case 3 -> menu.handleAddRating(store, io, logic);
                case 4 -> menu.handleShowAverages(store, io);
                case 5 -> menu.handleShowTop(store, io);
                case 6 -> menu.handleShowHigh(store, io);
                case 7 -> {
                    io.printLine(String.format(ConsoleIO.FORMAT, ConsoleIO.HINT,"Exiting..."));
                    running = false;
                }
            }
            if (running) {
                io.printLine("");
            }
        }
    }
}
