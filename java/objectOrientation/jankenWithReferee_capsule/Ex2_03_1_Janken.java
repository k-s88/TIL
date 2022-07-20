class Ex2_03_1_Janken{
    public static void main (String[] args) {

        //コマンドライン引数より３つの文字列を受け取る
        //インスタンス化と同時にプレイヤーと審判の名前を設定
        Ex2_03_1_Player A = new Ex2_03_1_Player(args[0]);
        Ex2_03_1_Player B = new Ex2_03_1_Player(args[1]);
        Ex2_03_1_Referee Ref = new Ex2_03_1_Referee(args[2]);

        Ref.jankenStart();      //じゃんけん開始 審判が掛け声を言う
        A.makeHandStatus();     //プレイヤーが出す手を決める
        B.makeHandStatus();     //プレイヤーが出す手を決める
        Ref.jankenProgress(A);  //審判がAの手を言う
        Ref.jankenProgress(B);  //審判がAの手を言う
        Ref.Judge(A,B);         //審判が判定し結果を言う

    }
}