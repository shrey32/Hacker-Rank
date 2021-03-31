package com.leetcode;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 
 * @author Shrey
 *
 */
public class TextJustification {

	public static void main(String[] args) {
		System.out.println(fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification" }, 16));
		System.out.println(fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" }, 16));
		System.out.println(fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough",
				"to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20));
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		int len = words.length;
		Map<String, int[]> map = new LinkedHashMap<>();
		StringBuilder sb = new StringBuilder();
		int start = -1;
		for (int i = 0; i < len; i++) {
			int newLength = words[i].length();
			int currLength = sb.length();
			if ((currLength + newLength) <= maxWidth) {
				sb.append(words[i] + " ");
				if (start < 0)
					start = i;
			} else {
				map.put(sb.toString().trim(), new int[] { start, i - 1 });
				sb = new StringBuilder(words[i]);
				if (sb.length() + 1 <= maxWidth)
					sb.append(" ");
				start = i;
			}
		}
		if (sb.length() > 0)
			map.put(sb.toString().trim(), new int[] { start, len - 1 });
		
		 //for(String key:map.keySet()){
		   //System.out.println(key+"=>"+Arrays.toString(map.get(key))); }
		 
		int total = map.size();
		List<String> merged = new ArrayList<>(total);
		for (String key : map.keySet()) {
			total--;
			int totalLength = key.length();
			int[] currIndx = map.get(key);
			int totalSpaceRequired = maxWidth - totalLength;
			int first = currIndx[0];
			int last = currIndx[1];
			int numberOfWords = (last - first) + 1;

			// even space
			StringBuilder str = new StringBuilder();
			if (total == 0) {
				for (int i = first; i <= last; i++) {
					str.append(words[i]);
					if (i < last)
						str.append(" ");
				}
				while (str.length() < maxWidth)
					str.append(" ");

			} else {
				int rem = totalSpaceRequired % numberOfWords;
                int spacePerWord = totalSpaceRequired;
                if(numberOfWords>1){
                    rem = totalSpaceRequired % (numberOfWords-1);
                    spacePerWord = totalSpaceRequired / (numberOfWords-1);
                }
				for (int i = first; i <= last; i++) {
					str.append(words[i]);
					if(rem > 0 && i < last){
                        str.append(" ");
                        rem--;
                    }
					if (i < last)
						str.append(" ");
					for (int j = 0; (j < spacePerWord) && (str.length() < maxWidth); j++) {
						str.append(" ");
					}
				}
			}
			merged.add(str.toString());
		}

		return merged;
	}

}
