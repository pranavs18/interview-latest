import java.util.ArrayList;

class Narytree {
    char val;
    ArrayList<Narytree> children;
    public Narytree(char val, ArrayList<Narytree> children) {
        this.val = val;
        this.children = children;
    }
}


class XMLGenerator {
    private static void generateXML(Narytree root) {
        if(root == null) {
            return;
        }

       System.out.println(xml(root, ""));

    }

    private static String xml(Narytree root, String s) {
        if(root.children.size() == 0) {
            s += "</" + root.val + ">";
            return s;
        }

        s += "<" + root.val + ">";
        for(int i=0;i<root.children.size();i++) {
            s = xml(root.children.get(i), s);
        }
        s += "</" + root.val + ">";
        return s;
    }

    public static void main(String args[]){

        ArrayList<Narytree> dl = new ArrayList<Narytree>();
        ArrayList<Narytree> al = new ArrayList<Narytree>();
        Narytree c1 = new Narytree('c', new ArrayList<Narytree>());
        Narytree c2 = new Narytree('d', dl);
        Narytree c3 = new Narytree('e', new ArrayList<Narytree>());
        Narytree c4 = new Narytree('f', new ArrayList<Narytree>());
        Narytree c5 = new Narytree('g', new ArrayList<Narytree>());

        al.add(c1);
        al.add(c2);
        al.add(c3);
        al.add(c4);
        dl.add(c5);
        Narytree root = new Narytree('a',al);
        generateXML(root);
		
		/*
		 *       a
		 *     / | \ \ 
		 *    c  d  e f
		 *       |
		 *       g
		 *   <a> </c> <d></g> </d> </e> </f> </a>
		 */


    }
}

