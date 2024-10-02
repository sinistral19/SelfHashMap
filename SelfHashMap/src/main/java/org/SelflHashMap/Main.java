package org.SelflHashMap;

public class Main
{
    public static void main(String[] args)
    {
        SelfHashMap<Integer,String> map=new SelfHashMap<Integer,String>();
        map.add(1,"AAA");
        map.add(1,"BBB");
        map.add(2,"CCC");
        map.add(3,"CCC");
        map.add(9,"ZZZ");

        SelfNode<Integer,String> node=map.get(2);

        map.delete(3);
    }
}
