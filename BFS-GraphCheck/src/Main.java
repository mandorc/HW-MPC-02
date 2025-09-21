/*
 * The MIT License
 *
 * Copyright 2025 armando.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author armando
 */
import java.util.*;

public class Main {

    static boolean isConnected(int[][] A) { // con BFS sobre matriz de adyacencia 
        int n = A.length;   // obtemeos el tamano
        if (n == 0) {       // comprobamos que no este vacio
            return true;  
        }
        boolean[] visited = new boolean[n];   // vamos marcando los vertices vicitados
        Deque<Integer> q = new ArrayDeque<>();// cola para BFS

        visited[0] = true;             // comenzamos desde cero
        q.add(0);         

        // --- Bucle BFS ---
        while (!q.isEmpty()) {
            int v = q.removeFirst();   // se saca de la cola el siguiente vértice


            for (int u = 0; u < n; u++) {

                if (A[v][u] != 0 && !visited[u]) {
                    visited[u] = true; // lo marcamos como visitado
                    q.addLast(u);      
                }
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return false;      
            }
        }
        return true;     
    }

    public static void main(String[] args) {

        // listamos nuestros ejemplos
        int[][] ejemploA = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0}
        };

        int[][] ejemploB = {
            {0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0}
        };

        int[][] ejemploC = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        
        // este ejemplo fue visto en clase
        int[][] ejemploD = {
            {0,1,0,0,0,0,1},
            {1,1,1,1,0,0,0},
            {0,1,1,0,0,0,0},
            {0,1,0,0,1,0,1},
            {0,0,0,1,0,1,0},
            {0,0,0,0,1,0,0},
            {1,0,0,1,0,0,0}
        };

        System.out.println("Ejemplo A: " + (isConnected(ejemploA) ? "CONEXO" : "NO CONEXO"));
        System.out.println("Ejemplo B: " + (isConnected(ejemploB) ? "CONEXO" : "NO CONEXO"));
        System.out.println("Ejemplo C: " + (isConnected(ejemploC) ? "CONEXO" : "NO CONEXO"));
        System.out.println("Ejemplo D: " + (isConnected(ejemploD) ? "CONEXO" : "NO CONEXO"));
    }
}
