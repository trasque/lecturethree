import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class AppController {
  private AppController() {}

  private static final int MAIN_MENU_EXIT = -1; // メインメニュー終了
  private static final int RE_EXECUTE = 1; // エラーハンドリング：再実行要請 数値以外や範囲外入力
  private static final String MENU_CONTROLL_INT = "menuControllInt"; // Scanner でメニュー番号を格納する
  private static final String ERROR_HANDLER = "errorHandler"; // エラー時の動作分岐を指示する値
  private static final String DO_CLOSE_SCANNER = "doCloseScanner"; // プログラム終了時に Scanner を閉じる指示をする

  public static int mainMenu() {
    Scanner menuControllScanner = new Scanner(System.in);
    Map<String, Integer> controllerStatus = new HashMap<>();
    controllerStatus.put(MENU_CONTROLL_INT, 0);
    controllerStatus.put(ERROR_HANDLER, 0);
    controllerStatus.put(DO_CLOSE_SCANNER, 1);
    int scannerInput = 0;

    do {
      controllerStatus.replace(MENU_CONTROLL_INT, 0);
      System.out.print(">> 1. List表示 / 2. Map表示 / 0. 終了 -> ");

      // 値のフィルタリングのために例外を利用するのは本来使途ではないという記事を見ました
      // 今回は練習のために文字を入力すると例外が出るようにしました
      try {
          scannerInput = menuControllScanner.nextInt();
      } catch (InputMismatchException e) {
        notIntWarningAndSetRestart(controllerStatus);
      }
      controllerStatus.replace(MENU_CONTROLL_INT, scannerInput);

      switch (controllerStatus.get(MENU_CONTROLL_INT)) {
        case 1 -> {
          displayList();
        }
        case 2 -> {
          displayMap();
        }
        case 0 -> {
          controllerStatus.replace(MENU_CONTROLL_INT, MAIN_MENU_EXIT);
        }
        default -> {
          outOfRangeWarningAndSetRestart(controllerStatus);
        }
      }
    } while (controllerStatus.get(MENU_CONTROLL_INT) != MAIN_MENU_EXIT);

    if (controllerStatus.get(DO_CLOSE_SCANNER) == 1)
      menuControllScanner.close();
    return controllerStatus.get(ERROR_HANDLER);
  }

  private static void displayList() {
    ProgrammingElement languages = new LanguageList();
    ProgrammingElement types = new TypeList();
    System.out.println("[プログラミング言語の種類]");
    languages.outputList();
    System.out.println("[プログラミング言語の型]");
    types.outputList();
  }

  private static void displayMap() {
    CatchCopyIndex commercial = new GameCommercial();
    CatchCopyIndex dialogue = new GameDialogue();
    System.out.println("\n[ゲームコマーシャルキャッチコピー]");
    commercial.outputMap();
    System.out.println("\n[ゲーム内セリフ]");
    dialogue.outputMap();
  }

  private static Map<String, Integer> notIntWarningAndSetRestart(Map<String, Integer> controller) {
    System.out.println(">> 半角数値で入力してください");
    controller.replace(MENU_CONTROLL_INT, MAIN_MENU_EXIT);
    controller.replace(ERROR_HANDLER, RE_EXECUTE);
    controller.replace(DO_CLOSE_SCANNER, 0);
    return controller;
  }

  private static Map<String, Integer> outOfRangeWarningAndSetRestart(Map<String, Integer> controller) {
    System.out.println(">> 1 ~ 2 の範囲で入力してください");
    controller.replace(MENU_CONTROLL_INT, MAIN_MENU_EXIT);
    controller.replace(ERROR_HANDLER, RE_EXECUTE);
    controller.replace(DO_CLOSE_SCANNER, 0);
    return controller;
  }
}
