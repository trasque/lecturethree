public class ErrorHandler {
  private ErrorHandler() {
  }

  public static int errorCommand(int command) {
    switch(command) {
      // Scanner 失敗時：INTにINT以外が入力された
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
