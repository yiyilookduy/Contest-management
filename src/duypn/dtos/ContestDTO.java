/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.dtos;

import duypn.daos.DistrictDAO;
import duypn.daos.ProvinceDAO;
import duypn.daos.WardDAO;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author duypnse63523
 */
public class ContestDTO {
    int contestId,provinceId,districtId,wardId;
    String contestName, address,status, description;
    float totalPrice;
    Timestamp startTime, endTime;

    public ContestDTO() {
    }

    
    
    public ContestDTO(int contestId, int provinceId, int districtId, int wardId, String contestName, String address, float totalPrice, Timestamp startTime, Timestamp endTime) {
        this.contestId = contestId;
        this.provinceId = provinceId;
        this.districtId = districtId;
        this.wardId = wardId;
        this.contestName = contestName;
        this.address = address;
        this.totalPrice = totalPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ContestDTO(int contestId, int provinceId, int districtId, int wardId, String contestName, String address, String status, float totalPrice, Timestamp startTime, Timestamp endTime) {
        this.contestId = contestId;
        this.provinceId = provinceId;
        this.districtId = districtId;
        this.wardId = wardId;
        this.contestName = contestName;
        this.address = address;
        this.status = status;
        this.totalPrice = totalPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
    
}
