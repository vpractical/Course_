package com.y.linked;

public class LinkedList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
    }


    public void add(E it) {
        Node<E> node = new Node<>(last, it, null);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = node;
        }
        size++;
    }

    public void add(int index,E it){
        //找到第index位置的节点，修改前驱后继引用,不写了
    }

    public void addAll(LinkedList<E> list) {
        if (list == null || list.size == 0) return;

        list.first.prev = last;
        if (last != null) {
            last.next = list.first;
        }else{
            first = list.first;
        }
        last = list.last;
        size += list.size;
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }

        Node<E> node = node(index);
        return unLink(node);
    }

    public E removeFirst(){
        Node<E> node = first;
        first = first.next;
        if(first != null){
            first.prev = null;
        }
        node.next = null;
        E it = node.it;
        node.it = null;
        size--;
        return it;
    }

    public E getFirst(){
        return first == null ? null : first.it;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }

        return node(index).it;
    }

    public int size() {
        return size;
    }

    private E unLink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        E it = node.it;
        node.it = null;
        size--;
        return it;
    }

    private Node<E> node(int index) {
        Node<E> it = null;
        try {
            if (index <= size >> 1) {
                it = first;
                while (--index >= 0) {
                    it = it.next;
                }
            } else {
                index = size - index - 1;
                it = last;
                while (--index >= 0) {
                    it = it.prev;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return it;
    }

    public void clear() {
        if (first == null) return;
        Node<E> next;
        while (first.next != null) {
            first.prev = null;
            first.it = null;
            next = first.next;
            first.next = null;
            first = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    private static class Node<E> {
        E it;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E it, Node<E> next) {
            this.it = it;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node<E> node = first;
        while (node != null){
            sb.append(node.it.toString());
            node = node.next;
        }

        return sb.toString();
    }
}
