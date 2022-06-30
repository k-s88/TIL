/*
自販機風プログラム
・コマンドライン引数を投入された硬貨とする
・「10円玉」「50円玉」「100円玉」「500円玉」のみを使用可能な硬貨とする
・「1円玉」「5円玉」は使用不可とし警告を表示
・効果に存在しない値の場合警告を表示
・最後に入力されたコマンドライン引数を商品の値段とし、お釣りを表示
*/

class jihan{
    public static void main(String[] args) {
        
        int coinNum = args.length - 1 ; // 硬貨の枚数
        int coinChk = 0 ;               // 硬貨の種類
        int coinSum = 0 ;               // 合計金額
        
        for( int i = 0 ; i < coinNum; i++ ){
            
            coinChk = Integer.parseInt(args[i]) ;

            if(coinChk == 10 || coinChk == 50 || coinChk == 100 || coinChk == 500 ){            // 10円玉、50円玉、100円玉、500円玉を合計
                coinSum += coinChk ; 

            }else if(coinChk == 1 || coinChk == 5){
                System.out.println( "警告：" + coinChk + "円玉は使えません" ) ; 

            }else{
                System.out.println( "警告：" + coinChk + "は硬貨として適切な値ではありません" ) ; 
                    
            }
        }

        int price = Integer.parseInt(args[args.length - 1]) ; ;                                 // 商品値段
        int change = coinSum - price ;                                                          // お釣り
 
        System.out.println( change + "円のお釣りです。ありがとうございました。" ) ; 
    }
}
