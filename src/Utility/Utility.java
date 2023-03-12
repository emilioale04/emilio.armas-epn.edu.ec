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

    public static String eaGetLstString(int[] eaLstInt) {
        String eaS = "";
        for (int i = 0; i < eaLstInt.length; i++) {
            eaS += Integer.toString(eaLstInt[i]) + " ";
        }
        return eaS;
    }

    public static int eaGetSumaLstInt(int[] eaLstInt) {
        int eaSuma = 0;
        for (int i = 0; i < eaLstInt.length; i++) {
            eaSuma += eaLstInt[i];
        }
        return eaSuma;
    }
}
