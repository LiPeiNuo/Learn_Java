package ListPractical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//这是一张牌
class Card{
    private String rank;//点数
    private String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "rank='" + rank + '\'' +
//                ", suit='" + suit + '\'' +
//                '}';
        return "[" + this.rank+this.suit + "]";
    }
}
public class Poker {
    public static void main(String[] args) {
        //创建一副牌
        List<Card> poker = buyPoker();
        //洗牌,最简单的办法是可以使用Collections.shuffle方法
        //Collections.shuffle将若干个元素打乱
        Collections.shuffle(poker);
        //发牌，假设有三个玩家，每人发五张牌
        //每个玩家就是一个List，就可以把每个人的手牌放入这个List中
        //可以把多个玩家的信息再放入一个List之中
        //players表示所有玩家的手牌
        //每个元素就是一个玩家的所有手牌
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //给三个玩家发牌 没人发五张牌
        //i表示牌的编号 j表示玩家的编号
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                List<Card> player = players.get(j);
                //remove表示删除List中指定下标的元素
                //remove返回值 表示要删除的这个元素是啥
                player.add(poker.remove(0));
            }
        }
        //到这一步 玩家发牌结束，可以查看玩家的手牌了
        for(int i = 0; i < 3; i++){
            System.out.println("玩家" + i +":" + players.get(i));
        }




    }
     private static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();
        String[] suits = {"♥","♠","♣","♦"};
        for(int i = 0; i < 4; i++){
            //遍历四种花色
            //每种花色有13张牌
            for(int j = 2; j <= 10; j++){
                //"" + j ,类型转换 int ——>String
                poker.add(new Card("" +j,suits[i] ));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
            poker.add(new Card("A",suits[i]));
        }
        return poker;
     }
}
