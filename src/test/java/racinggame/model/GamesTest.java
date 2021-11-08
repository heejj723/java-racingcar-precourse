package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GamesTest {

  private static Games games;

  @BeforeAll
  static void setUp() {
    games = new Games("pobi,crong,honux", 5);
  }

  @ParameterizedTest
  @CsvSource(value = {"3:false","4:true"}, delimiter = ':')
  @DisplayName("주사위 값이 전진인지 판단하는 메소드 테스트")
  void 주사위_값_전진_판단_테스트(Integer number, Boolean expected) {
    // given

    // when
    Boolean result = games.canIMove(number);
    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("car 에 대해 random Number 뽑기")
  void 랜덤_숫자_뽑기() {
    // given
    // when
    // then
    assertThat(games.getRandomNumber()).isBetween(0,9);
  }

  @Test
  @DisplayName("playRount(): ")
  void 한판_해보기() {
    /**
     * 차 리스트를 이름들로 생성하고
     * 각 리스트에 대해서
     * - 랜덤 숫자를 골라서
     * - 전진인지 아닌지 판별한 후
     *  - 만약에 전진이면 car 에 대해 전진 처리 후
     * - 차에대한 result 를 print 함.
     * */
  }

//  @Test
//  @DisplayName("checkMoveTest: 움직임이 true 일 경우 car Count 가 증가했는지 확인")
//  void 움직임이_트루() {
//
//  }
//
//  @Test
//  @DisplayName("checkMoveTest: 움직임이 true 일 경우 car Count 가 증가했는지 확인")
//  void 움직임이_트루() {
//
//  }

}
