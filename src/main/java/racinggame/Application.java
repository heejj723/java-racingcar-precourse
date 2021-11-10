package racinggame;

import racinggame.controller.CarController;
import racinggame.view.InputView;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.playGame();
    }
}
