import java.util.LinkedList;

public class ReadingResult implements IChallenge {
    //Initializers
    int avgBookGoal;
    LinkedList<BooksRead> genreOfBooks;

    //Constructors
    public ReadingResult(int avgBookGoal, BooksRead fictionBooks, BooksRead nonFictionBooks) {
        this.avgBookGoal = avgBookGoal;
        this.genreOfBooks = new LinkedList<>();
        this.genreOfBooks.add(fictionBooks);
        this.genreOfBooks.add(nonFictionBooks);
    }

    //Methods

    /**
     * The method averagePerDay() takes the average of books read per day from the LinkedList
     * @return the average books per day from the books per day divided from 31
     */
    public double averagePerDay() {
        int counter = 0;
        for (BooksRead booksRead : genreOfBooks) {
            double numBooks = booksRead.totalRead;
            counter += numBooks;
        }
        return counter / 31.0;
    }

    /**
     * The method differenceFromGoal() finds the difference from the goal with what the Literarian is
     * @return the difference from the goal with what Literarian has the current average of
     */
    public double differenceFromGoal() {
        return Math.max(avgBookGoal - this.averagePerDay(), 0);
    }

    /**
     * The method readSomeBooks() adds the BooksRead value to the LinkedList
     *
     * @param readObj takes in a BooksRead which is either the fiction or nonFiction value
     * @return ReadingResult
     */
    public ReadingResult readSomeBooks(BooksRead readObj) {
        this.genreOfBooks.add(readObj);
        return this;
    }

    /**
     * The method bestGenreByType() takes a boolean that checks for whether invested is true, a for each look goes into the genreOfBooks list to compare the value of x versus booksRead
     * @param invested is a boolean type that passes true and false
     * @return x.genreOfBooks which is the highest value
     */
    public String bestGenreByType(boolean invested) {
        BooksRead x = new BooksRead(0.0, "", false);
            if (invested) {
            for (BooksRead booksread : genreOfBooks) {
                if (!booksread.skimmed) {
                    if (x.totalRead < booksread.totalRead) {
                        x = booksread;
                    }
                }
            }
            return x.genreOfBooks;
        }
        else {
            for (BooksRead booksRead : genreOfBooks) {
                if (x.totalRead < booksRead.totalRead) {
                    x = booksRead;
                }
            }
        }
        return x.genreOfBooks;
    }
}