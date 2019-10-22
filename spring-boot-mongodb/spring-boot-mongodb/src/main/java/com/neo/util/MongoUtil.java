package com.neo.util;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MongoUtil {
    public static MongoClient mongoClient = null;

    private static String USERNAME;// 用户名
    private static String PASSWORD;// 密码
    private static String DBNAME;// mongo库名
    private static int connectsNum = 30;// 每台服务器连接的最大连接数
    private static int threadsAllowedToBlockForConnectionMultiplier = 10;// 线程队列数
    private static List<ServerAddress> serverList = new ArrayList<>();// 服务器列表

    public static MongoClient initMongo() {
        try {
            serverList.add(new ServerAddress("192.168.0.1", 27017));// 注，ip和端口以实际为准，这里只是测试
            serverList.add(new ServerAddress("192.168.0.2", 27017));// 注，ip和端口以实际为准，这里只是测试
            serverList.add(new ServerAddress("192.168.0.3", 27017));// 注，ip和端口以实际为准，这里只是测试

            // 连接池设置 注意readPreference参数
            MongoClientOptions options = MongoClientOptions.builder().connectTimeout(6000).socketTimeout(0)
                    .connectionsPerHost(connectsNum).maxConnectionIdleTime(6000)
                    .threadsAllowedToBlockForConnectionMultiplier(threadsAllowedToBlockForConnectionMultiplier)
                    .readPreference(ReadPreference.secondaryPreferred()).build();
            // 认证
            MongoCredential credential = MongoCredential.createCredential(USERNAME, DBNAME, PASSWORD.toCharArray());
            //mongoClient = new MongoClient(serverList, Arrays.asList(credential), options);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoClient;

    }
}
