package cn.mc.zcc.manager;

import cn.mc.zcc.config.PlayerConfig;
import cn.mc.zcc.entity.EntityElement;
import cn.mc.zcc.info.Element;
import cn.mc.zcc.info.PlayerInfo;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

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

    public static PlayerInfo getPlayerInfo(Player player) {
        return PLAYER_PLAYER_INFO_HASH_MAP.get(player.getName());
    }

    //元素附着触发器
    public static void elementUp(Player player, Element element, EntityElement entityElement) {
        PlayerInfo playerInfo = PLAYER_PLAYER_INFO_HASH_MAP.get(player.getName());
        playerInfo.getUsedRole().elementUpEvent(player, element, entityElement);
    }

    //元素附着触发器
    public static void elementDown(Player player, Element element, EntityElement entityElement) {
        PlayerInfo playerInfo = PLAYER_PLAYER_INFO_HASH_MAP.get(player.getName());
        playerInfo.getUsedRole().elementDownEvent(player, element, entityElement);
    }

    //玩家攻击一个实体事件
    public static void attackEntity(Player player, Entity entity) {
        PlayerInfo playerInfo = PLAYER_PLAYER_INFO_HASH_MAP.get(player.getName());
        playerInfo.getUsedRole().attackEntityEvent(player, entity);
    }
}
