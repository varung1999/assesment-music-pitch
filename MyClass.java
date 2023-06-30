import java.util.*;
public class MyClass {
    
    public static String[] letterOrder = {"C","D","E","F","G","A","B"};
    public static List<String> letters = Arrays.asList(letterOrder);
    public static int[] OctaveOrder = {0,1,2,3,4,5,6,7};
    
    public static int pitchIndex(String x) {
        for (int i = 0; i < 8; i++) {
            if (x.equals(letterOrder[i])) return i;
        }
        return -1;
    }
    
    public static boolean helper(String[] nodes,String start, String end)
    {
        Comparator<String> noteComparator = new Comparator<>() {
            @Override
            public int compare(String a, String b) {
                String a_pitch = a.charAt(0)+"",
                b_pitch = b.charAt(0)+"";
                int a_octave = Integer.parseInt(a.charAt(1)+""),
                b_octave = Integer.parseInt(b.charAt(1)+"");
                int comp = Integer.compare(a_octave, b_octave);
                if (comp != 0) return comp;
                else return Integer.compare(pitchIndex(a_pitch), pitchIndex(b_pitch));
            }
        };
        for (String note: nodes) {
            if (noteComparator.compare(start, note) > 0 || noteComparator.compare(note, end) > 0) return false;
        }
        return true;
    }
    
    public static void main(String args[]) {
      String[] song1 = {"F4", "B4", "C5"};
      String[] song2 = {"C3", "E3", "G3", "C4", "E4", "G4", "C5"};
      String[] song3 = {"B4", "F5", "B5" };
      String[] song4 = {"B4", "E4", "G4", "G4", "A4", "B4", "E4", 
                      "B4", "E4", "G4", "G4", "A4", "C5", "B4", 
                      "E5", "G4", "G4", "A4", "B4", "C5", "D5", 
                      "C5", "B4", "C5", "E5", "D5", "C5", "C5", 
                      "B4", "B4", "E5", "E4", "G4", "G4", "A4", 
                      "B4", "B4", "B4", "C5", "E5", "A5", "E5", 
                      "C5", "A4", "E5", "D5", "C5", "B4"};
      String[] song5={"F4"};
    
    System.out.println(helper(song1, "F4", "C5"));
    System.out.println(helper(song1, "A4", "C5"));
    System.out.println(helper(song2, "B2", "C5"));
    System.out.println(helper(song2, "C3", "B4"));
    System.out.println(helper(song3, "B4", "B5"));
    System.out.println(helper(song3, "B4", "C5"));
    System.out.println(helper(song4, "D4", "A5"));
    System.out.println(helper(song4, "D4", "G5"));
    System.out.println(helper(song4, "D4", "C6"));
    System.out.println(helper(song4, "F4", "C6"));
    System.out.println(helper(song5, "D4", "E4"));

    }
}