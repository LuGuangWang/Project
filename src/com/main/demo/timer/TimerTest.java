package com.main.demo.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

  /**
   * schedule方法：下一次执行时间相对于 上一次 实际执行完成的时间点 ，因此执行时间会不断延后
   */
  public static void testSchedule() throws Exception {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date startDate = dateFormatter.parse("2010/11/28 01:06:00");
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      public void run() {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("execute task!" + new Date(this.scheduledExecutionTime()));
      }
    }, startDate, 2 * 1000);
  }

  /**
   * scheduleAtFixedRate方法：下一次执行时间相对于上一次开始的 时间点 ，因此执行时间不会延后，存在并发性 
   */
  public static void testScheduleAtFixedRate() throws Exception {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date startDate = new Date();
    Timer timer = new Timer("定时任务1：");
    timer.scheduleAtFixedRate(new TimerTask() {
      public void run() {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("execute task!" + dateFormatter.format(new Date(this.scheduledExecutionTime())));
       
      }
    }, startDate, 2 * 1000);
  }

  public void timerInstruction() {
    // java.util.Timer timer = new java.util.Timer(true);
    // true 说明这个timer以daemon方式运行（优先级低，
    // 程序结束timer也自动结束），注意，javax.swing
    // 包中也有一个Timer类，如果import中用到swing包，
    // 要注意名字的冲突。

    // TimerTask task = new TimerTask() {
    // public void run() {
    // // 每次需要执行的代码放到这里面。
    // }
    // };

    // 以下是几种调度task的方法：

    // timer.schedule(task, time);
    // time为Date类型：在指定时间执行一次。

    // timer.schedule(task, firstTime, period);
    // firstTime为Date类型,period为long
    // 从firstTime时刻开始，每隔period毫秒执行一次。

    // timer.schedule(task, delay)
    // delay 为long类型：从现在起过delay毫秒执行一次

    // timer.schedule(task, delay, period)
    // delay为long,period为long：从现在起过delay毫秒以后，每隔period
    // 毫秒执行一次。

  }

  public static void main(String[] args) throws Exception {
//    testSchedule();
    
    testScheduleAtFixedRate();
  }
}
