class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length();
        int i = 0;
        String s = "";
        ArrayList<String> arr = new ArrayList<>();
        while (i < n) {
            if (sentence.charAt(i) == ' ') {
                arr.add(s);
                s = "";
            } else {
                s += sentence.charAt(i);
            }
            i++;
        }
        arr.add(s);
        int m = searchWord.length();
        for (int j = 0; j < arr.size(); j++) {
            if (arr.get(j).startsWith(searchWord)) {
                return j + 1;
            }
        }
        return -1;
    }
}
