/*************************************************************************
 *  Compilation:  javac CompactGenome.java
 *  Execution:    java CompactGenome
 *
 *  CHANGE TO USE CHAR ARRAY, AND PACK 8 TO THE CHAR
 *  BOOLEAN ARRAY IN JAVA USES 4 BITS PER VALUE (INSTEAD OF ONE)
 *
 *************************************************************************/

public class CompactGenome {
    private boolean[] a = new boolean[2];
    private int N = 0;


    // double the size of the array
    private void resize() {
        boolean[] temp = new boolean[2*a.length];
        for (int i = 0; i < a.length; i++) temp[i] = a[i];
        a = temp;
    }

    public void addNucleotide(char c) {
        if (2*N == a.length) resize();
        if      (c == 'a')  { a[2*N] = false; a[2*N + 1] = false; }
        else if (c == 'c')  { a[2*N] = false; a[2*N + 1] = true;  }
        else if (c == 'g')  { a[2*N] = true;  a[2*N + 1] = false; }
        else if (c == 't')  { a[2*N] = true;  a[2*N + 1] = true;  }
        else throw new RuntimeException("Illegal nucleotide");
        N++;
    }


    public char nucleotideAt(int i) {
        if (i >= N || i < 0) throw new RuntimeException("Genome out of bounds");
        if      (a[2*i] == false && a[2*i + 1] == false) return 'a';
        else if (a[2*i] == false && a[2*i + 1] == true)  return 'c';
        else if (a[2*i] == true  && a[2*i + 1] == false) return 'g';
        else                                             return 't';
    }

    public int length() { return N; }



    // sample client for testing
    public static void main(String[] args) {
        CompactGenome g = new CompactGenome();
        g.addNucleotide('a');
        g.addNucleotide('g');
        g.addNucleotide('c');
        g.addNucleotide('c');
        g.addNucleotide('t');
        for (int i = 0; i < g.length(); i++) {
            System.out.print(g.nucleotideAt(i));
        }
        System.out.println();
       

    }

}
