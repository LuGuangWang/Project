package wlg.javaapi.demo.cache;

public class CacheProperty {
  private int totalCount;
  private int doneCount;
  private int successCount;
  
  public CacheProperty(int totalCount) {
    this.totalCount = totalCount;
    this.doneCount = 0;
    this.successCount = 0;
  }
  public synchronized void updateCounts(int doneCount, int successCount) {
    this.doneCount = doneCount;
    this.successCount = successCount;
  }
  public synchronized void setOver() {
    doneCount = totalCount;
  }
  public synchronized SnapShot get() {
    return new SnapShot(totalCount, doneCount, successCount);
  }
  @Override
  public synchronized String toString() {
    return super.toString();
  }
  
  public static class SnapShot {
    private int totalCount;
    private int doneCount;
    private int successCount;
    public SnapShot(int totalCount, int doneCount, int successCount) {
      this.totalCount = totalCount;
      this.doneCount = doneCount;
      this.successCount = successCount;
    }
    public int getTotalCount() {
      return totalCount;
    }
    public int getDoneCount() {
      return doneCount;
    }
    public int getSuccessCount() {
      return successCount;
    }
    public boolean isOver() {
      return doneCount == totalCount;
    }
  }
}
