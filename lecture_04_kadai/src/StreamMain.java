import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StreamMain {
	public static void main(String[] args) {
		Map<String, String> memlerList = new HashMap<>();
		memlerList.put("山田太郎", "やまだたろう");
		memlerList.put("佐藤二郎", "さとうじろう");
		memlerList.put("田中三郎", "たなかさぶろう");
		memlerList.put("鈴木四郎", "すずきしろう");
		memlerList.put("齋藤五郎", "さいとうごろう");
		memlerList.put("相川一朗", "あいかわいちろう");

		System.out.println("氏名は以下である。");
		memlerList.entrySet().stream().sorted(java.util.Map.Entry.comparingByValue()).map(e -> e.getKey() + "：" + e.getValue()).forEach(System.out::println);
		System.out.println("--------------------------------");

		System.out.println("在籍人数");
		long memberNumber = memlerList.entrySet().size();
		System.out.println(memberNumber + "人");
		System.out.println("--------------------------------");

		System.out.println("出席番号１番の人");
		Optional<Map.Entry<String, String>> firstMember = memlerList.entrySet().stream().sorted(java.util.Map.Entry.comparingByValue()).findFirst();
		System.out.println(firstMember.get().getKey() + "：" + firstMember.get().getValue());
		System.out.println("--------------------------------");

		System.out.println("鈴木さんの在籍有無の確認");
		if (memlerList.entrySet().stream().anyMatch(name -> name.getKey().contains("鈴木"))) {
			System.out.println("鈴木さんは在籍してます。");
		}
	}
}
