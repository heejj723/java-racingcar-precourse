package racinggame.model;

import com.sun.media.sound.InvalidFormatException;

public class Car {

  public static final String NOT_ALPHABET_CAR_NAME = "car name containing not alphabet";
  public static final String CAR_NAME_LENGTH_OVER = "car name length is invalid";
  private static final int CAR_NAME_LENGTH = 5;
  public static final String BLANK_CAR_NAME = "";
  public static final String COMMA_STRING = ",";
  private static final String CAR_NAME_VALIDATE_PATTERN = "[a-zA-z]+";
  private final int MOVE_BOUNDARY = 4;
  private final int MOVE_COUNT_INIT = 0;
  public String carName;
  public int moveCount;

  public Car(String carName) {
    this.carName = carName;
    this.moveCount = MOVE_COUNT_INIT;
  }

  public static Car of(String carName) throws InvalidFormatException {
    validateCarName(carName);
    return new Car(carName);
  }

  private static void validateCarName(String carName) throws InvalidFormatException {
    validateCarNameLength(carName);
    validateCarNameAlphabet(carName);
  }

  private static void validateCarNameAlphabet(String carName) throws InvalidFormatException {
    if (!carName.matches(CAR_NAME_VALIDATE_PATTERN)) {
      throw new InvalidFormatException(NOT_ALPHABET_CAR_NAME);
    }
  }

  private static void validateCarNameLength(String carName) throws InvalidFormatException {
    if (carName.length() > CAR_NAME_LENGTH) {
      throw new InvalidFormatException(CAR_NAME_LENGTH_OVER);
    }
  }

  public void move() {
    this.moveCount++;
  }

  public void decideMoving(int number) {
    if (number >= MOVE_BOUNDARY) {
      this.move();
    }
  }

  public String getCarNameMoveCountIsMaxNumber(int maxNumber) {
    if (this.moveCount == maxNumber) return this.carName+COMMA_STRING;
    return BLANK_CAR_NAME;
  }
}
