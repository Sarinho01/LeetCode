package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> charactersSet = new HashMap<>();
        int max = 0;
        int actual = 0;
        for (int i = 0; i < s.length() ; i++) {
            if(!charactersSet.containsKey(s.charAt(i))){
                charactersSet.put(s.charAt(i), i);
                actual++;
            }
            else{
                max = Math.max(max, actual);
                actual = 0;
                i = charactersSet.get(s.charAt(i));
                charactersSet.clear();
            }
        }
        max = Math.max(max, actual);
        return max;
    }




}
