/*
�P�[�L���v���O����
 �E�R�}���h���C����������P�[�L��ނƒP�����܂Ƃ߂Ď��o��
 �E���v���z��1000�~���z�����ꍇ2������
 �E����ł�8��
 */
class CalcCakeSum{
    public static void main(String[] args) {

        //���i���Ɖ��i�̒�`
        final String short_name   = "�V���[�g�P�[�L"     ;
        final int    short_price  = 320                 ;
        final String monb_name    = "�����u����"         ;
        final int    monb_price   = 350                 ;
        final String choco_name   = "�`���R���[�g�P�[�L"  ;
        final int    choco_price  = 370                 ;
        final String ichigo_name  = "�������̃^���g"     ;
        final int    ichigo_price = 400                 ;
        final String cheese_name  = "�`�[�Y�P�[�L"       ;
        final int    cheese_price = 300                 ;

        final int    discountStandard   = 1000 ;    // �����
        final double discountRate       = 0.8  ;    // ������
        final double taxIncluded        = 1.08 ;    // ����ŗ�

        String cakeName  ;                          // �P�[�L�̎��
        int    cakeCount ;                          // �P�[�L�̌�
        int    Total = 0 ;                          // ���v���z
        int    payment ;                            // �x�����z

        for(int i = 0 ; i < args.length ; i = i+2){

                cakeName  = args[i]                     ;
                cakeCount = Integer.parseInt(args[i+1]) ;

            switch(cakeName){
                // �V���[�g�P�[�L
                case short_name:
                    Total = short_price * cakeCount ;
                    break;
                
                // �����u����
                case monb_name:
                    Total = monb_price * cakeCount ;
                    break;
                
                // �`���R���[�g�P�[�L
                case choco_name:
                    Total = choco_price * cakeCount ;
                    break;

                // �������̃^���g
                case ichigo_name:
                    Total = ichigo_price * cakeCount ;
                    break;

                // �`�[�Y�P�[�L
                case cheese_name:
                    Total = cheese_price * cakeCount ;
                    break;
            }
        }

        if ( Total > discountStandard ){        // �����Ώۂ̏ꍇ
            payment = (int)(Total * discountRate * taxIncluded) ;

        }else{                                  // �����ΏۊO�̏ꍇ
            payment = (int)(Total * taxIncluded) ;
        }

        System.out.println("���v���z��" + payment + "�~�ł��B");    //���v���z�̕\��
    }
}
