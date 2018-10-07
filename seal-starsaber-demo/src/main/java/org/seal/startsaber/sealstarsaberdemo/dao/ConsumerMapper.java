package org.seal.startsaber.sealstarsaberdemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.seal.startsaber.sealstarsaberdemo.entity.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ConsumerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    Consumer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKey(Consumer record);

    List<Consumer> searchConsumerPage(Consumer consumer);
}