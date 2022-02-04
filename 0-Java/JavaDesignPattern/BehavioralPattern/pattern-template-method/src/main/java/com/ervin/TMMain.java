package com.ervin;

import com.ervin.templatemethod.AbstractSetting;
import com.ervin.templatemethod.LocalSetting;
import com.ervin.templatemethod.RedisSetting;

public class TMMain {

	public static void main(String[] args) throws Exception {
		AbstractSetting setting1 = new LocalSetting();
		System.out.println("test = " + setting1.getSetting("test"));
		System.out.println("test = " + setting1.getSetting("test"));
		AbstractSetting setting2 = new RedisSetting();
		System.out.println("autosave = " + setting2.getSetting("autosave"));
		System.out.println("autosave = " + setting2.getSetting("autosave"));
	}
}
