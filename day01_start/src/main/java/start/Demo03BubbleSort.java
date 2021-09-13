package start;

/**
 * @Author Jface
 * @Since version-1.0
 * @Desc 尝试写一个
 */
public class Demo03BubbleSort {
    public static void main(String[] args) {
        //测试方法
        int[] arr = {4, 2, 5, 7, 80, 0, 9, 223};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }

    }

    /**
     * 定义一个方法, 通过冒泡排序实现Int类型数组升序排序
     *
     * @param arr 输入的Int类型数组
     * @return 返回的排序好的数组结果
     */
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }

        }


    }


}
