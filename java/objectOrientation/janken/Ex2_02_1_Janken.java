class Ex2_02_1_Janken{
    public static void main (String[] args) {
        
        //�v���C���[��ݒ�

        Ex2_02_1_Player A = new Ex2_02_1_Player(args[0]);        
        Ex2_02_1_Player B = new Ex2_02_1_Player(args[1]);
        
        //����񂯂�̊J�n
        System.out.println("����񂯂�E�E�E�ۂ�I�I�I�I�I");

        //����o��
        A.makeHandStatus();
        B.makeHandStatus();
        
        //�o�������\��
        System.out.println(A.name + "����̎�F" + A.handStatus);
        System.out.println(B.name + "����̎�F" + B.handStatus);

        //���ʂ̔���
        
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

        }

        //���ʂ̏o��
        System.out.println("���ʂ́E�E�E");
        System.out.println(result);

    }
}