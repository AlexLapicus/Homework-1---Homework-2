public class ChallengeResult {
    //Initializers
    ReadingResult rResult;
    WritingResult wResult;

    //Constructors
    public ChallengeResult(ReadingResult rResult, WritingResult wResult) {
        this.rResult = rResult;
        this.wResult = wResult;
    }

    //Methods
    public double howClose() { //Object 1
        return this.rResult.differenceFromGoal() * 10000 + this.wResult.differenceFromGoal();
    }
}