package churimon;

class Hitokake extends Monster3 {

	Hitokake(){

		super();

		setCharacter("ヒトカケ");

	}

	Hitokake(String tr, String nm){

		super(tr, nm);

		setCharacter("ヒトカケ");

	}

	Hitokake(String tr, String nm, int defLv){

		super(tr, nm, defLv);

		setCharacter("ヒトカケ");

	}

	public void levelUp(int x) {

		setLv(getLv() 	+ x		);
		setHp(getHp() 	+ x * 29);
		setAtk(getAtk() + x * 8	);
		setDef(getDef() + x * 5	);
		setSpd(getSpd() + x * 9	);
		setHpMax(getHp())		 ;

	}

}
