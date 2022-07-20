import java.util.Random;

class Ex2_03_1_Player{

    private String name;
    private String handStatus;

    Ex2_03_1_Player(String nm){
        this.name = nm;
    }

    void makeHandStatus(){
        String[] hands = { "グー", "チョキ", "パー" };
        Random r = new Random();
        this.handStatus = hands[r.nextInt(3)];
    }

    public String getName() {
        return this.name;
    }
    public String getHandStatus() {
        return this.handStatus;
    }
}
