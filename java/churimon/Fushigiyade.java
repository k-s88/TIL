package churimon;

class Fushigiyade extends Monster3 {

	Fushigiyade(){

		super();

		setCharacter("フシギヤデ");

	}

	Fushigiyade(String tr, String nm){

		super(tr, nm);

		setCharacter("フシギヤデ");

	}

	Fushigiyade(String tr, String nm, int defLv){

		super(tr, nm, defLv);

		setCharacter("フシギヤデ");

	}

	public void levelUp(int x) {

		setLv(getLv() 	+ x		);
		setHp(getHp() 	+ x * 31);
		setAtk(getAtk() + x * 6	);
		setDef(getDef() + x * 7	);
		setSpd(getSpd() + x * 8	);
		setHpMax(getHp()		);

	}

}
