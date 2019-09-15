package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;


import static entity.Constant.*;

public class ConnectionPool {
    private Vector<Connection> availableConns = new Vector<Connection>();
    private Vector<Connection> usedConns = new Vector<Connection>();

    private static ConnectionPool connectionPool = null;

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            try {
                Class.forName(DRIVER);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < INIT_CONNECTION_COUNT; i++) {
                connectionPool.availableConns.addElement(connectionPool.getConnection());
            }
        }
        return connectionPool;
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public synchronized Connection retrieve() {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }

    public int getCountAvailableConns() {
        return availableConns.size();
    }
}