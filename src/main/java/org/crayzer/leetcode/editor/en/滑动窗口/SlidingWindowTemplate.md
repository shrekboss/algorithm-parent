### 滑动窗口模板
> 开始套模板，只需要思考以下四个问题：
> 1、当移动right扩大窗口，即加入字符时，应该更新哪些数据？
> 2、什么条件下，窗口应该暂停扩大，开始移动left缩小窗口？
> 3、当移动left缩小窗口，即移出字符时，应该更新哪些数据？
> 4、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？


```
public class SlidingWindowTemplate {

    public static String template(String s, String t) {
        int count = t.length();
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;

        int left = 0, right = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            // ...
            
            System.out.printf("window: [%d, %d)\n", left, right);
            // 判断左侧窗口是否要收缩
            while (/* window needs shrink */) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                // ...
            }
        }
    }
```