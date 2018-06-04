import java.util.HashSet;

public class boggle {

    public static boolean wordExists(String word, char[][] matrix, HashSet<String> dictionary) {
        if(word == null || word == "") {
            return false;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == word.charAt(0)) {
                    findWord(word.substring(1), i,j,matrix, dictionary, visited);
                }
            }
        }
    }

    private static void findWord(String word, int i, int j, char[][] matrix, HashSet<String> dictionary, boolean[][]visited) {
        if(i<0 || j< 0 || i> matrix.length || j > matrix[0].length || visited[i][j]) {
            return;
        }

        findWord()
    }

    public static void main(String args[]) {
        char[][] matrix= new char[4][4];
        matrix[0][0]='t';
        matrix[0][1]='i';
        matrix[0][2]='m';
        matrix[0][3]='w';
        matrix[1][0]='z';
        matrix[1][1]='g';
        matrix[1][2]='a';
        matrix[1][3]='p';
        matrix[2][0]='f';
        matrix[2][1]='e';
        matrix[2][2]='r';
        matrix[2][3]='s';
        matrix[3][0]='a';
        matrix[3][1]='n';
        matrix[3][2]='s';
        matrix[3][3]='q';

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("tiger");
        dictionary.add("maps");
        dictionary.add("and");
        dictionary.add("tigers");
        dictionary.add("mars");
        // Matrix contains 6 valid occurences - Note "tigers" and "mars" are present two times.

        System.out.println(wordExists("tiger", matrix, dictionary));

    }
}