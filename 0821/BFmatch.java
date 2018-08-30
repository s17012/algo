import java.util.Scanner;

class BFmatch {

   
   static int bfMatch(String txt, String pat) {
      int pt = 0;      
      int pp = 0;      
      int count = 0;   
      int k = -1;

      while (pt != txt.length() && pp != pat.length()) {
         if (k == pt - pp)
            System.out.print("    ");
         else {
            System.out.printf("%2d  ", pt - pp);
            k = pt - pp;
         }
         for (int i = 0; i < txt.length(); i++)
            System.out.print(txt.charAt(i) + " ");
         System.out.println();

         for (int i = 0; i < pt * 2 + 4; i++)
            System.out.print(" ");
         System.out.print(txt.charAt(pt) == pat.charAt(pp) ? '+' : '|');
         System.out.println();

         for (int i = 0; i < (pt-pp) * 2 + 4; i++)
            System.out.print(" ");

         for (int i = 0; i < pat.length(); i++)
            System.out.print(pat.charAt(i) + " ");
         System.out.println();
         System.out.println();
         count++;

         if (txt.charAt(pt) == pat.charAt(pp)) {
            pt++;
            pp++;
         } else {
            pt = pt - pp + 1;
            pp = 0;
         }
      }
      System.out.printf("比較は%d回でした。\n", count);
      if (pp == pat.length())      
         return pt - pp;
      return -1;               
   }

   public static void main(String[] args) {
      Scanner stdIn = new Scanner(System.in);

      System.out.print("テキスト：");
      String s1 = stdIn.next();               

      System.out.print("パターン：");
      String s2 = stdIn.next();               

      int idx = bfMatch(s1, s2);  
      if (idx == -1)
         System.out.println("テキスト中にパターンは存在しません。");
      else {
         
         int len = 0;
         for (int i = 0; i < idx; i++)
            len += s1.substring(i, i + 1).getBytes().length;
         len += s2.length();

         System.out.println((idx + 1) + "文字目にマッチします。");
         System.out.println("テキスト：" + s1);
         System.out.printf(String.format("パターン：%%%ds\n", len), s2);
      }
   }
}
