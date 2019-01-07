package com.y.second;

public class Poker {

    /**
     * type = 红桃，方块，黑桃，梅花 = 1.2.3.4
     * num = 1-13
     */
    public int type,num;

    public Poker(int type, int num){
        this.type = type;
        this.num = num;
    }

    @Override
    public String toString() {
        return name() + num + "; ";
    }

    public String name(){
        switch (type){
            case 1:
                return "红桃";
            case 2:
                return "方块";
            case 3:
                return "黑桃";
            case 4:
                return "梅花";
        }
        return "";
    }
}
