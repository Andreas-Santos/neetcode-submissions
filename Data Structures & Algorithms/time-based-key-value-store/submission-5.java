class TimeMap {
    Map<String, List<Entry>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {

        List<Entry> list = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = list.size() - 1;

        String result = "";
        while(left <= right) {
            
            int mid = left + (right - left) / 2;
            Entry entry = list.get(mid);

            if(entry.getTimestamp() <= timestamp) {
                result = entry.getValue();
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }   

        return result;
    }
}

class Entry {
    private int timestamp;
    private String value;

    public Entry(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public String getValue() {
        return this.value;
    }
}
