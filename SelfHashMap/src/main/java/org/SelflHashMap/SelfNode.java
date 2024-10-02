package org.SelflHashMap;

public class SelfNode<K, T> {
    K key;
    T value;
    SelfNode<K,T> Next=null;

    public SelfNode(K key, T value) {
        this.key = key;
        this.value = value;
    }


}
