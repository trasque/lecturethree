import java.util.ArrayList;
import java.util.List;

public class TypeList implements ProgrammingElement {
  private List<String> lectureList = new ArrayList<>();

  public TypeList() {
    this.lectureList.add("char");
    this.lectureList.add("int");
    this.lectureList.add("float");
    this.lectureList.add("double");
    this.lectureList.add("long");
    this.lectureList.add("boolean");
    this.lectureList.add("List");
    this.lectureList.add("Set");
    this.lectureList.add("Queue");
    this.lectureList.add("Deque");
  }

  @Override
  public void outputList() {
    // ADD 挿入
    this.lectureList.add(7, "Map");

    for (String list : this.lectureList)
      System.out.print(list + " / ");
    System.out.println("");
  }
}
