package com.lzl.spring.server.compare;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.lzl.spring.server.effect.compare.Comparer;

public class ComparerTest {

	public void testComapre() {
		List<String> jxc_no_contain = new ArrayList<String>();
		List<String> jxc_no_eq = new ArrayList<String>();
		List<String> erp_no_eq = new ArrayList<String>();
		try {
			File erpFile = new File("C:\\Users\\muck\\Desktop\\originss.txt");
			Map<String, String> erpMap = Comparer.getERPSource(erpFile);

			File jxcFile = new File("C:\\Users\\muck\\Desktop\\进销存.txt");
			Map<String, String> jxcMap = Comparer.getJXCSource(jxcFile);

			for (String key : jxcMap.keySet()) {
				if (erpMap.containsKey(key)) {
					String jxc_result = jxcMap.get(key);
					String erp_result = erpMap.get(key);
					if (!(jxc_result.split("\\|")[1].equals(erp_result.split("\\|")[1]))) {
						System.out.println("channel_id不一致-->进销存:" + jxc_result + "  erp:" + erp_result);
					}

					if (!jxc_result.equals(erp_result)) {
						jxc_no_eq.add(jxc_result);
						erp_no_eq.add(erp_result);
					}
				} else {
					jxc_no_contain.add(jxcMap.get(key));
				}
			}

			/*
			 * for (int i=0;i<jxc_no_eq.size();i++) {
			 * System.out.println("进销存:"+jxc_no_eq
			 * .get(i)+" erp:"+erp_no_eq.get(i)); }
			 * 
			 * for (String string : jxc_no_contain) {
			 * System.out.println("erp 中不存在的，但是在进销存存在:"+string); }
			 */

			System.out.println("erp size-->" + erpMap.size());
			System.out.println("jxc size-->" + erpMap.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testSql() {
		try {
			File file = new File("C:\\Users\\muck\\Desktop\\originss.txt");
			List<String> lines = FileUtils.readLines(file, "UTF-8");
			for (String string : lines) {
				String[] splits = string.split("\\|");
				System.out
						.println("update sale_db.t_purchase_instock_detail set Fmark='erp初始数据11', Fmodify_time=Fmodify_time,Fline_num="
								+ splits[3]
								+ ",Fshipment_num="
								+ splits[4]
								+ ",Fdistribution_num="
								+ splits[5]
								+ " where Flogic_id='"
								+ splits[0]
								+ "' and Fstock_address_id="
								+ splits[1]
								+ " and Fserial_id='" + splits[2] + "' and Fline_num =0;");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testNull() {
		Set<Integer> bb = new HashSet<Integer>();
		bb.add(1);
		bb.add(2);
		bb.add(3);

		if (bb.contains(null)) {
			System.out.println(222);
		} else {
			System.out.println(11111111);
		}
	}
}
