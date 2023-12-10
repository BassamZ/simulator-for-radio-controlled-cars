package Main;

import RC.*;

public class Main {
    public static void main(String[] args) {
        InputData userinfo = new InputData();
        userinfo.setData();
        Car monsterTruck=new Car(ModelType.MonsterTrack);
        monsterTruck.operation(userinfo);

    }
}