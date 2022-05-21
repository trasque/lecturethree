public class ErrorHandler {
  private ErrorHandler() {}

  public static int errorCommand(int command) {
    switch (command) {
      // エラーハンドリング1 : 再実行要請
      case 1 -> {
        System.out.println("]] 再実行 [[");
        return 1;
      }
      // その他エラー：プログラム終了とする
      default -> {
        return 0;
      }
    }
  }

}
