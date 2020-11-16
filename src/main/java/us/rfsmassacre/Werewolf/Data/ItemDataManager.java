package us.rfsmassacre.Werewolf.Data;

import java.util.ArrayList;
import java.util.List;

import us.rfsmassacre.HeavenLib.BaseManagers.ResourceManager;
import us.rfsmassacre.HeavenLib.Managers.ChatManager;
import us.rfsmassacre.Werewolf.WerewolfPlugin;
import us.rfsmassacre.Werewolf.Items.WerewolfItemOld.WerewolfItemType;

public class ItemDataManager extends ResourceManager
{	
	public ItemDataManager(WerewolfPlugin instance) 
	{
		super(instance, "items.yml");
	}
	
	/*
	 * Get item configuration from file of werewolf items.
	 */
	public String getItemName(String name)
	{
		return ChatManager.format(file.getString(name + ".name", defaultFile.getString(name + ".name")));
	}
	public ArrayList<String> getItemLore(String name)
	{
		ArrayList<String> lore = new ArrayList<String>();
		
		List<String> fileLore = file.getStringList(name + ".lore");
		List<String> defaultLore = defaultFile.getStringList(name + ".lore");
		
		if (fileLore != null && !fileLore.isEmpty())
		{
			for (String line : fileLore)
			{
				lore.add(ChatManager.format(line));
			}
		}
		else
		{
			for (String line : defaultLore)
			{
				lore.add(ChatManager.format(line));
			}
		}
		
		return !lore.isEmpty() ? lore : null;
	}
}
