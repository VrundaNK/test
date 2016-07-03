package com.company.datastructures.hashTable;

/**
 * Created by vnagpurkar on 6/21/16.
 */
public class HashTable<K, V> {

    static final int MAXSIZE = 1024;
    HashEntry<K, V>[][] hashtable;

    public HashTable() {

        hashtable = new HashEntry[MAXSIZE][100];
    }

    public void put(K key, V value) {

        HashEntry<K, V> current = new HashEntry<K, V>(key, value);
        HashEntry[] currentBucket = getBucket(key);

        int position = 0;
        while (position < currentBucket.length) {
            if (currentBucket[position] != null) {
                currentBucket[position] = current;
                break;
            }
            position++;
        }
    }

    public V getValue(K key) {

        HashEntry[] currentBucket = getBucket(key);
        if(currentBucket == null) return null;

        int position = 0;
        while (position < currentBucket.length) {
            if (currentBucket[position] != null) {
                HashEntry current = currentBucket[position];
                if(current.getKey().equals(key)) {
                    return (V) current.getValue();
                }
            }
            position++;
        }
        return null;
    }

    public HashEntry getEntry(K key) {

        HashEntry[] currentBucket = getBucket(key);
        if(currentBucket == null) return null;

        for(HashEntry current: currentBucket) {
            if(current.getKey().equals(key)) {
                return current;
            }
        }
        return null;
    }

    private HashEntry[] getBucket(K key) {

        int hashCode = String.valueOf(key).hashCode();
        int bucket = hashCode % MAXSIZE;
        return hashtable[bucket];
    }
}

class HashEntry<K, V> {

    private K key;
    private V value;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }


}

