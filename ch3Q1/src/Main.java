
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int []x=new int [30];
        for (int i = 0; i < 30; i++) {
            x [i]=(int)( Math.random()*100);
        }
        List <Integer> list= new ArrayList<>();
        for (int i = 0; i <x.length; i++) {
            list.add(x[i]);
        }
        Collections.sort(list);
        System.out.print("30 Numbers Sorted: ");
        for (Integer integer : list) {
            System.out.print(integer +" ");
        }
        System.out.println("");
        System.out.println("The Sum: "+ IntStream.of(x).sum());
        System.out.println("The Average: "+IntStream.of(x).average().getAsDouble());
    }

}