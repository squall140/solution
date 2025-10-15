package org.ex.interview.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc: 使用LinkedHashMap实现LRU商品缓存
 * @author: Leif
 * @date: 2025/10/15 14:47
 */
public class ProductCache {
  private static final int MAX_ITEMS = 1000;
  private final LinkedHashMap<Integer, Product> cache;

  public ProductCache() {
    this.cache = new LinkedHashMap(16, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ITEMS;
      }
    };
  }

  public Product getProduct(int id) {
    return cache.get(id);
  }

  public void addProduct(Product product) {
    cache.put(product.id(), product);
  }

}

record Product(int id, String title) {}

