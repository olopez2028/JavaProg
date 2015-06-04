/*************************************************************************
 *  Compilation:  javac Genome.java
 *  Execution:    java Genome
 *
 *
 *************************************************************************/

public class Genome {
    private char[] a = new char[2];
    private int N = 0;


    public void addNucleotide(char c) {
        if (N == a.length) resize();
        if (c == 'a' || c == 'c' || c == 'g' || c == 't')
            a[N++] = c;
        else throw new RuntimeException("Illegal nucleotide");
    }

    // double the size of the array
    private void resize() {
        char[] temp = new char[2*N];
        for (int i = 0; i < N; i++) temp[i] = a[i];
        a = temp;
    }

    public char nucleotideAt(int i) {
        if (i < N) return a[i];
        else throw new RuntimeException("Genome out of bounds");
    }

    public int length()      { return N; }



    // sample client for testing
    public static void main(String[] args) {
        Genome g = new Genome();
        g.addNucleotide('a');
        g.addNucleotide('g');
        g.addNucleotide('c');
        g.addNucleotide('c');
        g.addNucleotide('t');
        for (int i = 0; i < g.length(); i++) 
            System.out.print(g.nucleotideAt(i));
        System.out.println();
       

    }

}