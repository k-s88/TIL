import java.sql.Time;

public class Payroll {

	public static void main(String[] args) {

		// �v�Z�p�̐��l��萔�ŗp��
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1���Ԃ̃~���b���Z
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1���̃~���b���Z
		final int  ONE_HOUR_BY_MIN       = 60;             // 1���Ԃ̕����Z

		// �o�C�g�̊J�n���ԂƏI�����Ԃ��R�}���h���C����������󂯎��
		Time startTime  = Time.valueOf(args[0]);
		Time finishTime = Time.valueOf(args[1]);

		// getTime���\�b�h���g���ĘJ�����Ԃ��~���b�i0.001�b�P�ʁj�Ŏ擾����
		// ��getTime()���\�b�h�̖߂�l��long�^�ł��邱�Ƃɒ���
		long workingTime = finishTime.getTime() - startTime.getTime();

		// �~���b�Ŏ擾�����J�����Ԃ������ԁ����̌`���ɒ���
		int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // ���ԂɊ��Z
		int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // ���Ɋ��Z

        // ���^�v�Z
        final int wage = 15 ; // 1��������̋��^
        final int restTime1 = 45 ; // �J�����Ԃ�6�`8���Ԃ̏ꍇ�̋x�e����
        final int restTime2 = 60 ; // �J�����Ԃ�8���Ԉȏ�̏ꍇ�̋x�e����
        final double excessMag = 1.25 ; // ���ߕ��̔{��
        final int legalWorkingHours = 480 ;
        
        int workingTimeConv = workingHour * 60 + workingMin ; 
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

        
        // �o��
		System.out.println("�{���̋��^��" + TotalWage + "�~�ł��B");
	}
}
