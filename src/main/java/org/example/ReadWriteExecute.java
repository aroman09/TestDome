package org.example;

import java.util.*;

public class ReadWriteExecute {
    public static int symbolicToOctal(String permString) {
        Map<String, Integer> symbolicToOctal = new HashMap<>();
        symbolicToOctal.put("r",4);
        symbolicToOctal.put("w",2);
        symbolicToOctal.put("x",1);
        symbolicToOctal.put("-",0);

        String total = "";
        int valorCadena=0;


        for(int j=0;j<permString.length();j++)
        {
            valorCadena +=symbolicToOctal.get(String.valueOf(permString.charAt(j)));
            if ( (j+1)%3==0)
            {
                total = total.concat(String.valueOf(valorCadena));
                valorCadena=0;
            }
        }
        return Integer.parseInt(total);

    }

    public static void main(String[] args) {
        // Should write 752
        System.out.println(ReadWriteExecute.symbolicToOctal("rwxr-x-w-"));
    }
}
