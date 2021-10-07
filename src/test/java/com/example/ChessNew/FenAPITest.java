package com.example.ChessNew;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.example.ChessNew.Api.Fen;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;


public class FenAPITest {

    public  Boolean checkFen(List<String> posytion){
        Iterator<String> i=posytion.listIterator();

        int w=0;
        boolean check =true;
        CheackingLoop:while(i.hasNext())
        {
            String startFen=i.next();
            startFen+="/";
            Fen test=new Fen(startFen);
            String fen = test.tabToFen(test.fenToTab());
            w++;
            if (!startFen.equals(fen))
                check =false; break CheackingLoop;


        }
        return check;
    }
    public  Boolean checkFen1(List<String> posytion){
        Iterator<String> i=posytion.listIterator();
        Fen test=new Fen();
        int w=0;
        boolean check =true;
        CheackingLoop:while(i.hasNext())
        {
            String startFen=i.next();
            startFen+="/";

            String fen = test.tabToFen(test.fenToTab(startFen));
            w++;
            if (!startFen.equals(fen))
                check =false; break CheackingLoop;


        }
        return check;
    }

    @Test
    @Order(1)
    public void  testFen(){
       List<String> posytion = new LinkedList<String>();
       posytion.add("8/1bRq4/P5R1/1NP5/3pPk2/3Pp3/7K/Qr2B3");
       posytion.add("3b2n1/3P1pr1/pp5p/6P1/1k6/1N1RQ3/5P1K/3r4");
       posytion.add("3N4/K2k1P2/2p5/2PPp2P/1rp5/2Pb1Q2/1B6/5N2");
       posytion.add("2b5/1pk5/4Pn2/2pP1KP1/1P1p4/P1p1b2N/5P2/8");
       posytion.add("6b1/7Q/3p2n1/1KpP1p2/1B2p2p/P7/2R1P3/5n1k");
       assertTrue(checkFen(posytion));
       assertTrue(checkFen1(posytion));
    }
    @Test
    @Order(2)
    public void  testFen1(){
        List<String> posytion = new LinkedList<String>();
        posytion.add("8/1bRq4/P5R1/1NP5/3pPk2/3Pp3/7K/Qr2B3");
        posytion.add("3b2n1/3P1pr1/pp5p/6P1/1k6/1N1RQ3/5P1K/3r4");
        posytion.add("3N4/K2k1P2/2p5/2PPp2P/1rp5/2Pb1Q2/1B6/5N2");
        posytion.add("2b5/1pk5/4Pn2/2pP1KP1/1P1p4/P1p1b2N/5P2/8");
        posytion.add("6b1/7Q/3p2n1/1KpP1p2/1B2p2p/P7/2R1P3/5n1k");
        assertTrue(checkFen1(posytion));
    }


}
