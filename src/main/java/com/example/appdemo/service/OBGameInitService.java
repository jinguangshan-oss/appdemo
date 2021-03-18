package com.example.appdemo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.appdemo.mybatis.entity.Game;
import com.example.appdemo.mybatis.entity.GameTags;
import com.example.appdemo.mybatis.mapper.GameMapper;
import com.example.appdemo.bean.LangObj;
import com.example.appdemo.mybatis.mapper.GameTagsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class OBGameInitService {

    @Autowired
    GameMapper gameMapper;

    @Autowired
    GameTagsMapper gameTagsMapper;

    @Value(value = "${flag.ob-game}")
    boolean gameFlag;

    @Value(value = "${flag.ob-tag}")
    boolean tagFlag;

    @PostConstruct
    @Transactional
    public void init() throws Exception{
        //开关
        if(!gameFlag) return;

        //读取json文本
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\mujun\\games\\obqp\\obqp.txt"));
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);

        //遍历json文本
        JSONObject mainObject = JSONObject.parseObject(new String(bytes));
        JSONArray jsonArray = mainObject.getJSONArray("games");

        //*************************************************************************游戏************************************************************************************
        //开关
        if(gameFlag){
            for (int i = 0; i < jsonArray.size() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Game game = new Game();
                game.setVendorId(96);
                game.setGameKindId(3);//1-电子游艺,,2-体育赛事,,3-棋牌游戏,,4-彩票游戏,,5-真人视讯,,6-电子竞技,,7-捕鱼,
                game.setCode(jsonObject.getString("gameId"));
                game.setName(jsonObject.getString("gameName"));
                game.setStatus(new Byte("1"));
                game.setOpenMode(new Byte("0"));
                game.setPc(new Byte("1"));
                game.setH5(new Byte("1"));
                game.setIos(new Byte("1"));
                game.setAndroid(new Byte("1"));
                //game.setPictureUrl();
                List<LangObj> langObjList = new ArrayList<>();
                langObjList.add(new LangObj("zh",jsonObject.getString("gameName")));
                game.setLang(JSONArray.parseArray(JSON.toJSONString(langObjList)));
                //game.setRemark();
                //game.setCreatedAt();
                //game.setUpdatedAt();
                //game.setDeletedAt();
                game.setSort(0);
                //game.setPlatform();
                game.setOperator("jinguangshan");
                game.setDelFlag(new Byte("0"));
                gameMapper.insertSelective(game);//插入游戏到数据库
            }
        }

        //*************************************************************************标签************************************************************************************
        //开关
        if(tagFlag) {
            //1-电子游艺,,2-体育赛事,,5-棋牌游戏,,8-彩票游戏,,9-视讯直播,,11-电竞赛事,,25-捕鱼,,55-骰宝,,57-老虎机,,58-时时彩,,59-11选5,,60-快三,,61-PK10,,90-YOPLAY,,91-桌面游戏,,92-电子其他,,93-休闲游戏,,94-街机游戏,,95-测试,,96-测试,,97-2,,98-网球游戏,
            for (int i = 0; i < jsonArray.size() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //查找对应游戏
                Game param = new Game();
                param.setVendorId(96);
                param.setCode(jsonObject.getString("gameId"));
                Game game = gameMapper.getGameByVendorIdAndCode(param);
                //插入对应tag
                GameTags gameTags = new GameTags();
                gameTags.setGameId(Integer.valueOf(game.getId().toString()));
                gameTags.setDelFlag(new Byte("0"));
                gameTags.setTagsId(5);
                gameTags.setOperator("jingaungshan");
                gameTagsMapper.insert(gameTags);
                //gameTags.setCreatedAt();
                //gameTags.setUpdatedAt();
            }
        }

    }

}
