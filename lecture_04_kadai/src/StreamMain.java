import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Map.Entry.comparingByValue;

public class StreamMain {
	public static void main(String[] args) {
		Map<String, String> memberList = new HashMap<>();
		memberList.put("山田太郎", "やまだたろう");
		memberList.put("佐藤二郎", "さとうじろう");
		memberList.put("田中三郎", "たなかさぶろう");
		memberList.put("鈴木四郎", "すずきしろう");
		memberList.put("齋藤五郎", "さいとうごろう");
		memberList.put("相川一朗", "あいかわいちろう");

		System.out.println("氏名は以下である。");
		memberList.entrySet().stream().sorted(comparingByValue()).map(e -> e.getKey() + "：" + e.getValue()).forEach(System.out::println);
		System.out.println("--------------------------------");

		System.out.println("在籍人数");
		int memberNumber = memberList.entrySet().size();
		System.out.println(memberNumber + "人");
		System.out.println("--------------------------------");

		System.out.println("出席番号１番の人");
		Optional<Map.Entry<String, String>> firstMember = memberList.entrySet().stream().min(comparingByValue());
		System.out.println(firstMember.get().getKey() + "：" + firstMember.get().getValue());
		System.out.println("--------------------------------");

		System.out.println("鈴木さんの在籍有無の確認");
		if (memberList.entrySet().stream().anyMatch(name -> name.getKey().contains("鈴木"))) {
			System.out.println("鈴木さんは在籍してます。");
		}
	}
}
