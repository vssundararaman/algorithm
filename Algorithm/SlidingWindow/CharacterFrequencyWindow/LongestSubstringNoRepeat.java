package SlidingWindow.CharacterFrequencyWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepeat {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str)); // Output: 3
    }
	
	static int lengthOfLongestSubstring(String string) {
		Set<Character> set = new HashSet<>();
		int left = 0, maxLen = 0;
		
		for (int right = 0; right < string.length(); right++) {
		
			while(set.contains(string.charAt(right))) {
				set.remove(string.charAt(left++));
			}
		
			set.add(string.charAt(right));
			maxLen = Math.max(maxLen, right - left + 1);
		}
		
		return maxLen;
	}
}
