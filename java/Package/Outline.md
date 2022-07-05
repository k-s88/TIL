パッケージ  
    →複数のクラスをグループ化するためのもの  
    ・全てのJavaプログラムは何かしらのパッケージに属している  
  
ソースコードの先頭でパッケージ宣言する  
    →そのクラスが所属するパッケージを定義  
    package パッケージ名;  
  
パッケージは必ずパッケージ名と同じ名前のフォルダで管理  
    →パッケージ≒フォルダ  
  
CLASSPATH
    →環境変数の１つ  
      Java実行時のアクセス先としてPC上におけるJavaのクラスやパッケージの格納場所を管理  
  
無名のパッケージ  
    実行ファイルが存在するフォルダ（カレントディレクトリ）が自動的にパッケージとして扱われる
    ここに格納されているファイルはpackage宣言が不要  
  
パッケージとインポート  
    同パッケージ内であればインポート宣言無しで他のクラスを利用可能  
  
パッケージ名  
    クラスパス（環境変数の設定）からの相対パス  