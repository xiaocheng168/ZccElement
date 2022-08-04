package cn.mc.zcc.manager;

import cn.mc.zcc.info.PlayerInfo;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class PlayerManager {
    public static final HashMap<Player, PlayerInfo> PLAYER_PLAYER_INFO_HASH_MAP = new LinkedHashMap<>();
}
