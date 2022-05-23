import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameCommercial implements CatchCopyIndex {
  private Map<String, String> lectureMap = new HashMap<>();

  public GameCommercial() {
    this.lectureMap.put("METAL GEAR SOLID 3", "任務は、最愛の人を殺すこと");
    this.lectureMap.put("タクティクスオウガ", "この混沌の時代に、無力であることは許されなかった");
    this.lectureMap.put("NieR:Automata", "命もないのに、殺し合う");
    this.lectureMap.put("怒首領蜂", "死ぬがよい");
    this.lectureMap.put("三菱自動車工業", "Heart-Beat Motors");
    this.lectureMap.put("MOTHER 2", "大人も子供も、おねーさんも");
    this.lectureMap.put("UNDERTALE", "誰も死ななくていいやさしいRPG");
    this.lectureMap.put("STREET FIGHTER II", "俺より強い奴に会いに行く");
    this.lectureMap.put("ファイナルファンタジーIII", "「そこに隠し通路あるぞ」新聞を読みながら教えてくれた親父は、昔 光の戦士だった。");
  }

  @Override
  public void outputMap() {
    // REMOVE 削除
    this.lectureMap.remove("三菱自動車工業");

    // キーの一覧を配列で取得
    lectureMap.forEach((key, value) -> System.out.println(key + "『" + value + "』"));
  }
}
