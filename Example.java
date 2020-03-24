import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        for(String arg : args) {
            if (arg != null) {
                if(!arg.isEmpty()) {
                    System.out.println(trans(arg));
                }
            }
        }
        System.out.println("输入Q退出");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String in = scanner.nextLine();
            if(in.equals("Q") || in.equals("q")) {
                break;
            }
            System.out.println(trans(in));
        }
        scanner.close();
    }

    public static String trans(String number) {
        if(number.startsWith("av") || number.startsWith("AV")) {
            return biliVideoNumberTool.a2b(number);
        } else if (number.matches("[0-9]+")) {
            return biliVideoNumberTool.a2b(("av" + number));
        } else if(number.startsWith("BV") || number.startsWith("bv")) {
            return biliVideoNumberTool.b2a(number);
        } else return "不是AV或BV号！";
    }
}