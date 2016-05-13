/**
 * 大数相乘
 */
public class BigInt_Add {
    public static void bigNumberSimpleMulti(String f, String s) {
        System.out.print("乘法：\n" + f + "*" + s + "=");
        // 获取首字符，判断是否是符号位
        char signA = f.charAt(0);
        char signB = s.charAt(0);
        char sign = '+';
        if (signA == '+' || signA == '-') {
            sign = signA;
            f = f.substring(1);
        }
        if (signB == '+' || signB == '-') {
            if (sign == signB) {
                sign = '+';
            } else {
                sign = '-';
            }
            s = s.substring(1);
        }
        // 将大数翻转并转换成字符数组
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        // 计算最终的最大长度
        int len = lenA + lenB;
        int[] result = new int[len];
        // 计算结果集合
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += (int) (a[i] - '0') * (int) (b[j] - '0');
            }
        }
        // 处理结果集合，如果是大于10的就向前一位进位，本身进行除10取余
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        // 该字段用于标识是否有前置0，如果是0就不需要打印或者存储下来
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        if (!sb.toString().equals("")) {
            if (sign == '-') {
                sb.insert(0, sign);
            }
        } else {
            sb.append(0);
        }
        // 返回最终结果
        System.out.println(sb.toString());
    }
}
