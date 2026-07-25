class UndergroundSystem {

    Map<Integer, String> s = new HashMap<>();
    Map<Integer, Integer> t = new HashMap<>();
    Map<String, int[]> m = new HashMap<>();

    public UndergroundSystem() {}

    public void checkIn(int id, String station, int time) {
        s.put(id, station);
        t.put(id, time);
    }

    public void checkOut(int id, String station, int time) {
        String key = s.get(id) + "-" + station;

        m.putIfAbsent(key, new int[2]);
        m.get(key)[0] += time - t.get(id);
        m.get(key)[1]++;

        s.remove(id);
        t.remove(id);
    }

    public double getAverageTime(String start, String end) {
        int[] a = m.get(start + "-" + end);
        return (double) a[0] / a[1];
    }
}
 