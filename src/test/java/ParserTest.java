import ide.processing.JavaLexer;
import ide.processing.JavaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class ParserTest {

    public static void main(String[] args) throws IOException {
        JavaLexer lexer = new JavaLexer(CharStreams.fromFileName("C:\\temp\\processing_repo\\src\\test\\resources\\Basics\\Arrays\\Array2D\\Array2D.pde"));
        JavaParser parser = new JavaParser(new CommonTokenStream(lexer));

        parser.activeProgram();
        System.out.println("Active OK");

//        lexer.reset();
//        parser.reset();
//        parser.compilationUnit();
    }
}
