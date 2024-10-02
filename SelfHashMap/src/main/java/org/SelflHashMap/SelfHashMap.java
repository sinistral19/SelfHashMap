package org.SelflHashMap;

import java.util.ArrayList;

public class SelfHashMap<K, T> {
    ArrayList<SelfNode<K, T>> Nodes;
    int currentsize = 0;
    int realSize = 10;
    float resizeCoef = 0.5f;

    public SelfHashMap() {
        //Nodes =(SelfNode<K,T>[]) new Object [realSize];
        Nodes = new ArrayList<>(realSize);
        for (int i = 0; i < realSize; i++) {
            Nodes.add(null);
        }
        int i = Nodes.size();
    }

    public int length() //возвращение длины
    {
        return currentsize;
    }

    public void resize() //увеличение размера массива
    {
        if (currentsize >= realSize * resizeCoef) {
            realSize *= 2;
            ArrayList<SelfNode<K, T>> NewNodes = new ArrayList<SelfNode<K, T>>(realSize);
            System.arraycopy(Nodes, 0, NewNodes, 0, Nodes.size());
            Nodes = NewNodes;

        }
    }
    public boolean isEmpty()
    {
        return currentsize>0?true:false;
    }

    public void add(K key,T value)
    {
        SelfNode node=new SelfNode(key,value);
        int hashcode=node.key.hashCode();
        int elementNumber=Math.round(hashcode/(realSize-1));
        int i=elementNumber<realSize?elementNumber:realSize-1;

        if(Nodes.get(i)==null)
        {
            Nodes.set(i,node);
            currentsize++;
        }
        else
        {
            repeat(node,Nodes.get(i));
        }

        resize();
    }

    public SelfNode<K,T> get(K key)
    {
        int hashcode=key.hashCode();
        int elementNumber=Math.round(hashcode/(realSize-1));
        int i=elementNumber<realSize?elementNumber:realSize-1;
        SelfNode node=Nodes.get(i);
        boolean end=false;
        do
        {

            if(node.key.equals(key))
            {
                end=true;
            }
            else
            {
                if(node.Next!=null)
                {
                    node=node.Next;
                }
                else
                {
                    end =true;
                }
            }
        }while(end==false);
        return node;
    }

    public void delete(K key)
    {
        int hashcode=key.hashCode();
        int elementNumber=Math.round(hashcode/(realSize-1));
        int i=elementNumber<realSize?elementNumber:realSize-1;
        SelfNode node=Nodes.get(i);
        SelfNode node2=null;
        boolean end=false;

        do
        {

            if(node.key.equals(key))
            {
                //Nodes.set(i,Nodes.get(i).Next);
                if(node.Next!=null)
                {
                node.value=node.Next.value;
                node.key=node.Next.key;
                node.Next=node.Next.Next;
                }
                else
                {
                    node.value=null;
                    node.key=null;
                    node.Next=null;
                    node2.Next=null;

                }
                end=true;
            }
            else
            {
                if(node.Next!=null)
                {
                    node2=node;
                    node=node.Next;

                }
                else
                {
                    end =true;
                }
            }
        }while(end==false);

    }


    public void repeat(SelfNode<K,T> node,SelfNode<K,T> node2)
    {
        boolean end=false;
        do
        {
            if(node.key.hashCode()==node2.key.hashCode())
            {
                if(node.key.equals(node2.key))
                {
                    node2.value=node.value;
                    end=true;
                }
            }
            else
            {
                if(node2.Next!=null)
                {
                    node2=node2.Next;
                }
                else
                {
                    node2.Next=node;
                    end =true;
                }
            }
        }while(end==false);

    }
}
