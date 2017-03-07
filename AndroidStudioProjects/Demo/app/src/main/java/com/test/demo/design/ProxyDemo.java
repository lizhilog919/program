package com.test.demo.design;

/**
 * Created by lizhi
 * 17-3-5
 */
public class ProxyDemo {
    public static void main(String[] args){
        System.out.println("normal test:");
        execute(new RealTask());
        System.out.println("proxy test:");
        execute(new ProxyTask(new RealTask()));
    }

    private static void execute(Task task){
        task.doSomeThing();
    }

    public interface Task{
        void doSomeThing();
    }

    public static class RealTask implements Task{

        @Override
        public void doSomeThing() {
            System.out.println("real do something");
        }
    }


    /**
     * 静态代理类，在真正操作时间进行一些自定义的操作以达到一些目的，动态代理类参考Proxy类
     */
    public static class ProxyTask implements Task{

        private Task mTask;

        ProxyTask(Task task){
            mTask = task;
        }

        @Override
        public void doSomeThing() {
            System.out.println("do something first");
            mTask.doSomeThing();
        }
    }


}
