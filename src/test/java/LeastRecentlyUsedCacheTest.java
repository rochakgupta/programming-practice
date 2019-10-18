import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class LeastRecentlyUsedCacheTest {

    private static final Logger log = Logger.getLogger(LeastRecentlyUsedCacheTest.class);

    private static final Gson gson = new GsonBuilder().serializeNulls()
                                                      .create();

    @Test
    public void test1() {
        LeastRecentlyUsedCache cache = new LeastRecentlyUsedCache(2);
        put(cache, 1, 1);
        put(cache, 2, 2);
        Assert.assertEquals(1, get(cache, 1));      // returns 1
        put(cache, 3, 3);                           // evicts key 2
        Assert.assertEquals(-1, get(cache, 2));     // returns -1 (not found)
        put(cache, 4, 4);                           // evicts key 1
        Assert.assertEquals(-1, get(cache, 1));     // returns -1 (not found)
        Assert.assertEquals(3, get(cache, 3));      // returns 3
        Assert.assertEquals(4, get(cache, 4));      // returns 4
    }

    @Test
    public void test2() {
        LeastRecentlyUsedCache cache = new LeastRecentlyUsedCache(2);
        put(cache, 2, 1);
        put(cache, 3, 2);
        Assert.assertEquals(2, get(cache, 3));      // returns 2
        Assert.assertEquals(1, get(cache, 2));      // returns 1
        put(cache, 4, 3);                           // evicts key 3
        Assert.assertEquals(1, get(cache, 2));      // returns 1
        Assert.assertEquals(-1, get(cache, 3));     // returns -1 (not found)
        Assert.assertEquals(3, get(cache, 4));      // returns 3
    }

    private int get(LeastRecentlyUsedCache cache, int key) {
        int value = cache.get(key);
        log.debug(String.format("Get(%d) => %d", key, value));
        log.debug(gson.toJson(cache.getCache()));
        return value;
    }

    private void put(LeastRecentlyUsedCache cache, int key, int value) {
        cache.put(key, value);
        log.debug(String.format("Put(%d, %d)", key, value));
        log.debug(gson.toJson(cache.getCache()));
    }
}