package kupchack.com.ua.lesson50_Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class lesson50_1 {

    public static void main(String[] args) {
        Collection<String> text = new ArrayList<String>();
        Collection<String> text1  = new ArrayList<String>();

        text.add("Igor");
        text.add("Nazar");
        text.add("Misha");

        text1.add("Ivan");
        text1.add("Ivan1");
        text1.add("Ivan2");


        //text.addAll(text1);
        //text1.clear();

//        boolean a = true;
//        System.out.println(a = text.containsAll(text1));

//        boolean a = true;
//        System.out.println(a = text.equals(text1));

//        text.add("Ivanka");
//        text.add("Ivanka2");
//        text1.add("Ivanka");
//        text1.add("Ivanka2");
//        boolean a = false;
//        System.out.println(a = (text.hashCode() == text1.hashCode()));

//        Collection<String> emptytext = new ArrayList<String>();
//        System.out.println(emptytext.isEmpty());

        //text.remove("Igor");

        //System.out.println(text.size());
        /*
        text.addAll(text1);
        Iterator<String> itr = text.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println(" ");

        text.removeAll(text1);
        Iterator<String> itr1 = text.iterator();

        while (itr1.hasNext()){
            System.out.println(itr1.next());
        }
        */

        /*
        text.addAll(text1);
        Iterator<String> itr = text.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println(" ");

        text.retainAll(text1);
        Iterator<String> itr1 = text.iterator();

        while (itr1.hasNext()){
            System.out.println(itr1.next());
        }
        */

        String[] mass = new String[0];
        mass =  text.toArray(mass);
        for (String i:mass) {
            System.out.println(i);
        }
    }
}
