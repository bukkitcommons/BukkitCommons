package cc.bukkit.chat;

import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import cc.bukkit.item.ItemJson;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

public class TellrawJson {
	
	ComponentBuilder builder;
	boolean setupedHover = false; // Tellraw limit
	boolean setupedClick = false; // Tellraw limit
	
	public TellrawJson() {
		
	}
	
	public static TellrawJson create() { // Actually this only for easy to use so i create this static method
		return new TellrawJson();
	}
	
	public TellrawJson text(String text) {
		this.builder.append(text);
		return this;
	}
	
	public TellrawJson link(TellrawJson tellrawJson) {
		this.builder.append(tellrawJson.getCuttentComponentBuilder().create());
		return this;
	}
	
	public TellrawJson hoverText(String text) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,new ComponentBuilder(text).create()));
		return this;
	}
	
	public TellrawJson hoverItem(ItemStack iStack) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		try {
			this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_ITEM, new ComponentBuilder(ItemJson.saveJsonfromNMS(iStack)).create()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public TellrawJson hoverAchievement(String achievement) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_ACHIEVEMENT,new ComponentBuilder(achievement).create()));
		return this;
	}
	public TellrawJson hoverEntity(String entity) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_ACHIEVEMENT,new ComponentBuilder(entity).create()));
		return this;
	}
	
	public TellrawJson clickCommand(String cmd) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, cmd));
		return this;
	}
	public TellrawJson clickSuggest(String cmd) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, cmd));
		return this;
	}
	public TellrawJson clickURL(String url) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, url));
		return this;
	}
	public TellrawJson clickPage(String page) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.CHANGE_PAGE, page));
		return this;
	}
	public TellrawJson clickFile(String file) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_FILE, file));
		return this;
	}
	public TellrawJson color(net.md_5.bungee.api.ChatColor color) {
		this.builder.color(color);
		return this;
	}
	public TellrawJson setBold(boolean bold) {
		this.builder.bold(bold);
		return this;
	}
	public TellrawJson setItalic(boolean italic) {
		this.builder.italic(italic);
		return this;
	}
	public TellrawJson setObfuscated(boolean obfuscated) {
		this.builder.obfuscated(obfuscated);
		return this;
	}
	public TellrawJson setUnderlined(boolean underlined) {
		this.builder.underlined(underlined);
		return this;
	}
	public TellrawJson setBold() {
		this.builder.bold(true);
		return this;
	}
	public TellrawJson setItalic() {
		this.builder.italic(true);
		return this;
	}
	public TellrawJson setObfuscated() {
		this.builder.obfuscated(true);
		return this;
	}
	public TellrawJson setUnderlined() {
		this.builder.underlined(true);
		return this;
	}
	public TellrawJson reset() {
		this.builder.reset();
		return this;
	}
	public TellrawJson getCurrentTellrawJson() {
		return this;
	}
	public ComponentBuilder getCuttentComponentBuilder() {
		return this.builder;
	}
	public void send(CommandSender sender) {
		sender.spigot().sendMessage(builder.create());
	}
}
