package com.lzl.spring.server;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class BuildReq {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\muck\\Desktop\\发货预占\\source1024.txt");
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		for (String string : lines) {
			JSONObject json = new JSONObject();
			String[] array = string.split("\\|");
			String provinceId = array[0];
			json.put("province_id", Integer.valueOf(provinceId));
			json.put("operator", "系统批量修改");
			JSONArray ja = new JSONArray();
			for (int i = 1; i < array.length; i++) {
				if (array[i].equals("")) {
					continue;
				}
				JSONObject one = new JSONObject();
				String adddId;
				Integer isAir;
				try {
					adddId = array[i];
					Integer.valueOf(adddId);
					isAir = 0;
				} catch (Exception e) {
					isAir = 1;
					String tmp = array[i];
					adddId = tmp.split("_")[0];
				}
				one.put("address_id", Integer.valueOf(adddId));
				one.put("is_air", isAir);
				ja.add(one);
			}
			json.put("list", ja);
			System.out.println("[" + JSONObject.toJSONString(json) + "]");
		}
	}
}
