package tpo.algorithm;

import lombok.Data;

@Data
public class HashEntity {
    String key;

    public HashEntity(String key) {
        this.key = key;
    }
}
