package ue2;


import net.htlgrieskirchen.pos3.pcp.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static void main(String[] args)
    {
        Dagger d1 = new Dagger();
        Dagger d2 = new Dagger();
        Dagger d3 = new Dagger();
        Dagger d4 = new Dagger();
        Dagger d5 = new Dagger();

        Ork o1 = new Ork("Ork-1",d5,d1);
        Ork o2 = new Ork("Ork-2",d1,d2);
        Ork o3 = new Ork("Ork-3",d2,d3);
        Ork o4 = new Ork("Ork-4",d3,d4);
        Ork o5 = new Ork("Ork-5",d4,d5);


        ExecutorService es = Executors.newFixedThreadPool(5);
        es.execute(o1);
        es.execute(o2);
        es.execute(o3);
        es.execute(o4);
        es.execute(o5);
    }
}
