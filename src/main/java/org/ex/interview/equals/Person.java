package org.ex.interview.equals;

import java.util.Objects;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/15 21:35
 */

public class Person{
  private String name;
  private int age;
  private String idCard;  // 身份证号唯一标识一个人

  public Person(String name, int age, String idCard) {
    this.name = name;
    this.age = age;
    this.idCard = idCard;
  }

  // 构造方法、getter/setter省略...

  @Override
  public boolean equals(Object o) {
    // 1. 检查是否是同一个对象
    if (this == o) return true;

    // 2. 检查是否为null或类不匹配
    if (o == null || getClass() != o.getClass()) return false;

    // 3. 类型转换
    Person person = (Person) o;

    // 4. 比较关键字段
    return age == person.age &&
      Objects.equals(name, person.name) &&
      Objects.equals(idCard, person.idCard);
  }

  @Override
  public int hashCode() {
    // 使用Objects.hash()自动处理null和组合多个字段
    return Objects.hash(name, age, idCard);
  }
}
