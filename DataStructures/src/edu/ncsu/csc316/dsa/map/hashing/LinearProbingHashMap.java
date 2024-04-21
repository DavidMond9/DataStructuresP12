package edu.ncsu.csc316.dsa.map.hashing;

import edu.ncsu.csc316.dsa.map.Map;

/**
 * The LinearProbingHashMap is implemented as a hash table that uses linear
 * probing for collision resolution.
 * 
 * The hash map uses a multiply-and-divide compression strategy for calculating
 * hash functions. The hash map ensures expected O(1) performance of
 * {@link Map#put}, {@link Map#get}, and {@link Map#remove}.
 * 
 * The hash table resizes if the load factor exceeds 0.5.
 * 
 * The LinearProbingHashMap class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author // Your Name Here 
 *
 * @param <K> the type of keys stored in the hash map
 * @param <V> the type of values associated with keys in the hash map
 */
public class LinearProbingHashMap<K, V> extends AbstractHashMap<K, V> {

    private TableEntry<K, V>[] table;
    private int size;

    /**
     * Constructs a new linear probing hash map that uses natural ordering of keys
     * when performing comparisons. The created hash table uses the
     * {@link AbstractHashMap#DEFAULT_CAPACITY}
     */
    public LinearProbingHashMap() {
        this(AbstractHashMap.DEFAULT_CAPACITY, false);
    }

    /**
     * Constructs a new linear probing hash map that uses natural ordering of keys
     * when performing comparisons. The created hash table is initialized to have
     * the provided capacity.
     * 
     * @param capacity the initial capacity of the hash table
     */
    public LinearProbingHashMap(int capacity) {
        this(capacity, false);
    }

    /**
     * FOR TESTING PURPOSES ONLY! Constructs a new linear probing hash map that uses
     * natural ordering of keys when performing comparisons. The created hash table
     * is initialized to have the provided capacity.
     * 
     * @param capacity  the initial capacity of the hash table
     * @param isTesting if true, the hash table uses a predictable series of random
     *                  values for deterministic and repeatable testing
     */
    public LinearProbingHashMap(int capacity, boolean isTesting) {
        super(capacity, isTesting);
        size = 0;
    }
    /**
     * FOR TESTING PURPOSES ONLY! Constructs a new linear probing hash map that uses
     * natural ordering of keys when performing comparisons. The created hash table
     * is initialized to have the provided capacity.
     * @param isTesting if true, the hash table uses a predictable series of random
     *                  values for deterministic and repeatable testing
     */
    public LinearProbingHashMap(boolean isTesting) {
    	this(AbstractHashMap.DEFAULT_CAPACITY, isTesting);
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        EntryCollection buffer = new EntryCollection();
        for(int h = 0; h < table.length; h++) {
        	if(!isAvailable(h)) {
        		buffer.add(table[h]);
        	}
        }
        return buffer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void createTable(int capacity) {
        table = (TableEntry<K, V>[]) new TableEntry[capacity];
        size = 0;
    }

    private boolean isAvailable(int index) {
        return (table[index] == null || table[index].isDeleted());
    }

    @Override
    public V bucketGet(int hash, K key) {
        int j = findBucket(hash, key);
        if(j < 0) {
        	return null;
        }
        return table[j].getValue();
    }

    @Override
    public V bucketPut(int hash, K key, V value) {
    	int j = findBucket(hash, key);
        if(j >= 0) {
        	V oldVal = table[j].getValue();
        	table[j].setValue(value);
        	return oldVal;
        }
        table[-(j + 1)] = new TableEntry<>(key, value);
        size++;
        return null;
    }

    private int findBucket(int index, K key) {
        int available = -1;
        int j = index;
        do {
        	if(isAvailable(j)) {
        		if(available == -1) {
        			available = j;
        		}
        		if(table[j] == null) {
        			return -(available + 1);
        		}
        	}
        	else if(table[j].getKey().equals(key)){
        		return j;
        	}
        	j = (j + 1) % table.length;
        } while (j != index);
        return -(available + 1);
    }

    @Override
    public V bucketRemove(int hash, K key) {
        int j = findBucket(hash, key);
        if(j < 0) {
        	return null;
        }
        V ans = table[j].getValue();
        table[j].setDeleted(true);
        size--;
        return ans;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected int capacity() {
        return table.length;
    }

    private static class TableEntry<K, V> extends MapEntry<K, V> {

        private boolean isDeleted;

        public TableEntry(K key, V value) {
            super(key, value);
            setDeleted(false);
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean deleted) {
            isDeleted = deleted;
        }
    }
}