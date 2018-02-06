package cn.com.start.AppAPI.controller;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.start.AppAPI.dto.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.AppAPI.service.UserManagerService;
import cn.com.start.AppAPI.util.Constant;
import cn.com.start.AppAPI.util.RegisterCoderMap;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * @author caijie
 */
@Controller
@RequestMapping("/userManager")
public class UserManager {
    private static Logger logger = LogManager.getLogger("LOG_API");

    @Autowired
    private UserManagerService userManager;

    /**
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/registerUser")
    public void registerUser(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String code = request.getParameter("code");

        //han 在什么时候set的值
        String realCode = (String) RegisterCoderMap.codeMap.get(phone);
        logger.info("phone:" + phone + "realCode:" + realCode + "Code:"
                + code);

//        if (realCode != null && realCode.equals(code)) {
        if(userManager.isExistPhone(phone) == 0){
            long currentTime = System.currentTimeMillis();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            StringBuffer sb = new StringBuffer();
            SimpleDateFormat ms = new SimpleDateFormat("yyyy-MM-dd");
            String[] day = ms.format(new Date(currentTime)).split("-");
            String phoneNumberPart1 = phone.substring(0, 4);
            String phoneNumberPart2 = phone.substring(7, phone.length());
            //手机号+yyyy-MM-dd 16位
            sb.append(phoneNumberPart1).append(phoneNumberPart2).append(day[0]).append(day[1]).append(day[2]);

            RegisterUserDto dto = new RegisterUserDto();
            dto.CPUSERID = sb.toString();
            dto.PHONE = phone;
            dto.CPUSERNAME = phone;
            dto.PASSWORD = password;
            dto.REGTIME = sf.format(new Date(currentTime));
            dto.VALIDFLAG = 1;

            userManager.registerUser(dto);

            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "registerUser success";
        } else {
            // 验证码错误
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "code error";
        }

        UserManager.send(response, ReDto);
    }

    /**
     * 忘记密码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/resetPassword")
    public void resetPassword(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String code = request.getParameter("code");

        String realCode = (String) RegisterCoderMap.codeMap.get(phone);
        if (realCode != null && realCode.equals(code)) {
            userManager.resetPassword(phone, password);
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "resetPassword success";
        } else {
            // 验证码错误
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "code error";
        }
        UserManager.send(response, ReDto);
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/loginUser")
    public void loginUser(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        List<CpuserInfoDto> userInfo = userManager.loginUser(phone, password);

        logger.info("phone:" + phone + ",password:" + password);


        if (userInfo != null) {
            if (userInfo.size() > 0) {
                logger.info(request.getRequestURI() + ","
                        + request.getRequestURL().toString());

                RegisterCoderMap.codeMap.remove(phone);

                ReDto.returnCode = 0;
                ReDto.errorCode = "";
                ReDto.message = "loginUser success";
                ReDto.detail.put("userInfo", userInfo);
            } else {
                logger.info("没有查到数据");
                ReDto.returnCode = 1;
                ReDto.errorCode = "";
                ReDto.message = "用户名或密码错误";
            }

        } else {
            logger.info("userInfo == null");
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "用户名或密码错误";
        }

        UserManager.send(response, ReDto);
    }

    /**
     * 忘记密码获取验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/repasswordByCode")
    public void repasswordByCode(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        JsonReDto ReDto = new JsonReDto();
        if (userManager.isExistPhone(phone) != 0) {
            getRegisterCoder(phone);

            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "repasswordByCode success";
        } else {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "手机号没有注册";
        }

        UserManager.send(response, ReDto);
    }

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getRegisterCoder")
    public void getRegisterCoder(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        JsonReDto ReDto = new JsonReDto();
        if (userManager.isExistPhone(phone) == 0) {
//            getRegisterCoder(phone);

            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "getRegisterCoder success";
        } else {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "手机号已经注册";
        }
        UserManager.send(response, ReDto);
    }


    /**
     * 充电记录
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/chargeRecorderByUserId")
    public void chargeRecorderByUserId(HttpServletRequest request,
                                       HttpServletResponse response) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        String userId = request.getParameter("userId");

        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.message = Constant.PARAM_ERROR_STRING;

            UserManager.send(response, ReDto);
            return;
        }

        List<UserChargeRecorder> chargeRecorder = userManager
                .chargeRecorderByUserId(userId);

        if (chargeRecorder != null && chargeRecorder.size() > 0) {
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "chargeRecorderByUserId success";
            ReDto.detail.put("chargeRecorder", chargeRecorder);
        } else {
            ReDto.returnCode = 1;
            ReDto.errorCode = Constant.NO_DATA_STRING;
            ReDto.message = "chargeRecorderByUserId failed";
        }

        UserManager.send(response, ReDto);
    }

    /**
     * 上传头像
     *
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/uploadPortrait")
    public void uploadPortrait(HttpServletRequest request,
                               HttpServletResponse response) throws IllegalStateException,
            IOException {
        JsonReDto ReDto = new JsonReDto();
        String userId = request.getParameter("userId");

        request.setCharacterEncoding("utf-8"); // 设置编码
        // 获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        File file = new File(Constant.UPLOAD_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        factory.setRepository(new File(Constant.UPLOAD_PATH));
        // 设置 缓存的大小
        factory.setSizeThreshold(1024 * 1024);
        // 文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            // 可以上传多个文件
            List<FileItem> list = upload.parseRequest(request);

            if (list != null) {
                logger.info("list.size:" + list.size());

                for (FileItem item : list) {
                    // 获取属性名字
                    String name = item.getFieldName();
                    // 如果获取的 表单信息是普通的 文本 信息
                    if (item.isFormField()) {
                        // 获取用户具体输入的字符串,因为表单提交过来的是 字符串类型的
                        String value = item.getString();
                        logger.info("value:" + value);
                        request.setAttribute(name, value);
                    } else {
                        // 获取路径名
                        String value = item.getName();

                        logger.info("size:" + item.getSize());

                        // 索引到最后一个反斜杠
                        int start = value.lastIndexOf("\\");
                        // 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
                        String filename = value.substring(start + 1);
                        request.setAttribute(name, filename);
                        // 写到磁盘上
                        item.write(new File(Constant.UPLOAD_PATH, filename));// 第三方提供的

                        // 更新头像URL
                        String url = request.getRemoteHost()
                                + "/UserMysql/images/" + filename;
                        logger.info("url:" + url);
                        userManager.updateHeadUrl(userId, url);

                        logger.info("上传成功：" + filename);
                        // response.getWriter().print(filename);// 将路径返回给客户端

                        ReDto.returnCode = 0;
                        ReDto.errorCode = "";
                        ReDto.message = "上传成功";
                        UserManager.send(response, ReDto);
                    }
                }
            }
        } catch (Exception e) {
            logger.info("上传失败");
            // response.getWriter().print("上传失败：" + e.getMessage());

            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "上传失败";
            UserManager.send(response, ReDto);
        }
    }

    /**
     * 更新个人资料
     *
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/updateProfile")
    public void updateProfile(HttpServletRequest request,
                              HttpServletResponse response) throws IllegalStateException,
            IOException {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String carNumber = request.getParameter("plateNumber");
        String carCode = request.getParameter("IdentificationCode");
        String codeMode = request.getParameter("codeMode");
        JsonReDto ReDto = new JsonReDto();

        if (userId == null || name == null || sex == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = "参数错误";

            System.out.println("参数错误");

            UserManager.send(response, ReDto);
            return;
        }

        if (codeMode != null) {
            name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            if (carNumber != null)
                carNumber = new String(carNumber.getBytes("ISO-8859-1"), "UTF-8");
        }

        logger.info("userName:" + name);

        UserProfileInfoDto dto = new UserProfileInfoDto();
        dto.CPUSERID = userId;
        dto.CPUSERNAME = name;
        dto.SEX = sex;
        dto.PLATENUMBER = carNumber;
        dto.VIN = carCode;


        System.out.println(dto.toString());

        userManager.updateProfile(dto);

        ReDto.returnCode = 0;
        ReDto.errorCode = "";
        ReDto.message = "updateProfile success";

        UserManager.send(response, ReDto);
    }

    /**
     * 获取个人资料
     *
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/loadProfile")
    public void loadProfile(HttpServletRequest request,
                            HttpServletResponse response) throws IllegalStateException,
            IOException {
        String userId = request.getParameter("userId");
        JsonReDto ReDto = new JsonReDto();
        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.message = Constant.PARAM_ERROR_STRING;

            UserManager.send(response, ReDto);
            return;
        }

        List<CpuserInfoDto> info = userManager.loadProfile(userId);
        System.out.println(info.toString());

        if (info != null && info.size() > 0) {
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "updateProfile success";
            ReDto.detail.put("userInfo", info);
        } else {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "updateProfile failed";
        }

        UserManager.send(response, ReDto);
    }

    /**
     * 微信充值记录
     *
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/loadAccountInfo")
    public void loadAccountInfo(HttpServletRequest request,
                                HttpServletResponse response) throws IllegalStateException,
            IOException {
        String userId = request.getParameter("userId");
        JsonReDto ReDto = new JsonReDto();
        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.message = Constant.PARAM_ERROR_STRING;

            UserManager.send(response, ReDto);
            return;
        }

        List<WechatResultDto> info = userManager.loadAccountInfo(userId);

        if (info != null && info.size() > 0) {
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "loadAccountInfo success";
            ReDto.detail.put("recorder", info);
        } else {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "loadAccountInfo failed";
        }
        UserManager.send(response, ReDto);
    }

    /**
     * 获取用户充电状态
     *
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/getUserState")
    public void getUserState(HttpServletRequest request,
                             HttpServletResponse response) throws IllegalStateException,
            IOException {
        String userId = request.getParameter("userId");
        UserChargeStateDto ReDto = new UserChargeStateDto();
        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.message = Constant.PARAM_ERROR_STRING;

            UserManager.send(response, ReDto);
            return;
        }

        String state = userManager.getUserState(userId);

        if (state != null) {
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "getUserState success";
            ReDto.chargeState = state;
        } else {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "getUserState failed";
        }
        UserManager.send(response, ReDto);

    }

    /**
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/getAppointRecorder")
    public void getAppointRecorder(HttpServletRequest request,
                                   HttpServletResponse response) throws IllegalStateException,
            IOException {
        String userId = request.getParameter("userId");
        JsonReDto ReDto = new JsonReDto();
        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.message = Constant.PARAM_ERROR_STRING;

            UserManager.send(response, ReDto);
            return;
        }

        List<AppointRecorderDto> recordInfoDto = userManager.getAppointRecorder(userId);
        if (recordInfoDto != null) {
            ReDto.returnCode = 0;
            ReDto.message = "成功获取预约记录";
            ReDto.detail.put("recordInfoDto", recordInfoDto);
        } else {
            ReDto.returnCode = 1;
            ReDto.message = "获取失败";
        }


        UserManager.send(response, ReDto);
    }

    /**
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/setAppointRecorder")
    public void setAppointRecorder(HttpServletRequest request,
                                   HttpServletResponse response) throws IllegalStateException,
            IOException {
        String userId = request.getParameter("userId");
        String cpId = request.getParameter("cpId");
        JsonReDto ReDto = new JsonReDto();
        if (userId == null || cpId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.message = Constant.PARAM_ERROR_STRING;

            UserManager.send(response, ReDto);
            return;
        }

        //不可预约，余额不足
        List<CpuserInfoDto> userInfo = userManager.loadProfile(userId);
        if (userInfo != null && userInfo.size() > 0) {
            String sum = userInfo.get(0).accountSum;
            if (sum != null) {
                if (Integer.valueOf(sum) < 1) {
                    ReDto.returnCode = Constant.REMAIN_ERROR;
                    ReDto.message = "余额不足";

                    UserManager.send(response, ReDto);
                    return;
                }
            }
        }

        long curTime = System.currentTimeMillis();
        long endTime = curTime + 30 * 60 * 1000L;
        AppointRecorderDto recordInfoDto = new AppointRecorderDto();
        recordInfoDto.cpUserId = userId;
        recordInfoDto.cpId = cpId;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        recordInfoDto.appointChargingTime = sf.format(new Date(curTime));
        recordInfoDto.endTime = sf.format(new Date(endTime));
        recordInfoDto.appointResult = 0;//0:成功，1:取消
        recordInfoDto.appointState = 0;//0:预约，1：取消 2：成功结束

        userManager.insertAppointRecorder(recordInfoDto);
        ReDto.returnCode = 0;
        ReDto.errorCode = "";
        ReDto.message = "insertAppointRecorder success";
        UserManager.send(response, ReDto);
    }

    /**
     * @param phone
     */
    private void getRegisterCoder(String phone) {
        String code = (int) (Math.random() * 9000 + 1000) + "";
        logger.info("phone:" + phone + "code:" + code);
        RegisterCoderMap.codeMap.put(phone, code);

        TaobaoClient client = new DefaultTaobaoClient(
                "http://gw.api.taobao.com/router/rest", "23561085",
                "1fd5d541fdb499021adaba90c273b035");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("山西尚宽电气集团");
        req.setSmsParamString("{\"code\":\"" + code
                + "\",\"product\":\"山西尚宽电气集团\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_33585202");

        try {
            AlibabaAliqinFcSmsNumSendResponse rsp;
            rsp = client.execute(req);
            logger.info(rsp.getBody());
        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/updateVersion")
    public void updateVersion(HttpServletRequest request,
                              HttpServletResponse response) throws IllegalStateException,
            IOException {
        JsonReDto ReDto = new JsonReDto();
        if(false){
            ReDto.returnCode = 0;
            ReDto.message = Constant.UPDATE_VERSION_URL;
        }else{
            ReDto.returnCode = 1;
            ReDto.message = Constant.UPDATE_VERSION_MESSAGE;

        }
        UserManager.send(response, ReDto);
    }


    public static <T> void send(HttpServletResponse response, T ReDto)
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
