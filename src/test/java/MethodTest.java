import org.junit.Test;

import static org.junit.Assert.*;

public class MethodTest {
    @Test
    public void test_pushBack() {
        var list = new Method<Integer>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assertEquals(3, list.getSize());
        assertEquals(1, list.get(0).intValue());
    }

    @Test
    public void test_pushFront() {
        var list = new Method<Integer>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(3, list.getSize());
        assertEquals(3, list.get(0).intValue());
    }

    @Test
    public void test_popFront() {
        var list = new Method<Integer>();
        list.pushBack(1);
        list.pushBack(2);
        list.popFront();
        assertEquals(1, list.getSize());
        assertEquals(2, list.get(0).intValue());
    }

    @Test
    public void test_popBack() {
        var list = new Method<Integer>();
        list.pushBack(1);
        list.pushBack(2);
        list.popBack();
        assertEquals(1, list.getSize());
        assertEquals(1, list.get(0).intValue());
    }

    @Test
    public void test_delete() {
        var list = new Method<Integer>();
        list.pushBack(1);
        list.pushBack(2);
        list.delete(0);
        assertEquals(1, list.getSize());
        assertEquals(2, list.get(0).intValue());
    }

    @Test
    public void test_insert() {
        var list = new Method<Integer>();
        list.pushBack(1);
        list.pushBack(2);
        list.insert(0, 3);
        assertEquals(3, list.getSize());
        assertEquals(3, list.get(0).intValue());
    }
}