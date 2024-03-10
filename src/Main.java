
import GbCollections.GbList;
import GbCollections.Lists.GbArrayList;
import GbCollections.Lists.GbLinkedList;

public class Main {
    public static void main(String[] args) {
        GbLinkedList<String> ll = new GbLinkedList<>();
        ll.add("14");
        ll.add("16");
        ll.add("28");
        ll.add("35");
        ll.add("43");
        System.out.println(ll);
        ll.add(0, "45");
        System.out.println(ll);
        ll.add("58");
        System.out.println(ll);
        ll.add("24");
        System.out.println(ll);
        ll.add(5, "234");
        System.out.println(ll);
        System.out.println(ll.size());
        System.out.println(ll.get(5));
        ll.remove("35");
        System.out.println(ll);
        System.out.println(ll.size());
        ll.removeByIndex(0);
        System.out.println(ll);
        System.out.println(ll.size());
        ll.removeByIndex(6);
        System.out.println(ll);
        System.out.println(ll.size());
        ll.removeByIndex(3);
        System.out.println(ll);
//        System.out.println(ll.size());
//        ll.removeByIndex(30);
        ll.add(5, "234");
        System.out.println(ll);
    }
}