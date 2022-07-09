import java.sql.Time;

public class Payroll {

	public static void main(String[] args) {

		// 計算用の数値を定数で用意
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1分のミリ秒換算
		final int  ONE_HOUR_BY_MIN       = 60;             // 1時間の分換算

		// バイトの開始時間と終了時間をコマンドライン引数から受け取る
		Time startTime  = Time.valueOf(args[0]);
		Time finishTime = Time.valueOf(args[1]);

		// getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
		// ※getTime()メソッドの戻り値はlong型であることに注意
		long workingTime = finishTime.getTime() - startTime.getTime();

		// ミリ秒で取得した労働時間を○時間△分の形式に直す
		int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // 時間に換算
		int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // 分に換算
	
		// 以下課題部分
       		// 給与計算
        	final int wage = 15 ; // 1分あたりの給与
        	final int restTime1 = 45 ; // 労働時間が6～8時間の場合の休憩時間
        	final int restTime2 = 60 ; // 労働時間が8時間以上の場合の休憩時間
        	final double excessMag = 1.25 ; // 超過分の倍率
        	final int legalWorkingHours = 480 ; // 法定労働時間
        
        	int workingTimeConv = workingHour * 60 + workingMin ; //労働時間を分単位で合計
        	int TotalWage = 0; 

        	if(workingTimeConv <= 360){
            		TotalWage =  wage * workingTimeConv;

        	}else if(workingTimeConv > 360 && workingTimeConv <= 480){
            		TotalWage =  wage * (workingTimeConv - restTime1);

        	}else if(workingTimeConv >= 480 && workingTimeConv < 540){
            		TotalWage =  wage * (workingTimeConv - restTime2);
        
        	}else if(workingTimeConv > 540){
            		int overtime = workingTimeConv - 540 ;
            		TotalWage =  (wage * legalWorkingHours) + (wage * (int)(excessMag) * overtime) ;
        	}

        
        	// 出力
		System.out.println("本日の給与は" + TotalWage + "円です。");
	}
}
