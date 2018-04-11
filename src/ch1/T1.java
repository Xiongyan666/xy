package ch1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hsqldb.*;

public class T1 {

    public static final int PORT = 9001;
    public static final String DB_NAME = "mydb"; // ���ݿ��ļ�����ͬʱҲ�Ǳ����е����ݿ���
    public static final String DB_PATH = "./db/";
    public static final String USER_NAME = "SA";
    public static final String PASSWORD = "";
    public static final int SERVER_MODE = 0;
    public static final int STAND_ALONE_MODE = 1; // In-Process
    public static int mode = SERVER_MODE; // ��¼��ǰ��ʲôģʽ������ʱ��Server������ʱ��standalone

    /**
     * �������ݿ����
     */
    public static boolean startHSQL() {

        if (mode == SERVER_MODE) {
            if (!T1.isConnected()) {
                Server server = new Server();// ������hsqldb.jar������డ��
                server.setDatabaseName(0, DB_NAME);
                server.setDatabasePath(0, DB_PATH + DB_NAME);
                server.setPort(PORT);
                server.setSilent(true);
                server.setNoSystemExit(true);
                server.start(); // ʵ�ʺ��������ƣ�Ҳ�Ǵ������ݿⲢ��������������ݿ���ڣ���ֱ����������
                System.out.println("hsqldb started...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else if (mode == STAND_ALONE_MODE) {
            // standaloneģʽ�������Ӿ�ͬʱ�������ݿ⣬�����������ʲô������
        }

        return true;
    }

    /**
     * �ر����ݿ����
     */
    public static boolean stopHSQL() {
        try {
            Statement statement = getConnection().createStatement();
            getConnection().close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null,
                    ex);
            return false;
        }
    }

    /**
     * ��ȡ����
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            if (mode == SERVER_MODE) {
                conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:" + PORT + "/" + DB_NAME,USER_NAME, PASSWORD);
            } else if (mode == STAND_ALONE_MODE) {
                conn = DriverManager.getConnection("jdbc:hsqldb:file:"
                        + DB_PATH + DB_NAME, USER_NAME, PASSWORD);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null,
                    ex);
        } catch (SQLException ex) {
            Logger.getLogger(T1.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return conn;
    }

    /**
     * �жϷ������Ƿ��ѿ���
     *
     * @return
     */
    public static boolean isConnected() {
        Connection hsqlConn = T1.getConnection();
        boolean isOpened = false;

        if (hsqlConn == null) {
            return false;
        }
        try {
            isOpened = !hsqlConn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                hsqlConn.close();
            } catch (SQLException e) {
            }
        }
        return isOpened;
    }

}