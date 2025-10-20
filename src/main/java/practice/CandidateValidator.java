package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String HYPHEN = "-";
    private static final String UKR_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(UKR_NATIONALITY)
                && getPeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD;
    }

    private int getPeriodInUkr(String stringPeriod) {
        String[] arrPeriod = stringPeriod.split(HYPHEN);
        int from = Integer.parseInt(arrPeriod[0]);
        int to = Integer.parseInt(arrPeriod[1]);

        return to - from;
    }
}
