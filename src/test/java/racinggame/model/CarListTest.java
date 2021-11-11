package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.media.sound.InvalidFormatException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarListTest {

  private CarList carList;

  @BeforeEach
  void setUp() throws InvalidFormatException {
    carList = CarList.of("pobi,crong,honux");
  }

  @Test
  @DisplayName("차리스트 생성 테스트: input String 으로 ")
  void 차_리스트_생성_inputStrings() {


    // then
    assertAll(
        () -> assertThat(carList.getSize()).isEqualTo(3),
        () -> assertThat(carList.getCar(0).carName).isEqualTo("pobi"),
        () -> assertThat(carList.getCar(1).carName).isEqualTo("crong"),
        () -> assertThat(carList.getCar(2).carName).isEqualTo("honux")
    );
  }

  @Test
  @DisplayName("maxMoveCount(): carList 중 가장 큰 moveCount")
  void 차_리스트_중_가장_큰_moveCount() {
    carList.getCar(0).moveCount = 4;
    carList.getCar(1).moveCount = 2;
    carList.getCar(2).moveCount = 1;
    // when
    int maxNum = carList.maxMoveCount();
    // then
    assertThat(maxNum).isEqualTo(4);
  }

  @Test
  @DisplayName("maxMoveCarsName(): 가장 많이 움직인 차의 이름을 뱉는 메소드 테스트")
    void 차_리스트_중_가장_많이_움직인_차_이름_고르기() {
    // given
    carList.getCar(0).moveCount = 4;
    carList.getCar(1).moveCount = 2;
    carList.getCar(2).moveCount = 4;
    // when
    List<String> result = carList.maxMoveCarsName();
    // then
    assertThat(result.get(0)).isEqualTo("pobi,");
    assertThat(result.get(2)).isEqualTo("honux,");
  }
}
