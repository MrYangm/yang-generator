import java.util.Scanner;

/**
 * @Author: yang
 * @Date: 2025/08/21/17:03
 */
public class MainTemplate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            //输入元素个数
            int n = sc.nextInt();




            //读取数组
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            //处理问题逻辑
            // 计算数组元素的和
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }

            System.out.println("Sum: " + sum);
        }
        sc.close();
    }
}
