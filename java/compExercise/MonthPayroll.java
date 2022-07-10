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
		
		//  WorkingResult.csv�̃p�X ���uC:\WorkSpace�v�����ɔz�u���Ă��Ȃ��ꍇ�͓K�X�ύX���Ă��������B
		final String WORKING_RESULT_FILE_PATH = "C:\\WorkSpace\\WorkingResult.csv";
		// �R���}
		final String COMMA = ","; 
		
		// �v�Z�p�̐��l��萔�ŗp��
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1���Ԃ̃~���b���Z
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1���̃~���b���Z
		final int  ONE_HOUR_BY_MIN       = 60;             // 1���Ԃ̕����Z
		
		List<String> workingResults = new ArrayList<String>(); //�t�@�C������ǂݍ��񂾃f�[�^�̊i�[�p
		
		//  WorkingResult.csv��ǂݍ���
		try {
			// WorkingResult.csv�̓ǂݍ��ݏ���
			File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
			BufferedReader br = new BufferedReader(new FileReader(workingResultFile));
			
			// WorkingResult.csv��1�s���ǂݍ����ArrayList�Ɋi�[����
			String recode = br.readLine();
			while (recode != null) {
				workingResults.add(recode);
				recode = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		final int wage = 15 ; // 1��������̋��^
		final int restTime1 = 45 ; // �J�����Ԃ�6�`8���Ԃ̏ꍇ�̋x�e����
		final int restTime2 = 60 ; // �J�����Ԃ�8���Ԉȏ�̏ꍇ�̋x�e����
		final double excessMag = 1.25 ; // ���ߕ��̔{��
		final int legalWorkingHours = 480 ; 

		int monthWage = 0;
	

		for (int i = 0; i < workingResults.size() ; i++) {
			
			String workingRecode    = workingResults.get(i);      // 1�s������������o��
			String[] forSplitRecode = workingRecode.split(COMMA); // split���\�b�h��p���ăJ���}��؂�ŕ�����𕪉����z��ɂ��ꂼ��i�[

			Time startTime   = Time.valueOf(forSplitRecode[1]); // �o�Ύ���
			Time finishTime  = Time.valueOf(forSplitRecode[2]); // �ދΎ���
			
			// getTime���\�b�h���g���ĘJ�����Ԃ��~���b�i0.001�b�P�ʁj�Ŏ擾����
			long workingTime = finishTime.getTime() - startTime.getTime();
			
			// �~���b�Ŏ擾�����J�����Ԃ������ԁ����̌`���ɒ���
			int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // ���ԂɊ��Z
			int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // ���Ɋ��Z

        	// ���^�v�Z
			int workingTimeConv = workingHour * 60 + workingMin; 
			int oneDateWage = 0;
			

        	if(workingTimeConv <= 360){																// 6���Ԗ���
				oneDateWage = wage * workingTimeConv;

			}else if(workingTimeConv > 360 && workingTimeConv <= 480){								// 6���ԉz��8���Ԉȉ�
				oneDateWage = wage * (workingTimeConv - restTime1);

			}else if(workingTimeConv > 480 && workingTimeConv < 540){								// 8���ԉz�����J������8���Ԗ���
				oneDateWage = wage * (workingTimeConv - restTime2);
			
			}else if(workingTimeConv > 540){														// ���J������8���ԉz���i�J������9���ԉz���j
				int overtime = workingTimeConv - 540 ;
				oneDateWage = (wage * legalWorkingHours) + (wage * (int)(excessMag) * overtime) ;
			}

			monthWage += oneDateWage;
		}
		// �o��
		System.out.println("�����̋��^��" + monthWage + "�~�ł��B");
    }
}