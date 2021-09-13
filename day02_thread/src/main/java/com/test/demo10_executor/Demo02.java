package com.test.demo10_executor;

/**
 * @Author: Jface
 * @Date: 2021/5/20 21:04
 * @Desc:
线程池详解:
概述:
实际开发中, 当我们需要使用大量生命周期短的线程对象时, 每次频繁的创建和销毁线程对象非常消耗系统资源,
针对于这种情况, 我们可以创建一个池子出来, 里边放一些线程对象, 用的时候从池子里边拿, 用完之后再放回去,
从而避免了频繁创建和销毁大量生命周期短的线程对象, 这个池子就叫: 线程池(ExecutorService)
好处:
节约资源, 提高效率.
涉及到的成员方法:
Executors: 创建线程池的工具类
public static ExecutorService newFixedThreadPool(int numThread);    获取线程池对象, 指定线程个数.
ExecutorService: 表示线程池
public Future submit(Runnable target);
提交要执行的任务给线程池对象, 由它自动分配线程对象来执行这些任务, 并获取结果, 任务类型为: Runnable资源类的对象.
public Future submit(Callable target);
提交要执行的任务给线程池对象, 由它自动分配线程对象来执行这些任务, 并获取结果, 任务类型为: Callable资源类的对象.
public void shutdown()      关闭线程池, 实际开发中: 不关闭.
Future:  记录的是线程任务执行后的结果对象.
public Object get();        获取线程任务执行结束后, 具体的返回值.
步骤:
1. 创建线程池对象, 指定初始化的线程个数.
2. 提交任务给线程池对象, 由它分配线程来执行该任务, 并返回执行结果对象.
3. 从结果对象(Future)中获取线程任务执行结束后具体的返回值.
4. 操作 线程任务的返回值.
5. 关闭线程池.
案例:
1. 提交Runnable任务.
2. 提交Callable任务.
 */
public class Demo02 {
    public static void main(String[] args) {




    }
}
