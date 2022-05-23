public class LectureThree {
  public static void main(String[] args) {
    int errorHandler = 0;
    do {
      errorHandler = AppController.mainMenu();
      ErrorHandler.errorCommand(errorHandler);
    } while (errorHandler != 0);
  }
}
