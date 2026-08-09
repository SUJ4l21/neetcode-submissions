class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i =0 ;i<strs.length;i++){
            int arr [] = new int[26];
            for(int j =0 ; j<strs[i].length();j++){
                arr[strs[i].charAt(j) - 'a']++;
            }
            String str =Arrays.toString(arr);
            if(map.containsKey(str)){
                map.get(str).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str,list);
            }
        }
        return new ArrayList<>(map.values());
        
    }
}
