import java.util.LinkedList;

public class LitJam {
    //Initializers
    int uniqueGenres;
    LinkedList<Literarian> Lit;

    //Constructors
    public LitJam(int uniqueGenres, LinkedList<Literarian> Lit) {
        this.uniqueGenres = uniqueGenres;
        this.Lit = Lit;
    }

    //Methods

    /**
     * This method readingDNF() goes through the LinkedList literarian and accesses the class ReadingResult to compare the genreOfBooks amount with uniqueGenres
     * @return Litty
     */
    public LinkedList<String> readingDNF() {
        LinkedList<String> Litty = new LinkedList<>();
        for (Literarian literarian : Lit) {
            if (literarian.cResult.rResult.genreOfBooks.size() < uniqueGenres) {
                Litty.add(literarian.penName);
            }
        }
        return Litty;
    }

    /**
     * The method finalScoreForLiterarian takes in a LinkedList and calculates the currentIntScore of the literarian
     * @param aliterarian takes a LinkedList
     * @return currentIntScore
     */
    public int finalScoreForLiterarian(String aliterarian) {
        int currentIntScore = 0;

        for (Literarian literarianBooksRead : Lit) {
            LinkedList<BooksRead> genreList = literarianBooksRead.cResult.rResult.genreOfBooks;
            double LiterarianGoal = literarianBooksRead.cResult.rResult.differenceFromGoal();
            LinkedList<Double> WordsWritten = literarianBooksRead.cResult.wResult.wordsWritten;
            int ListDayOfNovember = literarianBooksRead.cResult.wResult.dayOfNovember;

            if (genreList.size() >= uniqueGenres) {
                currentIntScore += 25;
            }

            for (BooksRead invested : genreList) {
                if (invested.skimmed) {
                    currentIntScore += (invested.totalRead * 5);
                }
            }

            if (LiterarianGoal < 0) {
                currentIntScore += 5;
            }

            for (double numWrote : WordsWritten) {
                if (numWrote >= 50000) {
                    currentIntScore += 25 + (5 * (30 - ListDayOfNovember));
                }
            }
        }
        return currentIntScore;
    }

    public boolean anyImprovement(LitJam anotherLitJam) {
        for (Literarian LitJamming : Lit) {
            if (this.finalScoreForLiterarian(LitJamming.penName) > anotherLitJam.finalScoreForLiterarian(LitJamming.penName)) {
                return true;
            }
        }
        return false;
    }
}

// I think factoring out the class variables made the code easier to work and look at overall.
// Maybe implementing helper methods for the expression or the helper methods would be nice as well.
