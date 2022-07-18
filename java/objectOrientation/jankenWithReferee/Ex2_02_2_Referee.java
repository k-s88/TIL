import javax.swing.text.html.HTML;

class Ex2_02_2_Referee{
    
    String refName;

    Ex2_02_2_Referee(String nm){
        refName = nm;
    }

    void jankenStart(){
        messageReferee("じゃんけん・・・ぽん！！！！！");
    }

    void jankenProgress(Ex2_02_2_Player n){
        messageReferee(n.name + "さんの手は" + n.handStatus + "でした！");
        messageReferee("結果は・・・");
    }

    void Judge(Ex2_02_2_Player A, Ex2_02_2_Player B){
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
        
            messageReferee(result);

        }
    }
    void messageReferee(String msg){
        System.out.println(refName + "「" + msg + "」");
    }
}