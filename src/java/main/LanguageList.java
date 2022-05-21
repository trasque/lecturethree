import java.util.ArrayList;
import java.util.List;

public class LanguageList implements ProgrammingElement {
  private List<String> lectureList = new ArrayList<>();

  public LanguageList() {
    this.lectureList.add("Java");
    this.lectureList.add("C");
    this.lectureList.add("Perl");
    this.lectureList.add("Ruby");
    this.lectureList.add("PHP");
    this.lectureList.add("Kotlin");
    this.lectureList.add("Japanese");
    this.lectureList.add("Go");
    this.lectureList.add("Dart");
    this.lectureList.add("Rust");
  }

  @Override
  public void outputList() {
    // ADD 挿入
    this.lectureList.add(4, "JavaScript");

    // REMOVE 削除
    this.lectureList.remove(7);

    for (String list : this.lectureList)
      System.out.print(list + " / ");
    System.out.println("");
  }
}
