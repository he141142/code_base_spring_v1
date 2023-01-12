package com.sykros.codebase.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Pair<K,V> implements IPair<K,V> {
    @Getter
    @Setter
    K key;

    @Getter
    @Setter
    V value;

    public Pair(K k,V v){
        this.key = k;
        this.value = v;
    }
    public Pair<K,V> Key(K key){
        this.key = key;
        return this;
    }

    public Pair<K,V> Value(V val){
        this.value = val;
        return this;
    }

}
