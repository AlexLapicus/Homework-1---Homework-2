import java.util.LinkedList;

public class PoemResult implements IChallenge{
    //Initializers
    LinkedList<Double> numOfWords;
    int dayOfAugust;
    int weeksOfSubmittedPoem;

    //Constructors
    public PoemResult (double numOfWords, int dayOfAugust, int weeksOfSubmittedPoem) {
        this.numOfWords = new LinkedList<>();
        this.numOfWords.add(numOfWords);
        this.dayOfAugust = dayOfAugust;
        this.weeksOfSubmittedPoem = weeksOfSubmittedPoem;
    }

    //Methods

    /**
     * The method nextPoem checks to see if the next poem was submitted
     * @param numOfWords takes in a double that gets added to the LinkedList
     * @param newPoem takes in a boolean that increases the counter if true
     * @return PoemResult
     */
    public PoemResult nextPoem(double numOfWords, boolean newPoem) {
        this.numOfWords.add(numOfWords);
        if (newPoem) {
            weeksOfSubmittedPoem++;
        }
        return this;
    }

    /**
     * The method averagePerDay() finds the average word written per day from the days of August
     * @return the average from the sum divided by the day
     */
    public double averagePerDay() {
        double sum = 0;
        for (double i: numOfWords) {
            sum += i;
        }
        return sum/dayOfAugust;
    }

    /**
     * The method differenceFromGoal() finds the difference from the number of words written with the total poems being four
     * @return the sum of the number of word required to write the four poems listed
     */
    public double differenceFromGoal() {
        double sum = 0;
        for (double i: numOfWords) {
            sum += i;
            if (weeksOfSubmittedPoem == 0) {
                weeksOfSubmittedPoem = 1;
            }
        }
        return (sum/weeksOfSubmittedPoem) * ((4 - weeksOfSubmittedPoem)/(31 - this.dayOfAugust + 1));
    }
}
