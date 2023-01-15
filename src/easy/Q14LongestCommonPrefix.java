package easy;

public class Q14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int tail = 1;
        String longestPrefix = "";
        while (tail <= strs[0].length()){
            String currentPrefix = strs[0].substring(0, tail);
            boolean isCommon = true;
            for (int i = 1; i< strs.length; i++){
                if (!strs[i].startsWith(currentPrefix)){
                    isCommon = false;
                    break;
                }
            }
            if (isCommon){
                tail++;
                longestPrefix = currentPrefix.length() > longestPrefix.length()? currentPrefix: longestPrefix;
            }else{
                return longestPrefix;
            }
        }
        return longestPrefix;
    }

    // this find common substring
    public static String longestCommonPrefixWrong(String[] strs) {
        if (strs.length == 1) return strs[0];
        int head = 0;
        int tail = 1;
        String longestPrefix = "";
        while (head < strs[0].length() && tail <= strs[0].length()){
            String currentPrefix = strs[0].substring(head, tail);
            System.out.println(currentPrefix + "," + longestPrefix);
            boolean isCommon = true;
            for (int i = 1; i< strs.length; i++){
                if (!strs[i].contains(currentPrefix)){
                    isCommon = false;
                    break;
                }
            }
            if (isCommon){
                longestPrefix = currentPrefix.length() > longestPrefix.length() ? currentPrefix : longestPrefix;
                tail++;
            }
            else{
                head++;
                tail = head +1;
            }
        }
        return longestPrefix;
    }
}
