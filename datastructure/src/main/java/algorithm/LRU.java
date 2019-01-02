package algorithm;


import util.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Nova wangxingchen
 * @date 2018/12/27
 * LRU淘汰最近未使用
 */
public class LRU {
    private ListNode head;
    private ListNode tail;


    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        LRU.Node<K,V> next;

        Node(int hash, K key, V value, LRU.Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
    }

}
