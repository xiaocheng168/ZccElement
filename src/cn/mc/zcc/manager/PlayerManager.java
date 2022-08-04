package cn.mc.zcc.manager;

import cn.mc.zcc.config.PlayerConfig;
import cn.mc.zcc.info.PlayerInfo;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class PlayerManager {
    //在线玩家的信息类
    public static final HashMap<String, PlayerInfo> PLAYER_PLAYER_INFO_HASH_MAP = new LinkedHashMap<>();

    //新玩家加入服务器，初始化玩家角色数据
    //玩家退出保存数据到本地
    public static void addAndLevelPlayer(Player player) {
        PlayerConfig playerConfig = new PlayerConfig(player);
        PlayerInfo playerInfo = new PlayerInfo();
        //如果是新玩家，将给予原版角色
        if (playerConfig.isNewPlayer()) {
            playerInfo.addRole(RoleManager.getRole(1));
            playerInfo.setPlayer(player.getName());
        } else {
            //如果不是新玩家将读入原版的配置文件
            playerInfo = playerConfig.load();
        }
        //无论如何，最后都要保存
        playerConfig.save(playerInfo);
        if (playerInfo.getUsedRole() == null) {
            playerInfo.setUsedRole(playerInfo.getRoles().get(1));
        }
        PLAYER_PLAYER_INFO_HASH_MAP.put(player.getName(), playerInfo);
    }

}
