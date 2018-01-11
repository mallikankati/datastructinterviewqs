package ds.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentWords {

	// Given a non-empty list of words, return the k most frequent elements.

	// Your answer should be sorted by frequency from highest to lowest. If two
	// words have the same frequency, then the word with the lower alphabetical
	// order comes first.

	public static List<String> topKFrequent(String[] words, int k) {
		if (words == null || words.length <= 0) {
			return null;
		}
		Map<String, Integer> temp = new HashMap<>();
		for (String word : words) {
			temp.put(word, temp.getOrDefault(word, 0) + 1);
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(temp.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return o1.getValue() == o2.getValue() ? o1.getKey().compareTo(
						o2.getKey()) : o2.getValue() - o1.getValue();
			}
		});

		System.out.println(list + "");
		List<String> rlist = new ArrayList<>();
		int count = 0;
		for (Map.Entry<String, Integer> entry : list) {
			if (count < k) {
				rlist.add(entry.getKey());
				count++;
			} else {
				break;
			}
		}
		return rlist;
	}

	public static void main(String[] args) {
		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode",
				"i", "love", "coding" }, 2));
		System.out.println(topKFrequent(new String[] { "the", "day", "is",
				"sunny", "the", "the", "the", "sunny", "is", "is" }, 2));
	}
}
