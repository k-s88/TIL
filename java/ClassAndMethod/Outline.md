# クラス
- プログラム全体の設計図  
１つのJavaファイルには１つのクラスを定義  
クラスブロックは`class X{}`と定義  
  
# メソッド
- パーツ毎の設計図  
- 関数とも  
- 機能ごとに作成  
  
#### 記述例  
`static int sum(int num1 , int num2){`  
`int calcResult = num1 + num2 ;`  
`return calcResult ;`  
`int`が戻り値の型、`return X` が戻り値を返す文  
戻り値の型の部分に`void`を記述すると戻り値なし
  
- mainメソッドから始まりmainメソッドで終わる  
`publc static void main(String args[])`  
  
### メソッドの区別  
- メソッド名・引数の型・引数の数  
同名のメソッドでも「引数の型」「引数の数」が異なっていれば複数定義できる  
- オーバーロード  
  
### スコープ
- 変数の有効範囲  
- 変数宣言されたブロック内がその変数のスコープ  
ブロック内の処理が完了すると、そのブロックをスコープとする変数はメモリ上から消去される  
スコープ外からアクセスしてもその変数は存在しないものとして扱われる  

### ローカル変数
- メソッド内で定義される変数  
- 同スコープ内で同名の変数は定義できない  
別スコープであれば可能  
- 仮引数はその直後のブロック内に含まれる（メソッドブロック内がスコープ）  

#### 補遺
- メソッド呼び出し元の変数、呼び出し先の仮引数が入る変数、戻り値の変数は異なっていてよい
