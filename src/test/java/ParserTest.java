import ide.processing.JavaLexer;
import ide.processing.JavaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public final class ParserTest {

    public static void main(String[] args) throws IOException {
        JavaLexer lexer = new JavaLexer(CharStreams.fromFileName("src/test/resources/Basics/Data/TrueFalse/TrueFalse.pde"));
        JavaParser parser = new JavaParser(new CommonTokenStream(lexer));

        parser.activeProgram();
        System.out.println("Active OK");

//        lexer.reset();
//        parser.reset();
//        parser.compilationUnit();
    }
}
