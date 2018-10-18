package site.jvbo.fun.common.util.map;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K, V> {

    private Map<K, V> map;

    public MapBuilder(Map<K, V> map) {
        this.map = map;
    }

    public MapBuilder() {
        this.map = new HashMap<K, V>();
    }

    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<? extends K, ? extends V> other) {
        map.putAll(other);
        return this;
    }

    public Map<K, V> build() {
        return map;
    }

    public Map<K, V> asUnmodifiableMap() {
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> MapBuilder<K, V> of(K key, V value){
        return new MapBuilder<K, V>().put(key, value);
    }

    public static <K extends Enum<K>, V> MapBuilder<K, V> fromEnum(Class<K> klass) {
        return new MapBuilder<K, V>(new EnumMap<K, V>(klass));
    }
}
