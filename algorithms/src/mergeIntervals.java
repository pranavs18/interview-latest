import java.util.ArrayList;
import java.util.Comparator;

public class mergeIntervals {

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> al) {
        ArrayList<Interval> res = new ArrayList<>();

        if(al == null || al.size() == 0) {
            return res;
        }

        Comparator<Interval> intervalComparator = (Interval one, Interval other)->  one.start - other.start;
        al.sort(intervalComparator);

        Interval a = al.get(0);

        for(int i=1;i<al.size();i++) {
            Interval b = al.get(i);

            if(b.start <= a.end) {
                // overlap hence merge
                Interval temp = new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
                a = temp;
            } else {
                res.add(a);
                a = b;
            }

        }
        res.add(a);
        return res;
    }

    public static ArrayList<Interval> insertInterval(ArrayList<Interval> al , Interval x) {
        ArrayList<Interval> res = new ArrayList<>();

        if(al == null || al.size() == 0) {
            return res;
        }

        Comparator<Interval> intervalComparator = (Interval a, Interval b) -> a.start - b.start;
        al.sort(intervalComparator);

        for(int i=0;i<al.size();i++) {
            Interval b = al.get(i);
            if(x.start > b.end) {
                res.add(b);
            } else if(b.start > x.end) {
                res.add(x);
                x = b;
            } else {
                if(b.end >= x.start || b.start <= x.end) {
                    x = new Interval(Math.min(x.start, b.start), Math.max(x.end, b.end));
                }
            }
        }
        res.add(x);
        return res;
    }

    public static void main(String args[]) {
        ArrayList<Interval> al = new ArrayList<>();

        al.add(new Interval(1,3));
        al.add(new Interval(2,6));
        al.add(new Interval(8,10));
        al.add(new Interval(15,18));
        al.add(new Interval(1,4));
        al.add(new Interval(4,5));

        ArrayList<Interval> res = insertInterval(al, new Interval(3,9));

        for(int i=0;i<res.size();i++) {
            System.out.println("[" + res.get(i).start + "," + res.get(i).end + "]");
        }
    }
}

class Interval {
    int start;
    int end;
    public Interval() {
        this.start = 0;
        this.end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}