
package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.DPF.aio.SendBytes;
import cn.com.start.webBack.dto.FindManufDto;
import cn.com.start.webBack.dto.ManufDto;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.service.ManufacturersService;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturersController extends LoggerController {

	@Autowired
	private ManufacturersService manufacturersService;

	/**
	 * 第一次进入查询
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findManufFirst")
	public void findManufFirst(HttpServletRequest request,HttpServletResponse response,
			 Model model) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindManufDto findManufDto = new FindManufDto();
		List<ManufDto> ManufList = manufacturersService.showManufByPage(findManufDto);
		
		ReDto.detail.put("page", ManufList);
		send(response, ReDto);
//		model.addAttribute("page", page);
//		model.addAttribute("roleaction", roleaction);
//		return "//jsp/device/manufactureManage.jsp";
	}
	


//	/**
//	 * 保存查询条件 分页
//	 * 
//	 * @param request
//	 * @param response
//	 * @param addressDto
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/findManufSaveData")
//	public String findManufSaveData(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindManufDto findManufDto)
//			throws IOException {
//		findManufDto.setPageNow(pageNow);
//		findManufDto.setPageSize(pageSize);
//		Page page = manufacturersService.showManufByPage(findManufDto);
//		System.out.println("-------------page--------------"+page);
//		String json = JsonUtil.toJson(page);
//		System.out.println("-------------json--------------"+json);
//		logger.info("findManufSaveData=" + json);
//		return json;
//	}

	/**
	 * 增加厂商
	 * 
	 * @param request
	 * @param addressDto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/addManuf")
	public void addManuf(HttpServletRequest request,HttpServletResponse response, ManufDto manufDto)
			throws IOException {
		JsonReDto ReDto = new JsonReDto();
		int count = manufacturersService.insertManuf(manufDto);
		if (count == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "增加成功！";
			// 获取递增id
			String mfrid = manufacturersService.findMaxid();
			this.addmodel(ReDto,mfrid, manufDto.getMODEL(), manufDto.getCPTYPE(),
					manufDto.getINTERFACECOUNT(), manufDto.getCPPHASE(),
					manufDto.getRATEDPOWER());
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "增加失败！请重试！";
		}
		send(response,ReDto);
	}

	@RequestMapping("/toAddManufactures")
	public String toAddManufactures(Model m) {
		return "//jsp/device/manufactureManageAdd.jsp";
	}
	
	/**
	 * @Title: toAddModel
	 * @Description: TODO 跳转到添加桩类型页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("/toAddModel")
	public String toAddModel(Model m){
		List<CPMfrInfo> mfrnameList = manufacturersService.findMfrname();
		m.addAttribute("mfrnameList", mfrnameList);
		return "//jsp/device/modelAdd.jsp";
	}
	/**
	 * 增加型号
	 * 
	 * @param MFRID
	 * @param MODEL
	 * @param CPTYPE
	 * @param INTERFACECOUNT
	 * @param CPPHASE
	 * @param RATEDPOWER
	 * @return
	 */
	public int addmodel(JsonReDto ReDto,String MFRID, String MODEL, String CPTYPE,
			String INTERFACECOUNT, String CPPHASE, String RATEDPOWER) {
		ManufDto manuf = new ManufDto();
		manuf.setMFRID(MFRID);
		manuf.setMODEL(MODEL);
		manuf.setCPTYPE(CPTYPE);
		manuf.setINTERFACECOUNT(INTERFACECOUNT);
		manuf.setCPPHASE(CPPHASE);
		manuf.setRATEDPOWER(RATEDPOWER);
		int modelcount = manufacturersService.insertModel(manuf);
		if(modelcount == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "增加成功！";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "增加失败！请重试！";
		}
		return modelcount;
	}

	/**
	 * @Title: addModel
	 * @Description: TODO 添加桩类型
	 * @param ReDto
	 * @param MFRID
	 * @param MODEL
	 * @param CPTYPE
	 * @param INTERFACECOUNT
	 * @param CPPHASE
	 * @param RATEDPOWER
	 * @return
	 * @return: int
	 * @throws IOException 
	 */
	@RequestMapping("/addModel")
	public void addModel(HttpServletResponse response,String MFRID, String MODEL, String CPTYPE,
			String INTERFACECOUNT, String CPPHASE, String RATEDPOWER) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		ManufDto manuf = new ManufDto();
		manuf.setMFRID(MFRID);
		manuf.setMODEL(MODEL);
		manuf.setCPTYPE(CPTYPE);
		manuf.setINTERFACECOUNT(INTERFACECOUNT);
		manuf.setCPPHASE(CPPHASE);
		manuf.setRATEDPOWER(RATEDPOWER);
		int modelcount = manufacturersService.insertModel(manuf);
		if(modelcount == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "增加成功！";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "增加失败！请重试！";
		}
		send(response,ReDto);
	}
	
	/**
	 * 查询修改信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 *//*
	@ResponseBody
	@RequestMapping("/findUpdateManuf")
	public String findUpdateManuf(@RequestParam String mfrid,
			@RequestParam String model) throws IOException {
		logger.info("mfrid=" + mfrid + "mdoel=" + model);
		ManufDto manufDto = manufacturersService.findManuf(mfrid, model);
		String json = JsonUtil.toJson(manufDto);
		logger.info("findUpdateManuf=" + json);
		return json;
	}*/
	
	@RequestMapping("/findUpdateManuf")
	public void findUpdateManuf(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String mfrid = request.getParameter("mfrid");
		String model = request.getParameter("model");
		ManufDto manufDto = manufacturersService.findManuf(mfrid,model);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(manufDto);
		// 向页面返回json数据
		System.out.println("-----json-----"+json);
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 修改查询数据
	 * 
	 * @param request
	 * @param manufDto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateManuf")
	public void updateManuf(HttpServletRequest request, HttpServletResponse response,ManufDto manufDto)
			throws IOException {
		JsonReDto ReDto = new JsonReDto();
		int flag = manufacturersService.updateManuf(manufDto);
		int flag2 = manufacturersService.updateModel(manufDto);
		if(flag ==1 && flag2==1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "增加成功！";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "增加失败！请重试！";
		}
		send(response,ReDto);
	}

	/**
	 * 删除选中信息
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteById")
	public void deleteById(HttpServletRequest request,HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String id = request.getParameter("id");
		System.out.println("id-----" + id);
		String ids[] = id.split(";");
		String mfrid = "";
		String model = "";
		String mid = "";
		for (int i = 0; i < ids.length; i++) {
			mid += "," + ids[i];
		}
		String mids[] = mid.substring(2).split(",");
		for (int j = 0; j < mids.length; j++) {
			if (j % 2 == 0) {
				mfrid += "," + mids[j];// 厂商id
			} else {
				model += "," + mids[j];// 桩型号
			}
		}
		String mfrids[] = mfrid.substring(1).split(",");
		int manufcount = manufacturersService.deletemanuf(mfrids);
		// 厂商删除成功后，删除桩型号信息
		if (manufcount > 0) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功!";
			this.del(id);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "删除失败！";
		}
		send(response, ReDto);
	}
	/**
	 * 删除型号
	 * @throws IOException 
	 */
	@RequestMapping("/deleteModel")
	public void deleteModel(HttpServletRequest request,HttpServletResponse response,Model Model) throws IOException {
		 JsonReDto ReDto = new JsonReDto();
		 String model = request.getParameter("MODEL");
		 String id = request.getParameter("id");
		 int result = this.del(id);
		 String DELETERESULT = "";
		 if (result == 0) {
		 	manufacturersService.deleteMfr(model,id);
		 	ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功!";
		 }else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "删除失败！";
		 }
		 Model.addAttribute("DELETERESULT", DELETERESULT);
		 send(response,ReDto);
	}
	
	/**
	 * 删除桩型号
	 * 
	 * @param id
	 * @return
	 */
	public int del(String id) {
		String mid = "";
		String ids[] = id.replaceAll(",", "").split(";");
		for (int i = 0; i < ids.length; i++) {
			mid += "," + ids[i];
		}
		String mids[] = mid.substring(2).split(",");
		int modelcount = manufacturersService.deletemodel(mids);
		return modelcount;
	}
//*****************************************************************************************//
	/**
	 * 根据厂商ID查找型号
	 */
	@RequestMapping("/findModelByMfr")
	@ResponseBody
	public String findModelByMfr(@RequestParam String MFRID) throws IOException {
		List<String> modelList = manufacturersService.findModelByMfr(MFRID);
		
		List<Map<String, String>> zzList = new ArrayList();
		for (int i = 0; i < modelList.size(); i++) {
			Map<String, String> zzMap = new HashMap();
			zzMap.put("model", modelList.get(i));
			zzList.add(zzMap);
		}
		String json = JsonUtil.toJson(zzList);
		logger.info("findModelByMfr" + json);
		return json;
	}
	
	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		logger.info(json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();

	}
}
