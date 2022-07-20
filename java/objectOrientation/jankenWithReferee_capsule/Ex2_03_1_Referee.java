class Ex2_03_1_Referee{
    
    private String refName;

    Ex2_03_1_Referee(String nm){
        refName = nm;
    }

    void jankenStart(){
        messageReferee("じゃんけん・・・ぽん！！！！！");
    }

    void jankenProgress(Ex2_03_1_Player n){
        messageReferee(n.getName() + "さんの手は" + n.getHandStatus() + "でした！");
    }

    void Judge(Ex2_03_1_Player A, Ex2_03_1_Player B){
        String result = "";

        if(A.getHandStatus() == "グー"){                 //Aさんがグーの場合

            if(B.getHandStatus() == "グー"){
                result = "あいこ！勝負つかず！";

            }else if(B.getHandStatus() == "チョキ"){
                result = A.getName() + "さんの勝利！";

            }else if(B.getHandStatus() == "パー"){
                result = B.getName() + "さんの勝利！";
            }

        }else if(A.getHandStatus() == "チョキ"){         //Aさんがチョキの場合

            if(B.getHandStatus() == "グー"){
                result = B.getName() + "さんの勝利！";

            }else if(B.getHandStatus() == "チョキ"){
                result = "あいこ！勝負つかず！";

            }else if(B.getHandStatus() == "パー"){
                result = A.getName() + "さんの勝利！";
            }

        }else if(A.getHandStatus() == "パー"){           //Aさんがパーの場合

            if(B.getHandStatus() == "グー"){
                result = A.getName() + "さんの勝利！";

            }else if(B.getHandStatus() == "チョキ"){
                result = B.getName() + "さんの勝利！";
                
            }else if(B.getHandStatus() == "パー"){
                result = "あいこ！勝負つかず！";
            }

        }
        
        messageReferee("結果は・・・");
        messageReferee(result);

    }
    void messageReferee(String msg){
        System.out.println(refName + "「" + msg + "」");
    }

    public String getRefName(){
        return this.refName;
    }
}