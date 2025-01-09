package Library;
// source: https://atcoder.jp/contests/abc212/submissions/58892054

class TreeMultiSet<T> {
    private final java.util.TreeMap<T, Integer> map;
    private int size;

    public TreeMultiSet() {
        map = new java.util.TreeMap<>();
        size = 0;
    }

    public TreeMultiSet(boolean reverse) {
        map = new java.util.TreeMap<>(reverse ? java.util.Collections.reverseOrder() : null);
        size = 0;
    }

    public void clear() {
        map.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T key) {
        return map.containsKey(key);
    }

    public int count(T key) {
        return map.getOrDefault(key, 0);
    }

    public void add(T key) {
        int x = map.getOrDefault(key, 0);
        x++;
        map.put(key, x);
        size++;
    }

    public void remove(T key) {
        int x = map.getOrDefault(key, 0);
        if (x == 0) return;

        if (x == 1) {
            map.remove(key);
        } else {
            map.put(key, x - 1);
        }
        size--;
    }

    public T first() {
        return map.firstKey();
    }

    public T last() {
        return map.lastKey();
    }

    public T pollFirst() {
        T key = first();
        remove(key);
        return key;
    }

    public T pollLast() {
        T key = last();
        remove(key);
        return key;
    }

}