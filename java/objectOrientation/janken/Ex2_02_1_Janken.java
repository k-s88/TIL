class Ex2_02_1_Janken{
    public static void main (String[] args) {
        
        //プレイヤーを設定

        Ex2_02_1_Player A = new Ex2_02_1_Player(args[0]);        
        Ex2_02_1_Player B = new Ex2_02_1_Player(args[1]);
        
        //じゃんけんの開始
        System.out.println("じゃんけん・・・ぽん！！！！！");

        //手を出す
        A.makeHandStatus();
        B.makeHandStatus();
        
        //出した手を表示
        System.out.println(A.name + "さんの手：" + A.handStatus);
        System.out.println(B.name + "さんの手：" + B.handStatus);

        //結果の判定
        
        String result = "";

        if(A.handStatus == "グー"){                 //Aさんがグーの場合

            if(B.handStatus == "グー"){
                result = "あいこ！勝負つかず！";
            }else if(B.handStatus == "チョキ"){
                result = A.name + "さんの勝利！";
            }else if(B.handStatus == "パー"){
                result = B.name + "さんの勝利！";
            }

        }else if(A.handStatus == "チョキ"){         //Aさんがチョキの場合

            if(B.handStatus == "グー"){
                result = B.name + "さんの勝利！";
            }else if(B.handStatus == "チョキ"){
                result = "あいこ！勝負つかず！";
            }else if(B.handStatus == "パー"){
                result = A.name + "さんの勝利！";
            }

        }else if(A.handStatus == "パー"){           //Aさんがパーの場合

            if(B.handStatus == "グー"){
                result = A.name + "さんの勝利！";
            }else if(B.handStatus == "チョキ"){
                result = B.name + "さんの勝利！";
            }else if(B.handStatus == "パー"){
                result = "あいこ！勝負つかず！";
            }

        }

        //結果の出力
        System.out.println("結果は・・・");
        System.out.println(result);

    }
}