// (1) 定义接口 Compute
interface Compute {
    int computer(int n, int m);
}

// (2) 设计四个类实现此接口完成加减乘除运算
class Add implements Compute {
    @Override
    public int computer(int n, int m) {
        return n + m;
    }
}

class Subtract implements Compute {
    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}

class Multiply implements Compute {
    @Override
    public int computer(int n, int m) {
        return n * m;
    }
}

class Divide implements Compute {
    @Override
    public int computer(int n, int m) {
        if (m != 0) {
            return n / m;
        } else {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
    }
}

// (3) 设计 UseCompute 类
class UseCompute {
    public void useCom(Compute com, int one, int two) {
        int result = com.computer(one, two);
        System.out.println("The result of the operation is: " + result);
    }
}

// (4) 主类 Test
public class Test {
    public static void main(String[] args) {
        UseCompute uc = new UseCompute();

        // 加法运算
        uc.useCom(new Add(), 5, 3);
        // 减法运算
        uc.useCom(new Subtract(), 8, 2);
        // 乘法运算
        uc.useCom(new Multiply(), 7, 4);
        // 除法运算（确保除数不为零）
        uc.useCom(new Divide(), 10, 2);
    }
}



import java.util.Scanner;

public class ScoreChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个分数（0-100）：");
        
        // 接收用户输入的分数
        int score = scanner.nextInt();
        
        try {
            if (score < 0 || score > 100) {
                throw new IllegalArgumentException("分数必须在 0—100 之间");
            } else {
                System.out.println("成绩为：" + score);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}



import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 提示用户输入 N 的值并获取
        int n;
        boolean validN = false;
        while (!validN) {
            System.out.println("请输入一个正整数 N（或 0）：");
            try {
                n = scanner.nextInt();
                if (n >= 0) {
                    validN = true;
                } else {
                    throw new IllegalArgumentException("N 必须是正数或者 0");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("请输入第 " + i + " 个整数：");
            int number = scanner.nextInt();
            sum += number;
        }

        double average = (double) sum / n;
        System.out.println("这 " + n + " 个整数的平均值为：" + average);

        scanner.close();
    }
}



import java.util.Date;

// 假设 MyDate 类已经定义好，可以表示日期信息
abstract class MyDate {
    // ...
}

public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    // 抽象方法 earnings()，由子类实现计算工资
    public abstract double earnings();

    // 重写 toString() 方法输出对象的 name,number 和 birthday
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                '}';
    }
}



import java.util.ArrayList;
import java.util.List;

public class SubsequenceWordsCount {
    public int countSubsequenceWords(String s, List<String> words) {
        int count = 0;
        
        for (String word : words) {
            if (isSubsequence(s, word)) {
                count++;
            }
        }
        
        return count;
    }

    // 判断字符串 t 是否是字符串 s 的子序列
    private boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                sIndex++;
            }
        }
        return tIndex == t.length();
    }

    public static void main(String[] args) {
        SubsequenceWordsCount solver = new SubsequenceWordsCount();
        String S = "abcde";
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("bb");
        words.add("acd");
        words.add("ace");

        System.out.println("输出: " + solver.countSubsequenceWords(S, words));  // 输出应为：3
    }
}
