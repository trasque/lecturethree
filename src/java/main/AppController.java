import java.util.InputMismatchException;
import java.util.Scanner;

public class AppController {
  private AppController() {
  }

  private static final int MAIN_MENU_EXIT = -1;               // メインメニュー終了
  private static final int INPUT_MISMATCH_EXCEPTION_INT = 1;  // 数字以外が入力された場合 一度メインメソッドへ抜けて再実行
  private static boolean doCloseScanner = true;               // プログラムを終了させる場合 scanner を閉じる

  public static int mainMenu() {
    Scanner menuControllScanner = new Scanner(System.in);
    int menuControllInt;
    int errorHandler = 0;

    do {
      menuControllInt = 0;
      System.out.print(">> 1. List表示 / 2. Map表示 / 0. 終了-> ");
      try {
        menuControllInt = menuControllScanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("半角数値で入力してください");
        menuControllInt = MAIN_MENU_EXIT;
        errorHandler = INPUT_MISMATCH_EXCEPTION_INT;
        doCloseScanner = false;
        continue;
      }

      switch (menuControllInt) {
        case 1 -> {
          System.out.println(1);
        }
        case 2 -> {
          System.out.println(2);
        }
        case 0 -> {
          menuControllInt = MAIN_MENU_EXIT;
        }
      }
    }
    while(menuControllInt != MAIN_MENU_EXIT);

    if (doCloseScanner) menuControllScanner.close();
    return errorHandler;
  }
}
