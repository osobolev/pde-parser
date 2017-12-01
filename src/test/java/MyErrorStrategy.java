import org.antlr.v4.runtime.*;

public final class MyErrorStrategy extends DefaultErrorStrategy {

    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
        super.reportNoViableAlternative(recognizer, e); // todo
    }

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        super.reportInputMismatch(recognizer, e); // todo
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        super.reportUnwantedToken(recognizer); // todo
    }

    @Override
    protected void reportMissingToken(Parser recognizer) {
        super.reportMissingToken(recognizer); // todo
    }
}
