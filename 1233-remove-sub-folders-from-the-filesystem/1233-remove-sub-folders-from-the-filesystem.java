class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = Arrays.asList(folder);
        Collections.sort(list);
        List<String> res = new ArrayList<>();

        for(String word : list){
            boolean flag = true;
            for(String it : res){
                if(word.startsWith(it + '/')){
                    flag = false;
                    break;
                }
            }
            if(flag) res.add(word);
        }
        return res;

    }
}