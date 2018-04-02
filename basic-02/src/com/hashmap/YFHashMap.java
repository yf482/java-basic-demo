package com.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunfeng
 * @version V.1.0
 * @title
 * @Desc
 * @create 2018-03-31 15:42
 **/
public class YFHashMap<K, V> implements YFMap<K, V> {

    private static int defaultLength = 16;
    private static double defaultLoader = 0.75;

    private Entry<K, V>[] table = null;

    private int size = 0;

    YFHashMap(int length, double loader) {
        defaultLength = length;
        defaultLoader = loader;
        table = new Entry[defaultLength];

    }

    YFHashMap() {
        this(defaultLength, defaultLoader);
    }

    public int getSize() {
        return size;
    }

    @Override
    public V put(K k, V v) {

        if (size >= defaultLength * defaultLoader) {
            updateSize();
        }

        int index = getIndex(k);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = newEntry(k, v, null);
            size++;
        } else {
            table[index] = new Entry<>(k, v, entry);
            size++;
        }
        return table[index].getValue();
    }

    /**
     * 扩容
     */
    private void updateSize() {
        Entry<K, V>[] newTable = new Entry[2 * defaultLength];
        againHash(newTable);
    }

    /**
     * @param newTable
     */
    private void againHash(Entry<K, V>[] newTable) {
        //先找到所有添加的entry
        List<Entry<K, V>> list = new ArrayList<Entry<K, V>>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            findEntryByNext(table[i], list);
        }
        //重新进行扩容处理
        if (list.size() > 0) {
            size = 0;
            defaultLength = defaultLength * 2;
            table = newTable;
            for (Entry<K, V> entry : list) {
                if (entry.next != null) {
                    entry.next = null;
                }
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void findEntryByNext(Entry<K, V> kvEntry, List<Entry<K, V>> list) {
        if (kvEntry != null && kvEntry.next != null) {
            list.add(kvEntry);
            findEntryByNext(kvEntry.next, list);
        } else {
            list.add(kvEntry);
        }

    }


    private V findValueByEqualKey(K k, Entry<K, V> entry) {
        if (k == entry.getKey() || k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            if (entry.getNext() != null) {
                return findValueByEqualKey(k, entry.getNext());
            }
        }
        return null;
    }


    private Entry<K, V> newEntry(K k, V v, Entry<K, V> next) {
        return new Entry<K, V>(k, v, next);

    }

    //根据key递归查找value
    @Override
    public V get(K k) {
        int index = getIndex(k);
        if (table[index] == null) {
            return null;

        }
        return findValueByEqualKey(k, table[index]);
    }

    @Override
    public int size() {
        return 0;
    }

    private int getIndex(K k) {
        int m = defaultLength;
        int index = k.hashCode() % m;
        return index >= 0 ? index : -index;
    }


    class Entry<K, V> implements YFMap.Entry<K, V> {

        private K k;

        private V v;

        private Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }
}
