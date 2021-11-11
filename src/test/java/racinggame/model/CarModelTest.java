package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.sun.media.sound.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarModelTest {

  Car defaultCar;

  @BeforeEach
  void setUp() throws InvalidFormatException {
    defaultCar = new Car("myCar");
  }

  @Test
  @DisplayName("Car 생성 테스트: 5자가 넘는 carName")
  public void car_생성_테스트_5자가_넘을경우() {
    // given
    String testCarName = "testCar";

    // when // then
    assertThatThrownBy(() -> {
      Car.of(testCarName);
    }).isInstanceOf(InvalidFormatException.class)
        .hasMessageContaining(Car.CAR_NAME_LENGTH_OVER);
  }

  @Test
  @DisplayName("Car 생성 테스트: 5자 이내이면서 alphabet 이외의 문자 포함")
  public void car_생성_테스트_알파벳_이외_문자_포함() {
    // given
    String testCarName = "I{)r";

    // when // then
    assertThatThrownBy(() -> {
      Car.of(testCarName);
    }).isInstanceOf(InvalidFormatException.class)
        .hasMessageContaining(Car.NOT_ALPHABET_CAR_NAME);
  }
  @Test
  @DisplayName("Car 생성 테스트: 성공")
  public void car_생성_테스트_성공() throws InvalidFormatException {
    // given
    String testCarName = "mycar";

    // when
    Car car = new Car(testCarName);
    // then
    assertAll(
        () -> assertThat(car.carName).isEqualTo(testCarName),
        () -> assertThat(car.moveCount).isEqualTo(0)
    );
  }

  @Test
  @DisplayName("Car 에 대해 전진 처리")
  void 자동차_전진하기() {

    // given
    defaultCar.moveCount = 1;
    
    // when
    defaultCar.move();
    
    // then
    assertThat(defaultCar.moveCount).isEqualTo(2);
  }

  @Test
  @DisplayName("들어온 random 값에 대한 행동: 3이하")
  void 들어온_숫자_판단_3이하() {

    int number = 3;
    // when
    defaultCar.decideMoving(number);
    // then
    assertThat(defaultCar.moveCount).isEqualTo(0);

  }

  @Test
  @DisplayName("들어온 random 값에 대한 행동: 4이상")
  void 들어온_숫자_판단_4이상() {

    int number = 4;
    // when
    defaultCar.decideMoving(number);
    // then
    assertThat(defaultCar.moveCount).isEqualTo(1);
  }

  @Test
  @DisplayName("decideWinner(number): moveCount 가 같을 경우")
  void 승리자판단_moveCountOverMaxNumber() {
    // given
    defaultCar.moveCount = 3;
    // when
    String winnerCarName = defaultCar.getCarNameMoveCountIsMaxNumber(3);
    // then
    assertThat(winnerCarName).isEqualTo("myCar,");
  }

}
