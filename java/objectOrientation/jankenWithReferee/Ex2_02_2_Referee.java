import javax.swing.text.html.HTML;

class Ex2_02_2_Referee{
    
    String refName;

    Ex2_02_2_Referee(String nm){
        refName = nm;
    }

    void jankenStart(){
        messageReferee("����񂯂�E�E�E�ۂ�I�I�I�I�I");
    }

    void jankenProgress(Ex2_02_2_Player n){
        messageReferee(n.name + "����̎��" + n.handStatus + "�ł����I");
        messageReferee("���ʂ́E�E�E");
    }

    void Judge(Ex2_02_2_Player A, Ex2_02_2_Player B){
        String result = "";

        if(A.handStatus == "�O�["){                 //A���񂪃O�[�̏ꍇ

            if(B.handStatus == "�O�["){
                result = "�������I���������I";

            }else if(B.handStatus == "�`���L"){
                result = A.name + "����̏����I";

            }else if(B.handStatus == "�p�["){
                result = B.name + "����̏����I";
            }

        }else if(A.handStatus == "�`���L"){         //A���񂪃`���L�̏ꍇ

            if(B.handStatus == "�O�["){
                result = B.name + "����̏����I";

            }else if(B.handStatus == "�`���L"){
                result = "�������I���������I";

            }else if(B.handStatus == "�p�["){
                result = A.name + "����̏����I";
            }

        }else if(A.handStatus == "�p�["){           //A���񂪃p�[�̏ꍇ

            if(B.handStatus == "�O�["){
                result = A.name + "����̏����I";

            }else if(B.handStatus == "�`���L"){
                result = B.name + "����̏����I";
                
            }else if(B.handStatus == "�p�["){
                result = "�������I���������I";
            }
        
            messageReferee(result);

        }
    }
    void messageReferee(String msg){
        System.out.println(refName + "�u" + msg + "�v");
    }
}