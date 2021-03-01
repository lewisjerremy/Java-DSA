import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class IO {

    /**
     * Parses terminal input for stack command, validates, then executes
     * 
     * @params stack: integer stack object
     */
    public static void handleInput(Stack stack) throws IOException {

        // Get input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        // Consider help input
        if (input.equals("--help")) {
            System.out.println("Java-DSA: Stack Implementation ");
            System.out.println("Commands: ");
            System.out.println("------------------------------ ");
            System.out.println("push(integer): add a positive or negative integer to the top of the stack");
            System.out.println("pop(): remove the top element of the stack, then return it ");
            System.out.println("peek(): return the top element of the stack ");
            System.out.println("--help: prints available commands ");
            System.out.println("--exit: exits the program\n");
            return;
        }

        if (input.equals("--exit")) {
            System.out.println("Program exiting...");
            System.exit(0);
        }

        // Validate brackets
        if (!input.contains("(") || !input.contains(")")) {
            throw new IOException("Missing brackets");
        }

        // Split at opening bracket
        String[] function = input.split("\\(");

        // Validate closing bracket
        if (!function[1].substring(function[1].length() - 1).equals(")")) {
            throw new IOException("End of command is not a bracket");
        }

        // Handle pop()
        if (function[0].equals("pop")) {
            // Verify no arguments
            if (!function[1].equals(")")) {
                throw new IOException("Pop command does not accept arguments");
            }
            System.out.println(Integer.toString(stack.pop()));
            return;
        }

        // Handle push(int)
        if (function[0].equals("push")) {

            // Remove closing bracket
            function[1] = function[1].substring(0, function[1].length() - 1);

            // If argument is not an integer throw exception
            if (!function[1].matches("^-?[0-9]+$")) {
                throw new IOException("Push command only accepts integers");
            }

            // Parse string to integer
            int num = Integer.parseInt(function[1]);

            // Push to stack
            stack.push(num);
            return;
        }

        // Handle peek()
        if (function[0].equals("peek")) {
            // Verify no arguments
            if (!function[1].equals(")")) {
                throw new IOException("Peek command does not accept arguments");
            }
            System.out.println(Integer.toString(stack.peek()));
            return;
        }

        // Handle isEmpty()
        if (function[0].equals("isEmpty")) {
            // Verify no arguments
            if (!function[1].equals(")")) {
                throw new IOException("isEmpty command does not accept arguments");
            }
            System.out.println(stack.isEmpty());
            return;
        }

        throw new IOException("No such command");
    }
}
