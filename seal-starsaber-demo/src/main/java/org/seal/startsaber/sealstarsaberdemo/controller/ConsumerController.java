package org.seal.startsaber.sealstarsaberdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.seal.starsaber.arch.http.ResponseOkEntity;
import org.seal.starsaber.arch.http.WebPage;
import org.seal.startsaber.sealstarsaberdemo.base.controller.BaseController;
import org.seal.startsaber.sealstarsaberdemo.entity.Consumer;
import org.seal.startsaber.sealstarsaberdemo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController extends BaseController {

    @Autowired
    private ConsumerService consumerService;

    /**
     * {
     *     "data":{"name": 1},
     *     "pageSize": 10,
     *     "pageNum": 1,
     *     "order": {
     *         "name": "asc"
     *     }
     * }
     * @param webPage
     * @return
     */
    @PostMapping("/page")
    public ResponseOkEntity<WebPage<List<Consumer>>> searchConsumerPage(@RequestBody @Valid WebPage<Consumer> webPage){
        WebPage<List<Consumer>> consumerWebPage = consumerService.searchConsumerPage(webPage);
        return ok(consumerWebPage);
    }

    @PostMapping("/")
    public ResponseOkEntity<String> saveConsumer(Consumer consumer){
        consumerService.saveConsumer(consumer);
        return ok();
    }
}
