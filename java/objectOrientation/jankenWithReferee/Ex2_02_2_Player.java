import java.util.Random;

class Ex2_02_2_Player{

    String name;
    String handStatus;

    Ex2_02_2_Player(String nm){
        this.name = nm;
    }

    void makeHandStatus(){
        String[] hands = { "�O�[", "�`���L", "�p�[" };
        Random r = new Random();
        this.handStatus = hands[r.nextInt(3)];
    }
}