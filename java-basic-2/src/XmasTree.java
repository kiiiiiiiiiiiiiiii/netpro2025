import java.util.Scanner;

public class XmasTree {
    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner(System.in);
            while (true) {
                String input = scan.nextLine();
                if (input.equals("q") || input.equals("e")) break;
                String[] inputSplit = input.split(",");
                int leavesN = Integer.parseInt(inputSplit[0]), stemWidth = Integer.parseInt(inputSplit[1]),
                        stemHeight = Integer.parseInt(inputSplit[2]);
                char snow = inputSplit[3].charAt(0);
                for (int i = 0; i < leavesN + 1; i++) {
                    StringBuilder out = new StringBuilder();
                    for (int j = 0; j < leavesN; j++) {
                        if (j < i)
                            out.append("*");
                        else
                            out.append((i + j) % 2 == 1 ? snow : " ");
                    }
                    System.out.print(out.reverse().toString());
                    System.out.println(out.reverse().toString());
                }
                StringBuilder stemLineBuilder = new StringBuilder();
                for (int i = 0; i < leavesN * 2; i++) stemLineBuilder.append(" ");
                for (int i = 0; i < stemWidth; i++){
                    int p = leavesN - stemWidth / 2 + i;
                    stemLineBuilder.replace(p, p, "*");
                }
                for (int i = 0; i < stemHeight; i++) System.out.println(stemLineBuilder.toString());
            }
        } catch (Exception e) {

        }
    }
}
