public class Literarian {
    //Initializers
    String penName;
    ChallengeResult cResult;

    //Constructors
    public Literarian(String penName, ChallengeResult cResult) {
        this.penName = penName;
        this.cResult = cResult;
    }

    //Methods

    /**
     * The method betterBookworm takes a new literarian and compares the differenceFromGoal with the current literarian
     * @param literarian takes in a literarian
     * @return literarian with the highest difference value
     */
    public boolean betterBookworm(Literarian literarian) {
        return (cResult.rResult.differenceFromGoal() < literarian.cResult.rResult.differenceFromGoal());
    }

    /**
     * The method wittierWordsmith takes a new Literarian and compares the averagePerDay with the current literarian
     * @param literarian takes in a literarian
     * @return literarian with the highest average value
     */
    public boolean wittierWordsmith(Literarian literarian) {
        return (cResult.wResult.averagePerDay() > literarian.cResult.wResult.averagePerDay());
    }

    /**
     * The method successfulScholar takes a new Literarian and compares both the difference and the average of the current literarian
     * @param literarian takes in a literarian
     * @return the highest value between betterBookworm and wittierWordsmith
     */
    public boolean successfulScholar(Literarian literarian) {
        return betterBookworm(literarian) || wittierWordsmith(literarian);
    }
}
