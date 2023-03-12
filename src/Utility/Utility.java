package Utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Business.Entities.Coordenada;

public class Utility {
    
    public static int[] eaGetLstIntOrdenada(int[] eaLstInt) {
        Set<Integer> eaSetInt = new HashSet<Integer>();
        int[] eaLstOrdenada;
        Iterator<Integer> it;
        
        for (int i = 0; i < eaLstInt.length; i++) {
            eaSetInt.add(eaLstInt[i]);
        }

        eaLstOrdenada = new int[eaSetInt.size()];

        it = eaSetInt.iterator();

        for (int i = 0; i < eaSetInt.size(); i++) {
            eaLstOrdenada[i] = it.next();
        }
        return eaLstOrdenada;
    }

    public static List<Coordenada> eaGetLstCoordenadaOrdenada(List<Coordenada> eaLstCoo) {
        Set<Coordenada> eaSetCoo = new HashSet<Coordenada>();
        List<Coordenada> eaLstOrdenada = new ArrayList<Coordenada>();
        Iterator<Coordenada> eaIt;
        
        for (Coordenada eaC : eaLstCoo) {
            eaSetCoo.add(eaC);
        }
        // eaSetCoo.

        eaIt = eaSetCoo.iterator();

        while(eaIt.hasNext()){
            eaLstOrdenada.add(eaIt.next());
        }
        return eaLstOrdenada;
    }
}
