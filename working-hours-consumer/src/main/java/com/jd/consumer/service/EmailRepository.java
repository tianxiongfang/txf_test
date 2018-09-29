package com.jd.consumer.service;

import com.jd.api.model.RequestLogMQMsgModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/8/21.
 */
@Repository
public interface EmailRepository extends MongoRepository<RequestLogMQMsgModel, String> {

}