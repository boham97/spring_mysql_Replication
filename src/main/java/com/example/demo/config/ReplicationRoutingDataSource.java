package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    private CircularList<String> dataSourceNameList;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);

        // slave db 정보를 CircularList로 관리
        dataSourceNameList = new CircularList<>(
                targetDataSources.keySet()
                        .stream()
                        .map(Object::toString)
                        .filter(string -> string.contains("slave"))
                        .collect(Collectors.toList())
        );
    }

    /**
     * 현재 요청에서 사용할 DataSource 결정할 key값 반환
     */
    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        if (isReadOnly) {
            log.info("Connection Slave");
            return dataSourceNameList.getOne();
        } else {
            log.info("Connection Master");
            return "master";
        }
    }
}