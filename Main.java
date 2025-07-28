public class Main {
    public static void main(String[] args) throws InterruptedException {
        LRUCache<Integer, String> cache = new LRUCache<>(3, 5000); // 3 items max, 5 seconds expiry

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.displayCache(); // [3=Three] [2=Two] [1=One]

        cache.get(1); // access 1
        cache.displayCache(); // [1=One] [3=Three] [2=Two]

        cache.put(4, "Four"); // should evict key 2
        cache.displayCache(); // [4=Four] [1=One] [3=Three]

        Thread.sleep(6000); // wait for entries to expire

        System.out.println("Expired Get 3: " + cache.get(3)); // should return null
        cache.displayCache(); // Should not show key 3
    }
}
