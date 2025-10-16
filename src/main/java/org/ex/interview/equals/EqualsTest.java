package org.ex.interview.equals;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
 *
 * ✅ equals用于判断逻辑相等性，必须满足五大特性
 * ✅ hashCode用于哈希表，必须与equals一致
 * ✅ 两者必须同时重写，遵守"equals相等则hashCode必须相等"
 * ✅ 实现时要注意null检查、类型检查、完整比较
 * ✅ 避免常见错误：参数类型错误、依赖可变字段等
 * ✅ 高级话题：继承处理、性能优化、工具使用
 * ————————————————
 *
 * @EqualsAndHashCode
 * public class Person {
 *     private String name;
 *     private int age;
 *     private String idCard;
 * }
 *
 * 它会自动生成正确的equals和hashCode方法，但要注意：
 * - 默认使用所有非静态字段
 * - 可以使用@EqualsAndHashCode.Exclude排除某些字段
 * - 可以使用@EqualsAndHashCode.Include指定特定字段
 *
 * @author: Leif
 * @date: 2025/10/15 21:39
 */
public class EqualsTest {
  public static void main(String[] args) {
    Person p1 = new Person("张三", 25, "123456");
    Person p2 = new Person("张三", 25, "123456");

    System.out.println(p1.equals(p2));  // true
    System.out.println(p1.hashCode() == p2.hashCode());  // false（如果没正确实现hashCode）

    // 放入HashSet会有奇怪行为
    Set set = new HashSet<>();
    set.add(p1);
    set.add(p2);

    System.out.println(set.size());  // 会是2！违反Set的唯一性

  }
}
