import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class Examples {

    public Examples() {
        writingresult1.nextChapter(10);
        writingresult3.nextChapter(25);
        writingresult4.nextChapter(50);

        readingresult1.readSomeBooks(booksread1);
        readingresult2.readSomeBooks(booksread2);
        readingresult3.readSomeBooks(booksread3);

        poemresult1.nextPoem(5.0, true);
        poemresult1.nextPoem(0.0, false);
        poemresult2.nextPoem(20.0, false);
        poemresult2.nextPoem(0.0, true);

        linkedlistlit1.add(literarian1);
        linkedlistlit2.add(literarian2);
        linkedlistlit3.add("Bababoey");
        linkedlistlit4.add("Kirby");
    }

    // WRITINGRESULT METHOD TEST CASES
    WritingResult writingresult1 = new WritingResult(0.0, 30);
    WritingResult writingresult2 = new WritingResult(30000.0, 1);
    WritingResult writingresult3 = new WritingResult(100, 15);
    WritingResult writingresult4 = writingresult3;

    @Test
    public void testWritingResultEdge1() {
        assertEquals(0.33, writingresult1.averagePerDay(), 0.01);
    }

    @Test
    public void testWritingResultEdge2() {
        assertEquals(30000.0, writingresult2.averagePerDay(), 0.01);
    }

    @Test
    public void testWritingResultEdge3() {
        assertEquals(49998.66, writingresult1.differenceFromGoal(), 0.01);
    }

    @Test
    public void testWritingResultEdge4() {
        assertEquals(19999.0, writingresult2.differenceFromGoal(), 0.01);
    }

    @Test
    public void testWritingResultEdge5() {
        assertEquals(49998.666666666664, writingresult1.differenceFromGoal(), 0.01);
    }

    @Test
    public void testWritingResultEdge6() {
        assertEquals(49987.333333333336, writingresult4.differenceFromGoal(), 0.01);
    }

    @Test
    public void testWritingResultEdge7() {
        assertEquals(0.3333333333333333, writingresult1.averagePerDay(), 0.01);
    }

    @Test
    public void testWritingResultEdge8() {
        assertEquals(11.666666666666666, writingresult4.averagePerDay(), 0.01);
    }

    // READRESULT METHOD TEST CASES
    BooksRead booksread1 = new BooksRead(10.0, "Fiction", true);
    BooksRead booksread2 = new BooksRead(30.0, "nonFiction", false);
    BooksRead booksread3 = new BooksRead(0.0, "Fiction", false);
    BooksRead booksread4 = new BooksRead(0.0, "nonFiction", true);
    BooksRead booksread5 = new BooksRead(50.0, "Fiction", false);
    ReadingResult readingresult1 = new ReadingResult(30, booksread1, booksread2);
    ReadingResult readingresult2 = new ReadingResult(5, booksread2, booksread3);
    ReadingResult readingresult3 = new ReadingResult(15, booksread3, booksread4);
    ReadingResult readingresult4 = new ReadingResult(20, booksread4, booksread5);

    @Test
    public void testReadResultEdge1() {
        assertEquals(1.61, readingresult1.averagePerDay(), 0.01);
    }

    @Test
    public void testReadResultEdge2() {
        assertEquals(1.93, readingresult2.averagePerDay(), 0.01);
    }

    @Test
    public void testReadResultEdge3() {
        assertEquals(0.0, readingresult3.averagePerDay(), 0.01);
    }

    @Test
    public void testReadResultEdge4() {
        assertEquals(28.38, readingresult1.differenceFromGoal(), 0.01);
    }

    @Test
    public void testReadResultEdge5() {
        assertEquals(3.06, readingresult2.differenceFromGoal(), 0.01);
    }

    @Test
    public void testReadResultEdge6() {
        assertEquals(15.0, readingresult3.differenceFromGoal(), 0.01);
    }

    @Test
    public void testReadResultEdge10() {
        assertEquals("nonFiction", readingresult1.bestGenreByType(true));
    }

    @Test
    public void testReadResultEdge11() {
        assertEquals("Fiction", readingresult4.bestGenreByType(true));
    }

    // CHALLENGERESULT METHOD TEST CASES
    ChallengeResult challengeresult1 = new ChallengeResult(readingresult1, writingresult1);
    ChallengeResult challengeresult2 = new ChallengeResult(readingresult2, writingresult2);

    @Test
    public void testChallengeResultEdge1() {
        assertEquals(333869.63, challengeresult1.howClose(), 0.01);
    }

    @Test
    public void testChallengeResultEdge2() {
        assertEquals(50644.16, challengeresult2.howClose(), 0.01);
    }

    // POEMRESULT METHOD TEST CASES
    PoemResult poemresult1 = new PoemResult(40.0, 10, 10);
    PoemResult poemresult2 = new PoemResult(0.0, 1, 0);

    @Test
    public void testPoemResultEdge1() {
        assertEquals(4.5, poemresult1.averagePerDay(), 0.01);
    }

    @Test
    public void testPoemResultEdge4() {
        assertEquals(0.0, poemresult2.differenceFromGoal(), 0.01);
    }

    // LITJAM METHOD TEST CASES
    LinkedList<Literarian> linkedlistlit1 = new LinkedList<>();
    LinkedList<Literarian> linkedlistlit2 = new LinkedList<>();
    LinkedList<String> linkedlistlit3 = new LinkedList<>();
    LinkedList<String> linkedlistlit4 = new LinkedList<>();
    LinkedList<String> linkedlistlit5 = new LinkedList<>();
    LitJam litjam1 = new LitJam(1, linkedlistlit1);
    LitJam litjam2 = new LitJam(0, linkedlistlit2);
    LitJam litjam3 = new LitJam(5, linkedlistlit1);
    LitJam litjam4 = new LitJam(10, linkedlistlit2);

    @Test
    public void testLitJamEdge1() {
        assertEquals(linkedlistlit5, litjam2.readingDNF());
    }

    @Test
    public void testLitJamEdge2() {
        assertEquals(linkedlistlit4, litjam3.readingDNF());
    }

    @Test
    public void testLitJamEdge3() {
        assertEquals(125.0, litjam1.finalScoreForLiterarian("Bababoey"), 0.01);
    }

    @Test
    public void testLitJamEdge4() {
        assertEquals(25.0, litjam2.finalScoreForLiterarian("Kirby"), 0.01);
    }

    @Test
    public void testLitJamEdge5() {
        assertFalse(litjam4.anyImprovement(litjam3));
    }

    @Test
    public void testLitJamEdge6() {
        assertTrue(litjam1.anyImprovement(litjam2));
    }

    // LITERARIAN METHOD TEST CASES
    Literarian literarian1 = new Literarian("Kirby", challengeresult1);
    Literarian literarian2 = new Literarian("Zoombanger", challengeresult2);

    @Test
    public void testLiterarianEdge1() {
        assertTrue(literarian2.betterBookworm(literarian1));
    }

    @Test
    public void testLiterarianEdge2() {
            assertFalse(literarian1.betterBookworm(literarian2));
    }

    @Test
    public void testLiterarianEdge3() {
        assertTrue(literarian2.betterBookworm(literarian1));
    }

    @Test
    public void testLiterarianEdge4() {
        assertFalse(literarian1.betterBookworm(literarian2));
    }

    @Test
    public void testLiterarianEdge5() {
        assertTrue(literarian2.successfulScholar(literarian1));
    }

    @Test
    public void testLiterarianEdge6() {
        assertFalse(literarian1.successfulScholar(literarian2));
    }
}
