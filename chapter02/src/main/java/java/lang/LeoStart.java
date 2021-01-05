package java.lang;
/**
 * @author leowei
 * @date 2021/1/5  - 23:06
 * 由于 java.lang 是由 启动类加载器进行加载， 加载的时候发现没有main函数，所以报如下错误
 * java.lang.SecurityException: Prohibited package name: java.lang
 * 双亲委派机制优势
 * 1.避免类的重复加载
 * 2.保护程序安全，放置核心API 被随意篡改
 */
public class LeoStart {
    public static void main(String[] args) {
        System.out.println("------");
    }
}
