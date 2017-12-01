import ide.processing.ProcessingLexer;
import ide.processing.ProcessingParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;

public final class ErrorTest {

    public static void main(String[] args) throws IOException {
        ProcessingLexer lexer = new ProcessingLexer(CharStreams.fromString("int x = 1 + ;"));
        ProcessingParser parser = new ProcessingParser(new CommonTokenStream(lexer));
        parser.setErrorHandler(new MyErrorStrategy());
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                System.out.println(msg);
            }
        });

        parser.program();
    }
}
