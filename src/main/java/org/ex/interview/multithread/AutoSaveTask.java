package org.ex.interview.multithread;

/**
 * @desc: 文档自动保存功能
 * @author: Leif
 * @date: 2025/10/16 10:19
 */
public class AutoSaveTask implements Runnable {
  private Document doc;
  private volatile boolean isRunning = true;
  public AutoSaveTask(Document doc) {
    this.doc = doc;
  }
  @Override
  public void run() {
    while (isRunning) {
      try {
        doc.autoSave();
        int i = 1 / 0;
        Thread.sleep(3000);
        isRunning = false;
        System.out.println("自动保存成功执行!");
      } catch (InterruptedException e) {
        System.out.println("自动保存被中断");
        break;
      }
    }
  }

  public static void main(String[] args) {

    Document document = new Document("abc","abcdefg");
    // 启动自动保存
    new Thread(new AutoSaveTask(document)).start();

  }

}


record Document(String docTitle, String docContent) {
  void autoSave() {
    System.out.println("执行自动保存...");
  }
}
