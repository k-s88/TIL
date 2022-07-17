import java.util.Random;

class Ex2_02_1_Player{

    String name;
    String handStatus;

    Ex2_02_1_Player(String nm){
        name = nm;
    }

    void makeHandStatus(){
        String[] hands = { "グー", "チョキ", "パー" };
        Random r = new Random();
        handStatus = hands[r.nextInt(3)];
    }
}