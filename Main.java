import java.io.IOException;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) throws IOException, EmptyStackException {

        // Introduce program
        System.out.println("\nJava Stack Implementation");
        System.out.println("For help, type --help\n");

        // New stack
        Stack myStack = new Stack();

        // Program loop
        while (true) {
            try {
                IO.handleInput(myStack);
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            } catch (EmptyStackException e) {
                throw new EmptyStackException();
            }
        }

    }

}