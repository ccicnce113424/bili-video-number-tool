public class biliVideoNumberTool {
    public static final long xor = 177451812;
    public static final long add = 100618342136696320L;
    public static final String table = "fZodR9XQDSUm21yCkr6zBqiveYah8bt4xsWpHnJE7jL5VG3guMTKNPAwcF";
    public static final int[] s = {11, 10, 3, 8, 4, 6, 2, 9, 5, 7};
    
    // av应为以av开头，后面跟纯十进制数字的字符串,如av810872
    public static String a2b (String av) {
        long x = Long.parseLong(av.substring(2));
        x = (x ^ xor) + add;
        char[] r = "BV          ".toCharArray();
        for(int i = 0; i < s.length; i++) {
            r[s[i]] = table.charAt((int) (x / (long) Math.pow(58, i) % 58));
        }
        return String.valueOf(r);
    }

    // bv应为BV开头,后跟十位包含大小写字母和数字的字符串,如BV17x411w7KC
    public static String b2a (String bv) {
        long r = 0;
        for(int i = 0; i < s.length; i++) {
            r += ((long)table.indexOf(bv.charAt(s[i]))) * ((long)Math.pow(58, i));
        }
        return "av" + ((r - add) ^ xor);
    }
}