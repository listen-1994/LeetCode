package LRU;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache<T> {
    private HashMap<T, LinkNode<T>> map;
    private LinkList<T> linkList;
    private int maxSize;

    public LRUCache(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        linkList = new LinkList<>();
        map = new HashMap<>(size);
        this.maxSize = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void put(T element) {
        if (map.keySet().contains(element)) {
            LinkNode<T> c = map.get(element);
            if (linkList.head.next == c) {
                return;
            }
            c.pre.next = c.next;
            if (c.next != null) {
                c.next.pre = c.pre;
            }
            if (linkList.tail == c) {
                linkList.tail = c.pre;
            }
            insertAfterHead(c);
            return;
        }
        if (linkList.size < maxSize) {
            LinkNode<T> c = new LinkNode<>(element);
            if (linkList.head == linkList.tail) {
                linkList.tail = c;
            }
            insertAfterHead(c);
            linkList.size++;
            map.put(element, c);
            return;
        }
        LinkNode<T> c = new LinkNode<>(element);
        insertAfterHead(c);
        map.remove(linkList.tail.getElement());
        linkList.tail.pre.next = null;
        linkList.tail = linkList.tail.pre;
    }

    private void insertAfterHead(LinkNode<T> c) {
        c.next = linkList.head.next;
        if (null!=linkList.head.next){
            linkList.head.next.pre = c;
        }

        linkList.head.next = c;
        c.pre = linkList.head;
    }

    class LinkList<T> {
        LinkNode<T> head;
        LinkNode<T> tail;
        int size;

        LinkList() {
            head = new LinkNode<>(null);
            size = 0;
            tail = head;
        }
    }

    class LinkNode<T> {
        Object element;
        LinkNode<T> pre;
        LinkNode<T> next;

        LinkNode(T element) {
            this.element = element;
        }

        @SuppressWarnings("unchecked")
        T getElement() {
            return (T) element;
        }
    }

    @Override
    public String toString() {
        LinkNode<T> p = linkList.head;
        StringBuilder sb = new StringBuilder();
        while (p.next != null) {
            p = p.next;
            sb.append(p.getElement().toString()+"->");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache<String> lruCache = new LRUCache<>(10);
        lruCache.put("000");
        System.out.println(lruCache.toString());
        lruCache.put("111");
        System.out.println(lruCache.toString());
        lruCache.put("222");
        System.out.println(lruCache.toString());
        lruCache.put("333");
        System.out.println(lruCache.toString());
        lruCache.put("444");
        System.out.println(lruCache.toString());
        lruCache.put("555");
        System.out.println(lruCache.toString());
        lruCache.put("666");
        System.out.println(lruCache.toString());
        lruCache.put("777");
        System.out.println(lruCache.toString());
        lruCache.put("888");
        System.out.println(lruCache.toString());
        lruCache.put("999");
        System.out.println(lruCache.toString());
        lruCache.put("000");
        System.out.println(lruCache.toString());
        lruCache.put("123123");
        System.out.println(lruCache.toString());
    }
}
