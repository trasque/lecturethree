import java.util.HashMap;
import java.util.Map;

public class GameDialogue implements CatchCopyIndex {
  private Map<String, String> lectureMap = new HashMap<>();

  public GameDialogue() {
    this.lectureMap.put("METAL GEAR SOLID 3", "そもそもお前はオートマティックに向いていない");
    this.lectureMap.put("タクティクスオウガ", "僕にその手を汚せというのか");
    this.lectureMap.put("NieR:Automata", "感情を持つことは禁止されている");
    this.lectureMap.put("怒首領蜂", "死ぬがよい");
    this.lectureMap.put("トヨタ自動車", "Drive your dreams");
    this.lectureMap.put("MOTHER 2", "ハロー！そして…グッドバイ！");
    this.lectureMap.put("UNDERTALE", "アンタは「ケツイ」ってもんをもってるんだ");
    this.lectureMap.put("STREET FIGHTER II", "くにへ かえるんだな おまえにも かぞくがいるだろう・・・");
    this.lectureMap.put("ファイナルファンタジーIII", "ファファファ・・・しねいっ！！");
  }

  @Override
  public void outputMap() {
    // REMOVE 削除
    this.lectureMap.remove("トヨタ自動車");

    // キーの一覧を配列で取得
    Object[] keys = lectureMap.keySet().toArray();
    for (Object key : keys) {
      System.out.println(key + "『" + lectureMap.get(key) + "』");
    }
  }
}
