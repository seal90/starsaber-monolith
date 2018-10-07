package org.seal.startsaber.sealstarsaberdemo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.seal.starsaber.arch.http.WebPage;
import org.seal.startsaber.sealstarsaberdemo.base.service.BaseService;
import org.seal.startsaber.sealstarsaberdemo.dao.ConsumerMapper;
import org.seal.startsaber.sealstarsaberdemo.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ConsumerService extends BaseService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void saveConsumer(Consumer consumer){
        consumer.setId(genId());
        consumerMapper.insertSelective(consumer);
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public WebPage<List<Consumer>> searchConsumerPage(WebPage<Consumer> webPage) {

        // 切记这句应该紧挨着 Mapper 分页查询，中间不能出现别的查询，且中间不要出现异常
//        PageHelper.startPage(webPage.getPageNum(), webPage.getPageSize());
        startPage(webPage);
        Consumer consumer = webPage.getData();

        List<Consumer> consumers = consumerMapper.searchConsumerPage(consumer);

//        Page<Consumer> consumerPage = (Page)consumers;
//        WebPage<List<Consumer>> consumerWebPage = new WebPage<>();
//        consumerWebPage.setData(consumers);
//        consumerWebPage.setTotal(consumerPage.getTotal());
//        consumerWebPage.setPageNum(webPage.getPageNum());
//        consumerWebPage.setPageSize(webPage.getPageSize());
//        consumerWebPage.setOrder(webPage.getOrder());
        WebPage<List<Consumer>> consumerWebPage = resultPage(consumers, webPage);

        return consumerWebPage;
    }
}
