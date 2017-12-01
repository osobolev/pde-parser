import ide.processing.ProcessingLexer;
import ide.processing.ProcessingParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public final class ParserTest {

    public static void main(String[] args) throws IOException {
        ProcessingLexer lexer = new ProcessingLexer(CharStreams.fromFileName("src/test/resources/Basics/Data/TrueFalse/TrueFalse.pde"));
        ProcessingParser parser = new ProcessingParser(new CommonTokenStream(lexer));

        parser.program();
    }
}
