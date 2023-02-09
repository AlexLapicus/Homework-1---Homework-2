import java.util.LinkedList;

public class WritingResult implements IChallenge {
    //Initializers
    LinkedList<Double> wordsWritten;
    int dayOfNovember;

    //Constructors
    public WritingResult (double wordsWritten, int dayOfNovember) {
        this.wordsWritten = new LinkedList<>();
        this.wordsWritten.add(wordsWritten);
        this.dayOfNovember = dayOfNovember;
    }

    //Methods

    /**
     * The method averagePerDay calculates the sum of the LinkedList wordsWritten
     * @return average
     */
    public double averagePerDay() {
        double sum = 0;
        for (double i: wordsWritten) {
            sum += i;
        }
        return sum/dayOfNovember;
    }

    /**
     * The method differenceFromGoal calculates the difference
     * @return difference
     */
    public double differenceFromGoal() {
        return 50000 - (averagePerDay() + 1);
    }

    /**
     * The method nextChapter takes a double book and adds it to the LinkedList
     * @param chapter takes in a double
     * @return Writing Result
     */
    public WritingResult nextChapter(double chapter) {
        this.wordsWritten.add(chapter);
        return this;
    }
}

