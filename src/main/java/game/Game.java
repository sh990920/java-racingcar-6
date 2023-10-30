package game;

import camp.nextstep.edu.missionutils.Randoms;
import car.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    //사람 추가
    public List<String> addPerson(String persons){
        String[] personArray = persons.split(",");
        List<String> people = new ArrayList<>();
        for(int i = 0; i < personArray.length; i++){
            if(personArray[i].length() > 5){
                throw new IllegalArgumentException("길이가 너무 김");
            }
            people.add(personArray[i]);
        }
        return people;
    }

    // 자동차 클래스 추가
    public List<Car> addCar(List<String> people){
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < people.size(); i++){
            Car car = new Car(people.get(i));
            carList.add(car);
        }
        return carList;
    }

    // 랜덤 숫자 뽑기
    public int randomNumber(){
        int number = Randoms.pickNumberInRange(0,9);
        return number;
    }

}
