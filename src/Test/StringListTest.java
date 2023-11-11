package Test;

import Algorithms.ArrayList;
import Algorithms.StringList;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertThrows;

public class StringListTest {
    private StringList stringList;

    @Before
    public void setUp() {
        stringList = new ArrayList(12);
    }

    @Test
    public void testAdd() {

        String item = "Examination";
        String result = stringList.add(item);
        assertEquals(item, result);
    }

    @Test
    public void testAddAtIndex() {

        String item = "Examination";
        int index = 0;
        String result = stringList.add(index, item);
        assertEquals(item, result);
    }
    @Test
    public void addByIndex_IndexOutOfBoundsException() {

        setupInit();
        stringList.add(1, "П");
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(13, "А"));

    }
    @Test
    public void testSet() {

        setupInit();
        String item = "А";
        int index = 2;
        String result = stringList.set(index, item);
        assertEquals(item, result);
    }

    @Test
    public void testRemove() {

        setupInit();
        String item = "А";
        String result = stringList.remove(item);
        assertEquals(result, item);
    }

    @Test
    public void testRemoveAtIndex() {

        setupInit();
        int index = 1;
        String result = stringList.remove(index);
        assertEquals(result, "А");
    }

    @Test
    public void testContains() {

        setupInit();
        String item = "А";
        boolean result = stringList.contains(item);
        assertTrue(result);
    }

    @Test
    public void testIndexOf() {

        setupInit();
        String item = "А";
        int result = stringList.indexOf(item);
        assertTrue(result >= 0);
        assertEquals(stringList.indexOf("А"), -1);
    }

    @Test
    public void testLastIndexOf() {

        setupInit();
        String item = "А";
        int result = stringList.lastIndexOf(item);
        assertTrue(result >= 0);
        assertEquals(stringList.indexOf("."), -1);
    }

    @Test
    public void testGet() {

        setupInit();
        int index = 0;
        String item = "А";
        String result = stringList.get(index);
        assertNotNull(result);
        assertEquals(result, item);
    }

    @Test
    public void testEquals() {

        StringList otherList = new ArrayList(12);
        boolean result = stringList.equals(otherList);
        assertTrue(result);
    }

    @Test
    public void testSize() {

        int result = stringList.size();
        assertEquals(0, result);
    }

    @Test
    public void testIsEmpty() {

        boolean result = stringList.isEmpty();
        assertTrue(result);
    }

    @Test
    public void testClear() {

        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testToArray() {

        String[] result = stringList.toArray();
        assertNotNull(result);
    }

    private void setupInit() {
        stringList.add("П");
        stringList.add("р");
        stringList.add("о");
        stringList.add("в");
        stringList.add("е");
        stringList.add("р");
        stringList.add("к");
        stringList.add("а");
        stringList.add(".");

    }
}
