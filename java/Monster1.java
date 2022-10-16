package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Monster1 {

	String character;				// 種族
	String trainer;					// トレーナー
	String name;					// なまえ
	int lv = 1;						// レベル
	int hp = 80;					// HP
	int atk = 15;					// こうげき
	int def = 10;					// ぼうぎょ
	int spd = 10;					// すばやさ
	int hpMax = 80;					// HP初期値
	String wazaNm = "たいあたり" ;	// わざ（なまえ）
	String wazaDmgRate = "1.0" ;	// わざ（ダメージ倍率）

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
	void levelUp(int x) {

		this.lv 	+= 	x ;
		this.hpMax 	+= 	x * 30;
		this.atk 	+= 	x * 5 ;
		this.def 	+= 	x * 5 ;
		this.spd 	+= 	x * 5 ;
		this.hp 	= 	hpMax ;

	}

	void setWaza(String Nm, String Rate) {

		if(Rate.matches("^[0-9]+\\.[0-9]$")) {

			this.wazaNm 		= Nm;
			this.wazaDmgRate 	= Rate;

		}else{

			System.out.println("[ERROR]わざの設定に失敗しました");

		}

	}

	String getStatus() {

		return "[" + this.name + " " + "lv" + this.lv + " " + "HP" + this.hp + "/" + this.hpMax + "]" ;

	}

	int useWaza(){

		BigDecimal 	wazaDmgRate 	= new BigDecimal(this.wazaDmgRate);
		BigDecimal 	calcDamage 	= BigDecimal.valueOf(this.atk).multiply(wazaDmgRate) ;
		int 		damage 		= calcDamage.intValue();
		return 	damage;

	}

	int damaged(int damage) {

		BigDecimal def 		= BigDecimal.valueOf(this.def);
		BigDecimal num1 	= new BigDecimal("1");
		BigDecimal num2 	= new BigDecimal("120");
		BigDecimal dmg 		= BigDecimal.valueOf(damage);

		BigDecimal SubtractRate 	= num1.divide((num1.add(def.divide(num2, 2, RoundingMode.DOWN))), 2, RoundingMode.DOWN) ;				// ダメージ減算率の計算：1 / (1＋ぼうぎょ÷120)
		BigDecimal calcDamage 		= (dmg.multiply(SubtractRate)).setScale(0,RoundingMode.DOWN) ;																			// 実際に受けるダメージの計算：値渡しされたダメージ値×ダメージ減算率

		int realDamage = calcDamage.intValue();


		if(this.hp > realDamage) {

			this.hp = this.hp - realDamage;

		}else if(this.hp <= realDamage) {

			this.hp = 0;

		}

		return realDamage;
	}

}