/*-< ���K�FEx1_14_2 >---------------------------------
�R�}���h���C����������1�ȏ�̐��l���󂯎��A����1��1�̐��l���w���������i�̒艿�Ƃ����Ƃ��A
���v���z�����߁A���̋��z�ɉ������l�����𗘂����A�Ō�ɏ���Łi8���Ƃ���j���̂������z��\������v���O��������肽���B
main���\�b�h�̓��e�͏����������ɏ������ʂ�悤�ȃ��\�b�h���d�l�ɏ]���ď����Ă��������B
----------------------------------------------------*/
public class Ex1_14_2 {
	
	//�I�I�Imain���\�b�h�̏����͏��������Ȃ��ł��������I�I�I
	public static void main (String[] args) {
		
		int totalPrice = 0 ;                                 //�w���������i�̍��v���z
		
		//�R�}���h���C����������w���������i�̍��v���z�i�艿�j���擾
		for(int i = 0 ; i < args.length ; i++ ){
			totalPrice += Integer.parseInt( args[i] );
		}
		
		//discount���\�b�h���g���Ēl������K�p���A�l������̋��z���擾
		int discountedPrice = discount( totalPrice );        //�l������̋��z
		
		//calcTaxPayment���\�b�h���g���Ďx�����z�i�ō��j���擾
		int taxPayment = calcTaxPayment( discountedPrice );  //�x�����z�i�ō��j
		
		//�x�����z�i�ō��j��\��
		System.out.println("�l������̎x�����z�F" + taxPayment + "�~" );
		
	}
	
	/*
	**�ȉ��̎d�l�������\�b�hdiscount���쐬���Ă��������B
	**  - �����Ƃ��Ď󂯎�����l��1000�~�ȏ�5000�~�ȉ��̏ꍇ�A1000�~���傫�����ɂ���10�������ɂ���
	**  - �����Ƃ��Ď󂯎�����l��5000�~���傫���ꍇ�A1000�~���傫��5000�~�ȉ��̕��ɂ���10�������A5000�~���傫�����ɂ���20�������ɂ���
	**  - �l�����z�͏����_�ȉ��؂�̂ĂŌv�Z����i�L���X�g���g���܂��傤�j
	**  - �������z�̏����5000�~�Ƃ���
	*/
	static int discount( int totalPrice ){            //�A���_�[�o�[��K�؂ȓ��e�ɏ��������Ă�������
		
		final int discountBorder1 = 1000 ;	// ��P
		final int discountBorder2 = 5000 ;	// ��Q
		final double discountRate1 = 0.1 ; 	// �������P
		final double discountRate2 = 0.2 ; 	// �������Q
		final int discountMax = 5000 ; 		// �������z�̏��

		int discountTemp = 0 ; 				// �b��̊����z
		
		// �b��̊����z���Z�o
		if(totalPrice >= discountBorder1 && totalPrice <= discountBorder2){								// �w���z��1000�~�ȏ�5000�~�ȉ�
			discountTemp = (int)((totalPrice - discountBorder1) * discountRate1) ; 
		
		}else if( totalPrice > discountBorder2 ){														// �w���z��5000�~�ȏ�
			int discountRange1 = discountBorder2 - discountBorder1 ;
			int discountRange2 = totalPrice - discountBorder2 ;
			discountTemp = (int)(discountRange1 * discountRate1 + discountRange2 * discountRate2) ; 
		}

		// �ŏI�I�Ȋ����z���Z�o
		int discount = 0 ;	// �ŏI�I�Ȋ����z
		
		if(discountTemp > discountMax){
			discount = discountMax ;
		
		}else{
			discount = discountTemp ;
		}

		return totalPrice - discount ; 
		
	}

	/*
	**�ȉ��̎d�l�������\�b�hcalcTaxPayment���쐬���Ă��������B
	**  - �����Ƃ��Ď󂯎�����l�̐ō����i�i����ł�8���Ƃ���j���v�Z���ĕԂ�
	**  - �ō����i�͐����i�����_�ȉ��؂�̂āj�ŕԂ�
	*/

	static int calcTaxPayment( int discountedPrice ){        //�A���_�[�o�[��K�؂ȓ��e�ɏ��������Ă�������
		final double taxRate = 1.08 ;
		
		return(int)(discountedPrice * taxRate) ; 

	}
}
