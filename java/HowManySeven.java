//7以上7777777以下の7の倍数を全て書き出したとき、数字「7」は何回現れるか

import java.util.zip.CheckedOutputStream;

public class test{

    public static void main(String args[]) {
        
        int number = 7;
        String check = "";
        int count = 0;

        for(int i = 0 ; number < 7777777 ; i++){                // ７の倍数をnumberに入れる
            number = 7;
            number = number + (i * 7);
            check = String.valueOf(number);                     // numberを文字列としてcheckに入れる

            for(int j = 0; j < check.length(); j++){
                String ch = String.valueOf(check.charAt(j));    // checkを一文字ずつ取り出す
                if(ch.equals("7")){                             // 取り出した文字が７ならカウントする
                    count++ ;
                }
            }
        
        }   
        System.out.println(count);                              // 結果を出力する
    }
}