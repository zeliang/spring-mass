package com.lzl.spring.server;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class BuildReq {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\muck\\Desktop\\发货预占\\source.txt");
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		for (String string : lines) {
			JSONObject json = new JSONObject();
			String[] array = string.split("\\|");
			String provinceId = array[0];
			json.put("provinceId", Integer.valueOf(provinceId));
			JSONArray ja = new JSONArray();
			for (int i = 1; i < array.length; i++) {
				if (array[i].equals("")) {
					continue;
				}
				JSONObject one = new JSONObject();
				String adddId;
				String isAir;
				try {
					adddId = array[i];
					Integer.valueOf(adddId);
					isAir = "false";
				} catch (Exception e) {
					isAir = "true";
					String tmp = array[i];
					adddId = tmp.split("_")[0];
				}
				one.put("addressId", Integer.valueOf(adddId));
				one.put("isAir", isAir);
				ja.add(one);
			}
			json.put("list", ja);
			System.out.println("[" + JSONObject.toJSONString(json) + "]");
		}
	}
}
