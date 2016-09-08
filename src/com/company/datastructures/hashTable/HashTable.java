package com.company.datastructures.hashTable;

import java.util.LinkedList;

/**
 * Created by vnagpurkar on 6/21/16.
 */
public class HashTable<K, V> {

    private static int MAXSIZE = 1024;
    private LinkedList<HashEntry<K,V>>[] hashtable; // array of LinkedLists of HashEntry<K,V>

    public HashTable() {

        hashtable = (LinkedList<HashEntry<K,V>>[]) new LinkedList[MAXSIZE];
    }

    public void put(K key, V value) {

        LinkedList<HashEntry<K,V>> currentBucket = getBucket(key);
        HashEntry<K,V> newEntry = new HashEntry<K, V>(key, value);

        // if the entry with same key already exist in linkedlist,
        // that entry will be removed, so that new entry with the same key will be added back.
        if(currentBucket.contains(newEntry)) {
            currentBucket.remove(newEntry);
        }
        currentBucket.add(newEntry);
    }

    public V getValue(K key) {

        HashEntry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    public HashEntry<K,V> getEntry(K key) {

        LinkedList<HashEntry<K,V>> currentBucket = getBucket(key);
        for(HashEntry<K,V> entry : currentBucket) {

            if(entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private LinkedList<HashEntry<K,V>> getBucket(K key) {

        int currentBucketIndex = getBucketIndex(key);
        LinkedList<HashEntry<K,V>> currentBucket= hashtable[currentBucketIndex];
        return currentBucket;
    }

    private int getBucketIndex(K key) {

        int hashCode = String.valueOf(key).hashCode();
        int bucketIndex = hashCode % MAXSIZE;

        return bucketIndex;
    }
}

class HashEntry<K,V> {

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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (this == null || this.getClass() != o.getClass()) return false;

        HashEntry<K, V> second = (HashEntry<K, V>) o;

        if (this.key != null && this.key.equals(second.getKey())) {

            if (this.value != null && this.value.equals(second.getValue())) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {

        int result = this.key != null ? this.key.hashCode() : 0;
        result = 31*result + (this.value != null ? this.value.hashCode() : 0);
        return result;
    }


}
