class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int cnt = 0;
        for(String s : arr){
            for(int i = 0; i < brokenLetters.length(); i++){
                if(s.indexOf(brokenLetters.charAt(i)) != -1){
                    cnt++;
                    break;
                }
            }
        }
        return arr.length - cnt;
    }
}