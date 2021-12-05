import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class barcode {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regex = "@{1}#+(?<product>[A-Z]([A-Za-z0-9]){4,}[A-Z])@";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (char e : matcher.group().toCharArray()) {


                    if (Character.isDigit(e)) {
                        sb.append(e);
                        count++;
                    }

                }
                if (count == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + sb);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
