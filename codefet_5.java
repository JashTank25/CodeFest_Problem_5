import java.util.*;
import java.lang.*;
import java.io.*;
public class codefet_5
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> fruit_price = new ArrayList<Integer>();
        FileInputStream fc = new FileInputStream("TOF_large.txt");
        Scanner sc1 = new Scanner(fc);
        String line = sc1.nextLine();
        Scanner sc2 = new Scanner(line);
        short t = sc2.nextShort();
        for(int i=0; i<t; i++){
            String line1 = sc1.nextLine();
            Scanner sc3 = new Scanner(line1);
            byte tree_num = sc3.nextByte();
            Short day = sc3.nextShort();
            int total_price = 0;
            fruit_price.add(0,(int)(day/10)*12000) ;
            fruit_price.add(1,(int)(day/6)*10000);
            fruit_price.add(2,(int)(day/15)*27500);
            fruit_price.add(3,(int)(day/5)*7500);
            fruit_price.add(4,(int)(day/15)*8000);

            for (int k=0; k<5; k++){
                total_price += fruit_price.get(k);
            }
//            total_price = fruit_price.stream().mapToInt(Integer::intValue).sum();
            Collections.sort(fruit_price);
            byte remining_tree = (byte)(tree_num-5);
            byte max_tree = (byte)(tree_num*0.4);
            int j=4;
            while (remining_tree != 0){

                if(remining_tree >= max_tree) {
                    total_price += fruit_price.get(j) * (max_tree - 1);
                    remining_tree -= (max_tree - 1);
                }
                else {
                    total_price += fruit_price.get(j)*remining_tree;
                    remining_tree = 0;
                }
                j-=1;
            }
            System.out.println(total_price);
            fruit_price.clear();
        }
    }
}
