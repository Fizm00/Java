package Semester_2_Practice.Chapter12;

//NAMA : Firza Himawan
//NIM  : 22537144003

public class FirzaCh12Substring {
    
    public static String substring(String str, int start, int end) {
        if (start < 0 || end > str.length() || start > end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }
        if (start == end) {
            return "";
        }
        if (start == end - 1) {
            return Character.toString(str.charAt(start));
        }
        return Character.toString(str.charAt(start)) + substring(str, start + 1, end);
    }
    
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hamburger";
        String s3 = "smiles";
        String s4 = "howdy";
        
        System.out.println(substring(s1, 0, 2));
        System.out.println(substring(s2, 4, 8));
        System.out.println(substring(s3, 1, 5));
        System.out.println(substring(s4, 3, 3));
        
    }
}

/*
 * output:
 * hello : "he"
 * hamburger : "urge"
 * smiles : "mile"
 * howdy : " " (empty string)
 */
