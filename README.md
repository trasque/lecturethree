# 課題3 Interface / List / Map / Exception

Interface, List, Map, Exception の練習プログラムです。

起動するとメインメニューが表示され、数値入力で機能を選びます。  
機能は以下の通りです。  

1. 共通するインターフェースを持つ異なる2つのクラスを使用して2つのリストを表示する。  
2. 共通するインターフェースを持つ異なる2つのクラスを使用して2つのマップを表示する。
3. プログラムを終了する。

## List / Map の作成と表示

2つのリスト

- `LanguageList` クラス / プログラミング言語の種類
- `TypeList` クラス / プログラミング言語の型  

を作成し、追加・削除等を行って一覧表示します。

また、2つのマップ

- `GameCommercial` クラス / ゲームコマーシャルのキャッチコピー
- `GameDialogue` クラス / ゲーム内のセリフ

を作成し、削除等を行って一覧表示します。

## Interface で共通メソッドにする

2つのリストは `ProgrammingElement` インターフェースで定義された共通のメソッド `outputList()` を持ちます。  
https://github.com/trasque/lecturethree/blob/439eaa8d36c3a3e41284aacea51de8a468e4fe07/src/java/main/ProgrammingElement.java#L1-L3

また、2つのマップは `CatchCopyIndex` インターフェースで定義された共通のメソッド `outputMap()` を持ちます。  
https://github.com/trasque/lecturethree/blob/439eaa8d36c3a3e41284aacea51de8a468e4fe07/src/java/main/CatchCopyIndex.java#L1-L3

## メニュー選択の数値入力で例外処理を行う

数値入力の値がおかしい場合は Exception を使用して例外表示を行い、メインメニューループをどのように外れるかを設定します。  

例外は2種類を検知しようとしています  
1. Scanner `nextInt()` に対する整数以外の入力 -> `nextInt()` に実装された `InputMismatchException`
2. 機能に使用する範囲の外の入力 -> Switch文の `default` で対応

https://github.com/trasque/lecturethree/blob/aa1928954a5b3282cd95690bd753fcb54d0e96cb/src/java/main/AppController.java#L27-L33

https://github.com/trasque/lecturethree/blob/aa1928954a5b3282cd95690bd753fcb54d0e96cb/src/java/main/AppController.java#L46-L48

どちらの例外でも以下の設定を行います  
この設定値は 3組で 1つの HashMap `controllerStatus` として保持し、値を変更して動作を制御します。
- メインメニューを終了するかどうか : MENU_CONTROLL_INT
- エラーハンドラクラスへどのような処理の指示を渡すか : ERROR_HANDLER
- Scanner `System.in` を `close()` するかどうか : DO_CLOSE_SCANNER

https://github.com/trasque/lecturethree/blob/439eaa8d36c3a3e41284aacea51de8a468e4fe07/src/java/main/AppController.java#L17-L20

上記の設定は、以下の動作を引き起こします。  
1. メインメニューから抜け出しメインメソッドへ戻るようループを抜け出します。  
2. その後、メインメソッドへの戻り値を利用し、エラーハンドラクラスへ値を渡します。  
3. この値を受けてエラーハンドラは（今回は 1パターンのみのハンドルですが）メインメニューを再実行するための値を返します。
4. エラーハンドラからの返り値を判定して、メインメニューを再実行します。

https://github.com/trasque/lecturethree/blob/aa1928954a5b3282cd95690bd753fcb54d0e96cb/src/java/main/AppController.java#L75-L89

メインメニューのループではなく、メインメソッドへ抜けている理由は、例外動作としてエラーハンドラを通るようにするためです。（今回はどちらにしても再実行なのであまり意味はありません）

# 動作例

## 起動直後

メインメニューとして以下の内容が出力され、入力待ちとなります。  
1 でリスト表示、2 でマップ表示, 0 でプログラムを終了します。  

```
>> 1. List表示 / 2. Map表示 / 0. 終了 -> 
```

## リスト表示

メインメニューで 1 を選択すると、以下の内容が表示され、メインメニューに戻ります。

```
[プログラミング言語の種類]
Java / C / Perl / Ruby / JavaScript / PHP / Kotlin / Go / Dart / Rust / 
[プログラミング言語の型]
char / int / float / double / long / boolean / List / Map / Set / Queue / Deque / 
```

## マップ表示

メインメニューで 2 を選択すると、以下の内容が表示され、メインメニューに戻ります。

```
[ゲームコマーシャルキャッチコピー]
MOTHER 2『大人も子供も、おねーさんも』
怒首領蜂『死ぬがよい』
NieR:Automata『命もないのに、殺し合う』
ファイナルファンタジーIII『「そこに隠し通路あるぞ」新聞を読みながら教えてくれた親父は、昔 光の戦士だった。』
STREET FIGHTER II『俺より強い奴に会いに行く』
UNDERTALE『誰も死ななくていいやさしいRPG』
METAL GEAR SOLID 3『任務は、最愛の人を殺すこと』
タクティクスオウガ『この混沌の時代に、無力であることは許されなかった』

[ゲーム内セリフ]
MOTHER 2『ハロー！そして…グッドバイ！』
怒首領蜂『死ぬがよい』
NieR:Automata『感情を持つことは禁止されている』
ファイナルファンタジーIII『ファファファ・・・しねいっ！！』
STREET FIGHTER II『くにへ かえるんだな おまえにも かぞくがいるだろう・・・』
UNDERTALE『アンタは「ケツイ」ってもんをもってるんだ』
METAL GEAR SOLID 3『そもそもお前はオートマティックに向いていない』
タクティクスオウガ『僕にその手を汚せというのか』
```

## 例外処理

### 負の数か、3以上を入力する

`>> 1 ~ 2 の範囲で入力してください` と表示され、メインメニューが再実行されます。  
このとき、メインメニュー本来のループではなく、 `mainMenu()` を抜け出しメインメソッドへと戻ります。  
メインメソッドへ戻る際、エラーハンドラ用の値を返します。  
メインメソッドでは正常終了でないと判断した場合、エラーハンドラを呼び出し、先の値を渡します。  
範囲外入力によるエラーは再実行を指示していることになります。

```
>> 1. List表示 / 2. Map表示 / 0. 終了 -> 5
>> 1 ~ 2 の範囲で入力してください
]] 再実行 [[
>> 1. List表示 / 2. Map表示 / 0. 終了 -> 
```

以下はメインメソッドでエラーハンドラを呼ぶ部分です。

https://github.com/trasque/lecturethree/blob/aa1928954a5b3282cd95690bd753fcb54d0e96cb/src/java/main/LectureThree.java#L2-L7

また、エラーハンドラに `1` を渡すと再実行を行うよう、`1` を返します。

https://github.com/trasque/lecturethree/blob/aa1928954a5b3282cd95690bd753fcb54d0e96cb/src/java/main/ErrorHandler.java#L4-L10

### 数値以外を入力する

`>> 半角数値で入力してください` と表示され、メインメニューが再実行される。
上記と同様に `mainMenu()` を抜け出し再実行のエラーハンドリングを行う。

```
>> 1. List表示 / 2. Map表示 / 0. 終了 -> z
>> 半角数値で入力してください
]] 再実行 [[
>> 1. List表示 / 2. Map表示 / 0. 終了 -> 
```

