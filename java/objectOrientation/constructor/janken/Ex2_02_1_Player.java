import java.util.Random;

class Ex2_02_1_Player{

    String name;
    String handStatus;

    Ex2_02_1_Player(String nm){
        name = nm;
    }

    void makeHandStatus(){
        String[] hands = { "�O�[", "�`���L", "�p�[" };
        Random r = new Random();
        for(int i=0 ; i<5 ; i++) {
            handStatus = hands[r.nextInt(3)];
        }
    }
}