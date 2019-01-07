package com.y.second;

public class Main2 {

    public static void main(String... args){
        Server.init();
        role1();
        role2();
        role3();
    }

    public static void role1(){
        LinkedList<Poker> list =  Server.handOut(1);
//        System.out.println(list.toString());
        sort(list);
        System.out.println(list.toString());
    }

    public static void role2(){
        LinkedList<Poker> list =  Server.handOut(2);
//        System.out.println(list.toString());
        sort(list);
        System.out.println(list.toString());
    }

    public static void role3(){
        LinkedList<Poker> list =  Server.handOut(3);
//        System.out.println(list.toString());
        sort(list);
        System.out.println(list.toString());
    }

    public static void sort(LinkedList<Poker> list){
        LinkedList<Poker>[] linkArr = new LinkedList[13];
        for (int i = 0; i < 13; i++) {
            linkArr[i] = new LinkedList<>();
        }

        for (int i = 0; i < list.size(); i++) {
            Poker poker = list.get(i);
            linkArr[poker.num - 1].add(poker);
        }

        list.clear();
        for (LinkedList l:linkArr) {
            list.addAll(l);
        }
    }
}
