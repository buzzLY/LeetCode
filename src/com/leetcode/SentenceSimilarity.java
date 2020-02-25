package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {

	public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
		if(words1 == null && words2 == null) return true;
		if(words1 == null || words2 == null) return false;
		if(words1.length != words2.length) return false;
		if(pairs == null || pairs.size() == 0) return true;
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		for (List<String> l : pairs) {
			map.putIfAbsent(l.get(0), new HashSet<String>());
			map.putIfAbsent(l.get(1), new HashSet<String>());
			map.get(l.get(0)).add(l.get(1));
			map.get(l.get(1)).add(l.get(0));
//			map.get(l.get(0)).add(l.get(0));
//			map.get(l.get(1)).add(l.get(1));
		}
		for(int i = 0; i < words1.length; ++i) {
			if(words1[i].equals(words2[i])) continue;
			if(!map.containsKey(words1[i])) return false;
			if(!map.get(words1[i]).contains(words2[i])) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
