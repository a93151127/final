package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Goods;

public interface GoodsDao {
	Goods findByPk(String pk);

    List<Goods> findAll();

    /**
     * 提供分页查询
     * @param start 开始索引 索引从0开始
     * @param end 结束索引  索引从0开始
     * @return 商品列表
     */
    List<Goods> findStartEnd(int start, int end);

    void create(Goods goods);

    void modify(Goods goods);

    void remove(String pk);
}
