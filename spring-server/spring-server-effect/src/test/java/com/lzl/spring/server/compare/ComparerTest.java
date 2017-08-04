package com.lzl.spring.server.compare;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.lzl.spring.server.effect.compare.Comparer;

public class ComparerTest {

	
	@Test
	public void testComapre(){
		List<String> jxc_no_contain=new ArrayList<String>();
		List<String> jxc_no_eq=new ArrayList<String>();
		List<String> erp_no_eq=new ArrayList<String>();
		try {
			File erpFile=new File("C:\\Users\\muck\\Desktop\\erp.log");
			Map<String,String> erpMap=Comparer.getERPSource(erpFile);
			
			File jxcFile=new File("C:\\Users\\muck\\Desktop\\进销存.txt");
			Map<String,String> jxcMap=Comparer.getJXCSource(jxcFile);
			
			
			for (String key : jxcMap.keySet()) {
				if(erpMap.containsKey(key)){
					String jxc_result=jxcMap.get(key);
					String erp_result=erpMap.get(key);
					if(!(jxc_result.split("\\|")[1].equals(erp_result.split("\\|")[1]))){
						System.out.println("channel_id不一致-->进销存:"+jxc_result+"  erp:"+erp_result);
					}
					
					if(!jxc_result.equals(erp_result)){
						jxc_no_eq.add(jxc_result);
						erp_no_eq.add(erp_result);
					}
				}else{
					jxc_no_contain.add(jxcMap.get(key));
				}
			}
			
			/*for (int i=0;i<jxc_no_eq.size();i++) {
				System.out.println("进销存:"+jxc_no_eq.get(i)+" erp:"+erp_no_eq.get(i));
			}
			
			for (String string : jxc_no_contain) {
				System.out.println("erp 中不存在的，但是在进销存存在:"+string);
			}*/
			
			System.out.println("erp size-->"+erpMap.size());
			System.out.println("jxc size-->"+erpMap.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
