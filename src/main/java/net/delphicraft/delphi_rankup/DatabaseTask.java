package net.delphicraft.delphi_rankup;

import com.google.inject.Inject;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTask extends BukkitRunnable {

    // set plugin instance
    private final JavaPlugin plugin;
    public DatabaseTask(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    // set vars
    private Connection connection;
    private String host = this.plugin.getConfig().getString("database.host");
//    private String database = plugin.getConfig().getString("database.database");
//    private String username = plugin.getConfig().getString("database.username");
//    private String password = plugin.getConfig().getString("database.password");
//    private Integer port = plugin.getConfig().getInt("database.port");

    plugin.getServer().broadcastMessage(host);

//    private String host = "localhost";
    private String database = "delphi_rankups";
    private String username = "root";
    private String password = "";
    private Integer port = 3306;

    public void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host  + ":" + this.port + "/" + this.database + "?autoReconnect=true&useSSL=false", this.username, this.password);
            plugin.getServer().broadcastMessage("Connected to database");
        }
    }


    @Override
    public void run() {
        try {
            openConnection();
            Statement statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
}
