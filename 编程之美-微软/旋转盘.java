class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if(dead.contains(start)) return -1;
        queue.add(start);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                String cur = queue.poll();
                if(target.equals(cur)) return step;
                List<String> next = getNext(cur);
                for(String s:next) {
                    if(!dead.contains(s) && !visited.contains(s)) {
                        visited.add(s);
                        queue.add(s);
                    }
                }
                size--;
            }
            step++;
        }
        return -1;
    }

    private List<String> getNext(String cur) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            StringBuilder curSb= new StringBuilder(cur);
            curSb.setCharAt(i,cur.charAt(i)=='0'?'9':(char)(cur.charAt(i)-1));
            list.add(curSb.toString());
            curSb.setCharAt(i,(char)cur.charAt(i)=='9'?'0':(char)(cur.charAt(i)+1));
            list.add(curSb.toString());
        }
        return list;
    }
}