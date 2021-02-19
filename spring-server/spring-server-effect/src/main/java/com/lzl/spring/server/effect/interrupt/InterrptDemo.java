package com.lzl.spring.server.effect.interrupt;

import com.lzl.spring.server.effect.utils.StaticUtils;

public class InterrptDemo {

    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (!Thread.interrupted()) {
                        System.out.println("thread running loop");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println("thread end!");
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }


    public static class SupportInterrptCallAble implements Runnable{


        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName()+" is running......");
                StaticUtils.sleep(10000);
                System.out.println(Thread.currentThread().getName()+" is end......");
            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}
