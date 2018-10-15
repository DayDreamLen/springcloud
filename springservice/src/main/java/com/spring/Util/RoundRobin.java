package com.spring.Util;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: CQ02
 * @Date: 2018/10/11 10:44
 * @Description:
 */
//轮询算法
public class RoundRobin {
    private static Integer lock=0;
    private static Map<String, Integer> serviceWeightMap = new HashMap<String, Integer>();
    private static  int currentIndex;
    private static int totalServer;
    private static int currentWeight;
    private static int maxWeight;
    private static int gcdWeight;
    static {
        serviceWeightMap.put("192.168.1.100", 1);
        //权重为4
        serviceWeightMap.put("192.168.1.101", 1);
        serviceWeightMap.put("192.168.1.102", 4);
        serviceWeightMap.put("192.168.1.103", 1);
        serviceWeightMap.put("192.168.1.104", 1);
        //权重为3
        serviceWeightMap.put("192.168.1.105", 3);
        serviceWeightMap.put("192.168.1.106", 1);
        //权重为2
        serviceWeightMap.put("192.168.1.107", 2);
        serviceWeightMap.put("192.168.1.108", 1);
        serviceWeightMap.put("192.168.1.109", 1);
        serviceWeightMap.put("192.168.1.110", 1);
        totalServer=serviceWeightMap.size();
        currentIndex=totalServer-1;
        maxWeight=getMaxWeight();
        gcdWeight=serverGcd();
    }
    //普通轮询算法
    public  String RoundRobinModel(){
        // 重新创建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serviceWeightMap);
        //取得服务地址
        Set<String> keySet = serverMap.keySet();
        List<String> serverList=new ArrayList<>();
        serverList.addAll(keySet);
        String server=null;
        synchronized (lock){
            if(lock>=serverList.size()){
                lock=0;
            }
            server=serverList.get(lock);
            lock++;
        }
        return  server;
    }
    //加权轮询算法
    public String round() {
        List<Integer> valueList=new ArrayList<>();
        List<String> keyList=new ArrayList<>();
        while (true) {
            currentIndex = (currentIndex + 1) % totalServer;
            if (currentIndex == 0) {
                currentWeight = currentWeight - gcdWeight;
                if (currentWeight <= 0) {
                    currentWeight = maxWeight;
                    if(currentWeight == 0) {
                        return null;
                    }
                }
            }
//            Iterator<String> it = serviceWeightMap.keySet().iterator();
//            while (it.hasNext()){
//                keyList.add(it.next());
//                valueList.add(serviceWeightMap.get(it.next()));
//
//            }
            for(Map.Entry<String,Integer> entry : serviceWeightMap.entrySet()){
                keyList.add(entry.getKey());
                valueList.add(entry.getValue());
            }
            if(valueList.get(currentIndex) >= currentWeight) {
                return keyList.get(currentIndex);
            }
        }
    }
    /**
     * 返回所有服务器的权重的最大公约数
     *
     * @return
     */
    private static int serverGcd() {
        int comDivisor = 0;
        List<Integer> list=new ArrayList<>();
        Iterator<String> it = serviceWeightMap.keySet().iterator();
        while (it.hasNext()){
            list.add(serviceWeightMap.get(it.next()));
        }
        for (int i = 0; i < totalServer - 1; i++) {
            if (comDivisor == 0) {
                comDivisor = gcd(list.get(i), list.get(i + 1));
            } else {
                comDivisor = gcd(comDivisor, list.get(i + 1));
            }
        }
        return comDivisor;
    }

    /**
     * 获得服务器中的最大权重
     *
     * @return
     */
    private static int getMaxWeight() {
        int max=0;
        for(Map.Entry<String,Integer> entry : serviceWeightMap.entrySet()){
           max=entry.getValue();
           if (max!=0){
               break;
           }
        }
        for(Map.Entry<String,Integer> entry : serviceWeightMap.entrySet()){
            int temp=entry.getValue();
            if(max<temp){
                max=temp;
            }
        }
        return max;
    }
    /**
     * 求两个数的最大公约数 4和6最大公约数是2
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int gcd(int num1, int num2) {
        BigInteger i1 = new BigInteger(String.valueOf(num1));
        BigInteger i2 = new BigInteger(String.valueOf(num2));
        return i1.gcd(i2).intValue();
    }


    public static void main(String[] args) {
        final RoundRobin wr = new RoundRobin();
        // 非并发情况
        for (int i = 0; i < 100; i++) {
            System.out.println(wr.round());
        }

        System.out.println();
        System.out.println("==========");
        System.out.println();

        final CyclicBarrier b = new CyclicBarrier(30);
        // 并发情况
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        b.await();
                        System.out.println(Thread.currentThread().getName() + " " + wr.round());
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }, "thread" + i).start();


        }
        System.out.println();
        System.out.println("==========");
        System.out.println();
        for (int i=0;i<30;i++){
            System.out.println(wr.RoundRobinModel());
        }
    }
}
