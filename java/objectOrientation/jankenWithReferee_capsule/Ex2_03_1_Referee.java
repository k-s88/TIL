class Ex2_03_1_Referee{
    
    private String refName;

    Ex2_03_1_Referee(String nm){
        refName = nm;
    }

    void jankenStart(){
        messageReferee("����񂯂�E�E�E�ۂ�I�I�I�I�I");
    }

    void jankenProgress(Ex2_03_1_Player n){
        messageReferee(n.getName() + "����̎��" + n.getHandStatus() + "�ł����I");
    }

    void Judge(Ex2_03_1_Player A, Ex2_03_1_Player B){
        String result = "";

        if(A.getHandStatus() == "�O�["){                 //A���񂪃O�[�̏ꍇ

            if(B.getHandStatus() == "�O�["){
                result = "�������I���������I";

            }else if(B.getHandStatus() == "�`���L"){
                result = A.getName() + "����̏����I";

            }else if(B.getHandStatus() == "�p�["){
                result = B.getName() + "����̏����I";
            }

        }else if(A.getHandStatus() == "�`���L"){         //A���񂪃`���L�̏ꍇ

            if(B.getHandStatus() == "�O�["){
                result = B.getName() + "����̏����I";

            }else if(B.getHandStatus() == "�`���L"){
                result = "�������I���������I";

            }else if(B.getHandStatus() == "�p�["){
                result = A.getName() + "����̏����I";
            }

        }else if(A.getHandStatus() == "�p�["){           //A���񂪃p�[�̏ꍇ

            if(B.getHandStatus() == "�O�["){
                result = A.getName() + "����̏����I";

            }else if(B.getHandStatus() == "�`���L"){
                result = B.getName() + "����̏����I";
                
            }else if(B.getHandStatus() == "�p�["){
                result = "�������I���������I";
            }

        }
        
        messageReferee("���ʂ́E�E�E");
        messageReferee(result);

    }
    void messageReferee(String msg){
        System.out.println(refName + "�u" + msg + "�v");
    }

    public String getRefName(){
        return this.refName;
    }
}