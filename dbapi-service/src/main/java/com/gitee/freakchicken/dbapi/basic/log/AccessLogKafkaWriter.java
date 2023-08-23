package com.gitee.freakchicken.dbapi.basic.log;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "access.log.writer", havingValue = "kafka")
public class AccessLogKafkaWriter implements AccessLogWriter {

    @Autowired
    private KafkaTemplate<String, String> template;

    @Value("${access.log.kafka.topic}")
    private String accessLogTopic;

    @Override
    public void write(AccessLog log) {
        template.send(accessLogTopic, JSON.toJSONString(log));
    }
}
