### 変数の命名規則
- 英文字、数字、アンダーバーが使用可
- 頭を数字にすることはできない
- 英文字の大文字と小文字は別の文字として扱われる
- 規定されている予約語は使えない  
### キャスト
ある変数に異なる型の値を入れる際の変換  
- 暗黙  
ex)  
`short num1 = 1000;`  
`long num2;`  
`num2 = num1;`  
→より上位の型へキャストする場合、単純に代入してよい  
- 明示的  
ex)  
`int a;`  
`double b;`  
`a = b;`  
→警告が表示される（下位の型へキャストすると数値が溢れる）  
→そこで「明示的に」キャストする  
`int a;`  
`double b;`  
`a = (int)b;`  
→警告は出ない（問題がないわけではないため、検証が必要）  
