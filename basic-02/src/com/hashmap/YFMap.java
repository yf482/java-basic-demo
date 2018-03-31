package com.hashmap;

public interface YFMap<K, V> {

    public V put(K k, V v);

    public V get(K k);

    public int size();

    public interface Entry<K, V> {
        public K getKey();

        public V getValue();
    }
}
