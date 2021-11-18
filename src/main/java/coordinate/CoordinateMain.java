package coordinate;

import coordinate.controller.CoordinateController;
import coordinate.view.InputConsoleView;
import coordinate.view.InputView;
import coordinate.view.OutputConsoleView;
import coordinate.view.OutputView;

import java.util.Scanner;

public class CoordinateMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputConsoleView(scanner);
        OutputView outputView = new OutputConsoleView();
        CoordinateController coordinateController = new CoordinateController(inputView, outputView);
        coordinateController.run();
        scanner.close();
    }
}
