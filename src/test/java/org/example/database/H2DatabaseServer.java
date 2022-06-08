package org.example.database;

import org.h2.tools.Server;
import org.h2.util.JdbcUtils;
import org.junit.rules.ExternalResource;

import java.sql.Connection;
import java.util.Properties;

public class H2DatabaseServer extends ExternalResource {

    private final String baseDir;
    private final String dbName;
    private final String schemaName;
    private Server server = null;


    public H2DatabaseServer(String baseDir, String dbName, String schemaName) {
        this.baseDir = baseDir;
        this.dbName = dbName;
        this.schemaName = schemaName;
    }

    @Override
    protected void before() throws Throwable{

        // DB サーバの機能
        server = Server.createTcpServer("-baseDir",baseDir);
        server.start();

        // スキーマの設定
        Properties pros = new Properties();
        pros.setProperty("user","sa");
        pros.setProperty("password","");
        String url = "jdbc:h2:" + server.getURL() + "/" + dbName;
        Connection conn = org.h2.Driver.load().connect(url,pros);

        try{
            conn.createStatement()
                    .execute("CREATE SCHEMA IF NOT EXISTS " + schemaName);
        }finally {
            JdbcUtils.closeSilently(conn);
        }
    }

    @Override
    protected void after(){
        // DBサーバの停止
        server.shutdown();
    }
}
