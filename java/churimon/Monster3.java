package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Monster3 {

	private String character;			// 種族
	private String trainer;			// トレーナー
	private String name;				// なまえ
	private int lv;					// レベル
	private int hp;					// HP
	private int atk;					// こうげき
	private int def;					// ぼうぎょ
	private int spd;					// すばやさ
	private int hpMax;					// HP初期値
	private String wazaNm;				// わざ（なまえ）
	private String wazaDmgRate;		// わざ（ダメージ倍率）

//getter / setterの設定

	public String getCharacter() {

		return character;

	}

	public void setCharacter(String character) {

		this.character = character;

	}

	public String getTrainer() {

		return trainer;

	}

	public void setTrainer(String trainer) {

		this.trainer = trainer;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public int getLv() {

		return lv;

	}

	public void setLv(int lv) {

		this.lv = lv;

	}

	public int getHp() {

		return hp;

	}

	public void setHp(int hp) {

		this.hp = hp;

	}

	public int getAtk() {

		return atk;

	}

	public void setAtk(int atk) {

		this.atk = atk;

	}

	public int getDef() {

		return def;

	}

	public void setDef(int def) {

		this.def = def;

	}

	public int getSpd() {

		return spd;

	}

	public void setSpd(int spd) {

		this.spd = spd;

	}

	public int getHpMax() {

		return hpMax;

	}

	public void setHpMax(int hpMax) {

		this.hpMax = hpMax;

	}

	public String getWazaNm() {

		return wazaNm;

	}

	public void setWazaNm(String wazaNm) {

		this.wazaNm = wazaNm;

	}

	public String getWazaDmgRate() {

		return wazaDmgRate;

	}

	public void setWazaDmgRate(String wazaDmgRate) {

		this.wazaDmgRate = wazaDmgRate;

	}

	// コンストラクタ（引数なし）
	public Monster3(){

		this.character 		= "(unknown)" ;
		this.trainer 		= "(wild)" ;
		this.name 			= "(noname)" ;
		this.lv 			= 1 ;
		this.hp 			= 80 ;
		this.atk 			= 15 ;
		this.def 			= 10 ;
		this.spd 			= 10 ;
		this.hpMax 			= 80 ;
		this.wazaNm 		= "たいあたり" ;
		this.wazaDmgRate 	= "1.0" ;

	}

	// コンストラクタ（引数：トレーナー、なまえ）
	public Monster3(String tr, String nm){

		this.character 		= "(unknown)" ;
		this.trainer 		= tr ;
		this.name 			= nm ;
		this.lv 			= 1 ;
		this.hp 			= 80 ;
		this.atk 			= 15 ;
		this.def 			= 10 ;
		this.spd 			= 10 ;
		this.hpMax 			= 80 ;
		this.wazaNm 		= "たいあたり" ;
		this.wazaDmgRate 	= "1.0" ;

	}

	// コンストラクタ（引数：トレーナー、なまえ、初期レベル）
	public Monster3(String tr, String nm, int defLv){

		this.character 		= "(unknown)" ;
		this.trainer 		= tr ;
		this.name 			= nm ;
		this.lv 			= 1 ;
		this.hp 			= 80 ;
		this.atk 			= 15 ;
		this.def 			= 10 ;
		this.spd 			= 10 ;
		this.hpMax 			= 80 ;
		this.wazaNm 		= "たいあたり" ;
		this.wazaDmgRate 	= "1.0" ;

		// 初期レベルが1の場合 なにもしない
		if(defLv == 1) {

			;

			// 初期レベルが2以上の場合 「初期レベル - 1」上昇とし初期化
		}else if(defLv >= 2){

			levelUp(defLv - 1);

		}

	}

	// フィールドを一覧として表示
	@Override
	public String toString(){

		return "<フィールド確認> " +
				"character:" 	+ character 	+ " / " +
				"trainer:" 		+ trainer 		+ " / " +
				"name:" 		+ name 			+ " / " +
				"lv:" 			+ lv 			+ " / " +
				"hp:" 			+ hp 			+ " / " +
				"atk:" 			+ atk 			+ " / " +
				"def:" 			+ def 			+ " / " +
				"spd:" 			+ spd 			+ " / " +
				"hpMax:" 		+ hpMax 		+ " / " +
				"wazaNm:" 		+ wazaNm 		+ " / " +
				"wazaDmgRate:" 	+ wazaDmgRate 	+ " / " ;

	}

	// xレベル上昇（x+1レベルとなる）分ステータス上昇
	public void levelUp(int x) {

		this.lv 	+= 	x ;
		this.hpMax 	+= 	x * 30;
		this.atk 	+= 	x * 5 ;
		this.def 	+= 	x * 5 ;
		this.spd 	+= 	x * 5 ;
		this.hp 	= 	hpMax ;

	}

	public void setWaza(String Nm, String Rate) {

		if(Rate.matches("^[0-9]+\\.[0-9]$")) {

			this.wazaNm 		= Nm;
			this.wazaDmgRate 	= Rate;

		}else{

			System.out.println("[ERROR]わざの設定に失敗しました");

		}

	}

	public String getStatus() {

		return "[" + this.name + " " + "lv" + this.lv + " " + "HP" + this.hp + "/" + this.hpMax + "]" ;

	}

	public int useWaza(){

		BigDecimal 	wazaDmgRate 	= new BigDecimal(this.wazaDmgRate);
		BigDecimal 	calcDamage 	= BigDecimal.valueOf(this.atk).multiply(wazaDmgRate) ;
		int 		damage 		= calcDamage.intValue();
		return 	damage;

	}

	public int damaged(int damage) {

		BigDecimal def 		= BigDecimal.valueOf(this.def);
		BigDecimal num1 	= new BigDecimal("1");
		BigDecimal num2 	= new BigDecimal("120");
		BigDecimal dmg 		= BigDecimal.valueOf(damage);

		BigDecimal SubtractRate 	= num1.divide((num1.add(def.divide(num2, 2, RoundingMode.DOWN))), 2, RoundingMode.DOWN) ;			// ダメージ減算率の計算：1 / (1＋ぼうぎょ÷120)
		BigDecimal calcDamage 		= dmg.multiply(SubtractRate) ;																			// 実際に受けるダメージの計算：値渡しされたダメージ値×ダメージ減算率

		int realDamage = calcDamage.intValue();


		if(this.hp > realDamage) {

			this.hp = this.hp - realDamage;

		}else if(this.hp <= realDamage) {

			this.hp = 0;

		}

		return realDamage;
	}

}
