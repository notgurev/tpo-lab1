package tpo.algorithm;

import org.junit.jupiter.api.Test;
import tpo.algorithm.ClosedHashTable;
import tpo.algorithm.HashEntity;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void TestFirstInsert() {
        ClosedHashTable first = new ClosedHashTable(29);

        assertEquals(first.hash("45"), 1);
        assertNull(first.getTable()[1]);
        assertEquals(first.put("45"), 1);

        assertEquals(first.hash("12345"), 21);
        assertNull(first.getTable()[21]);
        assertEquals(first.put("12345"), 21);

        assertEquals(first.hash("frt"), 12);
        assertNull(first.getTable()[12]);
        assertEquals(first.put("frt"), 12);

        assertEquals(first.hash("hd4g"), 19);
        assertNull(first.getTable()[19]);
        assertEquals(first.put("hd4g"), 19);
    }

    @Test
    public void TestSecondInsert() {
        ClosedHashTable second = new ClosedHashTable(29);

        assertEquals(second.hash("45"), 1);
        assertNull(second.getTable()[1]);
        assertEquals(second.put("45"), 1);

        assertEquals(second.hash("awerf"), 1);
        assertNotNull(second.getTable()[1]);
        assertNull(second.getTable()[2]);
        assertEquals(second.put("awerf"), 2);

        assertEquals(second.hash("wdsf"), 2);
        assertNotNull(second.getTable()[2]);
        assertNull(second.getTable()[3]);
        assertEquals(second.put("wdsf"), 3);
    }

    @Test
    public void TestForthInsert() {
        ClosedHashTable third = new ClosedHashTable(29);

        assertEquals(third.hash("45"), 1);
        assertNull(third.getTable()[1]);
        assertEquals(third.put("45"), 1);

        assertEquals(third.hash("awerf"), 1);
        assertNotNull(third.getTable()[1]);
        assertNull(third.getTable()[2]);
        assertEquals(third.put("awerf"), 2);

        assertEquals(third.hash("wdsf"), 2);
        assertNotNull(third.getTable()[2]);
        assertNull(third.getTable()[3]);
        assertEquals(third.put("wdsf"), 3);

        assertEquals(third.hash("sdaf"), 1);
        assertNotNull(third.getTable()[1]);
        assertNotNull(third.getTable()[2]);
        assertNotNull(third.getTable()[3]);
        assertNull(third.getTable()[4]);
        assertEquals(third.put("sdaf"), 4);
    }

    @Test
    public void TestFirstFind() {
        ClosedHashTable forth = new ClosedHashTable(29);

        assertEquals(forth.hash("45"), 1);
        assertNull(forth.getTable()[1]);
        assertEquals(forth.put("45"), 1);

        assertEquals(forth.hash("frt"), 12);
        assertNull(forth.getTable()[12]);
        assertEquals(forth.put("frt"), 12);

        assertEquals(forth.hash("awerf"), 1);
        assertNotNull(forth.getTable()[1]);
        assertNull(forth.getTable()[2]);
        assertEquals(forth.put("awerf"), 2);

        assertEquals(forth.hash("wdsf"), 2);
        assertNotNull(forth.getTable()[2]);
        assertNull(forth.getTable()[3]);
        assertEquals(forth.put("wdsf"), 3);

        HashEntity r = forth.get("45");
        assertEquals(forth.get("45"), forth.getTable()[1]);
        assertEquals(forth.get("frt"), forth.getTable()[12]);
    }

    @Test
    public void TestSecondFind() {
        ClosedHashTable fifth = new ClosedHashTable(29);

        assertEquals(fifth.hash("45"), 1);
        assertNull(fifth.getTable()[1]);
        assertEquals(fifth.put("45"), 1);

        assertEquals(fifth.hash("awerf"), 1);
        assertNotNull(fifth.getTable()[1]);
        assertNull(fifth.getTable()[2]);
        assertEquals(fifth.put("awerf"), 2);

        assertEquals(fifth.hash("wdsf"), 2);
        assertNotNull(fifth.getTable()[2]);
        assertNull(fifth.getTable()[3]);
        assertEquals(fifth.put("wdsf"), 3);

        assertEquals(fifth.hash("awerf"), 1);
        assertNotEquals(fifth.get("awerf"), fifth.getTable()[1]);
        assertEquals(fifth.get("awerf"), fifth.getTable()[2]);
    }

}
