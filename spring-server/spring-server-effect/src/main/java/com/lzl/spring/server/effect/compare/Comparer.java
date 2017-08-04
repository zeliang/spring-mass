package com.lzl.spring.server.effect.compare;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class Comparer {
	
	public static  Map<String,String> getJXCSource(File file) throws Exception{
		Map<String,String> result=new HashMap<String,String>();
		List<String> lines=FileUtils.readLines(file,"UTF-8");
		for (String string : lines) {
			String[] splits=string.split("\\|");
			String serial_id=splits[0];
			String channel_id=splits[1];
			String material=splits[2];
			String channel_id1=splits[3];
			String channel_id2=splits[4];
			String channel_id3=splits[5];
			if(result.containsKey(serial_id)){
				throw new Exception("重复 主数据，serial_id："+serial_id);
			}else{
				if(material.equals("")){
					material="0";
				}
				
				if(channel_id1.equals("")){
					channel_id1="0";
				}
				if(channel_id2.equals("")){
					channel_id2="0";
				}
				if(channel_id3.equals("")){
					channel_id3="0";
				}
				
				result.put(serial_id, serial_id+"|"+channel_id+"|"+material+"|"+channel_id1+"|"+channel_id2+"|"+channel_id3);
			}
		}
		return result;
	}
	
	
	public static Map<String,String> getERPSource(File file) throws Exception{
		Map<String,String> result=new HashMap<String,String>();
		List<String> lines=FileUtils.readLines(file,"UTF-8");
		for (String string : lines) {
			if(string.endsWith("|")){
				string=string+"0";
			}
			try {
				String[] splits=string.split("\\|");
				String serial_id=splits[0];
				String channel_id=splits[1];
				String material=splits[2];
				String channel_id1=splits[3];
				String channel_id2=splits[4];
				String channel_id3=splits[5];
				if(result.containsKey(serial_id)){
					throw new Exception("重复 主数据，serial_id："+serial_id);
				}else{
					if(material.equals("")){
						material="0";
					}
					
					if(channel_id1.equals("")){
						channel_id1="0";
					}
					if(channel_id2.equals("")){
						channel_id2="0";
					}
					if(channel_id3.equals("")){
						channel_id3="0";
					}
					
					result.put(serial_id, serial_id+"|"+channel_id+"|"+material+"|"+channel_id1+"|"+channel_id2+"|"+channel_id3);
				}
			} catch (Exception e) {
				System.out.println("异常："+string);
				e.printStackTrace();
			}
			
		}
		return result;
	}
}
