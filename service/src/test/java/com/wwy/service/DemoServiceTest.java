package com.wwy.service;

import com.wwy.api.DemoService;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DemoServiceTest extends BaseServiceTest {

    @Reference
    DemoService demoService;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testSayHello() {
        String aaa = demoService.sayHello("aaa");
        System.out.println(aaa);
    }

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("a", 1);
        System.out.println(111);
    }

    private static String zookeeperConnectionString = "192.168.213.133:2181,192.168.213.133:2182,192.168.213.133:2183";

    @Test
    public void testCurator() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(10000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
        client.start();
        InterProcessMutex interProcessMutex = new InterProcessMutex(client, "/lock/adlock");
        try {
            while (interProcessMutex.acquire(3000, TimeUnit.MILLISECONDS)){
                //todo something
            }
            interProcessMutex.release();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                interProcessMutex.release();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    @Test
    public void test() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(10000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
        client.start();

        String BasePath = "/curatorTest";
        Stat stat = client.checkExists().forPath(BasePath + "/node1");
        Object o;
        if (stat == null) {

            o = client.create().creatingParentContainersIfNeeded().
                    withMode(CreateMode.PERSISTENT).forPath(BasePath + "/node1", "0".getBytes());
        }


        //存储Stat
        client.getData().storingStatIn(stat).forPath(BasePath + "/node1");

        //更新时使用State
        stat = client.setData().withVersion(stat.getVersion()).forPath(BasePath + "/node1", "1".getBytes());
        System.out.println("update => " + stat.getVersion());
        GetChildrenBuilder children = client.getChildren();
        System.out.println(children);
    }


}
