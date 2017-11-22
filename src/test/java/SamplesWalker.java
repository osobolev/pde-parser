import ide.processing.JavaLexer;
import ide.processing.JavaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

public final class SamplesWalker {

    /**
     * @return true, если удалось разобрать успешно
     */
    private static boolean tryParse(Path file) throws IOException {
        JavaLexer lexer = new JavaLexer(CharStreams.fromPath(file));
        JavaParser parser = new JavaParser(new CommonTokenStream(lexer));

        parser.removeErrorListeners();
        MyErrorListener listener = new MyErrorListener();
        parser.addErrorListener(listener);
        parser.program();
        return !listener.isError();
    }

    public static void main(String[] args) throws IOException {
        PDEConsumer pathConsumer = new PDEConsumer();
        Path start = Paths.get("src/test/resources");
        Files.walk(start).forEach(pathConsumer);
        System.out.println("Error: " + pathConsumer.getCountError());
        System.out.println("OK: " + pathConsumer.getCountOK());
    }

    private static final class PDEConsumer implements Consumer<Path> {

        private int countOK = 0;
        private int countError = 0;

        @Override
        public void accept(Path path) {
            if (!Files.isRegularFile(path))
                return;
            if (!path.getFileName().toString().toLowerCase().endsWith(".pde"))
                return;
            boolean ok = false;
            try {
                ok = tryParse(path);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (ok) {
                countOK++;
            } else {
                System.out.println(path);
                countError++;
            }
        }

        public int getCountOK() {
            return countOK;
        }

        public int getCountError() {
            return countError;
        }
    }
}
