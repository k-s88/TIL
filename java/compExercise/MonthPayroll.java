import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MonthPayroll {
	public static void main(String[] args) {
		
		//  WorkingResult.csvのパス ※「C:\WorkSpace」直下に配置していない場合は適宜変更してください。
		final String WORKING_RESULT_FILE_PATH = "C:\\WorkSpace\\WorkingResult.csv";
		// コンマ
		final String COMMA = ","; 
		
		// 計算用の数値を定数で用意
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1分のミリ秒換算
		final int  ONE_HOUR_BY_MIN       = 60;             // 1時間の分換算
		
		List<String> workingResults = new ArrayList<String>(); //ファイルから読み込んだデータの格納用
		
		//  WorkingResult.csvを読み込む
		try {
			// WorkingResult.csvの読み込み準備
			File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
			BufferedReader br = new BufferedReader(new FileReader(workingResultFile));
			
			// WorkingResult.csvを1行ずつ読み込んでArrayListに格納する
			String recode = br.readLine();
			while (recode != null) {
				workingResults.add(recode);
				recode = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		final int wage = 15 ; // 1分あたりの給与
		final int restTime1 = 45 ; // 労働時間が6～8時間の場合の休憩時間
		final int restTime2 = 60 ; // 労働時間が8時間以上の場合の休憩時間
		final double excessMag = 1.25 ; // 超過分の倍率
		final int legalWorkingHours = 480 ; 

		int monthWage = 0;
	

		for (int i = 0; i < workingResults.size() ; i++) {
			
			String workingRecode    = workingResults.get(i);      // 1行ずつ文字列を取り出す
			String[] forSplitRecode = workingRecode.split(COMMA); // splitメソッドを用いてカンマ区切りで文字列を分解＆配列にそれぞれ格納

			Time startTime   = Time.valueOf(forSplitRecode[1]); // 出勤時間
			Time finishTime  = Time.valueOf(forSplitRecode[2]); // 退勤時間
			
			// getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
			long workingTime = finishTime.getTime() - startTime.getTime();
			
			// ミリ秒で取得した労働時間を○時間△分の形式に直す
			int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // 時間に換算
			int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // 分に換算

        	// 給与計算
			int workingTimeConv = workingHour * 60 + workingMin; 
			int oneDateWage = 0;
			

        		if(workingTimeConv <= 360){												// 6時間未満
				oneDateWage = wage * workingTimeConv;

			}else if(workingTimeConv > 360 && workingTimeConv <= 480){								// 6時間越え8時間以下
				oneDateWage = wage * (workingTimeConv - restTime1);

			}else if(workingTimeConv > 480 && workingTimeConv < 540){								// 8時間越え実労働時間8時間未満
				oneDateWage = wage * (workingTimeConv - restTime2);
			
			}else if(workingTimeConv > 540){											// 実労働時間8時間越え（労働時間9時間越え）
				int overtime = workingTimeConv - 540 ;
				oneDateWage = (wage * legalWorkingHours) + (wage * (int)(excessMag) * overtime) ;
			}

			monthWage += oneDateWage;
		}
		// 出力
		System.out.println("今月の給与は" + monthWage + "円です。");
    }
}
