class TimeMap {

    Map<String, List<Entry>> timeMap;

    public TimeMap() {
        
        timeMap = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }

        timeMap.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";

        List<Entry> list = timeMap.get(key);
        String result = "";

        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            Entry entry = list.get(mid);

            if(entry.timestamp == timestamp) {
                return entry.value;
            }

            if(entry.timestamp < timestamp) {
                left = mid + 1;
                result = entry.value;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }
}

class Entry {

    int timestamp;
    String value;
    
    public Entry(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
