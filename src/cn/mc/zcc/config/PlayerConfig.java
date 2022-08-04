package cn.mc.zcc.config;

import cn.mc.zcc.ElementM;
import cn.mc.zcc.info.PlayerInfo;
import org.bukkit.entity.Player;

import java.io.*;
import java.nio.file.Files;

public class PlayerConfig {
    final Player player;
    final File dataFile;

    public PlayerConfig(Player player) {
        this.player = player;
        dataFile = new File(ElementM.dataDir, this.player.getName() + ".db");
    }

    public boolean isNewPlayer() {
        return !dataFile.isFile();
    }

    //实例化 IO流

    //写出数据
    public void save(PlayerInfo playerInfo) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(dataFile.toPath()));
            objectOutputStream.writeObject(playerInfo);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //读入数据
    public PlayerInfo load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(dataFile.toPath()));
            Object o = objectInputStream.readObject();
            objectInputStream.close();
            return (PlayerInfo) o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
