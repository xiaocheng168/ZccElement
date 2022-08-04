package cn.mc.zcc.listener;

import cn.mc.zcc.entity.RoleBase;
import cn.mc.zcc.info.Element;
import cn.mc.zcc.info.PlayerInfo;
import cn.mc.zcc.manager.PlayerManager;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.C;
import xyz.upperlevel.spigot.book.BookUtil;

import java.util.Map;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new Thread(() -> PlayerManager.addAndLevelPlayer(player)).start();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        new Thread(() -> PlayerManager.addAndLevelPlayer(player)).start();
    }

    @EventHandler
    public void onChat(PlayerSwapHandItemsEvent event) {
        PlayerInfo playerInfo = PlayerManager.PLAYER_PLAYER_INFO_HASH_MAP.get(event.getPlayer().getName());
        BookUtil.BookBuilder bookBuilder = BookUtil.writtenBook();
        bookBuilder.author("zcc");
        bookBuilder.title("title");
        ComponentBuilder componentBuilder = new ComponentBuilder();
        RoleBase role = playerInfo.getUsedRole();
        Element element = role.getElement();
        componentBuilder.append("    角色基本信息 - " + element.getColorName()).append("\n\n");
        componentBuilder.append("§3「" + role.getName() + "」").append("\n");
        componentBuilder.append("基础攻击: " + playerInfo.getUsedRole().getDamage()).append("\n");
        componentBuilder.append("暴击率: " + playerInfo.getUsedRole().getLuck_crit()).append("\n");
        componentBuilder.append("暴击伤害: " + playerInfo.getUsedRole().getCrit()).append("\n");
        componentBuilder.append("§3「元素伤害」").append("\n");
        for (Map.Entry<Element, Float> elementIntegerEntry : role.getElementDamage().entrySet()) {
            Element k = elementIntegerEntry.getKey();
            Float v = elementIntegerEntry.getValue();
            componentBuilder.append(k.getColorName()).append("反应伤害加成: ").append(v.toString()).append("\n");
        }
        bookBuilder.pages(componentBuilder.create());
        ItemStack build = bookBuilder.build();
        BookUtil.openPlayer(event.getPlayer(), build);

    }
}
