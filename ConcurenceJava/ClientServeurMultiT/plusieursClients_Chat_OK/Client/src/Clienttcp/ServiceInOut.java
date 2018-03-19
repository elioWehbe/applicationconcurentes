/*
 * Copyright © <Pascal Fares @ ISSAE - Cnam Liban>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, 
 * fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, 
 * whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software. »
 */
package Clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pascalfares
 */
public class ServiceInOut implements Runnable {

    String _sens;
    PrintWriter _out;
    BufferedReader _in;

    public ServiceInOut(BufferedReader in, PrintWriter out,String sens) {
        _in = in;
        _out = out;
        _sens=sens;
    }

    @Override
    public void run() {
        try {
            String line;
            //System.out.println(_sens);
            while (!(line = _in.readLine()).equals(".")) {
                //System.out.println("Dans boucle "+ _sens + line);
                _out.printf("%s\n", line);_out.flush();
            }
            _out.printf(".\n");
        } catch (IOException ex) {
            Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
