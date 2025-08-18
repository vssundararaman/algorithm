package Strings;

import java.util.List;

public class PermutationOfStrings {
    public static void main(String[] args) {
        String str = "ABC";
        List<String> result = new java.util.ArrayList<>();
        permute("", str, result);
        System.out.println(result);
    }
	
	static void permute(String prefix, String remaining, List<String> result) {
		
		if (remaining.isEmpty()) {
			result.add(prefix);
			return;
		}
		
		for(int i=0; i< remaining.length(); i++) {
			permute(prefix + remaining.charAt(i), 
			remaining.substring(0,i) + remaining.substring(i+1),result);
		}		
	}
}
