package coordinate.view;

import coordinate.domain.vo.Point;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.out;
import static java.util.stream.Collectors.toUnmodifiableList;

public class InputConsoleView implements InputView {

    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;

    private static final String INPUT_MESSAGE = "좌표를 입력하세요.";
    private static final String INVALID_INPUT_EXCEPTION_MESSAGE = "입력 값이 유효하지 않습니다";

    private static final String POINTS_INPUT_DELIMITER = "-";
    private static final String COORDINATE_DELIMITER = ",[\\s]?";

    private static final String INPUT_REGEX = "^(\\([0-9]{1,2},[\\s]?[0-9]{1,2}\\))(-\\([0-9]{1,2},[\\s]?[0-9]{1,2}\\))+$";
    private static final Pattern INPUT_PATTERN = Pattern.compile(INPUT_REGEX);

    private final Scanner scanner;

    public InputConsoleView(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Point> input() {
        out.println(INPUT_MESSAGE);
        String input = scanner.nextLine();
        return parsePointsFrom(input);
    }

    private List<Point> parsePointsFrom(final String input) {
        validateOf(input);
        String[] splattedPoints = input.split(POINTS_INPUT_DELIMITER);
        return Arrays.stream(splattedPoints)
                .map(this::parsePointFrom)
                .collect(toUnmodifiableList());
    }

    private void validateOf(final String input) {
        if (!INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private Point parsePointFrom(final String token) {
        String parenthesesRemovedToken = token.substring(1, token.length() - 1);
        String[] splattedCoordinate = parenthesesRemovedToken.split(COORDINATE_DELIMITER);
        int x = Integer.parseInt(splattedCoordinate[X_COORDINATE_INDEX]);
        int y = Integer.parseInt(splattedCoordinate[Y_COORDINATE_INDEX]);
        return new Point(x, y);
    }
}
