package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DaoMaker {
    public static void main(String[] args) {

        //生成数据库的实体类XXentity 对应的是数据库的表
        Schema schema = new Schema(1, "com.db.entity");
        addStudent(schema);
        schema.setDefaultJavaPackageDao("com.db.dao");
        try {
            new DaoGenerator().generateAll(schema,
                    "D:\\1\\Music\\app\\src\\main\\java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //创建数据库的表
    private static void addStudent(Schema schema) {
        Entity entity = schema.addEntity("Localmusic");//创建数据库的表
        entity.addIdProperty();//主键 是 int类型
        entity.addIntProperty("uid");
        entity.addStringProperty("title_name");//对应的数据库的列
        entity.addStringProperty("album");//对应的数据库的列
        entity.addStringProperty("artist");//对应的数据库的列
        entity.addStringProperty("url");//对应的数据库的列
        entity.addStringProperty("display_name");//对应的数据库的列
        entity.addStringProperty("year");//对应的数据库的列
        entity.addIntProperty("duration");//对应的数据库的列
        entity.addLongProperty("size");//
        entity.addStringProperty("mine_type");//名称
    }

}
