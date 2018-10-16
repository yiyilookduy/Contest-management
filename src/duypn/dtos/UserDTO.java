/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.dtos;

/**
 *
 * @author duypnse63523
 */
public class UserDTO {
    private String username, firstname, lastname,phone,address,type;
    private int provinceId,districtId,wardId,totalEvent;

    public UserDTO() {
    }

    public UserDTO(String username, String firstname, String lastname, String phone, String address, String type, int provinceId, int districtId, int wardId, int totalEvent) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.provinceId = provinceId;
        this.districtId = districtId;
        this.wardId = wardId;
        this.totalEvent = totalEvent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getTotalEvent() {
        return totalEvent;
    }

    public void setTotalEvent(int totalEvent) {
        this.totalEvent = totalEvent;
    }
    
    public String getFullname(){
        return firstname+" "+lastname;
    }
}
