package Utility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Utility {
    
    public static int[] eaGetLstOrdenada(int[] eaLstInt) {
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
}
