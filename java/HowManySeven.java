//7�ȏ�7777777�ȉ���7�̔{����S�ď����o�����Ƃ��A�����u7�v�͉��񌻂�邩

import java.util.zip.CheckedOutputStream;

public class test{

    public static void main(String args[]) {
        
        int number = 7;
        String check = "";
        int count = 0;

        for(int i = 0 ; number < 7777777 ; i++){                // �V�̔{����number�ɓ����
            number = 7;
            number = number + (i * 7);
            check = String.valueOf(number);                     // number�𕶎���Ƃ���check�ɓ����

            for(int j = 0; j < check.length(); j++){
                String ch = String.valueOf(check.charAt(j));    // check���ꕶ�������o��
                if(ch.equals("7")){                             // ���o�����������V�Ȃ�J�E���g����
                    count++ ;
                }
            }
        
        }   
        System.out.println(count);                              // ���ʂ��o�͂���
    }
}