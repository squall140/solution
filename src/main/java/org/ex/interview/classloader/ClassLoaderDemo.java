package org.ex.interview.classloader;

/**
 * @author: Leif
 * @date: 2025/10/16 09:02
 * <p>
 * 1. 什么是双亲委派？🤝
 * 简单说就是："有事找爸妈，不行我再上"的加载策略。具体流程：
 * <p>
 * 1️⃣ 当一个类加载器收到加载请求时，先不自己加载
 * 2️⃣ 把请求委托给父加载器去完成
 * 3️⃣ 如果父加载器无法完成（在自己的搜索范围没找到），子加载器才会尝试加载
 * <p>
 * 就像你借钱💰：
 * <p>
 * 先找爸妈借 → 爸妈没有 → 找爷爷奶奶 → 最后才自己赚钱
 * 自定义ClassLoader → Application → Extension → Bootstrap
 * <p>
 * 这种设计有三大好处：
 * <p>
 * ① 避免重复加载
 * 同一个类只会被一个加载器加载，防止内存中出现多份相同的类。
 * <p>
 * ② 安全性
 * 防止核心API被篡改。比如你自己写了个java.lang.String类，由于双亲委派，会先由Bootstrap加载官方String，你的String不会被加载。
 * <p>
 * ③ 分工明确
 * 每个加载器专注自己的领域，Bootstrap管核心，Extension管扩展，Application管应用。
 *
 * 如何判断两个类相同？
 *  两个类相同必须满足：
 *  - 全限定名相同
 *  - 由同一个类加载器加载
 */
public class ClassLoaderDemo {
  public static void main(String[] args) {
    // 查看当前类的加载器
    ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
    System.out.println("当前类加载器：" + loader);

    // 查看父加载器
    System.out.println("父加载器：" + loader.getParent());

    // 查看祖父加载器（Bootstrap显示为null）
    System.out.println("祖父加载器：" + loader.getParent().getParent());
  }

}
