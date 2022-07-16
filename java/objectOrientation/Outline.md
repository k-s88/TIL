オブジェクト指向  
→「ある役割を持ったモノ」ごとにクラスを分割し、  
  モノとモノの関係性を定義していくことで  
  システムを作り上げようとするシステム構成の考え方  
  クラスをモノ（object）として扱う  
  
メリット  
分担した開発が容易  
読みやすい・わかりやすい・テストが楽  
再利用可  
使うクラスのみインスタンス化することでメモリ節約・高速化  
管理・特定がしやすい  
修正が必要な部分が絞れる（高いメンテナンス性）  
  
モノがもつ情報  
「機能」→メソッド  
「属性」→フィールド（変数）  
  
フィールド  
→クラスブロック直下で宣言された変数  
  
メンバ  
→メソッド+フィールド  
  
インスタンス化  
→「実体化」  
  クラスは設計図  
  実際に動く状態（インスタンス）にする  
  
Stringクラスは特別なインスタンス化  
本来なら  
`String X = new String(QWERTY);`  
となるところ、  
`String X = QWERTY;`  
で済むようになっている（擬似プリミティブ）  