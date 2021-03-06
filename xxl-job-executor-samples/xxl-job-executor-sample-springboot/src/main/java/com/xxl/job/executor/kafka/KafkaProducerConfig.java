
package com.xxl.job.executor.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


/**
* @ClassName: KafkaProducerConfig
* @Description: 消息端配置
* @author zhuxiange
* @date 2017年11月29日
*
*/

@Configuration
@EnableKafka
@PropertySource("classpath:/config/kafka.properties")
public class KafkaProducerConfig
{
	@Value("${kafka.producer.servers}")
	private String	servers;
	@Value("${kafka.producer.retries}")
	private String		retries;
	@Value("${kafka.producer.batch.size}")
	private String		batchSize;
	@Value("${kafka.producer.linger}")
	private String		linger;
	@Value("${kafka.producer.buffer.memory}")
	private String		bufferMemory;
	
	public Map<String, Object> producerConfigs()
	{
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
		props.put(ProducerConfig.RETRIES_CONFIG, retries);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
		props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}
	
	public ProducerFactory<String, String> producerFactory()
	{
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate()
	{
		return new KafkaTemplate<String, String>(producerFactory());
	}
}
