class Ex2_02_2_Janken{
    public static void main (String[] args) {

        //�R�}���h���C���������R�̕�������󂯎��
        //�C���X�^���X���Ɠ����Ƀv���C���[�ƐR���̖��O��ݒ�
        Ex2_02_2_Player A = new Ex2_02_2_Player(args[0]);
        Ex2_02_2_Player B = new Ex2_02_2_Player(args[1]);
        Ex2_02_2_Referee Ref = new Ex2_02_2_Referee(args[2]);

        Ref.jankenStart();      //����񂯂�J�n �R�����|����������
        A.makeHandStatus();     //�v���C���[���o��������߂�
        B.makeHandStatus();     //�v���C���[���o��������߂�
        Ref.jankenProgress(A);  //�R����A�̎������
        Ref.jankenProgress(B);  //�R����A�̎������
        Ref.Judge(A,B);            //�R�������肵���ʂ�����

    }
}