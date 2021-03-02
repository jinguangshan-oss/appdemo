package com.example.appdemo.mybatis.entity;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable {
    private Long id;

    private Integer vendorId;

    private Integer gameKindId;

    private String code;

    private String name;

    private Byte status;

    private Byte openMode;

    private Byte pc;

    private Byte h5;

    private Byte ios;

    private Byte android;


    private String pictureUrl;

    private JSONArray lang;

    private String remark;

    //@JsonIgnore
    private Date createdAt;
    //@JsonIgnore
    private Date updatedAt;
    //@JsonIgnore
    private Date deletedAt;

    private Integer sort;

    private String platform;

    private String operator;

    private Byte delFlag;

    private static final long serialVersionUID = 1L;

    public Game(Long id, Integer vendorId, Integer gameKindId, String code, String name, Byte status, Byte openMode, Byte pc, Byte ios,Byte android, Byte h5, String pictureUrl, JSONArray lang, String remark, Date createdAt, Date updatedAt, Date deletedAt,String platform,Integer sort,String operator, Byte delFlag) {
        this.id = id;
        this.vendorId = vendorId;
        this.gameKindId = gameKindId;
        this.code = code;
        this.name = name;
        this.status = status;
        this.openMode = openMode;
        this.pc = pc;
        this.h5 = h5;
        this.ios = ios;
        this.android = android;
        this.pictureUrl = pictureUrl;
        this.lang = lang;
        this.remark = remark;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.platform = platform;
        this.sort = sort;
        this.operator = operator;
        this.delFlag = delFlag;
    }


    public Byte getOpenMode() {
        return openMode;
    }

    public void setOpenMode(Byte openMode) {
        this.openMode = openMode;
    }

    public Game() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getGameKindId() {
        return gameKindId;
    }

    public void setGameKindId(Integer gameKindId) {
        this.gameKindId = gameKindId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getPc() {
        return pc;
    }

    public void setPc(Byte pc) {
        this.pc = pc;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public JSONArray getLang() {
        return lang;
    }

    public void setLang(JSONArray lang) {
        this.lang = lang;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Byte getH5() {
        return h5;
    }

    public void setH5(Byte h5) {
        this.h5 = h5;
    }

    public Byte getIos() {
        return ios;
    }

    public void setIos(Byte ios) {
        this.ios = ios;
    }

    public Byte getAndroid() {
        return android;
    }

    public void setAndroid(Byte android) {
        this.android = android;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Game other = (Game) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getVendorId() == null ? other.getVendorId() == null : this.getVendorId().equals(other.getVendorId()))
                && (this.getGameKindId() == null ? other.getGameKindId() == null : this.getGameKindId().equals(other.getGameKindId()))
                && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getPc() == null ? other.getPc() == null : this.getPc().equals(other.getPc()))
                && (this.getH5() == null ? other.getH5() == null : this.getH5().equals(other.getH5()))
                && (this.getIos() == null ? other.getIos() == null : this.getIos().equals(other.getIos()))
                && (this.getAndroid() == null ? other.getAndroid() == null : this.getAndroid().equals(other.getAndroid()))
                && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
                && (this.getLang() == null ? other.getLang() == null : this.getLang().equals(other.getLang()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
                && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
                && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()))
                && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
                && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVendorId() == null) ? 0 : getVendorId().hashCode());
        result = prime * result + ((getGameKindId() == null) ? 0 : getGameKindId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPc() == null) ? 0 : getPc().hashCode());
        result = prime * result + ((getH5() == null) ? 0 : getH5().hashCode());
        result = prime * result + ((getIos() == null) ? 0 : getIos().hashCode());
        result = prime * result + ((getAndroid() == null) ? 0 : getAndroid().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getLang() == null) ? 0 : getLang().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());

        return result;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}