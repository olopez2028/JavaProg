public class StringGenome {
    private String s = "";


    public void addNucleotide(char c) {
        if (c == 'a' || c == 'c' || c == 'g' || c == 't')
            s = s + c;
        else throw new RuntimeException("Illegal nucleotide");
    }

    public char nucleotideAt(int i) {
        if (i < s.length()) return s.charAt(i);
        else throw new RuntimeException("Genome out of bounds");
    }

    public int length()      { return s.length(); }
    public String toString() { return s;          }



    // sample client for testing
    public static void main(String[] args) {
        StringGenome g = new StringGenome();
        g.addNucleotide('a');
        g.addNucleotide('g');
        g.addNucleotide('c');
        g.addNucleotide('c');
        g.addNucleotide('t');
        System.out.println(g);
        for (int i = 0; i < g.length(); i++) 
            System.out.println(g.nucleotideAt(i));

    }

}