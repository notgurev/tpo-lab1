package tpo.algorithm;

import lombok.Getter;

public class ClosedHashTable {
    private final int TABLE_SIZE;
    @Getter
    private HashEntity[] table;

    public ClosedHashTable(int size) {
        this.TABLE_SIZE = size;
        table = new HashEntity[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public HashEntity get(String value) {
        int hash = hash(value);
        while (table[hash] != null && !table[hash].getKey().equals(value)) {
            hash = (hash + 1) % 10;
        }
        if (table[hash] == null) {
            return null;
        } else {
         return table[hash];
        }
    }

    public int put(String value) {
        int hash = hash(value);
        while (table[hash] != null && !table[hash].getKey().equals(value)) {
            hash = (hash + 1) % 10;
        }
        table[hash] = new HashEntity(value);
        return hash;
    }

    public int hash(String value) {
        int sum = 0;
        for (int i = value.length() - 1; i >= 0; i--) {
            if (i != value.length()) {
                sum = sum << 4;
            }
            int currentSymbol = value.charAt(i);
            sum += currentSymbol;
        }
        return sum % TABLE_SIZE;
    }

}
