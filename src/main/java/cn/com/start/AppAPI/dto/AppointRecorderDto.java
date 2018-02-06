package cn.com.start.AppAPI.dto;

/**
 * Created by user on 2017/3/8.
 */
public class AppointRecorderDto {
    public String appointId;
    public String cpUserId;
    public String cpId;
    public String appointChargingTime;
    public String endTime;
    public int appointResult;
    public int appointState;

    @Override
    public String toString() {
        return "AppointRecorderDto{" +
                "appointId='" + appointId + '\'' +
                ", cpUserId='" + cpUserId + '\'' +
                ", cpId='" + cpId + '\'' +
                ", appointChargingTime='" + appointChargingTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", appointResult=" + appointResult +
                ", appointState=" + appointState +
                '}';
    }


    public String getAppointId() {
        return appointId;
    }

    public void setAppointId(String appointId) {
        this.appointId = appointId;
    }

    public String getCpUserId() {
        return cpUserId;
    }

    public void setCpUserId(String cpUserId) {
        this.cpUserId = cpUserId;
    }

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getAppointChargingTime() {
        return appointChargingTime;
    }

    public void setAppointChargingTime(String appointChargingTime) {
        this.appointChargingTime = appointChargingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getAppointResult() {
        return appointResult;
    }

    public void setAppointResult(int appointResult) {
        this.appointResult = appointResult;
    }

    public int getAppointState() {
        return appointState;
    }

    public void setAppointState(int appointState) {
        this.appointState = appointState;
    }
}
