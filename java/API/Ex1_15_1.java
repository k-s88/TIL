/*-< 演習：Ex1_15_1 >---------------------------------
BigDecimalの扱いについてAPIドキュメントなどで調べながら
以下の結果が表示されるプログラムを作ってみましょう！
----------------------------------------------------*/
import java.math.BigDecimal;
import java.math.RoundingMode;

class Ex1_15_1{
	public static void main (String[] args) {
		
		//(1) 0.2 * 83 - 10.6
		BigDecimal num1 = new BigDecimal( "0.2" ) ;
		BigDecimal num2 = new BigDecimal( "83" ) ;
		BigDecimal num3 = new BigDecimal( "-10.6" ) ;
		BigDecimal result1 = (num1.multiply(num2)).add(num3) ;
		System.out.println(result1);		
		
		//(2) 0.2 * 83 - 10.6 / 3　※小数第4位までで表示（小数第5位以下は四捨五入）
		//<補足>
		// BigDecimalによる割り算は丸めの指定が必要です！
		// XXX ÷ YYYをして小数第2位で表示（小数第3位以下は切り捨て）
		// XXX.divide(YYY, 2, RoundingMode.DOWN);
		
		BigDecimal num4 = new BigDecimal( "3" ) ;
		BigDecimal result2 = (num1.multiply(num2)).add(num3.divide(num4, 4 , RoundingMode.HALF_UP));
		System.out.println(result2);
		
	}
}
