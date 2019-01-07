package com.y.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 三带二服务器
 */
public class Server {
    //所有的牌
    private static List<Poker> list = new ArrayList<>();
    //3个牌手的牌
    private static LinkedList<LinkedList<Poker>> roles = new LinkedList<>();

    static {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                list.add(new Poker(i,j));
            }
        }

        for (int i = 0; i < 54; i++) {
            if(list.get(i).num == 3){
                list.remove(i);
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            roles.add(new LinkedList<Poker>());
        }
    }


    /**
     * 洗牌分牌
     */
    public static void init(){

        //随机取出发牌
        int index = 0;
        while (list.size() > 0){
            int random = (int) (Math.random() * list.size());
            Poker poker = list.remove(random);
            roles.get(index).add(poker);
            index++;
            if(index >= 3){
                index = 0;
            }
        }
    }

    /**
     * 牌手拿牌 ：1  2  3
     * @param index
     */
    public static LinkedList<Poker> handOut(int index){
        return roles.get(index - 1);
    }
}
