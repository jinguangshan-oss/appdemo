package com.example.appdemo.mybatis.mapper;

import com.example.appdemo.mybatis.entity.Game;

public interface GameMapper {

    Game getGameByVendorIdAndCode(Game record);

    int insertSelective(Game record);
}
