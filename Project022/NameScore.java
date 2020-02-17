package Project022;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**Using names.txt (right click and 'Save Link/Target As...'),
 * a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN,
 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 * @author ndriqa
 * */

public class NameScore {
    private long scoreSum;

    private LinkedList<String> allNames;

    private String[] sortedNames;
    private int[] nameScores;

    public NameScore(){
        scoreSum = 0;
        allNames = new LinkedList<>();
        getNames();
    }
    private void getNames(){
        List<String> content = null;
        File names;
        // read "names.txt" file and put all the names in one line(not effective when line
        // length surpasses String maximum character range(2^31 - 1) but is good enough for us
        // for now)
        try {
            names = new File("Project022\\names.txt");
            content = Files.readAllLines(Paths.get(names.getPath()), StandardCharsets.US_ASCII);
        } catch (Exception e){
            System.out.println("something went wrong while getting the file");
        }
        assert content != null;

        //replace (",") with a space ( )
        String filtered = content.get(0).replaceAll("\",\"", " ");

        //then remove first and last (")
        filtered = filtered.substring(1, filtered.length() - 1);

        //declare "tempName" as a helper string
        StringBuilder tempName = new StringBuilder();

        //get every name and put it on the LinkedList
        for (int i = 0; i < filtered.length(); i++) {
            if (filtered.charAt(i) != ' '){
                tempName.append(filtered.charAt(i));
            } else {
                allNames.add(tempName.toString().trim());
                tempName = new StringBuilder();
            }
        }
        //let's not forget the last name
        allNames.add(tempName.toString());

        //now we use an pre defined array since it is faster.
        sortedNames = new String[allNames.size()];

        for (int i = 0; i < sortedNames.length; i++) {
            sortedNames[i] = allNames.get(i);
        }

        //make the new array worthy of its name
        Arrays.sort(sortedNames);

        //System.out.println(sortedNames[937]);

        System.out.println(Arrays.asList(sortedNames) + "\n" + sortedNames.length);
    }

    public void calculate(){
        //we set the score for each name
        nameScores = new int[sortedNames.length];

        //
        for (int i = 0; i < nameScores.length; i++) {
            setScore(sortedNames[i], i + 1);
        }

        for (int i = 0; i < nameScores.length; i++) {
            scoreSum += nameScores[i];
        }
    }
    private void setScore(String name, int n) {
        int sc = 0;
        for (int i = 0; i < name.length(); i++) {
            sc += (int)name.toUpperCase().charAt(i) - 'A' + 1;
        }
        sc *= n;
        nameScores[n-1] = sc;
    }
    @Override
    public String toString(){ return "the score of all names is: " + scoreSum; }

    public static void main(String[] args) {
        NameScore name = new NameScore();
        name.calculate();
        System.out.println(name);
    }
}