package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.media.sound.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarListTest {

  private CarList carList;

  @BeforeEach
  void setUp() {
  }

  @Test
  @DisplayName("차리스트 생성 테스트: input String 으로 ")
  void 차_리스트_생성_inputStrings() {
    // given
    String testCarNames = "pobi,crong,honux";

    // when
    CarList carList = new CarList(testCarNames);

    // then
    assertAll(
        () -> assertThat(carList.carList.size()).isEqualTo(3),
        () -> assertThat(carList.carList.get(0).carName).isEqualTo("pobi"),
        () -> assertThat(carList.carList.get(1).carName).isEqualTo("crong"),
        () -> assertThat(carList.carList.get(2).carName).isEqualTo("honux")
    );
  }
}
