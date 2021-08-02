package step3.model;

import java.util.*;
import java.util.stream.IntStream;

public class CarGame {
    /**
     * 전반적인 게임을 진행하는 메소드
     * 결과값을 /로 구분해서 차번호/랜덤숫자/거리 형태로 저장한다.
     * @param tryCnt
     */
    public List<String> playGame(int carCnt, int tryCnt) {
        //자동차 세팅
        Cars cars = new Cars(carCnt);

        //결과값
        List<String> results = new ArrayList<>();

        while (tryCnt-- > 0) {
            IntStream
                    .range(0, cars.getCarCnt())
                    .forEach(j -> {
                        RandomMovingStrategy strategy = new RandomMovingStrategy();
                        int nextMove = cars.move(j, strategy);
                        results.add((j+1) + "/" + strategy.getRandomNumber() + "/" + nextMove);
                    });
        }

        return results;
    }
}