/*
ケーキ屋プログラム
 ・コマンドライン引数からケーキ種類と単価をまとめて取り出す
 ・合計金額が1000円を越えた場合2割引き
 ・消費税は8％
 */
class CalcCakeSum{
    public static void main(String[] args) {

        //商品名と価格の定義
        final String short_name   = "ショートケーキ"     ;
        final int    short_price  = 320                 ;
        final String monb_name    = "モンブラン"         ;
        final int    monb_price   = 350                 ;
        final String choco_name   = "チョコレートケーキ"  ;
        final int    choco_price  = 370                 ;
        final String ichigo_name  = "いちごのタルト"     ;
        final int    ichigo_price = 400                 ;
        final String cheese_name  = "チーズケーキ"       ;
        final int    cheese_price = 300                 ;

        final int    discountStandard   = 1000 ;    // 割引基準
        final double discountRate       = 0.8  ;    // 割引率
        final double taxIncluded        = 1.08 ;    // 消費税率

        String cakeName  ;
        int    cakeCount ; 
        int    Total = 0 ;                         // 合計金額
        int    payment ;                           // 支払金額

        for(int i = 0 ; i < args.length ; i = i+2){

                cakeName  = args[i]                     ;     // ケーキの種類
                cakeCount = Integer.parseInt(args[i+1]) ;     // ケーキの個数

            switch(cakeName){
                // ショートケーキ
                case short_name:
                    Total = short_price * cakeCount ;
                    break;
                
                // モンブラン
                case monb_name:
                    Total = monb_price * cakeCount ;
                    break;
                
                // チョコレートケーキ
                case choco_name:
                    Total = choco_price * cakeCount ;
                    break;

                // いちごのタルト
                case ichigo_name:
                    Total = ichigo_price * cakeCount ;
                    break;

                // チーズケーキ
                case cheese_name:
                    Total = cheese_price * cakeCount ;
                    break;
            }
        }

        if ( Total > discountStandard ){        // 割引対象の場合
            payment = (int)(Total * discountRate * taxIncluded) ;

        }else{                                  // 割引対象外の場合
            payment = (int)(Total * taxIncluded) ;
        }

        System.out.println("合計金額は" + payment + "円です。");    //合計金額の表示
    }
}
