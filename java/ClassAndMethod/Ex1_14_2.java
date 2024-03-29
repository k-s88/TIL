/*-< 演習：Ex1_14_2 >---------------------------------
コマンドライン引数から1つ以上の数値を受け取り、この1つ1つの数値を購入した商品の定価としたとき、
合計金額を求め、その金額に応じた値引きを利かせ、最後に消費税（8％とする）をのせた金額を表示するプログラムを作りたい。
mainメソッドの内容は書き換えずに処理が通るようなメソッドを仕様に従って書いてください。
----------------------------------------------------*/
public class Ex1_14_2 {
	
	//！！！mainメソッドの処理は書き換えないでください！！！
	public static void main (String[] args) {
		
		int totalPrice = 0 ;                                 //購入した商品の合計金額
		
		//コマンドライン引数から購入した商品の合計金額（定価）を取得
		for(int i = 0 ; i < args.length ; i++ ){
			totalPrice += Integer.parseInt( args[i] );
		}
		
		//discountメソッドを使って値引きを適用し、値引き後の金額を取得
		int discountedPrice = discount( totalPrice );        //値引き後の金額
		
		//calcTaxPaymentメソッドを使って支払金額（税込）を取得
		int taxPayment = calcTaxPayment( discountedPrice );  //支払金額（税込）
		
		//支払金額（税込）を表示
		System.out.println("値引き後の支払金額：" + taxPayment + "円" );
		
	}
	
	/*
	**以下の仕様を持つメソッドdiscountを作成してください。
	**  - 引数として受け取った値が1000円以上5000円以下の場合、1000円より大きい分について10％割引にする
	**  - 引数として受け取った値が5000円より大きい場合、1000円より大きく5000円以下の分について10％割引、5000円より大きい分について20％割引にする
	**  - 値引き額は小数点以下切り捨てで計算する（キャストを使いましょう）
	**  - 割引金額の上限は5000円とする
	*/
	static int discount( int totalPrice ){            //アンダーバーを適切な内容に書き換えてください
		
		final int discountBorder1 = 1000 ;	// 基準１
		final int discountBorder2 = 5000 ;	// 基準２
		final double discountRate1 = 0.1 ; 	// 割引率１
		final double discountRate2 = 0.2 ; 	// 割引率２
		final int discountMax = 5000 ; 		// 割引金額の上限

		int discountTemp = 0 ; 				// 暫定の割引額
		
		// 暫定の割引額を算出
		if(totalPrice >= discountBorder1 && totalPrice <= discountBorder2){								// 購入額が1000円以上5000円以下
			discountTemp = (int)((totalPrice - discountBorder1) * discountRate1) ; 
		
		}else if( totalPrice > discountBorder2 ){														// 購入額が5000円以上
			int discountRange1 = discountBorder2 - discountBorder1 ;
			int discountRange2 = totalPrice - discountBorder2 ;
			discountTemp = (int)(discountRange1 * discountRate1 + discountRange2 * discountRate2) ; 
		}

		// 最終的な割引額を算出
		int discount = 0 ;	// 最終的な割引額
		
		if(discountTemp > discountMax){
			discount = discountMax ;
		
		}else{
			discount = discountTemp ;
		}

		return totalPrice - discount ; 
		
	}

	/*
	**以下の仕様を持つメソッドcalcTaxPaymentを作成してください。
	**  - 引数として受け取った値の税込価格（消費税は8％とする）を計算して返す
	**  - 税込価格は整数（小数点以下切り捨て）で返す
	*/

	static int calcTaxPayment( int discountedPrice ){        //アンダーバーを適切な内容に書き換えてください
		final double taxRate = 1.08 ;
		
		return(int)(discountedPrice * taxRate) ; 

	}
}
